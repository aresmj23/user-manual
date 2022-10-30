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

Conectar mysql

mysql -h localhost -u root -p


## Instalar Php


sudo apt install php libapache2-mod-php php-mysql


php -v


sudo apt install php php-{fpm,mbstring,bcmath,xml,mysql,common,gd,cli,curl,zip}


sudo systemctl enable php8.1-fpm --now


echo "<?php phpinfo(); ?>" | sudo tee /var/www/html/info.php


## Instalar PhpMyAdmin




## URL AMIGABLES

```bash
$ sudo a2enmod rewrite
$ sudo systemctl restart apache2
```

```bash
$ sudo nano /etc/apache2/apache2.conf
```

Cambiar none por All

```bash
<Directory />
	Options FollowSymLinks
	AllowOverride All 
	Require all denied
</Directory>
 
<Directory /var/www/>
	Options Indexes FollowSymLinks
	AllowOverride All
	Require all granted
</Directory>
```


```bash
$ sudo systemctl restart apache2
```