package application;

import entities.Lista;

public class Program {

	public static void main(String[] args) {
		Lista listaCircular = new Lista();
		listaCircular.imprimir(); // Lista vazia
		listaCircular.insere(5);
		listaCircular.imprimir();
		listaCircular.insere(1);
		listaCircular.imprimir();
		listaCircular.insere(3);
		listaCircular.imprimir();
		listaCircular.insere(2);
		listaCircular.imprimir();
		listaCircular.insere(6);
		listaCircular.imprimir();
		

	}

}
