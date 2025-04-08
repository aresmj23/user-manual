## Laravel JWT

Para implementar JWT (JSON Web Tokens) en Laravel 11, puedes usar el paquete tymon/jwt-auth, uno de los paquetes más populares para la autenticación con JWT en Laravel. A continuación, te muestro los pasos para instalarlo, configurarlo y usarlo en tu aplicación Laravel 11.

1. Instalar el paquete tymon/jwt-auth
Instala el paquete utilizando Composer:

```bash
composer require tymon/jwt-auth
```

2. Publicar el archivo de configuración
Ejecuta el siguiente comando para publicar el archivo de configuración de JWT:

```bash
php artisan vendor:publish --provider="Tymon\JWTAuth\Providers\LaravelServiceProvider"
```

Esto generará un archivo de configuración llamado config/jwt.php.

3. Generar la clave secreta de JWT
Para que los tokens JWT funcionen, necesitamos una clave secreta única. Ejecuta el siguiente comando para generarla:

```bash
php artisan jwt:secret
```

Este comando añadirá una clave única a tu archivo .env bajo la variable JWT_SECRET.

4. Configurar el Guard de Autenticación
En el archivo config/auth.php, configura el guard de la API para que utilice el driver jwt. Modifica la sección guards:

```php
'guards' => [
    'web' => [
        'driver' => 'session',
        'provider' => 'users',
    ],

    'api' => [
        'driver' => 'jwt',
        'provider' => 'users',
        'hash' => false,
    ],
],
```

5. Crear las Rutas de Autenticación con JWT
En routes/api.php, crea las rutas para el login, registro y logout, y para obtener información del usuario autenticado.

```php
use App\Http\Controllers\AuthController;

Route::post('register', [AuthController::class, 'register']);
Route::post('login', [AuthController::class, 'login']);
Route::post('logout', [AuthController::class, 'logout']);
Route::get('me', [AuthController::class, 'me'])->middleware('auth:api');
```

6. Crear el AuthController
Crea un controlador de autenticación llamado AuthController para manejar el registro, login, logout y obtener los datos del usuario autenticado.

```bash
php artisan make:controller AuthController
```

En el archivo AuthController.php, define los métodos para el registro, login, logout y el método me para obtener información del usuario autenticado.

```php
<?php

namespace App\Http\Controllers;

use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Facades\Validator;
use Tymon\JWTAuth\Facades\JWTAuth;
use Tymon\JWTAuth\Exceptions\JWTException;

class AuthController extends Controller
{
    // Registro de usuario
    public function register(Request $request)
    {
        $validator = Validator::make($request->all(), [
            'name' => 'required|string|max:255',
            'email' => 'required|string|email|max:255|unique:users',
            'password' => 'required|string|min:6|confirmed',
        ]);

        if ($validator->fails()) {
            return response()->json($validator->errors(), 422);
        }

        $user = User::create([
            'name' => $request->name,
            'email' => $request->email,
            'password' => Hash::make($request->password),
        ]);

        $token = JWTAuth::fromUser($user);

        return response()->json(compact('user', 'token'), 201);
    }

    // Login de usuario
    public function login(Request $request)
    {
        $credentials = $request->only('email', 'password');

        try {
            if (!$token = JWTAuth::attempt($credentials)) {
                return response()->json(['error' => 'Credenciales inválidas'], 401);
            }
        } catch (JWTException $e) {
            return response()->json(['error' => 'No se pudo crear el token'], 500);
        }

        return response()->json(compact('token'));
    }

    // Logout de usuario
    public function logout()
    {
        try {
            JWTAuth::invalidate(JWTAuth::getToken());
            return response()->json(['message' => 'Sesión cerrada correctamente']);
        } catch (JWTException $e) {
            return response()->json(['error' => 'No se pudo cerrar la sesión'], 500);
        }
    }

    // Obtener información del usuario autenticado
    public function me()
    {
        return response()->json(auth()->user());
    }
}
```

7. Proteger Rutas con el Middleware auth:api
Para proteger las rutas de la API, usa el middleware auth:api. Esto se asegura de que el usuario esté autenticado usando JWT antes de acceder a esas rutas.

Por ejemplo:

```php
Route::middleware(['auth:api'])->group(function () {
    Route::get('user/profile', [UserProfileController::class, 'show']);
    // Otras rutas protegidas
});
```

8. Probar la Autenticación con JWT
Registro: Envía una solicitud POST a /api/register con el nombre, correo electrónico, contraseña y confirmación de contraseña para registrar un usuario.
Login: Envía una solicitud POST a /api/login con el correo electrónico y contraseña para recibir un token JWT.
Obtener Usuario Autenticado: Envía una solicitud GET a /api/me con el token en el encabezado Authorization: Bearer {token} para obtener la información del usuario.
Logout: Envía una solicitud POST a /api/logout con el token para invalidarlo y cerrar la sesión del usuario.
Resumen
Con esta configuración, has implementado autenticación JWT en tu aplicación Laravel 11 usando tymon/jwt-auth. Las rutas protegidas solo serán accesibles para usuarios autenticados con un token válido.



## Laravel Sanctum

Para implementar JWT en Laravel 11, puedes utilizar el paquete laravel-sanctum, ya que Laravel ya no soporta oficialmente el paquete jwt-auth. Laravel Sanctum permite crear tokens de acceso personal para autenticar solicitudes API de manera sencilla, similar al funcionamiento de JWT.

Aquí tienes los pasos para configurar JWT en Laravel 11 usando Sanctum:

1. Instalar Sanctum
Ejecuta el siguiente comando en tu terminal para instalar Sanctum:

```bash
composer require laravel/sanctum
```

2. Publicar la Configuración de Sanctum
Publica el archivo de configuración de Sanctum y migra la base de datos para crear las tablas necesarias:

```bash
php artisan vendor:publish --provider="Laravel\Sanctum\SanctumServiceProvider"
php artisan migrate
```

3. Configurar el Middleware
Agrega el middleware de Sanctum en el archivo app/Http/Kernel.php para proteger las rutas de la API:

```php
// app/Http/Kernel.php
use Laravel\Sanctum\Http\Middleware\EnsureFrontendRequestsAreStateful;

protected $middlewareGroups = [
    'api' => [
        EnsureFrontendRequestsAreStateful::class,
        'throttle:api',
        \Illuminate\Routing\Middleware\SubstituteBindings::class,
    ],
];
```

4. Configurar el Driver de Autenticación
En el archivo de configuración config/auth.php, cambia el guard de la API para usar sanctum en lugar de token.

```php
// config/auth.php
'guards' => [
    'api' => [
        'driver' => 'sanctum',
        'provider' => 'users',
        'hash' => false,
    ],
],
```

5. Crear Controladores de Autenticación
Genera un controlador de autenticación donde manejaremos el login, registro y logout del usuario.

```bash
php artisan make:controller AuthController
```

Luego, abre el archivo AuthController.php y configura los métodos de autenticación.

```php
// app/Http/Controllers/AuthController.php
namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;
use App\Models\User;
use Illuminate\Support\Facades\Auth;

class AuthController extends Controller
{
    // Método de registro
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

    // Método de login
    public function login(Request $request)
    {
        $request->validate([
            'email' => 'required|email',
            'password' => 'required',
        ]);

        if (!Auth::attempt($request->only('email', 'password'))) {
            return response()->json(['message' => 'Invalid login details'], 401);
        }

        $user = Auth::user();
        $token = $user->createToken('auth_token')->plainTextToken;

        return response()->json(['access_token' => $token, 'token_type' => 'Bearer']);
    }

    // Método de logout
    public function logout(Request $request)
    {
        $request->user()->tokens()->delete();

        return response()->json(['message' => 'Successfully logged out']);
    }
}
```

6. Definir las Rutas de Autenticación
En el archivo routes/api.php, agrega las rutas para el registro, login y logout:

```php
// routes/api.php

use App\Http\Controllers\AuthController;

Route::post('/register', [AuthController::class, 'register']);
Route::post('/login', [AuthController::class, 'login']);

// Rutas protegidas por autenticación
Route::middleware('auth:sanctum')->group(function () {
    Route::post('/logout', [AuthController::class, 'logout']);
    // Aquí puedes agregar más rutas protegidas
});
```

7. Proteger Rutas con Sanctum
Para proteger cualquier otra ruta que quieras que solo sea accesible para usuarios autenticados, asegúrate de incluir el middleware auth:sanctum en esas rutas, como hemos hecho en el paso anterior.

8. Configurar el Cliente Frontend para el Token
En el frontend, cuando el usuario se autentique, deberás enviar el token en las solicitudes subsecuentes en el encabezado Authorization. Por ejemplo, en Vue.js, puedes hacer esto con Axios:

```javascript
import axios from 'axios';

axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
```

9. Probar la API de Autenticación
Ahora puedes probar la API utilizando un cliente como Postman o con un frontend en Vue. Al iniciar sesión o registrarse, recibirás un access_token, que deberás utilizar para acceder a las rutas protegidas.

Resumen
Con estos pasos, has implementado JWT en Laravel 11 utilizando Sanctum.