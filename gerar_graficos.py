import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

# Configuração de estilo
plt.style.use('seaborn-v0_8-darkgrid')
sns.set_palette("husl")

df = pd.read_csv("resultado.csv")

# Converte tempo para milissegundos
df["Tempo(ms)"] = df["Tempo(ns)"] / 1_000_000

# 1. Gráfico de Tempo por Dataset
plt.figure(figsize=(10, 6))
sns.barplot(data=df, x="Dataset", y="Tempo(ms)", hue="Algoritmo")
plt.title("Tempo de Execução por Algoritmo e Dataset")
plt.ylabel("Tempo (ms)")
plt.xlabel("Dataset")
plt.legend(title="Algoritmo")
plt.tight_layout()
plt.savefig("grafico_tempo_execucao.png", dpi=300)
plt.close()

# 2. Gráfico de Trocas
plt.figure(figsize=(10, 6))
sns.barplot(data=df, x="Dataset", y="Trocas", hue="Algoritmo")
plt.title("Número de Trocas por Algoritmo e Dataset")
plt.ylabel("Trocas")
plt.xlabel("Dataset")
plt.legend(title="Algoritmo")
plt.tight_layout()
plt.savefig("grafico_trocas.png", dpi=300)
plt.close()

# 3. Gráfico de Iterações
plt.figure(figsize=(10, 6))
sns.barplot(data=df, x="Dataset", y="Iteracoes", hue="Algoritmo")
plt.title("Número de Iterações por Algoritmo e Dataset")
plt.ylabel("Iterações")
plt.xlabel("Dataset")
plt.legend(title="Algoritmo")
plt.tight_layout()
plt.savefig("grafico_iteracoes.png", dpi=300)
plt.close()

print("Gráficos gerados")
