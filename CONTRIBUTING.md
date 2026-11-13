# Cómo se escribe una página

Cada archivo resuelve un trabajo. La distro es un dato de la página, no un motivo para copiar la misma guía cuatro veces.

## Plantilla

```markdown
# Título

Qué resuelve, en una o dos frases.

Probado en: sistema y versión. Si el procedimiento es antiguo, dilo en la primera pantalla.

## Requisitos

## Pasos

## Comprobar

## Errores frecuentes

## Qué no hacer
```

Omite una sección solo cuando no aplica. No la rellenes con texto vacío.

## Reglas

- Español. Los nombres de comandos, paquetes y archivos se quedan como están.
- Un comando por bloque, sin el prompt `$` ni `#`, para poder copiarlo.
- Versión del sistema y del paquete en el encabezado.
- Contraseñas, tokens, IPs y usuarios reales no entran al manual. Usa `CAMBIA_ESTA_CLAVE`, `USUARIO` y `NOMBRE_CONTENEDOR`.
- Rutas de una persona concreta no entran. Usa `$HOME`.
- Un apunte de un proyecto (un contenedor, un dominio, un cliente) no se mezcla con el procedimiento general.
- Si un comando puede dejar el servidor inaccesible o abierto, el paso dice qué comprobar antes de ejecutarlo.
- No pegues una página de otro sitio. Resume el procedimiento y enlaza la fuente.
