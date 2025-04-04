public class MergeFilaEncadeada {
    public static FilaEncadeada merge(FilaEncadeada A, FilaEncadeada B) {
        FilaEncadeada C = new FilaEncadeada();

        while (!A.vazia() && !B.vazia()) {
            if (A.espiar() < B.espiar()) {
                C.insere(A.remove());
            } else {
                C.insere(B.remove());
            }
        }

        while (!A.vazia()) {
            C.insere(A.remove());
        }

        while (!B.vazia()) {
            C.insere(B.remove());
        }

        return C;
    }
}
