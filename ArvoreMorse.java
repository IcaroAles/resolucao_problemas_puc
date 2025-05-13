public class ArvoreMorse {
    private Nodo raiz;

    public void inicializar() {
        raiz = new Nodo(' '); // raiz vazia
    }

    public void inserir(String codigo, char letra) {
        Nodo atual = raiz;
        int i = 0;
        while (i < codigo.length()) {
            char c = codigo.charAt(i);
            if (c == '.') {
                if (atual.esquerda == null)
                    atual.esquerda = new Nodo(' ');
                atual = atual.esquerda;
            } else if (c == '-') {
                if (atual.direita == null)
                    atual.direita = new Nodo(' ');
                atual = atual.direita;
            }
            i = i + 1;
        }
        atual.caractere = letra;
    }

    public char buscarLetra(String codigo) {
        Nodo atual = raiz;
        int i = 0;
        while (i < codigo.length()) {
            char c = codigo.charAt(i);
            if (c == '.') {
                if (atual.esquerda != null)
                    atual = atual.esquerda;
                else
                    return '?';
            } else if (c == '-') {
                if (atual.direita != null)
                    atual = atual.direita;
                else
                    return '?';
            }
            i = i + 1;
        }
        return atual.caractere;
    }

    public String buscarCodigo(char letra) {
        return buscarCodigoRec(raiz, letra, "");
    }

    private String buscarCodigoRec(Nodo atual, char letra, String caminho) {
        if (atual == null)
            return "";
        if (atual.caractere == letra)
            return caminho;

        String esquerda = buscarCodigoRec(atual.esquerda, letra, caminho + ".");
        if (esquerda != "")
            return esquerda;

        String direita = buscarCodigoRec(atual.direita, letra, caminho + "-");
        return direita;
    }

    public void desenhar(Nodo node, int nivel) {
        if (node == null) return;
        desenhar(node.direita, nivel + 1);
        for (int i = 0; i < nivel; i++) System.out.print("   ");
        System.out.println(node.caractere);
        desenhar(node.esquerda, nivel + 1);
    }

    public Nodo getRaiz() {
        return raiz;
    }
}
