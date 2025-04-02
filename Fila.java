public class Fila {
    private int MAX;
    private int[] fila;
    private int inicio;
    private int fim;

    public Fila(int MAX) {
        if (MAX <= 1) {
            System.out.println("Erro: maximo precisa ser maior do que 0");
        }
        this.MAX = MAX;
        this.fila = new int[MAX];
        this.inicio = 0;
        this.fim = 0;
        System.out.println("Fila criada, maximo: " + MAX + ". Capacidade utilizavel: " + (MAX - 1));
    }

    public boolean insereElemento(int elemento) {
        System.out.print("Inserindo " + elemento + "... ");
        if (filaCheia()) {
            System.out.println("Erro: Fila esta cheia");
            return false;
        }
        fila[fim] = elemento;
        fim = (fim + 1) % MAX;
        System.out.println("Início: " + inicio + ", Fim: " + fim);
        return true;
    }

    public boolean filaVazia() {
        return inicio == fim;
    }

    public boolean filaCheia() {
        return (fim + 1) % MAX == inicio;
    }


    public int removeElemento() {
        System.out.print("Removendo ");
        if (filaVazia()) {
            System.out.println("Erro: Fila esta vazia");
            throw new RuntimeException("Nao é possível remover da fila vazia.");
        }
        int elementoRemovido = fila[inicio];
        inicio = (inicio + 1) % MAX;
        System.out.println("Elemento " + elementoRemovido + " removido. Início: " + inicio + ", Fim: " + fim);
        return elementoRemovido;
    }

    public void mostrar() {
        if (filaVazia()) {
            System.out.println("Fila: vazia inicio=" + inicio + ", fim=" + fim + "");
            return;
        }
        System.out.print("Fila: / ");
        int indiceAtual = inicio;
        int count = 0;
        while (indiceAtual != fim) {
            System.out.print(fila[indiceAtual] + " ");
            indiceAtual = (indiceAtual + 1) % MAX;
            System.out.print("/ ");
            count++;
        }
        System.out.println(" (inicio=" + inicio + ", fim=" + fim + ", ocupados=" + count + "/" + (MAX-1) + ")");
    }

    public static void main(String[] args) {
        Fila fila1 = new Fila(5);

        fila1.mostrar();
        fila1.insereElemento(10);
        fila1.insereElemento(20);
        fila1.insereElemento(30);
        fila1.insereElemento(40);
        fila1.insereElemento(50);
        fila1.mostrar();
        fila1.removeElemento();
        fila1.mostrar();
        fila1.insereElemento(50);
        fila1.mostrar();
        fila1.removeElemento();
        fila1.mostrar();
        fila1.removeElemento();
        fila1.mostrar();
        fila1.removeElemento();
        fila1.mostrar();
        fila1.removeElemento();
        fila1.mostrar();
        
        try {
            fila1.removeElemento();
        } catch (RuntimeException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        fila1.mostrar();
    }
}