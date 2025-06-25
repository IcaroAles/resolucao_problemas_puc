public class QuickSortIterativo {

    public static int trocas = 0;
    public static int iteracoes = 0;

    public static void quickSort(int[] vetor, int tamanho) {
        trocas = 0;
        iteracoes = 0;

        //pilha para armazenar os indices do vetor
        int[] pilha = new int[100];
        int topo = -1;

        //empilha os indicis inicial e final do vetor
        topo++;
        pilha[topo] = 0;
        topo++;
        pilha[topo] = tamanho - 1;

        while (topo >= 0) {
            int fim = pilha[topo--];
            int inicio = pilha[topo--];

            int pivo = particionar(vetor, inicio, fim);

            //a esquerda do pivo
            if (pivo - 1 > inicio) {
                pilha[++topo] = inicio;
                pilha[++topo] = pivo - 1;
            }

            //direita do pivo
            if (pivo + 1 < fim) {
                pilha[++topo] = pivo + 1;
                pilha[++topo] = fim;
            }
        }
    }

    private static int particionar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[fim];
        int i = inicio - 1;
        int j = inicio;

        while (j <= fim - 1) {
            iteracoes++;

            //se o valor atual é menor que pivo, trocam de posição
            if (vetor[j] <= pivo) {
                i++;
                int temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
                trocas++;
            }
            j++;
        }

        //arruma posição do pivo, esquerda menores e direita maiores
        int temp = vetor[i + 1];
        vetor[i + 1] = vetor[fim];
        vetor[fim] = temp;
        trocas++;

        return i + 1;
    }
}
