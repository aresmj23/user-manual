# Usuarios, virtual hosts y FTP

Crea un usuario de sistema para un sitio, publica ese sitio en Apache y, si hace falta, abre FTP solo a cuentas locales.

No hay clientes, claves ni direcciones en esta página. Cada sitio repite el mismo procedimiento con su propio nombre.

## Requisitos

- Apache instalado. La pila está en [LAMP](../entorno/lamp.md).
- Decidido el usuario, el dominio y el directorio público antes de crear nada.

## Grupos y usuario

```bash
sudo groupadd clientes
sudo useradd --create-home --shell /bin/bash --gid clientes --comment "Nombre del cliente" cliente
sudo passwd cliente
```

`passwd` pide la clave en la terminal. No la escribas en un archivo de este manual.

Si el usuario solo existe para ser dueño de archivos y no debe entrar por SSH, el shell es `/usr/sbin/nologin` en vez de `/bin/bash`.

## Sitio

```bash
sudo mkdir -p /home/cliente/public_html
sudo chown cliente:clientes /home/cliente/public_html
sudo ln -s /home/cliente/public_html /var/www/cliente
```

`/etc/apache2/sites-available/ejemplo.test.conf`:

```apache
<VirtualHost *:80>
    ServerName ejemplo.test
    ServerAlias www.ejemplo.test
    ServerAdmin webmaster@ejemplo.test
    DocumentRoot /var/www/cliente

    <Directory /var/www/cliente>
        Options FollowSymLinks
        AllowOverride All
        Require all granted
    </Directory>

    ErrorLog ${APACHE_LOG_DIR}/ejemplo.test_error.log
    CustomLog ${APACHE_LOG_DIR}/ejemplo.test_access.log combined
</VirtualHost>
```

```bash
sudo a2ensite ejemplo.test.conf
sudo systemctl reload apache2
```

El argumento de `a2ensite` es el archivo de este sitio. Habilitar el de otro dominio deja este sitio apagado y el otro repetido.

Permisos del código publicado, después de subir los archivos:

```bash
sudo find /home/cliente/public_html -type d -exec chmod 755 {} \;
sudo find /home/cliente/public_html -type f -exec chmod 644 {} \;
```

## FTP con vsftpd

```bash
sudo apt install -y vsftpd
```

En `/etc/vsftpd.conf` la base es esta. El anónimo queda apagado.

```ini
anonymous_enable=NO
local_enable=YES
write_enable=YES
chroot_local_user=YES
```

Con `chroot_local_user`, vsftpd rechaza el login si la casa del usuario es escribible por él. La casa queda en `755` y de root, y el usuario escribe dentro de `public_html`:

```bash
sudo chown root:root /home/cliente
sudo chmod 755 /home/cliente
sudo chown cliente:clientes /home/cliente/public_html
```

```bash
sudo systemctl restart vsftpd
```

`ftpd_banner` puede llevar un texto de bienvenida. `xferlog_enable=YES` deja registro de las transferencias.

## Comprobar

- `getent passwd cliente` devuelve el usuario y el shell previsto.
- `sudo apache2ctl -S` lista `ejemplo.test` una sola vez.
- Una página en `public_html` se ve en el dominio, y el usuario FTP entra en su directorio y no puede subir al de otro.

## Errores frecuentes

- El enlace simbólico apunta a una ruta que no existe, o `a2ensite` recibió el `.conf` de otro sitio.
- vsftpd responde `500 OOPS: vsftpd: refusing to run with writable root inside chroot`: la casa del usuario es escribible. Aplica el `chown root` de arriba. `allow_writeable_chroot=YES` lo calla y debilita el chroot; no es el arreglo.

## Qué no hacer

- No guardes claves, IPs ni nombres de clientes reales en esta guía.
- No uses `chmod 777` sobre el sitio ni sobre `storage`.
- No actives `anonymous_enable`.
- No uses `Order allow,deny`. En Apache 2.4 el acceso del directorio es `Require all granted`.
