import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {

        int[] tamanhosTabela = {1000, 10000, 100000};
        int[] tamanhosDados = {1_000_000, 5_000_000, 20_000_000};
        long seed = 12345L;

        FileWriter csv = new FileWriter("resultados.csv");
        csv.write("Tabela,Dados,Hash,TempoInsercao(ms),Colisoes,TempoBusca(ms),Comparacoes\n");

        for (int tamanhoTabela : tamanhosTabela) {
            for (int tamanhoDados : tamanhosDados) {

                System.out.println("Gerando dados...");
                Registro[] dados = GeradorDados.gerarDados(tamanhoDados, seed);

                // Para cada função hash:
                String[] funcoesHash = {"Mod", "Multiplicacao", "Dobramento"};

                for (String funcao : funcoesHash) {

                    // Criar as tabelas
                    Encadeamento hashEnc = new Encadeamento(tamanhoTabela);
                    Linear hashLin = new Linear(tamanhoTabela);

                    // --- INSERÇÃO ---
                    long inicioInsercao = System.currentTimeMillis();

                    for (Registro r : dados) {
                        int key = Integer.parseInt(r.getCodigo());
                        int hashIndex = 0;

                        if (funcao.equals("mod")) {
                            hashIndex = FuncoesHash.hashMod(key, tamanhoTabela);
                        } else if (funcao.equals("Multiplicacao")) {
                            hashIndex = FuncoesHash.hashMultiplicacao(key, tamanhoTabela);
                        } else if (funcao.equals("Dobramento")) {
                            hashIndex = FuncoesHash.hashDobramento(r.getCodigo(), tamanhoTabela);
                        }

                        // Inserir nas tabelas
                        hashEnc.insert(r, hashIndex);
                        hashLin.insert(r, hashIndex);
                    }

                    long fimInsercao = System.currentTimeMillis();
                    long tempoInsercao = fimInsercao - inicioInsercao;

                    // --- BUSCA ---
                    Random rand = new Random(seed); // garantir que as buscas são sempre iguais
                    int comparacoesEnc = 0;
                    int comparacoesLin = 0;

                    long inicioBusca = System.currentTimeMillis();

                    for (int i = 0; i < 5; i++) {
                        int indiceBusca = rand.nextInt(tamanhoDados);
                        String codigoBusca = dados[indiceBusca].getCodigo();

                        int hashIndex = 0;
                        if (funcao.equals("Mod")) {
                            hashIndex = FuncoesHash.hashMod(Integer.parseInt(codigoBusca), tamanhoTabela);
                        } else if (funcao.equals("Multiplicacao")) {
                            hashIndex = FuncoesHash.hashMultiplicacao(Integer.parseInt(codigoBusca), tamanhoTabela);
                        } else if (funcao.equals("Dobramento")) {
                            hashIndex = FuncoesHash.hashDobramento(codigoBusca, tamanhoTabela);
                        }

                        // Busca Encadeamento
                        boolean foundEnc = hashEnc.search(codigoBusca, hashIndex);
                        // Supondo 1 comparação por elemento da lista (poderia ser mais detalhado se você contar no método search)
                        comparacoesEnc += 1;

                        // Busca Linear
                        boolean foundLin = hashLin.search(codigoBusca, hashIndex);
                        // Supondo 1 comparação por elemento visitado (mesma ideia)
                        comparacoesLin += 1;
                    }

                    long fimBusca = System.currentTimeMillis();
                    long tempoBusca = fimBusca - inicioBusca;

                    // --- Gravar no CSV ---
                    csv.write(tamanhoTabela + "," + tamanhoDados + "," + funcao + "," + tempoInsercao + "," + hashEnc.colisoes + "," + tempoBusca + "," + comparacoesEnc + "\n");

                    csv.write(tamanhoTabela + "," + tamanhoDados + "," + funcao + " (Linear)" + "," + tempoInsercao + "," + hashLin.colisoes + "," + tempoBusca + "," + comparacoesLin + "\n");

                    System.out.println("Rodada completa: Tabela=" + tamanhoTabela + " Dados=" + tamanhoDados + " Hash=" + funcao);
                }
            }
        }

        csv.close();
        System.out.println("Todos os resultados foram salvos no arquivo resultados.csv.");
    }
}
