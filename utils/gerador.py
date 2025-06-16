import random

def gerar_vetor(tamanho, seed):
    random.seed(seed)
    return [random.randint(0, 10000) for _ in range(tamanho)]
