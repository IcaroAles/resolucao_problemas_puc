import java.util.Random;

public class GeradorDados {

    public static Registro[] gerarDados(int quantidade, long seed) {
        System.out.println("Gerando dados...");
        Registro[] dados = new Registro[quantidade];
        System.out.println("Dados gerados com sucesso, iniciando inserção...");
        Random random = new Random(seed);

        for (int i = 0; i < quantidade; i++) {
            int numero = random.nextInt(1_000_000_000); // 9 dígitos
            String codigo = String.format("%09d", numero);
            dados[i] = new Registro(codigo);

            if (i % 100_000 == 0) {
                System.out.println("Gerados " + i + " Registros...");
            }
        }
        return dados;
    }
}
