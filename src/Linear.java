public class Linear {
    private Registro[] table;
    private int size;
    public int colisoes = 0;
    int tries = 0;

    public Linear(int size) {
        this.size = size;
        table = new Registro[size];
    }

    public void insert(Registro r, int hashIndex) {
        int index = hashIndex;
        while (table[index] != null) {
            colisoes++;
            index = (index + 1) % size;
            tries++;
            if (tries >= size) {
                return;
            }
        }
        table[index] = r;
    }

    public boolean search(String codigo, int hashIndex) {
        int index = hashIndex;
        int comparisons = 0;
        while (table[index] != null) {
            comparisons++;
            if (table[index].getCodigo().equals(codigo)) {
                return true;
            }
            index = (index + 1) % size;
            if (comparisons > size) break; // proteção contra loop infinito
        }
        return false;
    }
}
