package application;

import entities.Arvore;
import entities.No;

public class Program {

	public static void main(String[] args) {
		Arvore ar = new Arvore();

		ar.insere(9);
		ar.insere(6);
		ar.insere(11);
		ar.insere(7);
		ar.insere(12);
		ar.insere(10);
		ar.insere(5);
		ar.emOrdem();
		System.out.println();
		No buscado = ar.buscar(8);
		if (buscado != null) {
			System.out.println("buscado: " + buscado.getInfo());
		} else {
			System.out.println("nó não encontrado");
		}
		System.out.println("raiz: " + ar.getRaiz().getInfo());
		System.out.println("maximo: " + ar.maximo().getInfo());
		System.out.println(ar.encontrarSucessor(7).getInfo());
	}

}
