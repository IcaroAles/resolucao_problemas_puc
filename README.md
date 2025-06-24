# Comparação de Algoritmos de Ordenação

Este projeto tem como objetivo comparar o desempenho de três algoritmos de ordenação: Merge Sort, Radix Sort e Quick Sort. A análise considera três aspectos principais: tempo de execução, número de trocas e número de iterações.

## Estrutura do Projeto

O projeto é dividido em duas partes principais:

- Java: Implementação dos algoritmos de ordenação, coleta de métricas e geração do arquivo `resultado.csv`.
- Python: Leitura dos resultados e geração de gráficos estatísticos com `matplotlib`, `pandas` e `seaborn`.

---

## Rodadas e Coleta de Dados

Cada algoritmo foi testado em 3 datasets diferentes. Para cada combinação, foram registradas:

- O tempo de execução
- O número de trocas realizadas
- O número de iterações 

Os dados foram exportados automaticamente para o arquivo `resultado.csv`.

---

## Resultados e Análise

Abaixo, uma visão geral dos resultados com base na média dos três datasets.

###  Tempo de Execução Médio (ms)
- MergeSort: 0.187
- RadixSort: 0.190
- QuickSort: 0.210

 Análise: O MergeSort apresentou o menor tempo médio de execução, ainda que por uma margem pequena. O QuickSort foi o mais lento nesse aspecto.

### Número Médio de Trocas
- MergeSort: 262.0
- RadixSort: 130.0
- QuickSort: 566.7

 Análise: O RadixSort foi o algoritmo que realizou menos trocas, o que é esperado já que não usa comparações diretas, enquanto o QuickSort apresentou o maior número.

### Número Médio de Iterações
- MergeSort: 162.0  
- RadixSort: 130.0  
- QuickSort: 966.7

 Análise: O RadixSort teve o menor número médio de iterações. O QuickSort teve um número muito alto de iterações, o que pode indicar maior custo computacional interno.

---

## Melhor Algoritmo

Considerando os três critérios:

- Tempo: MergeSort foi o mais rápido.
- Trocas: RadixSort foi o mais eficiente.
- Iterações: RadixSort foii o melhor.

 Conclusão parcial: RadixSort teve o melhor desempenho geral, principalmente por ser o mais estável em trocas e iterações, mesmo que não tenha sido o mais rápido.

---

##  Conclusão Final

Cada algoritmo tem suas forças:

- MergeSort é eficiente, com bom tempo de execução.
- RadixSort é eficas em trocas e iterações, sendo o mais estável em datasets com números inteiros.
- QuickSort não se destacou em nenhuma métrica, e teve desempenho pior nos três aspectos, o que pode estar relacionado a forma como lida com piores casos.

A escolha do "melhor" depende do cenário. Para listas grandes e inteiras, o RadixSort se mostrou o melhor.

---

##  Gráficos Gerados

- `grafico_tempo_execucao.png`
- `grafico_trocas.png`
- `grafico_iteracoes.png`

Esses gráficos ajudam a visualizar rapidamente as diferenças de desempenho entre os algoritmos por dataset.