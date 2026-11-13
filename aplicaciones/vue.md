# Vue

Crea un proyecto Vue y añade Bootstrap y Axios.

## Requisitos

- Node actual, instalado con [nvm](../entorno/node.md).

## Proyecto

El asistente vigente es `create-vue`:

```bash
npm create vue@latest
cd base-vue
npm install
npm run dev
```

La build de producción:

```bash
npm run build
```

Vue CLI (`npm install -g @vue/cli` y `vue create`) sigue en notas antiguas y está en mantenimiento. Un proyecto nuevo no sale de ahí. `npm init vue@latest` es el mismo asistente con otro nombre.

## Bootstrap

```bash
npm install bootstrap
```

En `src/main.ts`:

```ts
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.bundle.min.js'
```

## Axios

```bash
npm install axios
```

En el componente o módulo que llama a la API:

```ts
import axios from 'axios'
```

## Comprobar

`npm run dev` abre el servidor de Vite y el navegador muestra la página de bienvenida del proyecto.

## Qué no hacer

- No instales Vue CLI y `create-vue` en el mismo proyecto para "tener las dos opciones". El `package.json` queda con dos formas de arrancar.
