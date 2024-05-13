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


104.43.221.42
sochoa
Templaris2021@

```bash
$ sudo nano /etc/php/7.2/apache2/php.ini

extension=gd2

$ sudo systemctl status apache2
```

## Php para laravel 7.x

```bash
$ sudo apt install php7.2
$ sudo apt install php7.2-fpm
$ sudo apt install php7.2-intl php7.2-bcmath php7.2-common php7.2-json php7.2-mbstring openssl php7.2-xml
$ sudo apt install php7.2-mysql
$ sudo apt install php7.2-curl
$ sudo apt install php7.2-gd
$
$ 
$ sudo nano /etc/php/7.2/apache2/php.ini
$ sudo systemctl status apache2
```

## Php para laravel 8.x

```bash
$ sudo apt install php7.4
$ sudo apt install php7.4-fpm
$ sudo apt install php7.4-intl php7.4-bcmath php7.4-common php7.4-json php7.4-mbstring openssl php7.4-xml
$ sudo apt install php7.4-mysql
$ sudo apt install php7.4-curl
$ sudo apt install php7.4-gd
$
$ 
$ sudo nano /etc/php/7.4/apache2/php.ini
$ sudo systemctl status apache2
```

php 8.0

```bash
$ sudo apt install php8.0
$ sudo apt install php8.0-fpm
$ sudo apt install php8.0-intl php8.0-bcmath php8.0-common php8.0-mbstring openssl php8.0-xml
$ sudo apt install php8.0-mysql
$ sudo apt install php8.0-curl
$ sudo apt install php8.0-gd
$
$ 
$ sudo nano /etc/php/8.0/apache2/php.ini
$ sudo systemctl status apache2
```

php 8.1

```bash
$ sudo apt install php8.1
$ sudo apt install php8.1-fpm
$ sudo apt install php8.1-intl php8.1-bcmath php8.1-common php8.1-mbstring openssl php8.1-xml
$ sudo apt install php8.1-mysql
$ sudo apt install php8.1-curl
$ sudo apt install php8.1-gd
$
$ 
$ sudo nano /etc/php/8.1/apache2/php.ini
$ sudo systemctl status apache2
```

php 8.2

```bash
$ sudo apt install php8.2
$ sudo apt install php8.2-fpm
$ sudo apt install php8.2-intl php8.2-bcmath php8.2-common php8.2-mbstring openssl php8.2-xml
$ sudo apt install php8.2-mysql
$ sudo apt install php8.2-curl
$ sudo apt install php8.2-gd
$
$ 
$ sudo nano /etc/php/8.2/apache2/php.ini
$ sudo systemctl status apache2
```

php 8.3

```bash
$ sudo apt install php8.3
$ sudo apt install php8.3-fpm
$ sudo apt install php8.3-intl php8.3-bcmath php8.3-common php8.3-mbstring openssl php8.3-xml
$ sudo apt install php8.3-mysql
$ sudo apt install php8.3-curl
$ sudo apt install php8.3-gd
$
$ 
$ sudo nano /etc/php/8.3/apache2/php.ini
$ sudo systemctl status apache2
```

## Cambiar entre versiones de PHPphp
```bash
sudo update-alternatives --config php
```

Deshabilitar
```bash
sudo a2dismod php7.2
sudo systemctl restart apache2
```

Deshabilitar
```bash
sudo a2dismod php7.4
sudo systemctl restart apache2
```

Habilitar
```bash
sudo a2enmod php7.4
sudo systemctl restart apache2
```

Deshabilitar
```bash
sudo a2dismod php8.0
sudo systemctl restart apache2
```

Habilitar
```bash
sudo a2enmod php8.0
sudo systemctl restart apache2
```

Habilitar
```bash
sudo a2enmod php8.1
sudo systemctl restart apache2
```

## Para php 7.4
```bash
sudo update-alternatives --config php
sudo a2dismod php8.0
sudo a2enmod php7.4
sudo systemctl restart apache2
```

## Para php 8.0
```bash
sudo update-alternatives --config php
sudo a2dismod php7.4
sudo a2enmod php8.0
sudo systemctl restart apache2
```

## Para php 8.1
```bash
sudo update-alternatives --config php
sudo a2dismod php7.4
sudo a2enmod php8.0
sudo systemctl restart apache2
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