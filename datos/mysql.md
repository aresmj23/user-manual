# MySQL y MariaDB: uso diario

Comandos para entrar, crear una base y sacar o meter un volcado. La instalación del servidor está en [LAMP](../entorno/lamp.md).

## Entrar

```bash
sudo mysql
```

Si la cuenta pide clave:

```bash
mysql -u USUARIO -p
```

`-h` solo hace falta cuando el servidor no está en la misma máquina.

## Crear y mirar

```sql
CREATE DATABASE appdb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
SHOW DATABASES;
USE appdb;
SHOW TABLES;
DESCRIBE nombre_tabla;
```

Usuario de una sola base, no administrador:

```sql
CREATE USER 'app'@'localhost' IDENTIFIED BY 'CAMBIA_ESTA_CLAVE';
GRANT ALL PRIVILEGES ON appdb.* TO 'app'@'localhost';
FLUSH PRIVILEGES;
```

## Volcar y restaurar

El detalle, incluido el caso de Docker, está en [Copias de bases de datos](../operacion/backups.md).

```bash
mysqldump -u USUARIO -p NOMBRE_BASE > NOMBRE_BASE.sql
mysql -u USUARIO -p NOMBRE_BASE < NOMBRE_BASE.sql
```

## Qué no hacer

- No des `GRANT ALL PRIVILEGES ON *.*` a la cuenta de una aplicación.
- No dejes la clave en el comando (`-pclave`). `-p` solo, y el cliente la pide.
- No borres una base con `DROP DATABASE` para "limpiar" antes de confirmar el nombre que devuelve `SELECT DATABASE();`.
