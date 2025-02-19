package application;

import entities.AVL;

public class Program {

	public static void main(String[] args) {
		AVL avl = new AVL();
		avl.insere(5);
		avl.insere(3);
		avl.insere(1);
		avl.insere(4);
		avl.insere(7);
		avl.insere(9);
		System.out.println(avl.preOrdem());
		avl.remove(5);
		System.out.println(avl.preOrdem());
		avl.remove(9);
		System.out.println(avl.preOrdem());
		avl.remove(3);
		avl.remove(1);
		avl.remove(4);
		avl.remove(0);
		System.out.println(avl.preOrdem());
		avl.remove(7);
		System.out.println(avl.preOrdem());
		avl.insere(10);
		avl.insere(8);
		avl.insere(15);
		avl.insere(12);
		avl.insere(5);
		avl.insere(3);
		avl.insere(20);
		avl.insere(21);
		avl.insere(22);
		System.out.println(avl.preOrdem());
	}
}
