import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] tamanhosTabela = {1000, 10000, 100000};
        int[] tamanhosDados = {10000, 100000, 1000000};
        int[] funcoes = {1, 2, 3};

        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter("resultados.csv"));
            out.println("TamanhoTabela;TamanhoConjunto;FuncaoHash;TempoInsercao(ms);Colisoes;TempoBusca(ms);Comparacoes");

            for (int tamanhoTabela : tamanhosTabela) {
                for (int tamanhoDados : tamanhosDados) {
                    for (int funcao : funcoes) {
                        Random rand = new Random();
                        rand.setSeed(42);

                        TabelaHash tabela = new TabelaHash(tamanhoTabela, funcao);
                        Registro[] registros = new Registro[tamanhoDados];
                        for (int i = 0; i < tamanhoDados; i++) {
                            int codigo = 100000000 + rand.nextInt(900000000);
                            registros[i] = new Registro(Integer.toString(codigo));
                        }

                        long iniInsercao = System.currentTimeMillis();
                        for (Registro r : registros) {
                            tabela.inserir(r);
                        }
                        long fimInsercao = System.currentTimeMillis();

                        rand.setSeed(42);
                        long iniBusca = System.currentTimeMillis();
                        for (int i = 0; i < 5; i++) {
                            int pos = rand.nextInt(tamanhoDados);
                            tabela.buscar(registros[pos].getCodigo());
                        }
                        long fimBusca = System.currentTimeMillis();

                        out.println(tamanhoTabela + ";" + tamanhoDados + ";" +
                            (funcao == 1 ? "DIVISAO" : funcao == 2 ? "MULTIPLICACAO" : "DOBRAMENTO") + ";" +
                            (fimInsercao - iniInsercao) + ";" + tabela.getColisoes() + ";" +
                            (fimBusca - iniBusca) + ";" + tabela.getComparacoes());
                    }
                }
            }
        } catch (java.io.IOException e) {
            System.out.println("Erro ao criar ou escrever no arquivo: " + e.getMessage());
            return;
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
