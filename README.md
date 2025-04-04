CONTEM:

- Estrutura de pilha
- Estrutura de fila
- Operações de merge entre ambas

Instruções para rodar:
- Compilar: javac *.java        Cria os arquivos .class
- Rodar a main: java Main       Roda o codigo e imprime as informações no terminal



Testes realizados:

PILHA: Cria uma nova pilhan insere os valores 10, 20 e 30, mostra a pilha, remove o 30, e mostra a pilha novamente.

FILA: Cria duas novas filas(filaA e filaB) e insere seus devidos valores.

MERGE: Cria uma nova fila encadeada(filaC) e da merge nas filas A e B, apois isso mostra as funções de cada um e imprime a fila final.





            PILHA:

Comandos:
PilhaEncadeada pilha = new PilhaEncadeada();
        pilha.insere(10);
        pilha.insere(20);
        pilha.insere(30);
        pilha.imprime();
        pilha.remove();
        pilha.imprime();

Resposta esperada:

Elemento 10 subiu no empilhamento.
Elemento 20 subiu no empilhamento.
Elemento 30 subiu no empilhamento.
Pilha: 30 20 10 
elemento 30 desceu do empilhamento.
Pilha: 20 10

            FILA:

Comandos:

FilaEncadeada filaA = new FilaEncadeada();
        filaA.insere(12);
        filaA.insere(35);
        filaA.insere(52);
        filaA.insere(64);

FilaEncadeada filaB = new FilaEncadeada();
        filaB.insere(5);
        filaB.insere(15);
        filaB.insere(23);
        filaB.insere(55);
        filaB.insere(75);

Resposta esperada:

Elemento 12 entrou na fila.
Elemento 35 entrou na fila.
Elemento 52 entrou na fila.
Elemento 64 entrou na fila.
Elemento 5 entrou na fila.
Elemento 15 entrou na fila.
Elemento 23 entrou na fila.
Elemento 55 entrou na fila.
Elemento 75 entrou na fila.
Fila: 12 35 52 64
Fila: 5 15 23 55 75

            MERGE:

Comandos:

FilaEncadeada filaC = MergeFilaEncadeada.merge(filaA, filaB);
        filaC.imprime();

Resposta esperada:

Elemento 5 saiu da fila.
Elemento 5 entrou na fila.
Elemento 12 saiu da fila.
Elemento 12 entrou na fila.
Elemento 15 saiu da fila.
Elemento 15 entrou na fila.
Elemento 23 saiu da fila.
Elemento 23 entrou na fila.
Elemento 35 saiu da fila.
Elemento 35 entrou na fila.
Elemento 52 saiu da fila.
Elemento 52 entrou na fila.
Elemento 55 saiu da fila.
Elemento 55 entrou na fila.
Elemento 64 saiu da fila.
Elemento 64 entrou na fila.
Elemento 75 saiu da fila.
Elemento 75 entrou na fila.
Fila: 5 12 15 23 35 52 55 64 75
