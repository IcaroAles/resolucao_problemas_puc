public class Main {
    public static void main(String[] args) {
        int[][] datasets = {
            {1, 100, 2, 99, 3, 98, 4, 97, 5, 96, 6, 95, 7, 94, 8, 93, 9, 92, 10, 91, 11, 90, 12, 89, 13, 88, 14, 87, 15, 86, 16, 85, 17, 84, 18, 83, 19, 82, 20, 81, 21, 80, 22, 79, 23, 78, 24, 77, 25, 76},
            {1, 100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87, 86, 85, 84, 83, 82, 81, 80, 79, 78, 77, 76, 75, 74, 73, 72, 71, 70, 69, 68, 67, 66, 65, 64, 63, 62, 61, 60, 59, 58, 57, 56, 55, 54, 53, 52},
            {50, 49, 48, 47, 46, 45, 44, 43, 42, 41, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1}
        };

        String[] nomes = {"Dataset 1", "Dataset 2", "Dataset 3"};

        System.out.println("Dataset,Algoritmo,Tempo(ns),Trocas,Iteracoes");

        for (int d = 0; d < 3; d++) {
            int[] original = datasets[d];

            // MergeSort
            int[] v1 = new int[50];
            for (int i = 0; i < 50; i++) v1[i] = original[i];
            long t1 = System.nanoTime();
            MergeSortIterativo.mergeSort(v1, 50);
            long t2 = System.nanoTime();
            System.out.println(nomes[d] + ",MergeSort," + (t2 - t1) + "," + MergeSortIterativo.trocas + "," + MergeSortIterativo.iteracoes);

            // RadixSort
            int[] v2 = new int[50];
            for (int i = 0; i < 50; i++) v2[i] = original[i];
            long t3 = System.nanoTime();
            RadixSort.radixSort(v2, 50);
            long t4 = System.nanoTime();
            System.out.println(nomes[d] + ",RadixSort," + (t4 - t3) + "," + RadixSort.trocas + "," + RadixSort.iteracoes);

            // QuickSort
            int[] v3 = new int[50];
            for (int i = 0; i < 50; i++) v3[i] = original[i];
            long t5 = System.nanoTime();
            QuickSortIterativo.quickSort(v3, 50);
            long t6 = System.nanoTime();
            System.out.println(nomes[d] + ",QuickSort," + (t6 - t5) + "," + QuickSortIterativo.trocas + "," + QuickSortIterativo.iteracoes);
        }
    }
}
