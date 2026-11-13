# PHP: versiones y cambio del módulo de Apache

Instala más de una versión de PHP en Debian y elige cuál usa la terminal y cuál usa Apache.

Probado en Debian con el repositorio de Sury. PHP 8.2 ya viene en Debian 12; usa esta página cuando necesitas otra versión. PHP 7 está fuera de soporte: el patrón sirve para un proyecto que todavía no arranca en 8, no para un servidor nuevo.

La instalación LAMP de una sola versión está en [LAMP](lamp.md).

## Requisitos

- Apache instalado.
- `ca-certificates`, `curl` o `wget`, y `lsb-release`.

## Repositorio

```bash
sudo apt update
sudo apt install -y apt-transport-https lsb-release ca-certificates wget
sudo wget -O /etc/apt/trusted.gpg.d/php.gpg https://packages.sury.org/php/apt.gpg
echo "deb https://packages.sury.org/php/ $(lsb_release -sc) main" | sudo tee /etc/apt/sources.list.d/php.list
sudo apt update
```

## Instalar una versión

Sustituye `8.3` por la versión que necesites. En PHP 8 el módulo JSON va en el núcleo: no existe el paquete `php8.3-json`.

```bash
sudo apt install -y php8.3 php8.3-cli php8.3-fpm php8.3-common php8.3-mysql php8.3-pgsql php8.3-zip php8.3-gd php8.3-mbstring php8.3-curl php8.3-xml php8.3-intl php8.3-bcmath
```

CakePHP necesita `intl`. Esa extensión va en la misma línea, no como `php_intl.dll`.

## Elegir la versión

CLI y Apache se cambian por separado. `update-alternatives` no cambia el módulo que carga Apache.

```bash
sudo update-alternatives --set php /usr/bin/php8.3
sudo a2dismod php8.2
sudo a2enmod php8.3
sudo systemctl restart apache2
php -v
```

Lista los módulos PHP cargados antes de deshabilitar, para no dejar Apache sin ninguno:

```bash
sudo a2query -m | grep php
```

Límites de subida y memoria: `/etc/php/8.3/apache2/php.ini`. Después del cambio, reinicia Apache.

## Comprobar

- `php -v` muestra la versión que acabas de fijar.
- Un `phpinfo()` temporal, borrado al terminar, muestra la misma versión en "Loaded Configuration File" bajo `apache2`.

## Errores frecuentes

- La terminal está en 8.3 y el sitio sigue en 8.2: se cambió `update-alternatives` y no el módulo de Apache, o al revés.
- `apt` no encuentra `phpX.Y-json` en PHP 8: el paquete ya no existe. Quita esa dependencia del comando.

## Qué no hacer

- No actives `display_errors` en un servidor público. En local puede hacer falta para ver un fallo; en producción el error va al log.
- No dejes varias versiones a la vez "por si acaso" sin saber cuál sirve el sitio. `a2query -m | grep php` tiene que mostrar una.
