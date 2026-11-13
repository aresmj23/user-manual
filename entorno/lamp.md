# LAMP

Instala el servidor web, la base de datos y PHP, y deja un virtual host con URLs amigables.

Probado como procedimiento de Debian 12. Ubuntu usa los mismos paquetes de Apache y PHP; la sección de MySQL cubre la diferencia. Manjaro va aparte. CentOS 7 está fuera de soporte: el bloque del final es archivo, no una instalación nueva.

Otras versiones de PHP y el cambio del módulo de Apache: [PHP](php.md).

## Requisitos

- Acceso `sudo`.
- En un servidor con SSH, abre el puerto 22 antes de activar el firewall.

## Debian 12

```bash
sudo apt update
sudo apt upgrade -y
sudo apt install -y mariadb-server mariadb-client
sudo systemctl status mariadb
sudo mysql_secure_installation
```

En `mysql_secure_installation` quita usuarios anónimos, impide el login remoto de root y borra la base de prueba.

```bash
sudo apt install -y apache2 apache2-utils
sudo systemctl status apache2
sudo apt install -y ufw
sudo ufw allow OpenSSH
sudo ufw allow http
sudo ufw allow https
sudo ufw enable
sudo ufw reload
```

PHP de la distribución (8.2 en Debian 12) y las extensiones que usan Laravel y phpMyAdmin:

```bash
sudo apt install -y php libapache2-mod-php php-cli php-fpm php-mysql php-zip php-gd php-mbstring php-curl php-xml php-pear php-bcmath
php -v
```

Comprueba que Apache ejecuta PHP y borra el archivo en el mismo paso. `phpinfo()` publica versión, rutas y módulos.

```bash
echo '<?php phpinfo();' | sudo tee /var/www/html/info.php
```

Abre `http://localhost/info.php`. Cuando veas la página:

```bash
sudo rm /var/www/html/info.php
```

### phpMyAdmin

```bash
sudo apt install -y phpmyadmin
```

En el asistente elige Apache y confirma la configuración de la base. Si el módulo MySQL no aparece en `phpinfo()`, actívalo y reinicia:

```bash
sudo phpenmod pdo_mysql mysqli
sudo systemctl restart apache2
```

### Límites de PHP

Edita el `php.ini` de la versión que Apache está usando, por ejemplo `/etc/php/8.2/apache2/php.ini`:

```ini
post_max_size = 25M
upload_max_filesize = 25M
max_input_vars = 5000
memory_limit = 256M
```

```bash
sudo systemctl restart apache2
```

### URLs amigables

```bash
sudo a2enmod rewrite
```

No cambies `<Directory />`. El `AllowOverride` va en el directorio del sitio. En `/etc/apache2/apache2.conf`, el bloque de `/var/www/` queda así:

```apache
<Directory /var/www/>
    Options Indexes FollowSymLinks
    AllowOverride All
    Require all granted
</Directory>
```

```bash
sudo systemctl restart apache2
```

`Options Indexes` lista los archivos si falta el índice. Quítalo en un sitio público.

### Virtual host

Sustituye `ejemplo.test` y la ruta. `/etc/apache2/sites-available/ejemplo.test.conf`:

```apache
<VirtualHost *:80>
    ServerName ejemplo.test
    ServerAlias www.ejemplo.test
    ServerAdmin webmaster@ejemplo.test
    DocumentRoot /var/www/ejemplo.test/public

    <Directory /var/www/ejemplo.test/public>
        Options FollowSymLinks
        AllowOverride All
        Require all granted
    </Directory>

    ErrorLog ${APACHE_LOG_DIR}/ejemplo.test_error.log
    CustomLog ${APACHE_LOG_DIR}/ejemplo.test_access.log combined
</VirtualHost>
```

```bash
sudo mkdir -p /var/www/ejemplo.test/public
sudo a2ensite ejemplo.test.conf
sudo systemctl reload apache2
```

El nombre del archivo que pasas a `a2ensite` es el que acabas de crear.

### Usuario de la aplicación

```bash
sudo mysql
```

```sql
CREATE DATABASE appdb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER 'app'@'localhost' IDENTIFIED BY 'CAMBIA_ESTA_CLAVE';
GRANT ALL PRIVILEGES ON appdb.* TO 'app'@'localhost';
FLUSH PRIVILEGES;
```

## Ubuntu

Apache, PHP y las URLs amigables son los de Debian. La base de esta guía en Ubuntu es MySQL, no MariaDB:

```bash
sudo apt install -y mysql-server
sudo mysql_secure_installation
sudo systemctl enable --now mysql
```

El cliente de root entra por socket:

```bash
sudo mysql
```

Política de claves, si el asistente la pregunta: `0` baja, `1` media, `2` alta.

```sql
SHOW VARIABLES LIKE 'validate_password%';
```

MySQL 8 autentica con `caching_sha2_password`. Pasa a `mysql_native_password` solo si un cliente viejo no puede conectar:

```sql
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'CAMBIA_ESTA_CLAVE';
```

## Manjaro

```bash
sudo pacman -Syu
sudo pacman -S apache
```

En `/etc/httpd/conf/httpd.conf` comenta `unique_id_module` si el servicio no arranca por ese módulo. PHP con Apache usa prefork, no event:

```apache
#LoadModule mpm_event_module modules/mod_mpm_event.so
LoadModule mpm_prefork_module modules/mod_mpm_prefork.so
LoadModule php_module modules/libphp.so
AddHandler php-script php
Include conf/extra/php_module.conf
LoadModule rewrite_module modules/mod_rewrite.so
```

Índice PHP:

```apache
<IfModule dir_module>
    DirectoryIndex index.php index.html
</IfModule>
```

URLs amigables, en el `Directory` de `/srv/http`:

```apache
<Directory "/srv/http">
    AllowOverride All
    Require all granted
</Directory>
```

```bash
sudo systemctl enable --now httpd
```

MariaDB:

```bash
sudo pacman -S mariadb
sudo mysql_install_db --user=mysql --basedir=/usr --datadir=/var/lib/mysql
sudo systemctl enable --now mariadb
sudo mysql_secure_installation
```

En instalaciones recientes el servicio se llama `mariadb`, no `mysqld`. Si `systemctl status mariadb` no existe, prueba `mysqld`.

En `/etc/php/php.ini` activa `extension=pdo_mysql`, `extension=mysqli` y `extension=iconv`. Esta última evita el fallo de Composer con iconv.

phpMyAdmin:

```bash
sudo pacman -S phpmyadmin
```

`/etc/httpd/conf/extra/phpmyadmin.conf`:

```apache
Alias /phpmyadmin "/usr/share/webapps/phpMyAdmin"
<Directory "/usr/share/webapps/phpMyAdmin">
    DirectoryIndex index.php
    AllowOverride All
    Options FollowSymLinks
    Require all granted
</Directory>
```

Incluye ese archivo al final de `httpd.conf`:

```apache
Include conf/extra/phpmyadmin.conf
```

En `/etc/webapps/phpmyadmin/config.inc.php` rellena `blowfish_secret` con una cadena larga propia. Sin ella, la autenticación por cookie no es válida.

Virtual hosts: descomenta `Include conf/extra/httpd-vhosts.conf` y define el sitio en ese archivo. El `DocumentRoot` y el `Directory` tienen que existir.

HTTPS local, solo para una máquina de desarrollo. Certificado autofirmado, un año:

```bash
sudo mkdir -p /etc/httpd/ssl
sudo openssl req -x509 -nodes -newkey rsa:2048 -sha256 -keyout /etc/httpd/ssl/sitio.key -out /etc/httpd/ssl/sitio.crt -days 365
```

Habilita `ssl_module` y añade el virtual host en el puerto 443 con `SSLEngine on`, `SSLCertificateFile` y `SSLCertificateKeyFile` apuntando a esos dos archivos.

Prueba PHP en `/srv/http/test.php` y bórralo después de ver `phpinfo()`.

```bash
sudo systemctl restart httpd
```

El usuario y el grupo de Apache se quedan en la cuenta del servicio. Cambiarlos por tu usuario de login solo tiene sentido en un puesto local donde el servidor deba escribir tus archivos.

## CentOS 7

CentOS 7 no recibe parches. No lo uses para un servidor nuevo.

Lo que sí queda documentado, si todavía administras uno: en `/etc/httpd/conf/httpd.conf`, el directorio del sitio lleva `AllowOverride All` y `Require all granted`, y se reinicia con `sudo systemctl restart httpd`. PHP 8.1 entraba por el repositorio Remi (`remi-php81`), no por los paquetes base.

## Comprobar

- `systemctl status` del servidor web y de la base en `active (running)`.
- `php -v` coincide con el módulo que muestra un `phpinfo()` temporal.
- `http://ejemplo.test` resuelve. En local, esa resolución es una línea de `/etc/hosts`, no un registro DNS público.
- Un `index.php` del virtual host se ejecuta, y `info.php` ya no está en el docroot.

## Errores frecuentes

- phpMyAdmin dice que hace falta otra versión de PHP: Apache sigue cargando un módulo viejo. El cambio de módulo está en [PHP](php.md).
- El sitio ignora `.htaccess`: `rewrite` no está habilitado, o `AllowOverride` no está en el `Directory` de ese sitio.
- `a2ensite` habilitó otro dominio: el argumento tiene que ser el archivo que acabas de escribir.

## Qué no hacer

- No dejes `phpinfo()` publicado.
- No pongas `AllowOverride All` en `<Directory />`.
- No abras el firewall sin haber permitido antes el SSH que estás usando.
- No uses `Order allow,deny` y `allow from all`. Esa sintaxis es de Apache 2.2. En 2.4 el acceso se expresa con `Require all granted`.
