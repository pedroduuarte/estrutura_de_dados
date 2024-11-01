package application;

import entities.Fila;

public class Program {

	public static void main(String[] args) {
		Fila f = new Fila();
		
		f.imprimir();
		f.insere(0);
		f.insere(1);
		f.insere(2);
		f.imprimir();
		f.remove();
		f.imprimir();
		f.remove();
		f.imprimir();
		f.remove();
		f.imprimir();
		f.insere(10);
		f.insere(11);
		f.insere(12);
		f.imprimir();
		f.remove();
		f.imprimir();
		f.remove();
		f.imprimir();
		f.remove();
		f.imprimir();

	}

}