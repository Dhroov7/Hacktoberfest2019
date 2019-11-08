import matplotlib.pyplot as plt
from random import randint

#define legendas
titulo = "Gráfico de Barras 2"
eixox = "Eixo X"
eixoY = "Eixo Y"

#setLegendas
plt.title(titulo)
plt.xlabel(eixox)
plt.ylabel(eixoY)

#criacao de Dados
x = [i for i in range(10)]
y = [randint(1,10) for i in range(10)]

#insere os dados
plt.scatter(x,y,color='r') #disperção
plt.plot(x,y,color='g') #liga os pontos

#mostra o grafico
plt.show()
