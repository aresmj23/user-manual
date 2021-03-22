# Instalar PostgreSQL

Actualizar Paquetes
```bash
$ sudo pacman -Sy
```

Instalar PostgreSQL
```bash
$ sudo pacman -S postgresql
```

Ver la version de PostgreSQL
```bash
$ postgres --version
```

Ver el estado de PostgreSQL
```bash
$ sudo systemctl status postgresql
```

Ingresar a PostgreSQL
```bash
$ sudo su - postgres
```

Ahora puede inicializar el directorio de datos de PostgreSQL con el siguiente comando: 
```bash
postgres@mj23 $ initdb --locale en_US.UTF-8 -D /var/lib/postgres/data
```

Salir de PostgreSQL
```bash
postgres@mj23 $ exit
```

Iniciar PostgreSQL
```bash
$ sudo systemctl start postgresql
```

Ver el estado de PostgreSQL
```bash
$ sudo systemctl status postgresql
```

## Cambiar contraseña a PostgreSQL
Ingresar a PostgreSQL
```bash
$ sudo -u postgres psql postgres
```

Cambiar contraseña
```bash
postgres@mj23 $ \password postgres
```

```bash
postgres@mj23 $ exit
```

## Instalar driver PostgreSQL para PHP
Instalar driver pgsql
```bash
$ sudo pacman -S php-pgsql
```

Modificar php.ini
```bash
$ sudo nano /etc/php/php.ini
```

Descomentar las siguientes lineas
```bash
extension=pdo_pgsql.so
extension=pgsql.so
```

Restaurar servicio
```bash
$ sudo systemctl restart httpd
```
