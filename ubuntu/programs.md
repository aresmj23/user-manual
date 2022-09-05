# Instalar programas


# Telegram

```bash
$ sudo apt install telegram-desktop
```


# Git

```bash
$ sudo apt install git
```

Set your username:
```bash
git config --global user.name "FIRST_NAME LAST_NAME"
```

Set your email address:
```bash
git config --global user.email "MY_NAME@example.com"
```


# Visual Studio Code

```bash
sudo apt update && sudo apt upgrade -y
sudo apt -y install wget
```

## Add Visual Studio Code repository and key

```bash
sudo apt update
sudo apt install apt-transport-https
curl https://packages.microsoft.com/keys/microsoft.asc | gpg --dearmor > microsoft.gpg
sudo install -o root -g root -m 644 microsoft.gpg /etc/apt/trusted.gpg.d/
```

```bash
sudo apt install apt-transport-https
```

```bash
curl https://packages.microsoft.com/keys/microsoft.asc | gpg --dearmor > microsoft.gpg
```

## Add APT repository to Linux Mint

```bash
sudo sh -c 'echo "deb [arch=amd64] https://packages.microsoft.com/repos/vscode stable main" > /etc/apt/sources.list.d/vscode.list'
```

```bash
cat  /etc/apt/sources.list.d/vscode.list
```

```bash
deb [arch=amd64] https://packages.microsoft.com/repos/vscode stable main
```

## Visual Studio Code on Linux Mint 20

```bash
sudo apt update
```

```bash
sudo apt install code
```

```bash
code
```


# Instalar Composer

```bash
sudo apt update
sudo apt install php-cli unzip
```

```bash
cd ~
curl -sS https://getcomposer.org/installer -o /tmp/composer-setup.php
```

```bash
HASH=`curl -sS https://composer.github.io/installer.sig`
```

```bash
php -r "if (hash_file('SHA384', '/tmp/composer-setup.php') === '$HASH') { echo 'Installer verified'; } else { echo 'Installer corrupt'; unlink('composer-setup.php'); } echo PHP_EOL;"
```

```bash
sudo php /tmp/composer-setup.php --install-dir=/usr/local/bin --filename=composer
```



```bash

```


