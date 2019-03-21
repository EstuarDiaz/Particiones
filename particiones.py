# -*- coding: utf-8 -*-
"""
Created on Thu Mar 21 10:49:36 2019

@author: ediaz
"""
import numpy as np
import matplotlib.pyplot as plt

def particiones(n, imprimir = False):
    line = [n]
    if imprimir:
        print(n)
    total = 1
    while line[0] > 1:
        pos = 0
        # Revisar de derecha a izquierda para que posicion i, line_i > 1
        i = len(line)-1
        while i >= 0 and pos == 0:
            if line[i] > 1:
                pos = i
            i -= 1
        # Se copian todos los elementos a_j, j < i para crear una nueva secuencia
        newLine = line[0:pos]
		# Se agrega un elemento b_i = a_i-1 al final de la nueva secuencia
        newLine.append(line[pos]-1)
		# Se agregan elementos a la secuencia de izquierda a derecha,
		# buscando agregar un b_j tal que sea el maaximo posible y b_j >= b_{j+1}
        while sum(newLine) < n:
            newLine.append(min(newLine[len(newLine)-1], n - sum(newLine)));
        line = newLine;
        # Imprimir particion
        if imprimir:
            print(",".join(str(x) for x in line))
        total += 1
    if imprimir:
        print("TOTAL: ",total)
    return total

# particiones(7, True)

x = np.arange(1, 20, 1)
y = np.array([particiones(int(i)) for i in x])
plt.plot(x, y,'-')
plt.show()