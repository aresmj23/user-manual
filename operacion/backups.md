# Copias de bases de datos

Saca y devuelve una base de MySQL, MariaDB o PostgreSQL. Los nombres de abajo son marcadores: sustitúyelos por el usuario, la base y el contenedor de ese entorno.

## MySQL o MariaDB en el servidor

```bash
mysqldump -u USUARIO -p NOMBRE_BASE > NOMBRE_BASE.sql
mysql -u USUARIO -p NOMBRE_BASE < NOMBRE_BASE.sql
```

`mysqldump` pide la clave y escribe SQL en el archivo. La restauración espera que la base ya exista.

## PostgreSQL en el servidor

Formato custom, que es el que luego lee `pg_restore`:

```bash
pg_dump -U USUARIO -d NOMBRE_BASE -F c -f NOMBRE_BASE.dump
pg_restore -U USUARIO -d NOMBRE_BASE --clean --if-exists --no-owner NOMBRE_BASE.dump
```

SQL plano, si quieres abrirlo en un editor:

```bash
pg_dump -U USUARIO -d NOMBRE_BASE > NOMBRE_BASE.sql
psql -U USUARIO -d NOMBRE_BASE < NOMBRE_BASE.sql
```

`--clean --if-exists` borra objetos de la base destino antes de recrearlos. Úsalo cuando estás reponiendo una copia encima de una base que ya tiene datos.

## PostgreSQL dentro de Docker

El archivo queda en el host, no dentro del contenedor. `-i` es obligatorio al restaurar: sin eso, `docker exec` no entrega el archivo por la entrada estándar.

```bash
docker exec NOMBRE_CONTENEDOR pg_dump -U USUARIO -d NOMBRE_BASE -F c > NOMBRE_BASE.dump
docker exec -i NOMBRE_CONTENEDOR pg_restore -U USUARIO -d NOMBRE_BASE -F c --clean --if-exists --no-owner < NOMBRE_BASE.dump
```

Cada parte del `pg_dump` hace una cosa distinta. Con un contenedor llamado `postgres`, el usuario `postgres` y la base `pension`, el comando queda `docker exec postgres pg_dump -U postgres -d pension -F c > pension.dump`.

| Parámetro | Descripción |
| --- | --- |
| `docker exec postgres` | Ejecuta `pg_dump` dentro del contenedor |
| `-U postgres` | Usuario de PostgreSQL |
| `-d pension` | Base de datos |
| `-F c` | Formato custom, el que después lee `pg_restore` |
| `>` | Guarda el archivo en Debian, en el directorio donde estás, no dentro del contenedor |

La restauración de un volcado custom es `pg_restore`. `pg_dump` solo exporta. El `<` del `pg_restore` hace el camino inverso: lee el archivo de Debian y lo entrega al contenedor. Por eso esa línea lleva `-i`.

Si el volcado es SQL plano:

```bash
docker exec NOMBRE_CONTENEDOR pg_dump -U USUARIO -d NOMBRE_BASE > NOMBRE_BASE.sql
docker exec -i NOMBRE_CONTENEDOR psql -U USUARIO -d NOMBRE_BASE < NOMBRE_BASE.sql
```

## Comprobar

- El archivo de salida pesa más que unos pocos bytes. Un fallo de autenticación a veces deja un archivo vacío.
- Después de restaurar, entra a la base y cuenta una tabla que conozcas.

## Qué no hacer

- No redirijas un `pg_dump` hacia el mismo archivo que estás leyendo.
- No restaures `--clean` contra una base de producción si el archivo no es el que crees. El nombre del archivo tiene que incluir la fecha.
- No guardes estos volcados dentro del directorio público del sitio.
