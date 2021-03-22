# Instalar Docker

```bash
$ sudo pacman -Syu
```

```bash
$ sudo pacman -S docker
```


```bash
$ sudo systemctl start docker.service
$ sudo systemctl enable docker.service
```

```bash
$ sudo docker version
```

## Ejecute Docker sin root 
```bash
$ sudo usermod -aG docker $USER
```

```bash
$ reboot
```

## Buscando una imagen de Docker 
```bash
$ docker search [name]
```

Buscar nginx servidor web
```bash
$ docker search nginx
```

## Iniciar docker 
```bash
$ docker run hello-world
```

Para ver qué contenedores de Docker se están ejecutando y verificar su estado actual.
```bash
$ docker container ls
```

Para ver una lista de todas las imágenes de Docker instaladas.
```bash
$ docker images
```

Para ver el uso actual de CPU, RAM y red de las imágenes en ejecución
```bash
$ docker stats
```

Para ver la configuración de red de Docker
```bash
$ docker network ls
```

```bash
$ 
```
## Instalar docker-compose

Instalar
```bash
$ sudo pacman -S docker-compose 
```

Ver la version
```bash
$ docker-compose --version
```

Eliminar
```bash
$ sudo pacman -R docker-compose
```
