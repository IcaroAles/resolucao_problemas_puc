import time

def insertion_sort(arr):
    trocas = 0
    interacoes = 0
    inicio = time.time()

    for i in range(1, len(arr)):
        interacoes += 1
        chave = arr[i]
        j = i - 1
        while j >= 0 and arr[j] > chave:
            interacoes += 1
            arr[j + 1] = arr[j]
            j -= 1
            trocas += 1
        arr[j + 1] = chave

    fim = time.time()
    return fim - inicio, trocas, interacoes
