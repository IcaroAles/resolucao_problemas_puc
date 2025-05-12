public class Arvore23 {

    No23 raiz;

    public void inserir(int valor) {
        raiz = inserir(raiz, valor);
    }

    private No23 inserir(No23 No23, int valor) {
        if (No23 == null) {
            return new No23(valor);
        }

        if (No23.ehFolha()) {
            if (!No23.duasChaves) {
                if (valor < No23.chave1) {
                    No23.chave2 = No23.chave1;
                    No23.chave1 = valor;
                } else {
                    No23.chave2 = valor;
                }
                No23.duasChaves = true;
                return No23;
            } else {
                return dividir(No23, valor);
            }
        }

        if (valor < No23.chave1) {
            No23.esquerda = inserir(No23.esquerda, valor);
        } else if (!No23.duasChaves || valor < No23.chave2) {
            No23.centro = inserir(No23.centro, valor);
        } else {
            No23.direita = inserir(No23.direita, valor);
        }

        return No23;
    }

    private No23 dividir(No23 No23, int valor) {
        int menor, meio, maior;

        if (valor < No23.chave1) {
            menor = valor;
            meio = No23.chave1;
            maior = No23.chave2;
        } else if (valor < No23.chave2) {
            menor = No23.chave1;
            meio = valor;
            maior = No23.chave2;
        } else {
            menor = No23.chave1;
            meio = No23.chave2;
            maior = valor;
        }

        No23 novaRaiz = new No23(meio);
        novaRaiz.esquerda = new No23(menor);
        novaRaiz.centro = new No23(maior);

        return novaRaiz;
    }

    public boolean buscar(int valor) {
        return buscar(raiz, valor);
    }

    private boolean buscar(No23 No23, int valor) {
        if (No23 == null) return false;

        if (valor == No23.chave1 || (No23.duasChaves && valor == No23.chave2)) return true;

        if (valor < No23.chave1) return buscar(No23.esquerda, valor);
        if (!No23.duasChaves || valor < No23.chave2) return buscar(No23.centro, valor);
        return buscar(No23.direita, valor);
    }

    public void remover(int valor) {
        remover(raiz, valor);
    }

    private void remover(No23 No23, int valor) {
        if (No23 == null) return;

        if (No23.chave1 == valor) {
            if (No23.duasChaves) {
                No23.chave1 = No23.chave2;
                No23.duasChaves = false;
            } else {
                No23.chave1 = -1;
            }
        } else if (No23.duasChaves && No23.chave2 == valor) {
            No23.chave2 = -1;
            No23.duasChaves = false;
        } else if (valor < No23.chave1) {
            remover(No23.esquerda, valor);
        } else if (!No23.duasChaves || valor < No23.chave2) {
            remover(No23.centro, valor);
        } else {
            remover(No23.direita, valor);
        }
    }

    public void emOrdem(No23 No23) {
        if (No23 == null) return;
        emOrdem(No23.esquerda);
        if (No23.chave1 != -1) System.out.print(No23.chave1 + " ");
        emOrdem(No23.centro);
        if (No23.duasChaves && No23.chave2 != -1) System.out.print(No23.chave2 + " ");
        emOrdem(No23.direita);
    }

    public void desenhar(No23 no, int nivel) {
        if (no == null) return;

        // Desenha primeiro o filho da direita
        desenhar(no.direita, nivel + 1);

    // Indentação para o nível atual
        for (int i = 0; i < nivel; i++) {
            System.out.print("       "); // 7 espaços para espaçamento visual
        }

    // Impressão do nó com base nas chaves
        if (no.chave1 != -1 && no.duasChaves && no.chave2 != -1) {
            System.out.println("[" + no.chave1 + " | " + no.chave2 + "]");
        } else if (no.chave1 != -1) {
            System.out.println("[" + no.chave1 + "]");
        } else if (no.duasChaves && no.chave2 != -1) {
            System.out.println("[" + no.chave2 + "]");
        } else {
            System.out.println("[ ]");
        }

    // Desenha o filho do centro
        desenhar(no.centro, nivel + 1);

    // Desenha o filho da esquerda
        desenhar(no.esquerda, nivel + 1);
    }
}