from algoritmos.insertion import insertion_sort
from algoritmos.counting import counting_sort
from utils.gerador import gerar_vetor
import pandas as pd
import os

tamanhos = [1000, 10000, 100000, 500000, 1000000]
seeds = [42, 43, 44, 45, 46]

resultados = []

for tamanho in tamanhos:
    for seed in seeds:
        vetor = gerar_vetor(tamanho, seed)

        if tamanho <= 10000:
            tempo_i, trocas_i, interacoes_i = insertion_sort(vetor.copy())
            resultados.append({
                "Algoritmo": "Insertion Sort",
                "Tamanho": tamanho,
                "Seed": seed,
                "Tempo": "{:.4f}".format(tempo_i),
                "Trocas": trocas_i,
                "Interacoes": interacoes_i
            })

        tempo_c, trocas_c, interacoes_c = counting_sort(vetor.copy())
        resultados.append({
            "Algoritmo": "Counting Sort",
            "Tamanho": tamanho,
            "Seed": seed,
            "Tempo": "{:.4f}".format(tempo_c),
            "Trocas": trocas_c,
            "Interacoes": interacoes_c
        })

# Salvar resultados
df = pd.DataFrame(resultados)

# Salvar com formatação
os.makedirs("resultados", exist_ok=True)
df.to_csv("resultados/resultados.csv", index=False)
print("Dados salvos em resultados/resultados.csv")

