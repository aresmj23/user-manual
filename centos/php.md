# Instalar php 8.1 en centos 7

Actualizar el índice de su paquete local:

```bash
sudo yum update -y
```


```bash
sudo yum -y install yum-utils https://rpms.remirepo.net/enterprise/remi-release-7.rpm
```


```bash
sudo yum update -y
```


```bash
sudo yum-config-manager --disable 'remi-php*'
```


```bash
sudo yum-config-manager --enable remi-php81
```


```bash
sudo yum repolist
```


```bash
sudo yum -y install php php-{cli,fpm,mysqlnd,zip,devel,gd,mbstring,curl,xml,pear,bcmath,json,opcache,redis,memcache}
```


```bash
php --version
php -v
```


php -v
rpm -qa | grep php
yum remove "php-*" -y
yum --disablerepo=remi-php72 --enablerepo=remi-php73 install php php-gd php-mbstring php-mysql php-curl php-mcrypt
rpm -qa | grep php
yum remove "php-*" -y
yum --disablerepo=remi-php73 --enablerepo=remi-php56 install php php-gd php-mbstring php-mysql php-curl php-mcrypt
php -v

