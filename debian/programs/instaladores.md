## Spring tool 4

sudo mv ~/Descargas/spring-tool-suite-*.tar.gz ~/programs

cd programs
sudo tar -xvf spring-tool-suite-*.tar.gz

sudo nano /usr/share/applications/spring-tool-suite.desktop

```bash
[Desktop Entry]
Name=Spring Tool Suite 4
Comment=Spring Boot Development Environment
Exec=/opt/sts4/SpringToolSuite4
Icon=/opt/sts4/icon.xpm
Terminal=false
Type=Application
Categories=Development;IDE;
```

sudo chmod +x /usr/share/applications/spring-tool-suite.desktop








## Inkscape

sudo chmod +x /home/amartinez/programs/inkscape/inkscape.AppImage

nano ~/.local/share/applications/inkscape.desktop

[Desktop Entry]
Name=Inkscape
Comment=Vector Graphics Editor
Exec=/home/amartinez/programs/inkscape/inkscape.AppImage
Icon=/home/amartinez/programs/inkscape/icon.webp
Terminal=false
Type=Application
Categories=Graphics;Design;

chmod +x ~/.local/share/applications/inkscape.desktop

