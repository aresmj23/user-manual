# Instalar mongodb

https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-debian/

https://howtoforge.es/como-instalar-y-asegurar-mongodb-en-debian-11/

sudo systemctl start mongod
sudo systemctl enable mongod
sudo systemctl status mongod
mongod --version

para ingresar a mongodb

```bash
mongosh
```

```bash
> use admin
```

Crear un usuario admin
```bash
db.createUser({
  user: "madmin",
  pwd: "ares2308",
  roles: [ { role: "userAdminAnyDatabase", db: "admin" } ]
})
```


```bash
sudo nano /etc/mongod.conf
```

Añade las siguientes líneas para activar la autenticación:
```bash
security:
 authorization: enabled
```

```bash
sudo systemctl restart mongod
```

Probar conexion con el nuevo usuario
```bash
mongosh -u madmin -p
```

```bash
> use admin
> show users
```


## Instalar compass 


https://www.mongodb.com/docs/compass/current/install/

wget https://downloads.mongodb.com/compass/mongodb-compass_1.40.4_amd64.deb

sudo dpkg -i mongodb-compass_1.40.4_amd64.deb

mongodb-compass

