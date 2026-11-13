# Laravel

Deja escribibles los directorios que Laravel necesita, limpia la caché y autentica una API.

Probado contra Laravel 11. Hay dos mecanismos distintos. Sanctum es el que trae el framework: emite tokens opacos guardados en la base de datos. JWT es otro paquete, `tymon/jwt-auth`, y el token viaja firmado. No son intercambiables y no se configuran en el mismo sitio.

## Requisitos

- PHP, Composer y una base creada. La pila está en [LAMP](../entorno/lamp.md) y [Composer](../entorno/composer.md).
- Un proyecto Laravel ya creado.

## Permisos

El usuario con el que despliegas es dueño de los archivos. El usuario de Apache (`www-data` en Debian y Ubuntu) es el grupo y puede escribir donde Laravel genera caché y logs.

```bash
sudo chown -R "$USER":www-data storage bootstrap/cache
sudo find storage bootstrap/cache -type d -exec chmod 775 {} \;
sudo find storage bootstrap/cache -type f -exec chmod 664 {} \;
```

## Puesta en marcha

```bash
composer install
php artisan key:generate
php artisan migrate
npm install
npm run dev
```

Caché, cuando un cambio de ruta o de `.env` no se refleja:

```bash
php artisan optimize:clear
```

Eso cubre config, rutas, vistas y caché de aplicación. `php artisan optimize` vuelve a cachear config y rutas: en local suele estorbar, porque un `.env` nuevo no se lee hasta el siguiente `optimize:clear`.

`composer dump-autoload` regenera el mapa de clases después de crear un archivo a mano fuera de Composer.

## Sanctum en Laravel 11

```bash
php artisan install:api
php artisan migrate
```

`install:api` instala Sanctum y deja `routes/api.php`. El modelo `User` tiene que usar el trait:

```php
use Laravel\Sanctum\HasApiTokens;

class User extends Authenticatable
{
    use HasApiTokens, HasFactory, Notifiable;
}
```

Rutas. El registro y el login son públicos. El resto exige el token:

```php
use App\Http\Controllers\AuthController;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

Route::post('/register', [AuthController::class, 'register']);
Route::post('/login', [AuthController::class, 'login']);

Route::middleware('auth:sanctum')->group(function () {
    Route::post('/logout', [AuthController::class, 'logout']);
    Route::get('/user', function (Request $request) {
        return $request->user();
    });
});
```

El controlador crea el token con `createToken` y lo devuelve en claro una sola vez:

```php
namespace App\Http\Controllers;

use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Hash;

class AuthController extends Controller
{
    public function register(Request $request)
    {
        $request->validate([
            'name' => 'required|string|max:255',
            'email' => 'required|string|email|max:255|unique:users',
            'password' => 'required|string|min:8|confirmed',
        ]);

        $user = User::create([
            'name' => $request->name,
            'email' => $request->email,
            'password' => Hash::make($request->password),
        ]);

        $token = $user->createToken('auth_token')->plainTextToken;

        return response()->json(['access_token' => $token, 'token_type' => 'Bearer']);
    }

    public function login(Request $request)
    {
        $request->validate([
            'email' => 'required|email',
            'password' => 'required',
        ]);

        if (! Auth::attempt($request->only('email', 'password'))) {
            return response()->json(['message' => 'Credenciales inválidas'], 401);
        }

        $token = $request->user()->createToken('auth_token')->plainTextToken;

        return response()->json(['access_token' => $token, 'token_type' => 'Bearer']);
    }

    public function logout(Request $request)
    {
        $request->user()->currentAccessToken()->delete();

        return response()->json(['message' => 'Sesión cerrada']);
    }
}
```

El cliente manda `Authorization: Bearer {token}`.

Sanctum no se registra en `app/Http/Kernel.php`. Laravel 11 no usa ese archivo. Una SPA que autentica con cookie de sesión, además del token, activa el middleware en `bootstrap/app.php`:

```php
->withMiddleware(function (Middleware $middleware) {
    $middleware->statefulApi();
})
```

Una API solo con token no necesita `statefulApi()`.

## JWT con tymon/jwt-auth

Camino alternativo cuando el cliente exige un JWT. Si Composer rechaza el paquete, esa versión no declara Laravel 11. No lo fuerces con `--ignore-platform`.

```bash
composer require tymon/jwt-auth
php artisan vendor:publish --provider="Tymon\JWTAuth\Providers\LaravelServiceProvider"
php artisan jwt:secret
```

`jwt:secret` escribe `JWT_SECRET` en `.env`. En `config/auth.php` el guard de la API usa el driver `jwt`:

```php
'guards' => [
    'web' => [
        'driver' => 'session',
        'provider' => 'users',
    ],
    'api' => [
        'driver' => 'jwt',
        'provider' => 'users',
    ],
],
```

El login devuelve el token de `JWTAuth::attempt`. Las rutas protegidas llevan `auth:api`. El logout invalida el token con `JWTAuth::invalidate`.

No copies este guard si el proyecto ya usa Sanctum. Un proyecto, un mecanismo.

## Comprobar

- `storage/logs` es escribible por `www-data`: una petición al sitio crea o actualiza `laravel.log`.
- `POST /api/register` responde 201 con `access_token`.
- `GET /api/user` sin cabecera responde 401, y con `Authorization: Bearer` responde el usuario.

## Errores frecuentes

- Cambias `.env` y la app sigue con la base vieja: hay config cacheada. `php artisan optimize:clear`.
- `Permission denied` en `storage/framework/views`: el grupo no es `www-data`, o se desplegó con `sudo` y los archivos quedaron de root.
- La guía antigua de Sanctum editaba `app/Http/Kernel.php`. En Laravel 11 ese cambio no tiene efecto.

## Qué no hacer

- No uses `chmod -R 777` ni `chmod -R o=rwx` en `storage`.
- No llames JWT al token de Sanctum. Quien lea el cliente va a buscar un token firmado en tres partes y no lo va a encontrar.
- No dejes `JWT_SECRET` ni claves de `.env` en el manual ni en el repositorio.
