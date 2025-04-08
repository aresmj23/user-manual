# Install docker

## Install docker

1. Actualiza tu sistema
Primero, asegúrate de que tu sistema está actualizado:

```bash
sudo apt update && sudo apt upgrade -y
```

2. Instala dependencias necesarias
Docker Desktop requiere algunas dependencias. Instálalas ejecutando:

```bash
sudo apt install -y apt-transport-https ca-certificates curl software-properties-common
```

3. Agrega la clave GPG de Docker
Descarga y agrega la clave GPG del repositorio oficial de Docker:

```bash
sudo mkdir -p /etc/apt/keyrings
curl -fsSL https://download.docker.com/linux/debian/gpg | sudo gpg --dearmor -o /etc/apt/keyrings/docker.gpg
```

4. Agrega el repositorio de Docker
Configura el repositorio de Docker para Debian 12:

```bash
echo "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.gpg] https://download.docker.com/linux/debian $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
```

5. Instala Docker
Actualiza la lista de paquetes e instala Docker Desktop:

```bash
sudo apt update
sudo apt install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin
```

6. Descarga Docker Desktop

```bash
wget https://desktop.docker.com/linux/main/amd64/docker-desktop-<VERSION>-amd64.deb
```

7. Instala Docker Desktop
Una vez descargado el paquete, instálalo con dpkg:

```bash
sudo dpkg -i docker-desktop-<VERSION>-amd64.deb
```

Si aparecen errores de dependencias, corrígelos con:
```bash
sudo apt --fix-broken install
```

8. Inicia Docker Desktop
Después de la instalación, puedes iniciar Docker Desktop desde el menú de aplicaciones o ejecutando:

```bash
systemctl --user start docker-desktop
```

```bash
systemctl --user enable docker-desktop
```

9. Verifica la instalación
Verifica que Docker está instalado correctamente ejecutando:

```bash
docker --version
```


10. (Opcional) Configura permisos
Para evitar usar sudo con Docker, agrega tu usuario al grupo docker:

```bash
sudo usermod -aG docker $USER
```


## Install docker-compose

```bash
sudo curl -L "https://github.com/docker/compose/releases/download/1.26.0/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
```


```bash
sudo chmod +x /usr/local/bin/docker-compose
```


```bash
docker-compose --version
```


sudo lsof -i :5432
sudo systemctl restart postgresql
