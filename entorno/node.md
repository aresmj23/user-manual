# Node.js con nvm

Instala nvm y cambia de versión de Node sin tocar los paquetes del sistema.

Probado con el script oficial de nvm 0.40.8 en Linux, y con el paquete de Manjaro.

## Debian y Ubuntu

```bash
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.40.8/install.sh | bash
```

Cierra la terminal y ábrela de nuevo. El script escribe la carga de nvm en `~/.bashrc`, `~/.profile` o `~/.zshrc`.

```bash
nvm install --lts
node -v
npm -v
```

## Manjaro

```bash
sudo pacman -S nvm
```

El paquete no queda activo solo. Añade esto a `~/.bashrc` y abre otra terminal:

```bash
source /usr/share/nvm/init-nvm.sh
```

```bash
nvm install --lts
```

## Uso

```bash
nvm ls-remote
nvm install 22
nvm use 22
nvm alias default 22
nvm ls
nvm uninstall 22
```

La primera versión instalada queda como predeterminada. `nvm alias default` fija la que deben ver las terminales nuevas.

## Comprobar

`command -v nvm` escribe `nvm`. `node -v` coincide con `nvm current`.

## Qué no hacer

- No instales nvm con el script de la 0.38.0 que circulaba en notas viejas. Esa versión es de 2021.
- No hace falta `sudo` para `nvm install`. Si Node queda en `/usr/bin/node` por apt y otro en nvm, la terminal usa el primero que aparezca en el `PATH`. `which node` lo aclara.
