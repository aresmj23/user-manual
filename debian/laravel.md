# Laravel

Permisos de laravel en tu proyecto

```bash
$ sudo chown -R $USER:www-data storage
$ chmod -R 775 storage/ bootstrap/cache/
$ sudo chmod -R o=rwx storage
```

Comandos basicos

```bash
$ php artisan key:generate
$ composer install
$ composer dump-autoload
$ npm install
$ npm run dev
$ php artisan optimize
$ php artisan cache:clear
$ php artisan config:clear
$ php artisan route:clear
```


## Comandos
Limpiar las rutas
```bash
$ php artisan route:clear
$ php artisan route:cache
```

Eliminar el archivo de caché de configuración.
```bash
$ php artisan config:clear
$ php artisan config:cache
```

Borrar el caché de la aplicación de clases y servicios compilados.
```bash
$ php artisan clear-compiled
```

Optimizar el framework para un mejor rendimiento
```bash
$ php artisan optimize
```

Actualizar la información del cargador automático de clases.
```bash
$ composer dump-autoload
```

Todos
```bash
php artisan route:clear
php artisan route:cache
php artisan config:clear
php artisan config:cache
php artisan clear-compiled
php artisan optimize
composer dump-autoload
```

Buscar: <!--layout-partial:([\w\/\-_]+)\.html-->
Reemplazar por: @include('base.$1')

# CAMBIAR EL / POR .
Buscar: (@include\('[^']+?)\/([^']+'\))
Reemplazar por: $1.$2

