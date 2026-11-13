# React

Crea un proyecto React con Vite y añade Bootstrap.

## Requisitos

- Node actual, instalado con [nvm](../entorno/node.md).

## Proyecto

```bash
npm create vite@latest base-react -- --template react
cd base-react
npm install
npm run dev
```

Producción:

```bash
npm run build
```

`create-react-app` ya no es el camino de un proyecto nuevo. Si encuentras un repositorio que todavía arranca con `react-scripts`, se mantiene con lo que ya tiene; no lo uses de plantilla.

## Bootstrap

```bash
npm install bootstrap
```

En `src/main.jsx`:

```js
import 'bootstrap/dist/css/bootstrap.min.css'
```

## Comprobar

`npm run dev` sirve la página y el CSS de Bootstrap aplica en un elemento con clase `container`.

## Qué no hacer

- No instales `create-react-app` en global. Además de estar abandonado, un paquete global de ese tipo pisa la versión del proyecto.
