Ubuntu Server
$ ssh root@192.168.1.101
password: Fx_7erBP3vasgbcV

mysql: 
Usuario: root
Password: FEUMNghXxmJi

Usuario: sochoa
Password: 

Usuario: amartinez
Password: 

Usuario: root
Password: FEUMNghXxmJi

Usuario: tech4alive
Password: 4Gi6utCikr

Usuario: hola
Password: xKj9hkttU6

Usuario: ironcrypto
Password: isC7FuxDG6

Usuario: mobusapp
Password: isC7FuxDG6

user:risko
password:kc28ma10cw18

user:generalpico
password:xKj9hkttU6

Servidor SucreTrade
root:192.168.1.102
user:sucretrade
password:QNgvAaSpSLqZ

Crear directorios administradores y clientes
root@tech4alive:~# sudo mkdir /home/administrators
root@tech4alive:~# sudo mkdir /home/customers

Listar todos los grupos
root@tech4alive:~# more /etc/group

Listar todos los usuarios
root@tech4alive:~# more /etc/passwd

Crear Grupos
root@tech4alive:~# sudo groupadd -g 1000 administrators
root@tech4alive:~# sudo groupadd -g 2000 customers

Crear Usuarios Administradores
root@tech4alive:~# sudo useradd -u 1001 -g 1000 -s /bin/false -c "Sergio Ochoa" -md /home/administrators/sochoa sochoa
root@tech4alive:~# sudo useradd -u 1002 -g 1000 -s /bin/false -c "Angel Martinez" -md /home/administrators/amartinez amartinez

---------------tech4alive---------------
Crear el Virtual Host en el Servidor Apache
root@tech4alive:~# sudo nano /etc/apache2/sites-available/tech4alive.com.conf

Añadir las siguientes líneas
<VirtualHost *:80>
    ServerName tech4alive.com
    ServerAlias www.tech4alive.com
    ServerAdmin webmaster@tech4alive.com
    DocumentRoot /var/www/html/tech4alive
    <Directory /var/www/html/tech4alive>
	Options Indexes FollowSymLinks MultiViews
	AllowOverride All
	Order allow,deny
	allow from all
    </Directory>
    ErrorLog ${APACHE_LOG_DIR}/tech4alive.com_error.log
    CustomLog ${APACHE_LOG_DIR}/tech4alive.com_access.log combined
</VirtualHost>

Habilitar el Virtual Host:
sudo a2ensite tech4alive.com.conf

Reiniciamos el servidor Apache:
sudo service apache2 restart

Crear Usuarios Clientes
root@tech4alive:~# sudo useradd -u 2001 -g 2000 -s /bin/false -c "tech4alive" -md /home/customers/tech4alive tech4alive
root@tech4alive:~# sudo passwd tech4alive

Crear el repositorio privado para el Virtual Host
root@tech4alive:~# sudo mkdir /home/customers/tech4alive/public_html

Cambiamos el usuario y grupo propietario:
root@tech4alive:~# sudo chown tech4alive.customers /home/customers/tech4alive/public_html/

Crear el enlace simbólico del repositorio general al privado:
root@tech4alive:~# sudo ln -s /home/customers/tech4alive/public_html/ /var/www/html/tech4alive

Editar el archivo index y añadirle una bienvenida:
root@tech4alive:~# sudo nano /home/customers/tech4alive/public_html/index.html

<html>
<head>
	<title>Bienvenidos</title>
</head>
<body>
	<center>Bienvenido a tech4alive!</center>
</body>
</html>



---------------hola---------------
Crear el Virtual Host en el Servidor Apache
root@tech4alive:~# sudo nano /etc/apache2/sites-available/hola.com.conf

Añadir las siguientes líneas
<VirtualHost *:80>
    ServerName hola.com
    ServerAlias www.hola.com
    ServerAdmin webmaster@hola.com
    DocumentRoot /var/www/html/hola
    <Directory /var/www/html/hola>
	Options Indexes FollowSymLinks MultiViews
	AllowOverride All
	Order allow,deny
	allow from all
    </Directory>
    ErrorLog ${APACHE_LOG_DIR}/hola.com_error.log
    CustomLog ${APACHE_LOG_DIR}/hola.com_access.log combined
</VirtualHost>

Habilitar el Virtual Host:
sudo a2ensite hola.com.conf

Reiniciamos el servidor Apache:
sudo service apache2 restart

Crear Usuarios Clientes
root@tech4alive:~# sudo useradd -u 2002 -g 2000 -s /bin/false -c "hola" -md /home/customers/hola hola
root@tech4alive:~# sudo passwd hola

Crear el repositorio privado para el Virtual Host
root@tech4alive:~# sudo mkdir /home/customers/hola/public_html

Cambiamos el usuario y grupo propietario:
root@tech4alive:~# sudo chown hola.customers /home/customers/hola/public_html/

Crear el enlace simbólico del repositorio general al privado:
root@tech4alive:~# sudo ln -s /home/customers/hola/public_html/ /var/www/html/hola

Editar el archivo index y añadirle una bienvenida:
root@tech4alive:~# sudo nano /home/customers/hola/public_html/index.html

<html>
<head>
	<title>Bienvenidos</title>
</head>
<body>
	<center>Bienvenido a hola!</center>
</body>
</html>



---------------ironcrypto---------------
Crear el Virtual Host en el Servidor Apache
root@tech4alive:~# sudo nano /etc/apache2/sites-available/ironcrypto.com.conf

Añadir las siguientes líneas
<VirtualHost *:80>
    ServerName ironcrypto.com
    ServerAlias www.ironcrypto.com
    ServerAdmin webmaster@ironcrypto.com
    DocumentRoot /var/www/html/ironcrypto
    <Directory /var/www/html/ironcrypto>
	Options Indexes FollowSymLinks MultiViews
	AllowOverride All
	Order allow,deny
	allow from all
    </Directory>
    ErrorLog ${APACHE_LOG_DIR}/ironcrypto.com_error.log
    CustomLog ${APACHE_LOG_DIR}/ironcrypto.com_access.log combined
</VirtualHost>

Habilitar el Virtual Host:
sudo a2ensite ironcrypto.com.conf

Reiniciamos el servidor Apache:
sudo service apache2 restart

Crear Usuarios Clientes
root@tech4alive:~# sudo useradd -u 2003 -g 2000 -s /bin/false -c "ironcrypto" -md /home/customers/ironcrypto ironcrypto
root@tech4alive:~# sudo passwd ironcrypto

Crear el repositorio privado para el Virtual Host
root@tech4alive:~# sudo mkdir /home/customers/ironcrypto/public_html

Cambiamos el usuario y grupo propietario:
root@tech4alive:~# sudo chown ironcrypto.customers /home/customers/ironcrypto/public_html/

Crear el enlace simbólico del repositorio general al privado:
root@tech4alive:~# sudo ln -s /home/customers/ironcrypto/public_html/ /var/www/html/ironcrypto

Editar el archivo index y añadirle una bienvenida:
root@tech4alive:~# sudo nano /home/customers/ironcrypto/public_html/index.html

<html>
<head>
	<title>Bienvenidos</title>
</head>
<body>
	<center>Bienvenido a ironcrypto!</center>
</body>
</html>








Instalando Apache
root@tech4alive:~# sudo apt-get install apache2 -y

Instalando php
root@tech4alive:~# sudo apt-get install php7.0 libapache2-mod-php7.0 -y

Reiniciar apache2
root@tech4alive:~# sudo /etc/init.d/apache2 restart

Instalacion del servidor y el cliente de MySQL
root@tech4alive:~# sudo apt-get install mysql-server mysql-client -y

Ahora podemos instalar todos estos módulos
root@tech4alive:~# sudo apt-get -y install php7.0-mysql php7.0-curl php7.0-gd php7.0-intl php-pear php-imagick php7.0-imap php7.0-mcrypt php-memcache  php7.0-pspell php7.0-recode php7.0-sqlite3 php7.0-tidy php7.0-xmlrpc php7.0-xsl php7.0-mbstring php-gettext

Ahora otro reinicio del servidor web:
root@tech4alive:~# sudo /etc/init.d/apache2 restart

Instalamos la interfaz web para manejar el MySQL y sus bases de datos, phpMyAdmin:
root@tech4alive:~# sudo apt-get install phpmyadmin -y 

Seleccionar
apache

Seleccionar
No




Servidores de transferencia de ficheros FPT
root@tech4alive:~# sudo apt-get install vsftpd
root@tech4alive:~# sudo nano /etc/vsftpd.conf

Habilitar el acceso FTP a usuarios anónimos
anonymous_enable=YES

Permitir el acceso de usuarios locales a sus respectivas carpetas privadas, utilizando su propio login y password para acceder al servidor FTP
local_enable=YES

Permitir el modo escritura a los usuarios
write_enable=YES

Enjaula a los usuarios dentro de su propio directorio personal
chroot_local_user=YES

Habilita la lista de usuarios que sólo puedan acceder a sus respectivas carpetas personales al hacer el FTP y no a todo sistema
chroot_list_enable=YES
chroot_list_file=/etc/vsftpd.chroot_list

Mensaje de bienvenida que muestra en pantalla el mensaje que esté entre comillas dobles, cuando alguien se conecta al servidor
ftpd_banner= “mensaje de bienvenida”.

Activa el registro de errores, quién se conecta, etc.
xferlog_enable=YES

Especifica el archivo de registros.
xferlog_file= ruta/archivo








Instalar netbeans
$ sudo chmod +x Descargas/netbeans-8.2-linux.sh
$ sudo sh Descargas/netbeans-8.2-linux.sh

Desinstalar netbeans
$ sudo sh netbeans-8.2/uninstall.sh






Crear el Virtual Host en el Servidor Apache
root@tech4alive:~# sudo nano /etc/apache2/sites-available/mobusapp.com.conf

Añadir las siguientes líneas
<VirtualHost *:80>
    ServerName mobusapp.com
    ServerAlias www.mobusapp.com
    ServerAdmin webmaster@mobusapp.com
    DocumentRoot /var/www/html/mobusapp
    <Directory /var/www/html/mobusapp>
	Options Indexes FollowSymLinks MultiViews
	AllowOverride All
	Order allow,deny
	allow from all
    </Directory>
    ErrorLog ${APACHE_LOG_DIR}/mobusapp.com_error.log
    CustomLog ${APACHE_LOG_DIR}/mobusapp.com_access.log combined
</VirtualHost>

Habilitar el Virtual Host:
sudo a2ensite tech4alive.com.conf

Reiniciamos el servidor Apache:
sudo service apache2 restart

Crear Usuarios Clientes
root@tech4alive:~# sudo useradd -u 2004 -g 2000 -s /bin/false -c "mobusapp" -md /home/customers/mobusapp mobusapp
root@tech4alive:~# sudo passwd mobusapp

Crear el repositorio privado para el Virtual Host
root@tech4alive:~# sudo mkdir /home/customers/mobusapp/public

Cambiamos el usuario y grupo propietario:
root@tech4alive:~# sudo chown mobusapp.customers /home/customers/mobusapp/public/

Crear el enlace simbólico del repositorio general al privado:
root@tech4alive:~# sudo ln -s /home/customers/mobusapp/public/ /var/www/html/mobusapp

Editar el archivo index y añadirle una bienvenida:
root@tech4alive:~# sudo nano /home/customers/tech4alive/public_html/index.html

<html>
<head>
	<title>Bienvenidos</title>
</head>
<body>
	<center>Bienvenido a tech4alive!</center>
</body>
</html>

Crear Usuarios Clientes
root@tech4alive:~# sudo useradd -u 2001 -g 2000 -s /bin/false -c "sucretrade" -md /home/customers/sucretrade sucretrade
root@tech4alive:~# sudo passwd sucretrade

Crear el repositorio privado para el Virtual Host
root@tech4alive:~# sudo mkdir /home/customers/sucretrade/public_html

Cambiamos el usuario y grupo propietario:
root@tech4alive:~# sudo chown sucretrade.customers /home/customers/sucretrade/public_html/

Crear el enlace simbólico del repositorio general al privado:
root@tech4alive:~# sudo ln -s /home/customers/sucretrade/public_html/sucretrade/public/ /var/www/html/sucretrade


sudo chmod -R 777 webbase/storage/
sudo chmod -R 777 webbase/bootstrap/cache/


Primo Angel, [23.11.16 16:51]
find /home/cusomsers-2.9.0 -type d -exec chmod -R 755 {} \;

Primo Angel, [23.11.16 16:51]
find /home/marcelo/Programas/cakephp-2.9.0 -type f -exec chmod -R 644 {} \;


find sucretrade/ -type d -exec chmod -R 755 {} \;
  595  find sucretrade/ -type f -exec chmod -R 644 {} \;
  596  cd sucretrade/
  597  ls
  598  chmod 777 -R storage/
  599  ls
  600  cd bootstrap/
  601  ls
  602  chmod 777 -R cache/
  603  cd ..
  604  cd alivesafe/
  605  ls
  606  nano .env
  607  cd /home/customers/
  608  ls
  609  cd sucretrade/
  610  cd 
  611  ls
  612  cd /home/customers/sucretrade/public/
  613  ls
  614  cd images/
  615  ls
  616  cd ..
  617  chmod 777 -R images/

