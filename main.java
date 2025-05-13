public class main {
    public static void main(String[] args) {
        ArvoreMorse arvore = new ArvoreMorse();
        arvore.inicializar();

        arvore.inserir(".-", 'A');
        arvore.inserir("-...", 'B');
        arvore.inserir("-.-.", 'C');
        arvore.inserir("-..", 'D');
        arvore.inserir(".", 'E');
        arvore.inserir("..-.", 'F');
        arvore.inserir("--.", 'G');
        arvore.inserir("....", 'H');
        arvore.inserir("..", 'I');
        arvore.inserir(".---", 'J');
        arvore.inserir("-.-", 'K');
        arvore.inserir(".-..", 'L');
        arvore.inserir("--", 'M');
        arvore.inserir("-.", 'N');
        arvore.inserir("---", 'O');
        arvore.inserir(".--.", 'P');
        arvore.inserir("--.-", 'Q');
        arvore.inserir(".-.", 'R');
        arvore.inserir("...", 'S');
        arvore.inserir("-", 'T');
        arvore.inserir("..-", 'U');
        arvore.inserir("...-", 'V');
        arvore.inserir(".--", 'W');
        arvore.inserir("-..-", 'X');
        arvore.inserir("-.--", 'Y');
        arvore.inserir("--..", 'Z');

        System.out.println("Buscar letra por código:");
        System.out.println(arvore.buscarLetra("...")); // S
        System.out.println(arvore.buscarLetra("---")); // O
        System.out.println(arvore.buscarLetra("...")); // S

        System.out.println("\nBuscar código por letra:");
        System.out.println("S: " + arvore.buscarCodigo('S')); // ...
        System.out.println("O: " + arvore.buscarCodigo('O')); // ---
        System.out.println("S: " + arvore.buscarCodigo('S')); // ...

        System.out.println("\nDesenho da árvore:");
        arvore.desenhar(arvore.getRaiz(), 0);
    }
}
