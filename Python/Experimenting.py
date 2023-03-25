import numpy as np

matrix = np.array([[2, 2, 2],
                   [2, 2, 2]])
vector = np.array([[5],
                    [2],
                    [1]])
print('Matrix:')
print(matrix)
print('Vector:')
print(vector)

print('Product: ')
print(np.matmul(matrix, vector))