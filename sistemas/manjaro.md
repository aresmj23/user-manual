# Manjaro: pacman, hora y fuentes

Comandos de pacman que se usan al mantener el sistema, más la hora y las fuentes de Microsoft.

Las instalaciones de Apache, Docker, PostgreSQL o Node en Manjaro están en sus páginas: [LAMP](../entorno/lamp.md), [Docker](../entorno/docker.md), [PostgreSQL](../datos/postgres.md), [Node](../entorno/node.md), [Java](../entorno/java.md).

## Pacman

Instalar y actualizar:

```bash
sudo pacman -S paquete
sudo pacman -Syu
```

`-Syyu` vuelve a bajar las bases de datos aunque parezcan al día. `-Syuu` además permite bajar de versión un paquete. Los dos son para salir de un problema concreto, no la actualización de cada día.

Buscar, listar y borrar:

```bash
sudo pacman -Ss texto
pacman -Q
pacman -Qdt
sudo pacman -R paquete
sudo pacman -Rns paquete
```

`-Rns` quita el paquete y las dependencias que ya nadie usa. `-Qdt` lista huérfanos; revísalos antes de borrarlos.

Caché:

```bash
sudo pacman -Sc
```

`-Scc` vacía también los paquetes que servirían para volver a una versión anterior. Úsalo cuando necesites el espacio, sabiendo que ya no podrás bajar de versión desde esa caché.

Ejemplo:

```bash
sudo pacman -S neofetch
neofetch
```

## Hora

```bash
timedatectl set-ntp true
timedatectl status
```

`System clock synchronized: yes` confirma que el reloj del sistema sigue a NTP. Hace falta el servicio de sincronización de systemd, que en Manjaro ya viene instalado.

## Fuentes de Microsoft

Están en AUR y chocan entre sí: instala una.

```bash
sudo pamac upgrade -a
sudo pamac build ttf-ms-fonts
```

La otra opción es `ttf-ms-win10`, no las dos. Comprueba si puedes usarlas con la licencia que tienes. El paquete no resuelve esa pregunta.

## Qué no hacer

- No actualices con `-Syuu` en cada mantenimiento. Puede bajar paquetes de versión y dejar el sistema a medias.
- No borres huérfanos en bloque sin leer la lista de `-Qdt`.
