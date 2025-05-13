public class main {
    public static void main(String[] args) {
        ArvoreMorse arvore = new ArvoreMorse();
        arvore.inicializar();

        // Inserindo algumas letras
        arvore.inserir("...", 'S');
        arvore.inserir("---", 'O');
        arvore.inserir(".-", 'A');
        arvore.inserir("-...", 'B');

        System.out.println("Buscar letra por código:");
        System.out.println(arvore.buscarLetra("...")); // S
        System.out.println(arvore.buscarLetra("---")); // O

        System.out.println("\nBuscar código por letra:");
        System.out.println("S: " + arvore.buscarCodigo('S')); // ...
        System.out.println("O: " + arvore.buscarCodigo('O')); // ---

        System.out.println("\nDesenho da árvore:");
        arvore.desenhar(arvore.getRaiz(), 0);
    }
}
