# Instalar postgres

https://www.howtoforge.com/how-to-install-postgresql-and-pgadmin-tool-on-debian-12/

```bash
$ sudo sh -c 'echo "deb [arch=amd64 signed-by=/usr/share/keyrings/pgdg.gpg] http://apt.postgresql.org/pub/repos/apt $(lsb_release -cs)-pgdg main" > /etc/apt/sources.list.d/pgdg.list'
```

```bash
$ curl -fsSL https://www.postgresql.org/media/keys/ACCC4CF8.asc | sudo gpg --dearmor -o /usr/share/keyrings/pgdg.gpg
```

```bash
$ sudo apt update
```

```bash
$ sudo apt install postgresql
```


```bash
$ sudo systemctl is-enabled postgresql
$ sudo systemctl status postgresql
```



```bash
$ sudo -u postgres psql
```

psql
```bash
$ ALTER USER postgres WITH PASSWORD 'p4ssw0rdAdmin';
```

## Crear un usuario en postgres

sudo -u postgres psql

CREATE USER alice with CREATEDB CREATEROLE;
ALTER USER alice with PASSWORD 'p4ssw0rd';

Verificar

\du

# Instalar PgAdmin4


```bash
$ sudo echo "deb [arch=amd64 signed-by=/usr/share/keyrings/pgadmin4.gpg] https://ftp.postgresql.org/pub/pgadmin/pgadmin4/apt/$(lsb_release -cs) pgadmin4 main"\
| sudo tee /etc/apt/sources.list.d/pgadmin4.list
```



```bash
$ curl -fsSL https://www.pgadmin.org/static/packages_pgadmin_org.pub | sudo gpg --dearmor -o /usr/share/keyrings/pgadmin4.gpg
```


```bash
sudo apt update
sudo apt install pgadmin4-web
```

con root

```bash
/usr/pgadmin4/bin/setup-web.sh
```

Insertar un email y password pgAdmin4.

Ejemplo

jperez@domain.com

## Install postgresql an pgadmin debian

https://www.tecmint.com/install-postgresql-on-debian/

