# Tabela Hash com Árvore Binária

Este é um exemplo de implementação de uma tabela hash utilizando uma árvore binária. O código está escrito em Java.

A classe `HashTable` representa a tabela hash e contém os seguintes métodos:

- `HashTable(int capacity)`: Construtor que cria uma tabela hash com a capacidade especificada.

- `insert(int key, Object value)`: Insere um novo elemento na tabela hash, associando a chave especificada ao valor fornecido.

- `get(int key)`: Recupera o valor associado à chave especificada.

- `remove(int key)`: Remove o elemento com a chave especificada da tabela hash.

- `print()`: Imprime todos os elementos armazenados na tabela hash.

O arquivo `Node.java` contém a definição da classe `Node`, que representa um nó na árvore binária. Cada nó contém uma chave e um valor.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

A classe `tree` é uma implementação básica de uma árvore binária.

- `insert(int key, Object value)`: Insere um novo elemento na árvore binária. A chave é usada para determinar a posição do elemento na árvore.

- `get(int key)`: Recupera o valor associado à chave especificada da árvore.

- `remove(int key)`: Remove o elemento com a chave especificada da árvore.

- `print(Node root, int lvl)`: Método auxiliar para imprimir a árvore de forma hierárquica, exibindo a chave e o valor de cada nó.

- `toString()`: Retorna uma representação em forma de string da árvore, chamando o método `print()`.

- `postOrder()`: Realiza a travessia pós-ordem na árvore, imprimindo cada nó visitado.

- `preOrder()`: Realiza a travessia pré-ordem na árvore, imprimindo cada nó visitado.

- `inOrder()`: Realiza a travessia em ordem na árvore, imprimindo cada nó visitado.

O método `main` contém um exemplo de uso da classe `tree`. Alguns nós são inseridos na árvore, alguns elementos são removidos e, em seguida, são feitas chamadas para realizar as travessias pré-ordem, em ordem e pós-ordem na árvore.


