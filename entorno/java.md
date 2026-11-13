# Java con SDKMAN o Arch

Instala varias versiones de Java y elige la activa. En Debian y Ubuntu el camino es SDKMAN. En Manjaro también vale el mecanismo `archlinux-java`.

## Requisitos

- `curl`, `zip` y `unzip` para SDKMAN.

## SDKMAN

```bash
sudo apt install -y zip unzip curl
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk version
```

Las versiones concretas cambian. Elige una de la lista, no copies un identificador de una nota antigua.

```bash
sdk list java
sdk install java IDENTIFICADOR
sdk current java
sdk use java IDENTIFICADOR
java -version
```

El `use` dura lo que dura la terminal. Para dejarla fija:

```bash
sdk default java IDENTIFICADOR
```

Mantenimiento:

```bash
sdk upgrade java
sdk selfupdate
sdk offline enable
sdk offline disable
sdk flush archives
sdk flush temp
```

Quitar SDKMAN borra también los JDK que instaló:

```bash
rm -rf "$HOME/.sdkman"
```

## Manjaro

```bash
sudo pacman -S jdk-openjdk
sudo pacman -S jdk11-openjdk
sudo pacman -S jdk8-openjdk
archlinux-java status
sudo archlinux-java set java-21-openjdk
java -version
```

El nombre que acepta `archlinux-java set` es uno de los que imprime `archlinux-java status`. Java 7 ya no está en los repositorios actuales.

## Comprobar

`java -version` y `javac -version` responden, y la versión es la que acabas de fijar.

## Qué no hacer

- No escribas `/home/alguien/.sdkman` en un comando que vaya a seguir otra persona. La ruta es `$HOME/.sdkman`.
- No instales un identificador de 2021 (`8.0.292.hs-adpt`, `11.0.11.hs-adpt`) sin mirar `sdk list java`. Esos builds ya no son el candidato actual.
