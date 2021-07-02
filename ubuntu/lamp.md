# Instalar LAMP en Ubuntu







## URL AMIGABLES

```bash
$ sudo a2enmod rewrite
$ sudo service apache2 restart
```

```bash
$ sudo nano /etc/apache2/apache2.conf
```

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
$ sudo service apache2 restart
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