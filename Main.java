public class Main {
    public static void main(String[] args) {
        Arvore23 arvore = new Arvore23();

        arvore.inserir(10);
        arvore.inserir(20);
        arvore.inserir(15);
        arvore.inserir(5);
        arvore.inserir(25);
        arvore.inserir(30);

        System.out.println("\n\nÁrvore em ordem:");
        arvore.emOrdem(arvore.raiz);

        System.out.println("\n\nDesenho da árvore:");
        arvore.desenhar(arvore.raiz, 0);

        System.out.println("\nRemovendo 15 e 10...\n");
        arvore.remover(15);
        arvore.remover(10);

        System.out.println("\nApós remoção:");
        arvore.emOrdem(arvore.raiz);

        System.out.println("\n\nÁrvore desenhada:");
        arvore.desenhar(arvore.raiz, 0);
    }
}
