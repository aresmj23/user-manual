# Docker

Instala Docker Engine y el plugin Compose, y deja a mano los comandos de imágenes y contenedores.

Probado en Debian 12 y Manjaro. Docker Engine es el servicio para un servidor y para la terminal. Docker Desktop es una aplicación de escritorio aparte: no sustituye estos pasos y no hace falta para construir ni ejecutar contenedores.

## Requisitos

- Debian 12 o Manjaro actualizado.
- Tu usuario puede usar `sudo`.

## Debian: Docker Engine

```bash
sudo apt update
sudo apt install -y ca-certificates curl
sudo install -m 0755 -d /etc/apt/keyrings
sudo curl -fsSL https://download.docker.com/linux/debian/gpg -o /etc/apt/keyrings/docker.asc
sudo chmod a+r /etc/apt/keyrings/docker.asc
sudo tee /etc/apt/sources.list.d/docker.sources <<EOF
Types: deb
URIs: https://download.docker.com/linux/debian
Suites: $(. /etc/os-release && echo "$VERSION_CODENAME")
Components: stable
Architectures: $(dpkg --print-architecture)
Signed-By: /etc/apt/keyrings/docker.asc
EOF
sudo apt update
sudo apt install -y docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin
```

```bash
sudo systemctl enable --now docker
docker --version
docker compose version
```

Ejecutar Docker sin `sudo`:

```bash
sudo usermod -aG docker "$USER"
```

Cierra la sesión y vuelve a entrar. `newgrp docker` vale para la terminal actual. Un reinicio no es necesario.

## Manjaro

```bash
sudo pacman -Syu
sudo pacman -S docker docker-compose
sudo systemctl enable --now docker.service
sudo usermod -aG docker "$USER"
docker version
```

En Manjaro el paquete `docker-compose` sigue existiendo. En Debian usa el plugin: el comando es `docker compose`, con espacio, no `docker-compose`.

## Comprobar

```bash
docker run --rm hello-world
```

Tiene que descargar la imagen y terminar con el mensaje de que la instalación funciona.

## Imágenes

```bash
docker build -t NOMBRE_IMAGEN .
docker build --no-cache -t NOMBRE_IMAGEN .
docker images
docker rmi NOMBRE_IMAGEN
docker image prune
```

`--no-cache` va delante del contexto. `-no-cache` no es una opción.

## Contenedores

```bash
docker run --name NOMBRE_CONTENEDOR NOMBRE_IMAGEN
docker run -d -p PUERTO_HOST:PUERTO_CONTENEDOR NOMBRE_IMAGEN
docker ps
docker ps --all
docker start NOMBRE_CONTENEDOR
docker stop NOMBRE_CONTENEDOR
docker rm NOMBRE_CONTENEDOR
docker exec -it NOMBRE_CONTENEDOR sh
docker logs -f NOMBRE_CONTENEDOR
docker inspect NOMBRE_CONTENEDOR
docker stats
```

Un contenedor se borra parado. Una imagen se borra cuando ningún contenedor la usa.

Ejemplo de MySQL. La clave y el nombre de la base son de ese contenedor, no de un servidor real:

```bash
docker run -d --name mysql-dev -e MYSQL_ROOT_PASSWORD=CAMBIA_ESTA_CLAVE -e MYSQL_DATABASE=appdb -p 3306:3306 mysql:8
```

Si el puerto 3306 o el 5432 ya están ocupados por el servicio del sistema, publica otro puerto del host (`-p 3307:3306`) o para el servicio local. `sudo ss -ltnp | grep 5432` muestra el proceso.

## Errores frecuentes

- `permission denied` al hablar con el socket: el usuario no está en el grupo `docker`, o la sesión se abrió antes de añadirlo.
- `docker compose` no existe y sí `docker-compose`: en Debian falta el paquete `docker-compose-plugin`. No instales el binario suelto 1.26; esa serie está abandonada.
- El build no ve el `Dockerfile`: el comando se lanzó fuera del directorio del proyecto, o falta el `.` final.

## Qué no hacer

- No mezcles la instalación de Docker Desktop con la de Docker Engine en el mismo procedimiento. Si solo vas a usar la terminal, Engine alcanza.
- No documentes aquí el nombre de un contenedor de un proyecto ni la ruta donde ese proyecto guarda los backups.
