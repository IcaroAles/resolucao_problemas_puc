public class PilhaEncadeada {
    class No {
        int dado;
        No proximo;

        No(int elemento) {
            this.dado = elemento;
            this.proximo = null;
        }
    }

    No topo = null;

    public void insere(int elemento) {
        No novo = new No(elemento);
        novo.proximo = topo;
        topo = novo;
        System.out.println("Elemento " + elemento + " subiu no empilhamento.");
    }

    public void remove() {
        if (topo == null) {
            System.out.println("Erro: Pilha esta vazia");
            return;
        }
        int removido = topo.dado;
        topo = topo.proximo;
        System.out.println("\nelemento " + removido + " desceu do empilhamento.");
    }

    public void imprime() {
        No atual = topo;
        System.out.print("Pilha: ");
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
    }
}
