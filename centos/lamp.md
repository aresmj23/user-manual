## URL AMIGABLES

```bash
$ sudo nano /etc/httpd/conf/httpd.conf
```

Cambiar none por All

```bash 
<Directory "/var/www/html">
	Options Indexes FollowSymLinks
	AllowOverride All
	Require all granted
</Directory>
```

```bash
sudo systemctl restart httpd
```
