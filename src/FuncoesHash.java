public class FuncoesHash {

    public static int hashMod(int key, int tableSize) {
        return key % tableSize;
    }

    public static int hashMultiplicacao(int key, int tableSize) {
        double A = 0.61803398875; // constante irracional
        double frac = (key * A) % 1;
        return (int) Math.floor(tableSize * frac);
    }

    public static int hashDobramento(String codigo, int tableSize) {
        int sum = 0;
        for (int i = 0; i < codigo.length(); i += 3) {
            int end = Math.min(i + 3, codigo.length());
            String part = codigo.substring(i, end);
            sum += Integer.parseInt(part);
        }
        return sum % tableSize;
    }
}
