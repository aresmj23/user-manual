# Instalar php en Linux Debian

```bash
sudo  apt  update
sudo  apt  upgrade  -y
sudo  apt  -y  install  lsb-release  apt-transport-https  certificados-ca
wget  -O  /etc/apt/trusted.gpg.d/php.gpg  https://packages.sury.org/php/apt.gpg
sudo  apt  update
sudo  apt  policy  php
sudo  apt  install  -y  php
php  -v
sudo  apt  install  -y  php-mysql  php-curl  php-json  php-xml  php-mbstring
```

## Instalar php 7.2

```bash
$ sudo apt install php7.2
$ sudo apt install php7.2-fpm
$ sudo apt install php7.2-common php7.2-json php7.2-xml
$ sudo apt install php7.2-curl
$ sudo apt install php7.2-mbstring
$ sudo apt install php7.2-zip
$ sudo apt install php7.2-gd
$ sudo apt install php7.2-intl
$ sudo apt install php7.2-mysql
$ sudo apt install php7.2-pgsql
$
$ 
$ sudo nano /etc/php/7.2/apache2/php.ini
$ sudo systemctl restart apache2
```

## Instalar php 7.4

```bash
$ sudo apt install php7.4
$ sudo apt install php7.4-fpm
$ sudo apt install php7.4-common php7.4-json php7.4-xml
$ sudo apt install php7.4-curl
$ sudo apt install php7.4-mbstring
$ sudo apt install php7.4-zip
$ sudo apt install php7.4-gd
$ sudo apt install php7.4-intl
$ sudo apt install php7.4-mysql
$ sudo apt install php7.4-pgsql
$
$ 
$ sudo nano /etc/php/7.4/apache2/php.ini
$ sudo systemctl restart apache2
```

## Instalar php 8.0

```bash
$ sudo apt install php8.0
$ sudo apt install php8.0-fpm
$ sudo apt install php8.0-common php8.0-json php8.0-xml
$ sudo apt install php8.0-curl
$ sudo apt install php8.0-mbstring
$ sudo apt install php8.0-zip
$ sudo apt install php8.0-gd
$ sudo apt install php8.0-intl
$ sudo apt install php8.0-mysql
$ sudo apt install php8.0-pgsql
$
$ 
$ sudo nano /etc/php/8.0/apache2/php.ini
$ sudo systemctl restart apache2
```

## Instalar php 8.3

```bash
$ sudo apt install php8.3
$ sudo apt install php8.3-fpm
$ sudo apt install php8.3-common php8.3-json php8.3-xml
$ sudo apt install php8.3-curl
$ sudo apt install php8.3-mbstring
$ sudo apt install php8.3-zip
$ sudo apt install php8.3-gd
$ sudo apt install php8.3-intl
$ sudo apt install php8.3-mysql
$ sudo apt install php8.3-pgsql
$
$ 
$ sudo nano /etc/php/8.3/apache2/php.ini
$ sudo systemctl restart apache2
```

## Configuraciones de extensiones de php

```bash
$ sudo nano /etc/php/7.2/apache2/php.ini

extension=gd2

$ sudo systemctl restart apache2
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
sudo a2dismod php8.0
sudo systemctl restart apache2
```

Habilitar
```bash
sudo a2enmod php7.4
sudo systemctl restart apache2
```

Habilitar
```bash
sudo a2enmod php8.2
sudo systemctl restart apache2
```

## Para php 7.2
```bash
sudo update-alternatives --config php
sudo a2dismod php8.0
sudo a2enmod php7.2
sudo systemctl restart apache2
```

## Para php 8.0
```bash
sudo update-alternatives --config php
sudo a2dismod php7.2
sudo a2enmod php8.0
sudo systemctl restart apache2
```

## Para php 8.2
```bash
sudo update-alternatives --config php
sudo a2dismod php7.2
sudo a2enmod php8.2
sudo systemctl restart apache2
```

