import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

plt.style.use('seaborn-v0_8')
sns.set_palette("husl")

df = pd.read_csv('resultados.csv', sep=';')

def criar_graficos():
    fig = plt.figure(figsize=(20, 12))

    for idx, tamanho_conjunto in enumerate(df['TamanhoConjunto'].unique()):
        data = df[df['TamanhoConjunto'] == tamanho_conjunto]

        ax1 = plt.subplot(3, 4, idx * 4 + 1)
        pivot = data.pivot_table(values='TempoInsercao(ms)', index='TamanhoTabela', columns='FuncaoHash')
        pivot.plot(kind='bar', ax=ax1, legend=(idx==0))
        ax1.set_title(f'Tempo de Inserção - {tamanho_conjunto:,} registros')
        ax1.set_ylabel('ms')

        ax2 = plt.subplot(3, 4, idx * 4 + 2)
        pivot = data.pivot_table(values='Colisoes', index='TamanhoTabela', columns='FuncaoHash')
        pivot.plot(kind='bar', ax=ax2, legend=False)
        ax2.set_title(f'Colisões - {tamanho_conjunto:,} registros')
        ax2.set_ylabel('Colisões')

        ax3 = plt.subplot(3, 4, idx * 4 + 3)
        pivot = data.pivot_table(values='TempoBusca(ms)', index='TamanhoTabela', columns='FuncaoHash')
        pivot.plot(kind='bar', ax=ax3, legend=False)
        ax3.set_title(f'Tempo de Busca - {tamanho_conjunto:,} registros')
        ax3.set_ylabel('ms')

        ax4 = plt.subplot(3, 4, idx * 4 + 4)
        pivot = data.pivot_table(values='Comparacoes', index='TamanhoTabela', columns='FuncaoHash')
        pivot.plot(kind='bar', ax=ax4, legend=False)
        ax4.set_title(f'Comparações - {tamanho_conjunto:,} registros')
        ax4.set_ylabel('Comparações')

    plt.suptitle('Análise Completa de Desempenho - Tabela Hash', fontsize=16)
    plt.tight_layout()
    plt.savefig('analise_desempenho.png', dpi=300)
    plt.close()

    gerar_relatorio_texto(df)

def gerar_relatorio_texto(df):
    def tempo_formatado(ms):
        return f"{ms:.2f} ms"

    with open('relatorio_texto.txt', 'w', encoding='utf-8') as f:
        f.write("RELATÓRIO DE DESEMPENHO - TABELA HASH\n\n")

        for func in df['FuncaoHash'].unique():
            subset = df[df['FuncaoHash'] == func]
            f.write(f"Função: {func}\n")
            f.write(f"- Média tempo de inserção: {tempo_formatado(subset['TempoInsercao(ms)'].mean())}\n")
            f.write(f"- Média colisões: {subset['Colisoes'].mean():.0f}\n")
            f.write(f"- Média tempo de busca: {tempo_formatado(subset['TempoBusca(ms)'].mean())}\n")
            f.write(f"- Média comparações: {subset['Comparacoes'].mean():.0f}\n\n")

        f.write("\nMÉDIAS POR TAMANHO DE TABELA:\n")
        for tamanho in sorted(df['TamanhoTabela'].unique()):
            f.write(f"\nTamanho {tamanho}:\n")
            data = df[df['TamanhoTabela'] == tamanho]
            for func in df['FuncaoHash'].unique():
                d = data[data['FuncaoHash'] == func]
                if not d.empty:
                    f.write(f"  {func}:\n")
                    f.write(f"    - Média inserção: {tempo_formatado(d['TempoInsercao(ms)'].mean())}\n")
                    f.write(f"    - Colisões médias: {d['Colisoes'].mean():.0f}\n")
                    f.write(f"    - Média busca: {tempo_formatado(d['TempoBusca(ms)'].mean())}\n")
                    f.write(f"    - Comparações médias: {d['Comparacoes'].mean():.0f}\n")

if __name__ == "__main__":
    criar_graficos()
