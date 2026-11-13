# Composer

Instala Composer en Debian o Ubuntu comprobando la firma del instalador antes de ejecutarlo.

## Requisitos

- PHP CLI y `unzip`.

```bash
sudo apt update
sudo apt install -y php-cli unzip curl
```

## Instalación

```bash
curl -sS https://getcomposer.org/installer -o /tmp/composer-setup.php
HASH=$(curl -sS https://composer.github.io/installer.sig)
php -r "if (hash_file('SHA384', '/tmp/composer-setup.php') === '$HASH') { echo 'Installer verified'; } else { echo 'Installer corrupt'; unlink('/tmp/composer-setup.php'); } echo PHP_EOL;"
sudo php /tmp/composer-setup.php --install-dir=/usr/local/bin --filename=composer
composer --version
```

Tiene que imprimir `Installer verified` antes del `sudo php`. Si imprime `Installer corrupt`, no continúes.

En Manjaro los comandos son los mismos, con PHP ya instalado por pacman. `composer self-update` actualiza el binario global más adelante.

Si Composer se queja de iconv, activa `extension=iconv` en `/etc/php/php.ini` y reinicia el servicio.

## Qué no hacer

- No canalices el instalador a `php` sin comprobar el hash.
- No instales Composer como root dentro de un proyecto (`sudo composer install` en el directorio de la app). El binario global puede estar en `/usr/local/bin`; los archivos del proyecto tienen que quedar con tu usuario.
