public class MergeSortIterativo {

    public static int trocas = 0;
    public static int iteracoes = 0;

    public static void mergeSort(int[] vetor, int tamanho) {
        trocas = 0;
        iteracoes = 0;

        int largura = 1;

        while (largura < tamanho) {
            int esquerda = 0;

            //percorre o vetor de largura em largura
            while (esquerda < tamanho) {
                //define os limites esquerda meio e direita
                int meio = esquerda + largura - 1;
                int direita = esquerda + 2 * largura - 1;

                //se meior passar do vetor nao tem o que mesclar
                if (meio >= tamanho) break;

                //corrige limite direito se passar do vetor
                if (direita >= tamanho) direita = tamanho - 1;

                mesclar(vetor, esquerda, meio, direita);
                esquerda = esquerda + 2 * largura;
            }

            largura = largura * 2;
        }
    }

    private static void mesclar(int[] vetor, int esquerda, int meio, int direita) {
        int tamanho1 = meio - esquerda + 1;
        int tamanho2 = direita - meio;

        //vetores auxilixares para guardar os blocos
        int[] esq = new int[100];
        int[] dir = new int[100];

        //copiar elementos da esquerda
        int i = 0;
        while (i < tamanho1) {
            esq[i] = vetor[esquerda + i];
            i = i + 1;
        }

        //copia elementos da direita
        int j = 0;
        while (j < tamanho2) {
            dir[j] = vetor[meio + 1 + j];
            j = j + 1;
        }

        i = 0;
        j = 0;
        int k = esquerda;

        //compara e junta os elementos em ordem
        while (i < tamanho1 && j < tamanho2) {
            iteracoes++;
            if (esq[i] <= dir[j]) {
                vetor[k] = esq[i];
                i = i + 1;
            } else {
                vetor[k] = dir[j];
                j = j + 1;
                trocas++;
            }
            k = k + 1;
        }

        //se ainda houver elementos na esquerda copia para o vetor
        while (i < tamanho1) {
            vetor[k] = esq[i];
            i = i + 1;
            k = k + 1;
            trocas++;
        }

        //se ainda houver elementos na direita copia para o vetor
        while (j < tamanho2) {
            vetor[k] = dir[j];
            j = j + 1;
            k = k + 1;
            trocas++;
        }
    }
}
