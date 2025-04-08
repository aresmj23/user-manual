# Manual de usuario de angular

npm install -g @angular/cli

## Instalar angular y crear un nuevo proyecto

ng new base-angular

cd base-angular

ng serve

## Instalar bootstrap

### Instalar bootstrap
```bash
npm install bootstrap --save
```

Agregar las lineas en angular.json

```json
"styles": [
    "node_modules/bootstrap/dist/css/bootstrap.min.css",
    "src/styles.css"
],
"scripts": [
    "node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"
],
```

### Instalar ng-bootstrap para angular 
```bash
ng add @ng-bootstrap/ng-bootstrap
```

Si sale error al instalar ejecutar y despues volver a instalar
```bash
npm config set legacy-peer-deps true
```

Abre el archivo app.module.ts (o el módulo donde quieras utilizar ng-bootstrap) e importa los módulos necesarios:
```typescript
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [...],
  imports: [NgbModule, ...],
  ...
})
export class AppModule { }
```

Ahora puedes utilizar los componentes de ng-bootstrap en tus componentes Angular. Por ejemplo, para utilizar un modal, puedes hacer lo siguiente en tu componente:

```typescript
import { Component } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-root',
  template: `
    <button (click)="open()">Open</button>
  `
})
export class AppComponent {
  constructor(private modalService: NgbModal) {}

  open() {
    this.modalService.open(ModalContentComponent);
  }
}
```