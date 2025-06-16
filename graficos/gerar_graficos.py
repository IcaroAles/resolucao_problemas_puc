import pandas as pd
import matplotlib.pyplot as plt
import os

# Criar pasta se não existir
os.makedirs("graficos", exist_ok=True)

# Carregar os dados
df = pd.read_csv("resultados/resultados.csv")

# Agrupar por algoritmo e tamanho
media_df = df.groupby(["Algoritmo", "Tamanho"]).mean().reset_index()

# Lista de métricas
metricas = ["Tempo", "Trocas", "Interacoes"]

for metrica in metricas:
    plt.figure()
    for algoritmo in media_df["Algoritmo"].unique():
        dados = media_df[media_df["Algoritmo"] == algoritmo]
        plt.plot(dados["Tamanho"], dados[metrica], label=algoritmo, marker="o")

    plt.title(f"{metrica} por Tamanho do Vetor")
    plt.xlabel("Tamanho do Vetor")
    plt.ylabel(metrica)
    plt.legend()
    plt.grid(True)
    plt.tight_layout()
    
    nome_arquivo = f"{metrica.lower()}_por_tamanho.png"
    plt.savefig(f"graficos/{nome_arquivo}")
    plt.close()

print("Gráficos gerados na pasta /graficos") 