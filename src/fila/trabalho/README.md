# Projeto de Fila

Fila com Reversão em O(1)

Implemente uma fila que suporta reversão instantânea em tempo O(1), sem percorrer ou modificar os elementos.

Uma fila tradicional permite enqueue (inserir no fim) e dequeue (remover do início) em O(1). Sua tarefa: adicionar a operação reverse() que inverte a fila em O(1). Após reverse():

- O próximo dequeue() deve retornar o elemento que estava no fim
- O próximo enqueue() deve inserir no novo fim (que antes era o início)
- Obs 1: Sua implementação deve usar array circular e dar suporte ao processo de duplicação quando cheio e redução do tamanho da array quando chegar em 1/3. 
- Obs 2: Após ocorrer a reversão todos os métodos devem continuar a funcionar normalmente.