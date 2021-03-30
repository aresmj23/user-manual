# Instalar Insomnia

```bash
$ sudo pacman -S snapd
```

```bash
$ sudo systemctl enable --now snapd.socket
```

```bash
$ sudo ln -s /var/lib/snapd/snap /snap
```

```bash
$ sudo snap install insomnia
```
