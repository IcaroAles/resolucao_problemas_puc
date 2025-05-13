# Árvore Binária para Código Morse

Este projeto implementa uma **árvore binária em Java** para representar o **Código Morse**.

##  Objetivo

Criar uma árvore binária onde:
- Cada **caminho** da raiz até um nó representa uma **sequência em código Morse**.
- Pontos (`.`) indicam **filho à esquerda**.
- Traços (`-`) indicam **filho à direita**.

A árvore permite:
- Inserir letras e números com base em seu código Morse.
- Buscar letras a partir de um código Morse.
- Buscar o código Morse correspondente a uma letra.
- Exibir a estrutura da árvore hierarquicamente.



##  Exemplo de Uso

```java
arvore.inserir("...", 'S');
arvore.inserir("---", 'O');

System.out.println(arvore.buscarLetra("...")); // Saída: S
System.out.println(arvore.buscarCodigo('O'));  // Saída: ---




COMO EXECUTAR:

1. javac javac *.java

2. java main
