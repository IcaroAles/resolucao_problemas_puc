public class FilaEncadeada {
    class No {
        int dado;
        No proximo;

        No(int elemento) {
            this.dado = elemento;
            this.proximo = null;
        }
    }

    No inicio = null;
    No fim = null;

    public void insere(int elemento) {
        No novo = new No(elemento);
        if (fim != null) {
            fim.proximo = novo;
        } else {
            inicio = novo;
        }
        fim = novo;
        System.out.println("Elemento " + elemento + " entrou na fila.");
    }

    public int remove() {
        if (inicio == null) {
            System.out.println("Erro: Fila esta vazia");
            return -1;
        }
        int removido = inicio.dado;
        inicio = inicio.proximo;
        if (inicio == null) {
            fim = null;
        }
        System.out.println("Elemento " + removido + " saiu da fila.");
        return removido;
    }

    public int espiar() {
        return (inicio != null) ? inicio.dado : -1;
    }

    public boolean vazia() {
        return inicio == null;
    }

    public void imprime() {
        No atual = inicio;
        System.out.print("Fila: ");
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}
