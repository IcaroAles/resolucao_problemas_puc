import java.util.LinkedList;

public class Encadeamento {
    private LinkedList<Registro>[] table;
    private int size;
    public int colisoes = 0;

    @SuppressWarnings("unchecked")
    public Encadeamento(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public void insert(Registro r, int hashIndex) {
        LinkedList<Registro> list = table[hashIndex];
        if (!list.isEmpty()) {
            colisoes++;
        }
        list.add(r);
    }

    public boolean search(String codigo, int hashIndex) {
        LinkedList<Registro> list = table[hashIndex];
        for (Registro r : list) {
            if (r.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }
}
