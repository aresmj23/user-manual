# MongoDB

Deja el servicio en marcha, crea un usuario administrador y enciende la autenticación. El alta del repositorio apt cambia con la versión de Debian: sigue el tutorial vigente de MongoDB para el sistema que estés instalando y vuelve aquí para el cierre.

Documentación del repositorio: https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-debian/

## Requisitos

- Paquetes de MongoDB ya instalados (`mongod` responde).
- `mongosh` instalado.

## Servicio

```bash
sudo systemctl enable --now mongod
sudo systemctl status mongod
mongod --version
```

## Usuario administrador

```bash
mongosh
```

```javascript
use admin
db.createUser({
  user: "madmin",
  pwd: "CAMBIA_ESTA_CLAVE",
  roles: [ { role: "userAdminAnyDatabase", db: "admin" } ]
})
```

Sal de la consola. En `/etc/mongod.conf` activa la autenticación. Respeta los espacios: `authorization` va indentado bajo `security`.

```yaml
security:
  authorization: enabled
```

```bash
sudo systemctl restart mongod
mongosh -u madmin -p --authenticationDatabase admin
```

Dentro:

```javascript
use admin
show users
```

## Compass

Descarga el `.deb` actual desde https://www.mongodb.com/docs/compass/current/install/ e instálalo:

```bash
sudo dpkg -i mongodb-compass_*_amd64.deb
sudo apt --fix-broken install
mongodb-compass
```

## Qué no hacer

- No dejes `authorization` desactivado después de crear el usuario. Sin esa línea, cualquiera en la máquina entra sin clave.
- No anotes la clave real en esta página.
- No instales un `.deb` de Compass fijado en una versión vieja si la página oficial ya publicó otra.
