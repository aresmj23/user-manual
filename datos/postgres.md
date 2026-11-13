# PostgreSQL y pgAdmin

Instala PostgreSQL, crea un usuario de aplicación y, en Debian o Ubuntu, publica pgAdmin 4 en el navegador.

Probado como procedimiento de Debian 12 y Manjaro. En Ubuntu los pasos de apt son los mismos; cambia el nombre de la versión que devuelve `lsb_release -cs`.

## Requisitos

- Debian 12, Ubuntu o Manjaro actualizado.
- `curl`, `ca-certificates` y `gpg` en Debian y Ubuntu.

En Debian y Ubuntu el paquete crea el clúster e inicializa los datos. No ejecutes `initdb` ahí.

## Debian y Ubuntu

La clave del repositorio PGDG tiene que existir antes de `apt update`.

```bash
sudo apt install -y curl ca-certificates gnupg lsb-release
sudo install -d /usr/share/keyrings
curl -fsSL https://www.postgresql.org/media/keys/ACCC4CF8.asc | sudo gpg --dearmor -o /usr/share/keyrings/pgdg.gpg
echo "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/pgdg.gpg] http://apt.postgresql.org/pub/repos/apt $(lsb_release -cs)-pgdg main" | sudo tee /etc/apt/sources.list.d/pgdg.list
sudo apt update
sudo apt install -y postgresql
```

## Comprobar el servicio

```bash
sudo systemctl enable --now postgresql
sudo systemctl status postgresql
```

El estado tiene que quedar en `active (running)`.

## Usuario y clave

Entra con el usuario del sistema `postgres`. La clave no queda en el historial de la shell si usas `\password`.

```bash
sudo -u postgres psql
```

```sql
\password postgres
CREATE USER app WITH PASSWORD 'CAMBIA_ESTA_CLAVE';
CREATE DATABASE app OWNER app;
\du
\q
```

`CREATEDB` y `CREATEROLE` convierten a ese usuario en administrador. No los añadas a la cuenta de una aplicación.

## pgAdmin 4 en Debian y Ubuntu

```bash
curl -fsSL https://www.pgadmin.org/static/packages_pgadmin_org.pub | sudo gpg --dearmor -o /usr/share/keyrings/pgadmin4.gpg
echo "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/pgadmin4.gpg] https://ftp.postgresql.org/pub/pgadmin/pgadmin4/apt/$(lsb_release -cs) pgadmin4 main" | sudo tee /etc/apt/sources.list.d/pgadmin4.list
sudo apt update
sudo apt install -y pgadmin4-web
sudo /usr/pgadmin4/bin/setup-web.sh
```

`setup-web.sh` pide un correo y una clave de acceso a pgAdmin. Son credenciales de la interfaz web, distintas de las de PostgreSQL.

## Manjaro

```bash
sudo pacman -Sy
sudo pacman -S postgresql
sudo -iu postgres initdb --locale=C.UTF-8 --encoding=UTF8 -D /var/lib/postgres/data
sudo systemctl enable --now postgresql
sudo systemctl status postgresql
```

Si `initdb` responde que el directorio no está vacío, el clúster ya existe. No lo vuelvas a inicializar.

```bash
sudo -u postgres psql -c '\password postgres'
sudo pacman -S php-pgsql
```

En `/etc/php/php.ini` deja activas estas líneas y reinicia el servidor web:

```ini
extension=pdo_pgsql
extension=pgsql
```

```bash
sudo systemctl restart httpd
```

Las copias de seguridad están en [Copias de bases de datos](../operacion/backups.md).

## Errores frecuentes

- `apt update` falla con `NO_PUBKEY` o `signed-by`: la clave no se escribió en `/usr/share/keyrings/pgdg.gpg` antes de actualizar.
- En Manjaro el servicio no arranca y el log dice que falta el directorio de datos: falta el `initdb`.
- Un contenedor y el PostgreSQL del sistema no pueden escuchar los dos el puerto 5432. `sudo ss -ltnp | grep 5432` muestra cuál lo tiene.

## Qué no hacer

- No pongas la clave en la línea de comandos (`ALTER USER ... PASSWORD` dentro de un script que quede en el historial) si puedes usar `\password`.
- No cambies `pg_hba.conf` a `md5` para todos los métodos. Las versiones actuales usan `scram-sha-256`. Cámbialo solo si un cliente concreto no puede autenticarse, y prefiere `scram-sha-256` antes que `md5`.
- No documentes el nombre real del contenedor ni la ruta de un backup de un proyecto dentro de esta página.
