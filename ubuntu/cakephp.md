# CakePHP

CAMBIAR EN EL PHP.INI (NOTA ES PARA CAKEPHP)

```bash
$ sudo apt-get install php7.4-intl
```

Instalar intl

```bash
$ sudo nano /etc/php/7.4/apache2/php.ini
```

Cambiar los siguientes parametros

```bash
error_reporting = E_ALL
display_errors = On
extension=php_intl.dll
```

```bash
sudo systemctl restart apache2
```
