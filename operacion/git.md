# Git

Instala Git, fija la identidad, publica un proyecto nuevo y decide dónde se guardan las credenciales.

## Identidad

```bash
sudo apt install -y git
git config --global user.name "Nombre Apellido"
git config --global user.email "correo@ejemplo.com"
```

## Proyecto nuevo en GitLab

Dentro del directorio del proyecto, con la URL SSH que muestra GitLab:

```bash
git init
git checkout -b main
git remote add origin git@gitlab.com:grupo/proyecto.git
git add .
git commit -m "Initial commit"
git push -u origin main
```

La URL y el mensaje son del proyecto. No dejes un remoto de un cliente dentro de un ejemplo que se vaya a copiar tal cual a otro repositorio.

## Credenciales

La forma de trabajar es una clave SSH para `git@gitlab.com`. No guarda la clave en un archivo de texto del home.

Si aun así quieres que Git recuerde un token durante un rato, y solo en esta máquina:

```bash
git config --global credential.helper cache
```

`cache` lo mantiene en memoria un tiempo y no escribe `~/.git-credentials`.

`credential.helper store` también funciona, y deja usuarios y tokens en claro en `~/.git-credentials`. Para ver si está activo:

```bash
git config --global --get credential.helper
```

Para quitarlo y borrar lo que ya se guardó:

```bash
git config --global --unset credential.helper
rm -f "$HOME/.git-credentials"
```

Quitar el helper no borra el archivo. El `rm` sí. Hazlo cuando quieras invalidar lo que estaba guardado en disco; el token en el servidor sigue siendo válido hasta que lo revoques allí.

## Rama en el prompt

En `~/.bashrc`:

```bash
parse_git_branch() {
  git branch 2> /dev/null | sed -e '/^[^*]/d' -e 's/* \(.*\)/ (\1)/'
}
PS1="\[\033[01;31m\]\u\[\033[01;33m\]@\[\033[01;36m\]\h \[\033[01;33m\]\w\[\033[31m\]\$(parse_git_branch)\[\033[00m\] \[\033[01;35m\]\$\[\033[01;0m\] "
```

Abre otra terminal. El prompt muestra la rama del repositorio en el que estás.

## Qué no hacer

- No actives `credential.helper store` en una máquina compartida.
- No subas `.env`, volcados ni `~/.git-credentials`.
