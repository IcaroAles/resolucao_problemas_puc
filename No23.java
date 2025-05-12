public class No23 {
    int chave1, chave2;
    No23 esquerda, centro, direita;
    boolean duasChaves;

    public No23(int valor) {
        this.chave1 = valor;
        this.chave2 = -1;
        this.duasChaves = false;
    }

    public boolean ehFolha() {
        return esquerda == null && centro == null && direita == null;
    }
}
