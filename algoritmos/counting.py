import time

def counting_sort(arr):
    trocas = 0
    interacoes = 0
    inicio = time.time()

    max_val = max(arr)
    count = [0] * (max_val + 1)

    for num in arr:
        count[num] += 1
        interacoes += 1

    index = 0
    for i in range(len(count)):
        while count[i] > 0:
            arr[index] = i
            count[i] -= 1
            index += 1
            trocas += 1
            interacoes += 1

    fim = time.time()
    return fim - inicio, trocas, interacoes
