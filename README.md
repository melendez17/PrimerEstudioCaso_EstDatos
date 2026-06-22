# Analizador de Expresiones Aritméticas con Pilas en Java

## Descripción del trabajo

Este proyecto implementa un analizador de expresiones aritméticas utilizando la estructura de datos **pila ** en Java.

Su principal funcionalidad es convertir expresiones en notación **infija** (la forma convencional y que usamos los humanos) a notación **postfija** , respetando la precedencia de operadores y el uso de paréntesis.

---

## Funcionalidades

- Conversión de expresiones infijas → postfijas  
- Manejo de:
  - Operadores: `+`, `-`, `*`, `/`, `^`
  - Paréntesis `()`
  - Números y variables (operandos)
- Uso de pila dinámica implementada manualmente  
- Aplicación del algoritmo de algoritmo Shunting-Yard
- Procesamiento carácter por carácter de la expresión  

---

## Concepto utilizado

El proyecto se basa en el algoritmo de conversión infija a postfija usando pilas:

- Los operandos se imprimen directamente.  
- Los operadores se almacenan en una pila.  
- Los paréntesis controlan bloques de prioridad.  
- La pila sigue el principio **LIFO (Last In, First Out)**.  

---

## Estructura del proyecto

```
pilaDinamica/
│
├── Analizador.java     # Conversión infija a postfija
├── Pila.java           # Implementación de la pila
└── Nodo.java           # Nodo utilizado en la pila
```

---

## Ejemplo de uso

### Entrada:
```
(5+3)*2
```

### Resultado:
```
Infija:   (5+3)*2
Postfija: 53+2*

```
<img width="330" height="170" alt="image" src="https://github.com/user-attachments/assets/d4033ec6-290d-4af7-99c4-3ec7a32ccfe4" />

## Clase principal (Main)

El programa puede ejecutarse desde una clase `Main` que permite ingresar expresiones y visualizar su conversión llamando a un metodo `Menu`.

---

## Reglas del algoritmo

- Si el símbolo es un operando, se agrega a la salida.  
- Si es `(`, se inserta en la pila.  
- Si es `)`, se desapila hasta encontrar `(`.  
- Si es un operador:
  - Se compara su precedencia con la cima de la pila.  
  - Se desapilan operadores con mayor o igual prioridad.  
- Al final, se vacía la pila.  

---

## Precedencia de operadores

| Operador | Precedencia |
|----------|------------|
| `+ -`    | 1          |
| `* /`    | 2          |
| `^`      | 3          |

---

## Autor

Andrés Meléndez Carvajal  
Primer Caso - Estructuras de Datos
