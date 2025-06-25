public class RadixSort {

    public static int trocas = 0; // Contador de trocas
    public static int iteracoes = 0; // Contador de iterações

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
        int[] output = new int[100]; // vetor guarda ordenacao atual
        int[] count = new int[10];  // vetor temporario para contar quantas vezes cada digito aparece

        int i = 0;
        while (i < 10) {
            count[i] = 0;
            i++;
        }
// conta quantas vezes cada digito aparece na casa decimal atual
        i = 0;
        while (i < tamanho) {
            int digito = (vetor[i] / exp) % 10;
            count[digito]++;
            iteracoes++;
            i++;
        }
// transforma a contagem em posição do vetor
        i = 1;
        while (i < 10) {
            count[i] += count[i - 1];
            i++;
        }
//constroi o vetor de saida
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
