# Trabalho de Tabela Hash - Estrutura de Dados

## Sobre o Trabalho

Este projeto implementa uma tabela hash com tratamento de colisões via lista encadeada, conforme exigido pela disciplina. Foram avaliadas três funções hash diferentes (divisão, multiplicação e dobramento), testadas em diferentes tamanhos de tabela e conjuntos de dados gerados aleatoriamente com seed fixa.

O objetivo é analisar o desempenho das funções hash quanto ao tempo de inserção, número de colisões, tempo de busca e número de comparações, e apresentar os resultados por meio de gráficos e relatórios automáticos.

---

## Implementação

### Arquivos principais:

- `Registro.java` – Representa um registro com código de 9 dígitos (como String).
- `TabelaHash.java` – Implementa a tabela hash com listas encadeadas (chaining).
- `No.java` – Representa um nó de uma lista encadeada contendo um `Registro`.
- `Main.java` – Executa os testes de inserção e busca, gera o arquivo `resultados.csv` com os dados medidos.
- `analise_desempenho_hash.py` – Script Python que gera gráficos automáticos e um relatório textual (`relatorio_texto.txt`) com as médias por função hash.

---

## Como Funciona

1. O programa gera códigos aleatórios de 9 dígitos com `Random` e `setSeed(42)`.
2. Os registros são inseridos na tabela hash usando cada uma das 3 funções hash.
3. O código mede:
   - Tempo total de inserção (`System.currentTimeMillis()`),
   - Número de colisões (no vetor e nas listas encadeadas),
   - Tempo total de busca (buscando 5 elementos),
   - Número total de comparações.
4. Os resultados são armazenados no arquivo `resultados.csv`.
5. O script Python lê esse CSV, gera gráficos (`analise_desempenho.png`) e um relatório em texto (`relatorio_texto.txt`).

---

## Funções Hash Implementadas

- Divisão: `chave % tamanho_tabela`  
  Simples, rápida e eficiente. Ideal quando os dados estão bem distribuídos.

- Multiplicação: Baseada em aritmética com constante primitiva e multiplicações sucessivas. Boa dispersão, custo maior.

- Dobramento: Divide a chave em blocos de 3 dígitos, soma os blocos e aplica módulo da tabela. É intuitiva, mas nos testes teve resultados mistos.

---

## Tamanhos Testados

### Tamanhos de Tabela:
- 1.000 posições  
- 10.000 posições  
- 100.000 posições  

### Tamanhos dos Conjuntos de Dados:
- 10.000 elementos  
- 100.000 elementos  
- 1.000.000 elementos  

Todos os testes são realizados com os mesmos dados (graças à `seed` fixa) para garantir comparação justa entre as funções hash.

---

## Resultados e Gráficos

### 📊 `analise_desempenho.png`

O gráfico gerado apresenta:

- Tempo de inserção
- Número de colisões
- Tempo de busca
- Número de comparações

Para cada combinação de tamanho de tabela, tamanho do conjunto e função hash.

### 📄 `relatorio_texto.txt`

Este relatório mostra as médias por função hash em todos os testes. Ideal para embasar a conclusão e comparar o desempenho global de cada abordagem.

---

## Conclusões

- A função Divisão teve o melhor desempenho geral: rápida e com menos colisões.
- A Multiplicação foi intermediária em tempo, mas teve mais colisões em algumas situações.
- A função Dobramento surpreendeu em alguns testes com listas encadeadas, mas teve desempenho inconsistente.
- Tabelas muito pequenas (ex: 1.000) geram muitas colisões e afetam o desempenho.
- Tabelas maiores, mesmo com grande volume de dados, garantem inserção rápida e menor número de colisões.

---


## Como Rodar

### Etapa 1: Compilar e executar os testes em Java
```bash
javac *.java
java Main
