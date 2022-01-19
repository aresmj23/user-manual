# Instalar sdkman

```bash
$ sudo apt install zip unzip curl
$ curl -s "https://get.sdkman.io" | bash
$ source "$HOME/.sdkman/bin/sdkman-init.sh"
$ sdk version
```

## Lista versiones

```bash
$ sdk list
$ sdk list java
```

## Instalar java

```bash
$ sdk install java 8.0.292.hs-adpt
$ sdk install java 11.0.11.hs-adpt
```

## Versiones Usadas

```bash
$ sdk current java
$ sdk current
```

## Cambiar entre versiones

```bash
$ sdk use java 11.0.11.hs-adpt
$ sdk current java
$ java -version
```

## Actualizar candidato

```bash
$ sdk upgrade java
$ sdk upgrade
```

## Activar o desactivar funcion sin conexión
```bash
sdk offline enable
sdk offline disable
```

## Actualizar SDKMAN
Si se quisiera actualizar SDKMAN a una nueva versión. El siguiente comando lo instala si es que esta disponible.

```bash
sdk selfupdate
```

## Limpiar

Es recomandable limpiar el cache que contiene los archivos binarios SDK descargados de vez en cuando.

```bash
$ sdk flush archives
```

Es recomandable tambien limpiar la carpeta temporal para ahorar espacio.

```bash
$ sdk flush temp
```

## Desintalar SDKMAN

```bash
rm -rf /home/gnujavasergio/.sdkman/
```
