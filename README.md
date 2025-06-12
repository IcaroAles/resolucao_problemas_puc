# Trabalho: Tabela Hash — Análise de Desempenho

Este trabalho tem como objetivo implementar e analisar o desempenho de diferentes tabelas hash em Java, utilizando três funções hash e três tamanhos de tabela, com conjuntos de dados de diferentes tamanhos.

## Configuração do Experimento

* **Tamanhos da Tabela:** 1000, 10000, 100000
* **Funções Hash:**

  * Mod (resto da divisão)
  * Multiplicacao
  * Dobramento (folding)
* **Conjuntos de Dados:** 1 milhão (1M), 5 milhões (5M), 20 milhões (20M)
* **Seed fixa:** 12345L

## Metodologia

Cada registro contém um código de 9 dígitos. Os dados foram gerados com seed fixa, garantindo a reprodutibilidade.

Foram implementadas duas abordagens para tabela hash:

* **Encadeamento** (LinkedList em cada slot da tabela)
* **Linear Probing** (com controle para evitar loops infinitos em tabela cheia)

Para cada combinação de:

* Tamanho da tabela
* Função hash
* Tamanho do conjunto de dados

foram realizadas as seguintes medições:

* Tempo de inserção (ms)
* Número de colisões
* Tempo de busca (ms)
* Número de comparações (realizadas 5 buscas por rodada)

Os resultados foram salvos no arquivo `resultados.csv`.

## Resultados

### Gráfico 1 — Tempo de Inserção

*O gráfico mostra que a função hash de Multiplicacao apresentou um tempo de inserção mais equilibrado em todos os tamanhos de tabela. Já a função de Dobramento apresentou maior variação, principalmente em tabelas menores. A estratégia de Linear Probing apresentou crescimento maior no tempo de inserção em tabelas pequenas devido ao aumento de colisões.*

### Gráfico 2 — Colisões

*O gráfico evidencia que a quantidade de colisões foi significativamente maior em tabelas de tamanho pequeno (1000), independentemente da função hash utilizada. As funções de Multiplicacao e Dobramento apresentaram melhor desempenho em termos de redução de colisões em tabelas maiores. O Encadeamento demonstrou mais robustez em lidar com altas taxas de ocupação.*

### Gráfico 3 — Tempo de Busca

*O gráfico demonstra que o tempo de busca permaneceu estável nas tabelas maiores, com destaque para o Encadeamento, que apresentou desempenho consistente mesmo com grande volume de dados. A estratégia de Linear Probing apresentou aumento de tempo de busca em tabelas pequenas devido ao maior número de colisões.*

## Análise dos Resultados

A análise dos resultados mostrou os seguintes comportamentos:

* Em tabelas pequenas (1000 slots), todas as funções apresentaram alto número de colisões, como esperado.
* A função de Multiplicacao apresentou desempenho de inserção mais equilibrado nas tabelas maiores.
* O método de Linear Probing apresentou degradação de desempenho em tabelas muito carregadas, especialmente com conjuntos de 20M registros.
* O Encadeamento foi mais robusto e consistente, mesmo com grandes volumes de dados.
* O tempo de busca foi mais estável com Encadeamento em tabelas maiores.

## Conclusão

A análise demonstrou que:

* A função hash que apresentou o desempenho mais equilibrado foi a função de Multiplicacao.
* A abordagem de Encadeamento foi a mais robusta e confiável em volumes de dados maiores.
* O tamanho de tabela 100000 foi o que melhor equilibrou tempo de inserção e busca.
* Tabelas pequenas (1000 slots) não são adequadas para grandes volumes de dados, gerando elevado número de colisões e impacto no desempenho.

O trabalho evidenciou a importância de escolher um tamanho de tabela adequado e uma função hash eficiente para obter bom desempenho em operações com tabelas hash.

## Execução do Projeto

Para compilar e executar o projeto:

```bash
javac -d bin src/*.java
java -cp bin Main
```

---

# Fim do Relatório
