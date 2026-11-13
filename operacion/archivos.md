# Archivos, permisos y scp

Comprime, copia entre máquinas y deja permisos de código, no de "que todo el mundo escriba".

## Comprimir y descomprimir

```bash
zip -r nombre.zip directorio
unzip nombre.zip
```

## Permisos de un árbol de código

Directorios recorribles y archivos de solo lectura para el grupo y el resto:

```bash
find . -type d -exec chmod 755 {} \;
find . -type f -exec chmod 644 {} \;
```

Ejecuta esto en la raíz del proyecto, no en `/`.

Laravel necesita escritura en `storage` y `bootstrap/cache`. Ese caso está en [Laravel](../aplicaciones/laravel.md), con el usuario del servidor web como grupo. No se resuelve con `chmod 777`.

## Copiar por SSH

Bajar un archivo:

```bash
scp USUARIO@HOST:ruta/origen archivo-local
```

Subir un archivo:

```bash
scp archivo-local USUARIO@HOST:ruta/destino
```

## Qué no hacer

- No uses `chmod -R 777` para que una aplicación pueda escribir. Abre escritura a cualquier usuario del sistema.
- No lances el `find` de permisos desde `/` ni desde `/home`.
