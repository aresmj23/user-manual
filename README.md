# Manual de entorno de desarrollo

Procedimientos para instalar y operar el entorno de desarrollo: sistema, bases de datos, PHP, Docker, frameworks y tareas de servidor.

Cada guía indica en qué sistema se probó. Si una página dice que el procedimiento es antiguo, no lo uses para un servidor nuevo sin revisarlo.

Cómo se escribe una página nueva: [CONTRIBUTING.md](CONTRIBUTING.md).

## Sistemas

- [Manjaro: pacman, hora y fuentes](sistemas/manjaro.md)
- [Neovim](sistemas/neovim.md)

## Datos

- [PostgreSQL y pgAdmin](datos/postgres.md)
- [MySQL y MariaDB: uso diario](datos/mysql.md)
- [MongoDB](datos/mongodb.md)

## Entorno

- [LAMP: Apache, MariaDB o MySQL, y PHP](entorno/lamp.md)
- [PHP: versiones y cambio del módulo de Apache](entorno/php.md)
- [Docker](entorno/docker.md)
- [Node.js con nvm](entorno/node.md)
- [Java con SDKMAN o Arch](entorno/java.md)
- [Composer](entorno/composer.md)
- [Programas de escritorio](entorno/herramientas.md)

## Aplicaciones

- [Laravel, permisos y autenticación de API](aplicaciones/laravel.md)
- [CakePHP](aplicaciones/cakephp.md)
- [Vue](aplicaciones/vue.md)
- [React](aplicaciones/react.md)
- [Angular](aplicaciones/angular.md)

## Operación

- [Usuarios, virtual hosts y FTP](operacion/usuarios.md)
- [Copias de bases de datos](operacion/backups.md)
- [Archivos, permisos y scp](operacion/archivos.md)
- [Git](operacion/git.md)

## Páginas que ya no están

El manual estaba partido por distro y mezclaba notas de proyectos con procedimientos. Esas rutas se reemplazaron por las de arriba. En particular se eliminó `servidores/createUser.md`: contenía contraseñas, usuarios e IPs de servidores. Si esa copia llegó a publicarse o a entrar en git, hay que rotar esas credenciales. Borrar el archivo del árbol actual no las invalida.
