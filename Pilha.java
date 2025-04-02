public class Pilha {
    private int MAX;
    private int[] pilha;
    private int topo;

    public Pilha(int MAX) {
        if (MAX <= 0) {
            System.out.println("Erro: maximo precisa ser maior do que 0");
        }
        this.MAX = MAX;
        this.pilha = new int[MAX];
        this.topo = -1;
        System.out.println("Pilha criada, maximo: " + MAX);
    }

    
    
    public boolean empilhaElemento(int elemento) {
        System.out.print("Empilhando " + elemento + "... ");
        if (pilhaCheia()) {
            System.out.println("Erro: Pilha cheia!");
            return false;
        }
        topo++;
        pilha[topo] = elemento;
        System.out.println("Topo atual: " + topo);
        return true;
    }
    
    public boolean pilhaVazia() {
        return topo == -1;
    }

    public boolean pilhaCheia() {
        return topo == MAX - 1;
    }

    public int desempilhaElemento() {
        System.out.print("Desempilhando ");
        if (pilhaVazia()) {
            System.out.println("Erro: Pilha vazia");
            throw new RuntimeException("Não é possível desempilhar uma pilha vazia.");
        }
        int elementoRemovido = pilha[topo];
        topo--;
        System.out.println("Elemento " + elementoRemovido + " removido. Topo atual: " + topo);
        return elementoRemovido;
    }

    public int consultaTopo() {
        System.out.print("Consultando topo... ");
        if (pilhaVazia()) {
            System.out.println("Erro: Pilha vazia");
            throw new RuntimeException("Não é possível consultar o topo onde a pilha esta vazia.");
        }
        int elementoTopo = pilha[topo];
        System.out.println("Atual elemento no topo: " + elementoTopo);
        return elementoTopo;
    }

    public void mostrar() {
        if (pilhaVazia()) {
            System.out.println("pilha: vazia");
            return;
        }
        System.out.print("pilha:  ");
        for (int i = 0; i <= topo; i++) {
            System.out.print(pilha[i]);
            System.out.print(" / ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Pilha pilha1 = new Pilha(5);

        pilha1.mostrar();

        
        pilha1.empilhaElemento(10);
        pilha1.mostrar();
        pilha1.empilhaElemento(20);
        pilha1.empilhaElemento(30);
        pilha1.mostrar();
        pilha1.consultaTopo();
        pilha1.empilhaElemento(40);
        pilha1.empilhaElemento(50);
        pilha1.mostrar();
        pilha1.mostrar();
        pilha1.desempilhaElemento();
        pilha1.mostrar();
        pilha1.consultaTopo();
        pilha1.desempilhaElemento();
        pilha1.desempilhaElemento();
        pilha1.mostrar();
        pilha1.desempilhaElemento();
        pilha1.mostrar();

        try {
            pilha1.desempilhaElemento();
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        pilha1.mostrar();
    }
}