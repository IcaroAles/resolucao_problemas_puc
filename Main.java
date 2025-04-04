public class Main {
    public static void main(String[] args) {
        System.out.println("-------------- Pilha --------------");
        PilhaEncadeada pilha = new PilhaEncadeada();
        pilha.insere(10);
        pilha.insere(20);
        pilha.insere(30);
        pilha.imprime();
        pilha.remove();
        pilha.imprime();

        System.out.println("\n-------------- Fila --------------");
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

        filaA.imprime();
        filaB.imprime();

        System.out.println("\n-------------Merge--------------");
        FilaEncadeada filaC = MergeFilaEncadeada.merge(filaA, filaB);
        filaC.imprime();
    }
}
