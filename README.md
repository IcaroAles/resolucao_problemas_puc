
## Algoritmos Implementados

- Insertion Sort (Grupo A)
- Counting Sort (Grupo C)


## Metodologia

- Foram utilizados vetores de inteiros com os seguintes tamanhos:
  - 1.000
  - 10.000
  - 100.000
  - 500.000
  - 1.000.000

- Para cada tamanho, foram geradas 5 rodadas diferentes utilizando seeds fixas.

- Os resultados médios de cada métrica foram salvos em `resultados/resultados.csv`.

## Gráficos

Foram gerados três gráficos para análise comparativa:

- `tempo_por_tamanho.png`: Tempo médio de execução
- `trocas_por_tamanho.png`: Número médio de trocas
- `interacoes_por_tamanho.png`: Número médio de interações

Todos os gráficos se encontram na pasta `/graficos`.

## Demonstração em vídeo

A explicação do funcionamento, código-fonte, dados e análise dos gráficos pode ser conferida no vídeo a seguir:

 [Clique aqui para assistir ao vídeo](https://youtu.be/Woqihd9Ygxo)

## Execução

Para rodar o projeto:

```bash
pip install -r requirements.txt
python main.py
python graficos/gerar_graficos.py