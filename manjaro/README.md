# Manual de PACMAN

Instala un paquete.
```bash
$ sudo pacman -S paquete
```

Actualiza la base de datos y todos los paquetes.
```bash
$ sudo pacman -Syu
```

Fuerza una actualización completa de la base de datos y actualiza todos los paquetes.
```bash
$ sudo pacman -Syyu
```

Fuerza la actualización de paquetes y también degrada paquetes (si tiene una versión más nueva que en el repositorio). Normalmente esto no debe usarse. Solo si está tratando de solucionar un problema específico debido a un nuevo paquete que se elimina del repositorio.
```bash
$ sudo pacman -Syuu
```

Permite buscar un paquete específico.
```bash
$ sudo pacman -Ss
```

Borra la caché de pacman.
```bash
$ sudo pacman -Sc
```

Borra paquetes guardados y limpia repositorios no utilizados.
```bash
$ sudo pacman -Scc
```

Elimina un paquete.
```bash
$ sudo pacman -R
```

Elimina el paquete junto a las dependencias que no son utilizadas por otros paquetes.
```bash
$ sudo pacman -Rsu
```

Muestra una lista de los paquetes instalados
```bash
$ sudo pacman -Q
```

Muestra los paquetes huérfanos
```bash
$ sudo pacman -Qdt
```

Ejemplo instalar neofetch
```bash
$ pacman -S neofetch
$ neofetch
```
