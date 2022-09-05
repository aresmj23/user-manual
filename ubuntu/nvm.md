# Instalar nvm para el control de versiones de Node

https://github.com/nvm-sh/nvm

```bash
$ curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.38.0/install.sh | bash
```

```bash
$ export NVM_DIR="$([ -z "${XDG_CONFIG_HOME-}" ] && printf %s "${HOME}/.nvm" || printf %s "${XDG_CONFIG_HOME}/nvm")" [ -s "$NVM_DIR/nvm.sh" ] && \. "$NVM_DIR/nvm.sh" # This loads nvm
```

Instalar la ultimar version LTS de node

```bash
$ nvm install --lts
```

Buscar las versiones de node LTS

```bash
$ nvm ls-remote
```

Instalar la version v12.21.0

```bash
$ nvm install v12.21.0
```

Eliminar la version v12.21.0

```bash
$ nvm uninstall v12.21.0
```

Listar las versiones de node instaladas

```bash
$ nvm list
```

Usar la version v16


```bash
$ nvm use 16
```

Now using node v16.9.1 (npm v7.21.1)

```bash
$ node -v
```

v16.9.1

```bash
$ nvm use 14
```

Now using node v14.18.0 (npm v6.14.15)

```bash
$ node -v
```
v14.18.0
