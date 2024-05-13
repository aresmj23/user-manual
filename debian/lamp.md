# Instalar LAMP en Debian 12

## Step 1: Update the System

sudo apt update
sudo apt upgrade -y

## Step 2: Install MariaDB Database Server

sudo apt install -y mariadb-server mariadb-client

sudo systemctl status mariadb

## Step 3: Secure the Database Server

sudo mysql_secure_installation

## Step 4: Install Apache Web Server

sudo apt install -y apache2 apache2-utils

sudo systemctl status apache2

## Step 5: Enable HTTP and HTTPS Ports

sudo apt install ufw -y

sudo ufw allow http
sudo ufw allow https

sudo ufw enable
sudo ufw reload

## Step 6: Install PHP

sudo apt install -y php libapache2-mod-php php-cli php-fpm php-json php-pdo php-mysql php-zip php-gd php-mbstring php-curl php-xml php-pear php-bcmath


php -v

### How To Install PHP (8.3, 8.2 or 7.4) on Debian 12

sudo apt update 
sudo apt upgrade

sudo apt install -y apt-transport-https lsb-release ca-certificates wget 
wget -O /etc/apt/trusted.gpg.d/php.gpg https://packages.sury.org/php/apt.gpg
echo "deb https://packages.sury.org/php/ $(lsb_release -sc) main" | sudo tee /etc/apt/sources.list.d/php.list 

sudo apt update

sudo apt install -y php8.3 
sudo apt install -y php8.2
sudo apt install -y php8.0 
sudo apt install -y php7.4 

sudo update-alternatives --config php

sudo update-alternatives --set php /usr/bin/php8.0 

### Install php 8.0

sudo apt install -y php8.0 php8.0-cli php8.0-fpm php8.0-mysql php8.0-zip php8.0-gd php8.0-mbstring php8.0-curl php8.0-xml php8.0-bcmath


php -v

## Step 7: Test PHP Installation

echo "<?php phpinfo(); ?>" | sudo tee /var/www/html/info.php

## Step 8: Remove PHP Info File

sudo rm /var/www/html/info.php


## Step 8: Install phpmyadmin

sudo apt update
sudo apt upgrade

sudo apt install php-mbstring php-zip php-gd

sudo apt install phpmyadmin

seleccionar apache2, despues ok y yes


sudo nano /etc/php/8.0/apache2/php.ini

Descomentar la linea

extension=pdo_mysql

sudo systemctl restart apache2

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

## Crear un usuario de mysql y tambien insertar contraseña 

```bash
$ mysql -u root
```

Crear un usuario de mysql y tambien insertar contraseña
```bash
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'howtoforge';
GRANT ALL PRIVILEGES ON *.* TO 'admin'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;
exit
```


## Cómo crear Virtual Hosts con Apache para Linux y Mac

https://styde.net/como-crear-virtual-hosts-con-apache-para-linux-y-mac/