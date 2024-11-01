package application;

import entities.Pilha;

public class Program {

	public static void main(String[] args) {
		Pilha pilha = new Pilha();
		pilha.imprime(); // Pilha vazia!
		pilha.push(0);
		pilha.push(1);
		pilha.push(2);
		pilha.push(3);
		pilha.push(4);
		pilha.imprime(); // 4 3 2 1 0
		pilha.pop();
		pilha.pop();
		pilha.pop();
		pilha.pop();
		pilha.imprime(); // 0
		pilha.pop();
		pilha.imprime(); // Pilha vazia!
		pilha.push(0);
		pilha.push(1);
		pilha.push(2);
		pilha.push(3);
		pilha.push(4);
		pilha.imprime(); // 4 3 2 1 0
		
	}

}