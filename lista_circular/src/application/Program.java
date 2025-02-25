package application;

import entities.Lista;

public class Program {

	public static void main(String[] args) {
		Lista listaCircular = new Lista();
		System.out.println(listaCircular.imprime()); // Lista vazia
		listaCircular.insere(5);
		System.out.println(listaCircular.imprime()); // 5
		listaCircular.insere(1);
		System.out.println(listaCircular.imprime()); // 1 5
		listaCircular.insere(3);
		System.out.println(listaCircular.imprime()); // 1 3 5
		listaCircular.insere(2);
		System.out.println(listaCircular.imprime()); // 1 2 3 5
		listaCircular.insere(6);
		System.out.println(listaCircular.imprime()); // 1 2 3 5 6
		listaCircular.insere(1);
		System.out.println(listaCircular.imprime()); // 1 1 2 3 5 6
		listaCircular.insere(2);
		System.out.println(listaCircular.imprime()); // 1 1 2 2 3 5 6
		listaCircular.insere(6);
		System.out.println(listaCircular.imprime()); // 1 1 2 2 3 5 6 6
		listaCircular.insere(7);
		System.out.println(listaCircular.imprime()); // 1 1 2 2 3 5 6 6 7
		listaCircular.remove(1, false);
		System.out.println(listaCircular.imprime()); // 1 2 2 3 5 6 6 7
		listaCircular.remove(2, false);
		System.out.println(listaCircular.imprime()); // 1 2 3 5 6 6 7
		listaCircular.remove(5, false);
		System.out.println(listaCircular.imprime()); // 1 2 3 6 6 7
		listaCircular.remove(7, false);
		System.out.println(listaCircular.imprime()); // 1 2 3 6 6
		System.out.println("==========================");
		listaCircular.insere(1);
		listaCircular.insere(1);
		System.out.println(listaCircular.imprime()); // 1 1 1 2 3 6 6
		listaCircular.remove(1, true);
		System.out.println(listaCircular.imprime()); // 2 3 6 6
		listaCircular.insere(6);
		listaCircular.insere(6);
		listaCircular.insere(7);
		listaCircular.insere(7);
		listaCircular.insere(4);
		listaCircular.insere(4);
		listaCircular.insere(5);
		System.out.println(listaCircular.imprime()); // 2 3 4 4 5 6 6 6 6 7 7
		listaCircular.remove(4, true);
		System.out.println(listaCircular.imprime()); // 2 3 5 6 6 6 6 7 7
		listaCircular.remove(2, true);
		System.out.println(listaCircular.imprime()); // 3 5 6 6 6 6 7 7
		listaCircular.remove(6, true);
		System.out.println(listaCircular.imprime()); // 3 5 7 7
		listaCircular.insere(7);
		listaCircular.insere(7);
		System.out.println(listaCircular.imprime()); // 3 5 7 7 7 7
		listaCircular.insere(8);
		listaCircular.insere(8);
		System.out.println(listaCircular.imprime()); // 3 5 7 7 7 7 8 8
		listaCircular.remove(7, true);
		System.out.println(listaCircular.imprime()); // 3 5 8 8
		listaCircular.remove(3, false);
		System.out.println(listaCircular.imprime()); // 5 8 8
		listaCircular.remove(8, false);
		System.out.println(listaCircular.imprime()); // 5 8
		listaCircular.insere(7);
		listaCircular.insere(7);
		listaCircular.insere(8);
		System.out.println(listaCircular.imprime()); // 5 7 7 8 8
		listaCircular.remove(8, true);
		System.out.println(listaCircular.imprime()); // 5 7 7
		listaCircular.remove(7, true);
		System.out.println(listaCircular.imprime()); // 5
		listaCircular.remove(5, true);
		System.out.println(listaCircular.imprime()); // lista circular vazia
		listaCircular.insere(1);
		listaCircular.insere(1);
		listaCircular.insere(9);
		listaCircular.insere(3);
		listaCircular.insere(5);
		listaCircular.insere(5);
		listaCircular.insere(9);
		System.out.println(listaCircular.imprime()); // 1 1 3 5 5 9 9
		listaCircular.remove(5, true);
		System.out.println(listaCircular.imprime()); // 1 1 3 9 9
		listaCircular.remove(9, true);
		System.out.println(listaCircular.imprime()); // 1 1 3
		listaCircular.remove(1, false);
		System.out.println(listaCircular.imprime()); // 1 3
		listaCircular.remove(5, false);
		System.out.println(listaCircular.imprime()); // 1 3
		listaCircular.insere(1);
		listaCircular.insere(3);
		listaCircular.insere(3);
		System.out.println(listaCircular.imprime()); // 1 1 3 3 3
		listaCircular.remove(1, true);
		System.out.println(listaCircular.imprime()); // 3 3 3
		listaCircular.remove(3, false);
		System.out.println(listaCircular.imprime()); // 3 3
		listaCircular.insere(3);
		listaCircular.remove(3, true);
		System.out.println(listaCircular.imprime()); // lista circular vazia
	}

}