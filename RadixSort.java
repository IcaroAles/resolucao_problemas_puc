public class RadixSort {

    public static int trocas = 0;
    public static int iteracoes = 0;

    public static void radixSort(int[] vetor, int tamanho) {
        trocas = 0;
        iteracoes = 0;

        int maior = encontrarMaior(vetor, tamanho);
        int exp = 1;

        while (maior / exp > 0) {
            countingSort(vetor, tamanho, exp);
            exp = exp * 10;
        }
    }

    private static void countingSort(int[] vetor, int tamanho, int exp) {
        int[] output = new int[100];
        int[] count = new int[10];

        int i = 0;
        while (i < 10) {
            count[i] = 0;
            i++;
        }

        i = 0;
        while (i < tamanho) {
            int digito = (vetor[i] / exp) % 10;
            count[digito]++;
            iteracoes++;
            i++;
        }

        i = 1;
        while (i < 10) {
            count[i] += count[i - 1];
            i++;
        }

        i = tamanho - 1;
        while (i >= 0) {
            int digito = (vetor[i] / exp) % 10;
            output[count[digito] - 1] = vetor[i];
            count[digito]--;
            trocas++;
            i--;
        }

        i = 0;
        while (i < tamanho) {
            vetor[i] = output[i];
            i++;
        }
    }

    private static int encontrarMaior(int[] vetor, int tamanho) {
        int maior = vetor[0];
        int i = 1;
        while (i < tamanho) {
            if (vetor[i] > maior) {
                maior = vetor[i];
            }
            i++;
        }
        return maior;
    }
}
