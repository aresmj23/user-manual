# Neovim

Abre, edita y cierra un archivo. Neovim arranca en modo normal: las teclas son comandos hasta que entras a insertar.

## Requisitos

```bash
sudo apt install -y neovim
```

En Manjaro: `sudo pacman -S neovim`. Se abre con `nvim archivo`.

## Modos

- Normal: teclas de movimiento y comandos. Es el modo al abrir.
- Insertar: el texto que escribes entra en el archivo.
- Visual: selección de texto.
- Línea de comandos: los que empiezan por `:`.

## Editar

| Acción | Teclas |
| --- | --- |
| Insertar en el cursor | `i` |
| Volver a normal | `Esc` |
| Guardar | `Esc` y después `:w` |
| Guardar y salir | `Esc` y después `:wq`, o `ZZ` en modo normal |
| Salir si no hay cambios | `Esc` y después `:q` |
| Salir y descartar cambios | `Esc` y después `:q!` |

`ZZ` es `Shift+z` dos veces, en modo normal, y equivale a guardar y salir.

## Comprobar

Abre un archivo, escribe una línea, guárdalo con `:wq` y confirma con `cat` que la línea está en disco.

## Qué no hacer

- No pulses `:q!` para "cerrar" si todavía no guardaste. Descarta el buffer.
- `Shift+z+z` no hace nada si sigues en modo insertar. `Esc` primero.
