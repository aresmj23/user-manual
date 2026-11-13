# Angular

Crea un proyecto Angular y añade Bootstrap.

## Requisitos

- Node actual, instalado con [nvm](../entorno/node.md).

## Proyecto

```bash
npm install -g @angular/cli
ng new base-angular
cd base-angular
ng serve
```

## Bootstrap

```bash
npm install bootstrap
```

En `angular.json`, dentro de la build de la aplicación:

```json
"styles": [
  "node_modules/bootstrap/dist/css/bootstrap.min.css",
  "src/styles.css"
],
"scripts": [
  "node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"
]
```

## ng-bootstrap

```bash
ng add @ng-bootstrap/ng-bootstrap
```

Si npm se detiene por un conflicto de peer dependencies:

```bash
npm config set legacy-peer-deps true
```

Vuelve a lanzar `ng add`. `legacy-peer-deps` es un desbloqueo, no la configuración que quieres dejar en todas las máquinas sin necesidad.

En un proyecto con `NgModule`, importa `NgbModule` en el módulo donde se usa. En un proyecto standalone (el que genera el CLI actual) importa el componente de ng-bootstrap en el `imports` del componente que lo usa, no en un `AppModule` que ya no existe.

## Comprobar

`ng serve` compila y `http://localhost:4200` responde. Un botón con clases de Bootstrap se ve con los estilos del framework.

## Qué no hacer

- No copies un ejemplo con `AppModule` dentro de un proyecto standalone. El build falla porque ese archivo no está en el proyecto.
