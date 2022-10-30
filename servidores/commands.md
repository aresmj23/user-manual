# Comandos Linux

## Comprimir

```
zip -r nombre_comprimido.zip directorio_a_comprimir
```

## Descromprimir

```
unzip srcpython20190610.zip
```

## Permisos de directorios y ficheros 

```
find . -type d -exec chmod 755 {} \;
```

```
find . -type f -exec chmod 644 {} \;
```

## Descargar archivos

```
scp usuario@host:directorio/ArchivoOrigen ArchivoDestino
```

```

```

## Subir archivos

```
scp ArchivoOrigen usuario@host:directorio/ArchivoDestino
```

```

```

## Exportar base de datos

```
mysqldump -u root -p municipios > municipios.sql
```

## Importar base de datos

```
mysql -u root -p sysgamestore < sysgamestore.sql
```
