# CakePHP

Activa la extensión intl que CakePHP exige y apunta el `php.ini` de Apache, no el de Windows.

Probado en Debian con PHP servido por Apache. La versión de PHP del ejemplo viejo era 7.4, fuera de soporte. Usa la versión que realmente sirve el sitio; si es 8.2, la ruta es `/etc/php/8.2/apache2/php.ini`.

## Requisitos

- Apache y PHP de la misma versión. Cómo instalar la extensión en otra versión: [PHP](../entorno/php.md).

## Pasos

```bash
sudo apt install -y php-intl
sudo systemctl restart apache2
```

Si hay varias versiones, instala `php8.2-intl` (o la que corresponda) y reinicia Apache después de habilitar ese módulo.

En el `php.ini` de Apache no hace falta `extension=php_intl.dll`. Esa línea es de Windows. En Debian la extensión llega como archivo en `conf.d` al instalar el paquete.

## Comprobar

Un `phpinfo()` temporal lista `intl` en la sección de módulos. Bórralo al terminar.

## Qué no hacer

- No pongas `display_errors = On` en el PHP de un servidor público. En local ayuda a ver el fallo; en producción el detalle se queda en el log.
- No edites el `php.ini` de una versión que Apache no está cargando. La ruta sale en "Loaded Configuration File" del `phpinfo()`.
