# Instalar LAMP


## Instalar Apache 

sudo apt install apache2

## Instalar Mysql

sudo apt install mysql-server

sudo mysql_secure_installation

There are three levels of password validation policy:

LOW    Length >= 8
MEDIUM Length >= 8, numeric, mixed case, and special characters
STRONG Length >= 8, numeric, mixed case, special characters and dictionary              file

Please enter 0 = LOW, 1 = MEDIUM and 2 = STRONG: 0

sudo mysql

mysql> ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password by 'mynewpassword';

mysql> SHOW VARIABLES LIKE 'validate_password%'; 

mysql> SET GLOBAL validate_password.policy = 0;

SET GLOBAL validate_password.policy = 0;   # For LOW
SET GLOBAL validate_password.policy = 1;   # For MEDIUM
SET GLOBAL validate_password.policy = 2;   # For HIGH



sudo mysql

mysql> CREATE DATABASE example_database;

mysql> CREATE USER 'example_user'@'%' IDENTIFIED BY 'password';

mysql> ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';


sudo systemctl status mysql.service
sudo systemctl start mysql.service
sudo systemctl stop mysql.service
sudo systemctl enable mysql.service
sudo systemctl disable mysql.service


## Instalar Php


sudo apt install php libapache2-mod-php php-mysql


php -v


sudo apt install php php-{fpm,mbstring,bcmath,xml,mysql,common,gd,cli,curl,zip}


sudo systemctl enable php8.1-fpm --now


## Instalar PhpMyAdmin



sudo nano /etc/apache2/conf-available/phpmyadmin.conf

Antes

```bash
# phpMyAdmin default Apache configuration

Alias /phpmyadmin /usr/share/phpmyadmin

<Directory /usr/share/phpmyadmin>
    Options SymLinksIfOwnerMatch
    DirectoryIndex index.php

    # limit libapache2-mod-php to files and directories necessary by pma
    <IfModule mod_php7.c>
        php_admin_value upload_tmp_dir /var/lib/phpmyadmin/tmp
        php_admin_value open_basedir /usr/share/phpmyadmin/:/usr/share/doc/phpmyadmin/:/etc/phpmyadmin/:/var/lib/phpmyadmin/:/usr/share/php/:/usr/share/javascript/
    </IfModule>

</Directory>

# Disallow web access to directories that don't need it
<Directory /usr/share/phpmyadmin/templates>
    Require all denied
</Directory>
<Directory /usr/share/phpmyadmin/libraries>
    Require all denied
</Directory>
```
