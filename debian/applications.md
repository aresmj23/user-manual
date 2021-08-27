# Aplicaciones necesarias

```bash
$ sudo wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
$ sudo apt install ./google-chrome-stable_current_amd64.deb
$ sudo apt install google-chrome-stable
```

```bash
$ sudo apt-get update
$ sudo apt install snapd
$ sudo snap install core
$ sudo snap install insomnia
$ sudo snap install spotify
$ sudo snap install zoom-client
```

# Brave

https://brave.com/linux/

```bash
$ sudo apt install apt-transport-https curl
```

```bash
$ sudo curl -fsSLo /usr/share/keyrings/brave-browser-archive-keyring.gpg https://brave-browser-apt-release.s3.brave.com/brave-browser-archive-keyring.gpg
```

```bash
$ echo "deb [signed-by=/usr/share/keyrings/brave-browser-archive-keyring.gpg arch=amd64] https://brave-browser-apt-release.s3.brave.com/ stable main"|sudo tee /etc/apt/sources.list.d/brave-browser-release.list
```

```bash
$ sudo apt update
```

```bash
$ sudo apt install brave-browser
```
