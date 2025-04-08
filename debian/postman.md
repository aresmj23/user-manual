
Descargar postam de la pagina oficial

https://www.postman.com/downloads/

o con el comando

wget https://dl.pstmn.io/download/latest/linux64 -O postman-linux-x64.tar.gz



Descomprimir

```bash
sudo tar -xzf postman-linux-x64.tar.gz
```



```bash
cd Postman
./Postman
```



Crear un execute the Postman


```bash
sudo nano ~/.local/share/applications/Postman.desktop
```


```
Encoding=UTF-8
Name=Postman
Exec=/home/amartinez/programs/Postman/app/Postman %U
Icon=/home/amartinez/programs/Postman/app/resources/app/assets/icon.png
Terminal=false
Type=Application
Categories=Development;
```
