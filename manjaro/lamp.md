# Instalar LAMP en Manjaro

Actualizar paquetes

```bash
$ sudo pacman -Syu
```

## Instalar Apache

Instalar Apache

```bash
$ sudo pacman -S apache
```

Modificar el archivo **/etc/httpd/conf/httpd.conf**

```bash
$ sudo nano /etc/httpd/conf/httpd.conf
```

Comentar la siguiente linea

```bash
#LoadModule unique_id_module modules/mod_unique_id.so
```

Habilitar y iniciar y ver el estado de Apache

```bash
$ sudo systemctl enable httpd
$ sudo systemctl restart httpd
$ sudo systemctl status httpd
```

Abra su navegador web y navegue hasta
http://localhost/

## Instalar MySQL

Instalar MySQL

```bash
$ sudo pacman -S mysql
```

Inicializar MariaDB en Manjaro

```bash
$ sudo mysql_install_db --user=mysql --basedir=/usr --datadir=/var/lib/mysql
```

Habilitar y iniciar y ver el estado de MySQL

```bash
$ sudo systemctl enable mysqld
$ sudo systemctl restart mysqld
$ sudo systemctl status mysqld
```

Ejecutar **mysql_secure_installation** para configurar la contraseña de root

```bash
$ sudo mysql_secure_installation
```

```bash
Enter current password for root (enter for none):
Switch to unix_socket authentication [Y/n] Y
Change the root password? [Y/n] y
Remove anonymous users? [Y/n] Y
Disallow root login remotely? [Y/n] Y
Remove test database and access to it? [Y/n] Y
Reload privilege tables now? [Y/n] Y
```

Iniciar sesión en el usuario root de mysql

```bash
$ mysql -u root -p
```

### Instalar driver MySQL para PHP

Modificar php.ini

```bash
$ sudo nano /etc/php/php.ini
```

Descomentar las siguientes lineas

```bash
extension=pdo_mysql
```

Restaurar servicio

```bash
$ sudo systemctl restart httpd
```

## Instalar PHP

Instalar PHP

```bash
$ sudo pacman -S php php-apache
```

Modificar el archivo **/etc/httpd/conf/httpd.conf**

```bash
$ sudo nano /etc/httpd/conf/httpd.conf
```

Comentar la siguiente linea

```bash
#LoadModule mpm_event_module modules/mod_mpm_event.so
```

Descomentar la siguiente linea

```bash
LoadModule mpm_prefork_module modules/mod_mpm_prefork.so
```

Agregar al final del archivo php8

```bash
LoadModule php_module modules/libphp.so
AddHandler php-script php
Include conf/extra/php_module.conf
```

para php7

```bash
LoadModule php7_module modules/libphp7.so
AddHandler php7-script php
Include conf/extra/php7_module.conf
```

### Test PHP

Agregar

```bash
$ sudo nano /srv/http/test.php
```

```php
<?php
phpinfo();
```

Restaurar servicio httpd

```bash
$ sudo systemctl restart httpd
```

Abra su navegador web y navegue hasta

```bash
$ http://localhost/test.php
```

### Modificar archivo php

```bash
$ sudo nano /etc/httpd/conf/httpd.conf
```

Agregar la extension **index.php**

```bash
<IfModule dir_module>
    DirectoryIndex index.php index.html
</IfModule>
```

Restaurar servicio httpd

```bash
$ sudo systemctl restart httpd
```

### Si quieres instalar php7

Sale un error de php7 que no se encuentra el archivo php

```bash
$ bash: /usr/bin/php: No existe el fichero o el directorio
```

Hacer un enlace simbolico para que reconozca php

```bash
$ sudo ln -s /usr/bin/php7 /usr/bin/php
```

## Instalar phpmyadmin

```bash
$ sudo pacman -S phpmyadmin
```

Modificar el archivo

```bash
$ sudo nano /etc/php/php.ini
```

Descomentar las siguientes lineas

```bash
extension=bz2
extension=mysqli
```

Crear la configuración para phpmyadmin

```bash
$ sudo nano /etc/httpd/conf/extra/phpmyadmin.conf
```

Agregar las lineas

```bash
Alias /phpmyadmin "/usr/share/webapps/phpMyAdmin"
<Directory "/usr/share/webapps/phpMyAdmin">
DirectoryIndex index.php
AllowOverride All
Options FollowSymlinks
Require all granted
</Directory>
```

Modificar el archivo

```bash
$ sudo nano /etc/httpd/conf/httpd.conf
```

Agregar linea al final del archivo

```bash
Include conf/extra/phpmyadmin.conf
```

```bash
$ sudo systemctl restart httpd
```

### Test phpMyAdmin

Abrir el navegador http://localhost/phpmyadmin/

```bash
$ sudo nano /etc/webapps/phpmyadmin/config.inc.php
```

Modificar la siguiente linea

```bash
$ $cfg['blowfish_secret'] = '`MyP@$S`'; /* YOU MUST FILL IN THIS FOR COOKIE AUTH!$ /**
```

```bash
$ sudo systemctl restart httpd
```

## Descargar y instalar Composer

```bash
$ curl -sS https://getcomposer.org/installer | php
$ sudo mv composer.phar /usr/local/bin/composer
```

Restaurar servicio httpd

```bash
sudo systemctl restart httpd
```

Actualizar composer

```bash
$ sudo composer self-update
```

### Si tiener error composer iconv

```bash
$ sudo nano /etc/php/php.ini
```

Descomentar la siguiente linea

```bash
extension=iconv
```

Restaurar servicio httpd

```bash
$ sudo systemctl restart httpd
```
