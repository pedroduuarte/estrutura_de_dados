package entities;

public class Lista {

	private No ref;

	public Lista() {
		this.ref = null;
	}

	public void insere(int info) {
		No novo = new No(info, ref);
		this.ref = novo;
	}

	public boolean listaVazia() {
		if (ref == null) {
			return true;
		}
		return false;
	}

	public void imprimir() {
		if (listaVazia()) {
			System.out.println("Lista vazia");
			return;
		}
		for (No aux = ref; aux != null; aux = aux.getProx()) {
			System.out.print(aux.getInfo() + " ");
		}
		System.out.println();
	}
	


	public void remove(int info) {
		if (listaVazia()) {
			return;
		}

		if (ref.getInfo() == info) {
			ref = ref.getProx();
			return;
		}

		for (No aux = ref; aux.getProx() != null; aux = aux.getProx()) {
			if (aux.getProx().getInfo() == info) {
				aux.setProx(aux.getProx().getProx());
				if (aux.getProx() == null) {
					return;
				}
			}
		}
	}

}
