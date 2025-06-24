public class TabelaHash {
    private No[] tabela;
    private int tamanho;
    private int funcaoHash;
    private int colisoes;
    private int comparacoes;

    public TabelaHash(int tamanho, int funcaoHash) {
        this.tamanho = tamanho;
        this.tabela = new No[tamanho];
        this.funcaoHash = funcaoHash;
        this.colisoes = 0;
        this.comparacoes = 0;
    }

    private int hash(String chave) {
        int codigo = 0;

        if (funcaoHash == 1) {
            for (int i = 0; i < 9; i++) {
                char c = chave.charAt(i);
                if (c >= '0' && c <= '9') {
                    codigo = codigo * 10 + (c - '0');
                }
            }
            int idx = codigo % tamanho;
            if (idx < 0) idx = idx + tamanho;
            return idx;

        } else if (funcaoHash == 2) {
            for (int i = 0; i < 9; i++) {
                char c = chave.charAt(i);
                if (c >= '0' && c <= '9') {
                    codigo = codigo * 10 + (c - '0');
                }
            }
            int val = 0;
            int p = 31415;
            for (int i = 0; i < 9; i++) {
                val = (p * val + (chave.charAt(i) - '0')) % tamanho;
            }
            int idx = val % tamanho;
            if (idx < 0) idx = idx + tamanho;
            return idx;

        } else {
            int soma = 0;
            int bloco = 0;
            int cont = 0;

            for (int i = 0; i < 9; i++) {
                char c = chave.charAt(i);
                if (c >= '0' && c <= '9') {
                    bloco = bloco * 10 + (c - '0');
                    cont++;
                    if (cont == 3) {
                        soma += bloco;
                        bloco = 0;
                        cont = 0;
                    }
                }
            }
            if (cont > 0) {
                soma += bloco;
            }
            int idx = soma % tamanho;
            if (idx < 0) idx = idx + tamanho;
            return idx;
        }
    }

    public void inserir(Registro registro) {
        int pos = hash(registro.getCodigo());
        if (tabela[pos] == null) {
            tabela[pos] = new No(registro);
        } else {
            colisoes++;
            No atual = tabela[pos];
            while (atual.proximo != null) {
                atual = atual.proximo;
                colisoes++;
            }
            atual.proximo = new No(registro);
        }
    }

    public Registro buscar(String codigo) {
        int pos = hash(codigo);
        No atual = tabela[pos];
        while (atual != null) {
            comparacoes++;
            if (atual.registro.getCodigo().equals(codigo)) {
                return atual.registro;
            }
            atual = atual.proximo;
        }
        return null;
    }

    public int getColisoes() {
        return colisoes;
    }

    public int getComparacoes() {
        return comparacoes;
    }
}
