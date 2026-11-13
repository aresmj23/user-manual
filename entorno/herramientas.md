# Programas de escritorio

Instalación de los programas que se usan junto al entorno. Las rutas son de tu usuario (`$HOME`), no de una cuenta concreta.

## Git, Telegram y Snap

```bash
sudo apt install -y git telegram-desktop
sudo apt install -y snapd
sudo snap install core
```

En Debian, si Snap está bloqueado:

```bash
sudo rm -f /etc/apt/preferences.d/nosnap.pref
sudo apt update
sudo apt install -y snapd
```

```bash
sudo snap install insomnia
sudo snap install mysql-workbench-community
```

En Manjaro, Snap necesita el socket y el enlace `/snap`:

```bash
sudo pacman -S snapd
sudo systemctl enable --now snapd.socket
sudo ln -s /var/lib/snapd/snap /snap
sudo snap install insomnia
```

La identidad de Git y el alta de un repositorio están en [Git](../operacion/git.md).

## Visual Studio Code

```bash
sudo apt install -y wget gpg apt-transport-https
curl -fsSL https://packages.microsoft.com/keys/microsoft.asc | gpg --dearmor | sudo tee /etc/apt/trusted.gpg.d/microsoft.gpg > /dev/null
echo "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/trusted.gpg.d/microsoft.gpg] https://packages.microsoft.com/repos/code stable main" | sudo tee /etc/apt/sources.list.d/vscode.list
sudo apt update
sudo apt install -y code
```

## Navegadores

Chrome, paquete oficial:

```bash
cd /tmp
wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
sudo apt install -y ./google-chrome-stable_current_amd64.deb
```

Brave:

```bash
sudo apt install -y apt-transport-https curl
sudo curl -fsSLo /usr/share/keyrings/brave-browser-archive-keyring.gpg https://brave-browser-apt-release.s3.brave.com/brave-browser-archive-keyring.gpg
echo "deb [signed-by=/usr/share/keyrings/brave-browser-archive-keyring.gpg arch=$(dpkg --print-architecture)] https://brave-browser-apt-release.s3.brave.com/ stable main" | sudo tee /etc/apt/sources.list.d/brave-browser-release.list
sudo apt update
sudo apt install -y brave-browser
```

Fuente: https://brave.com/linux/

## DBeaver

```bash
sudo wget -O /usr/share/keyrings/dbeaver.gpg.key https://dbeaver.io/debs/dbeaver.gpg.key
echo "deb [signed-by=/usr/share/keyrings/dbeaver.gpg.key] https://dbeaver.io/debs/dbeaver-ce /" | sudo tee /etc/apt/sources.list.d/dbeaver.list
sudo apt update
sudo apt install -y dbeaver-ce
```

## Postman

La descarga actual está en https://www.postman.com/downloads/. El archivo de Linux se descomprime y se lanza así:

```bash
tar -xzf postman-linux-x64.tar.gz -C "$HOME/programs"
```

`~/.local/share/applications/postman.desktop`:

```ini
[Desktop Entry]
Name=Postman
Exec=$HOME/programs/Postman/app/Postman %U
Icon=$HOME/programs/Postman/app/resources/app/assets/icon.png
Terminal=false
Type=Application
Categories=Development;
```

Algunos escritorios no expanden `$HOME` dentro de un `.desktop`. Si el icono no aparece, escribe la ruta absoluta.

## AppImage: Inkscape y Cursor

El mismo patrón sirve para los dos. El archivo tiene que ser ejecutable y el `.desktop` apunta a esa ruta.

```bash
mkdir -p "$HOME/programs" "$HOME/.local/share/applications"
chmod +x "$HOME/programs/inkscape/inkscape.AppImage"
```

`~/.local/share/applications/inkscape.desktop`:

```ini
[Desktop Entry]
Name=Inkscape
Comment=Editor de gráficos vectoriales
Exec=/home/USUARIO/programs/inkscape/inkscape.AppImage
Icon=/home/USUARIO/programs/inkscape/icon.webp
Terminal=false
Type=Application
Categories=Graphics;Design;
```

Para Cursor cambia el nombre, el comentario y las rutas del `Exec` y del `Icon`. El comentario no es el de un editor vectorial.

```bash
chmod +x "$HOME/.local/share/applications/inkscape.desktop"
update-desktop-database "$HOME/.local/share/applications"
```

## Spring Tool Suite 4

Descomprime el archivo en una ruta fija, por ejemplo `/opt/sts4`, y crea `/usr/share/applications/spring-tool-suite.desktop`:

```ini
[Desktop Entry]
Name=Spring Tool Suite 4
Comment=Spring Boot Development Environment
Exec=/opt/sts4/SpringToolSuite4
Icon=/opt/sts4/icon.xpm
Terminal=false
Type=Application
Categories=Development;IDE;
```

`Exec` e `Icon` tienen que ser los archivos que quedaron al descomprimir. Si el tar no deja el binario en `/opt/sts4`, el acceso directo no arranca.

## Qué no hacer

- No dejes en el manual la ruta personal de quien escribió la nota. Usa `$HOME` o un marcador.
- No instales el `.desktop` de un programa con la ruta de otro.
