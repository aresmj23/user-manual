# Manual de usuario de vue

## Instalar vue y crear un nuevo proyecto

### Opción 1
npm create vue@latest

vue create base-vue

Despues eligies opciones con que trabajar

cd base-vue

npm install

npm run dev

npm run build

### Opción 2
npm install -g @vue/cli

vue create base-vue

cd base-vue

npm run serve

npm run build

### Opción 3
npm install npm@latest -g

npm init vue@latest

cd base-vue

npm install

npm run dev

npm run build

## Instalar bootstrap

```bash
npm install bootstrap --save
```

Agregar las lineas en src/main.js

```js
import "bootstrap/dist/css/bootstrap.min.css";
```

