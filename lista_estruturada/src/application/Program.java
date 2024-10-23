package application;

import entities.Lista;

public class Program {

	public static void main(String[] args) {
		Lista lista = new Lista();
		lista.imprimir(); //Lista vazia
		lista.insere(1); 
		lista.imprimir(); //1
		lista.insere(2);
		lista.imprimir(); //2 1 
		lista.insere(3);
		lista.imprimir(); //3 2 1 
		lista.insere(4);
		lista.imprimir();  //4 3 2 1
		lista.remove(3);
		lista.imprimir();// 4 2 1 
		lista.remove(2);
		lista.imprimir();// 4 1 
		lista.remove(1);
		lista.imprimir();// 4
		lista.remove(4);
		lista.imprimir();//Lista vazia
	}

}
