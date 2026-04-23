# IFRN - EDL

## Sumário

### 1. [Pilha](#pilha)
### 2. [Fila](#fila)

## Pilha

### Introdução

Inserções e remoções seguem o esquema LIFO (Last In, First Out)

- Principais operações:
  - `push(Object o)`: insere um elemento
  - `Object pop()`: remove e returna o último elemento inserido

- Operações auxiliares:
  - `object top()`: retorna o último elemento inserido sem removê-lo
  - `int size()`: retorna o número de elementos armazenados
  - `boolean isEmpty()`: indica se há ou não elementos na Pilha

### Implementações

#### [Array](src/pilha/PilhaArray.java)

#### [Atividade - Pilha Rubro Negra](src/pilha/rubronegra/README.md)

## Fila

### Introdução

Inserções e remoções seguem o esquema FIFO (First In, First Out)

- Operações principais:
    - `enqueue(Object o)`: insere um elemento no fim da fila;
    - `Object dequeue()`: remove e retorna o elemento do início da fila.

- Operações auxiliares:
    - `Object first()`: retorna o elemento do início sem removê-lo;
    - `int size()`: retorna o número de elementos armazenados;
    - `boolean isEmpty()`: indica se há elementos na fila.

### Implementações

#### [Array circular](src/fila/FilaArray.java)

#### [Lista simplesmente encadeada](src/fila/FilaEncadeada.java)

#### [Atividade - Reversão em O(1)](src/fila/reverse/README.md)
