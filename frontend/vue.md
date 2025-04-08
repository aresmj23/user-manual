# Manual de usuario de vue

## Instalar vue y crear un nuevo proyecto

### Opción 1

npm create vue@latest

Despues eligies opciones con que trabajar

cd base-vue

npm install

npm run format

npm run dev

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

Agregar las lineas en src/main.ts

```ts
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.bundle.min.js'
```

## Instalar axios

```bash
npm install axios --save
```

Agregar axios en el componentes que se va a utilizar

```vue
import axios from 'axios'
```

