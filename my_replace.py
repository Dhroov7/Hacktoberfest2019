def my_replace(lista, exchange, changed):
    for i in range(len(lista)):
        if lista[i] == exchange:
            lista[i] = changed

    return lista

lista = input().split()
exchange = input()
changed = input()
my_replace = my_replace(lista, exchange, changed)
print(my_replace)
