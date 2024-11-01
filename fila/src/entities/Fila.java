package entities;

public class Fila {
	
	private No inicio;
	private No fim;
	
	public Fila() {
		this.inicio = null;
		this.fim = null;
	}
	
	public boolean filaVazia() {
		return this.inicio == null && this.fim == null;
	}
	
	public void insere(int info) {
		No novo = new No(info);
		if (filaVazia()) {
			this.inicio = novo;
			this.fim = novo;
			return;
		}
		this.fim.setProx(novo);
		this.fim = novo;
	}
	
	public void imprimir() {
		if (filaVazia()) {
			System.out.print("fila vazia!");
			}
		for (No aux = this.inicio; aux != null; aux = aux.getProx()) {
			System.out.print(aux.getInfo() + " ");
		}
		System.out.println();

	}
	
	public void remove() {
		this.inicio = this.inicio.getProx();
		if (this.inicio == null) {
			this.fim = null;
		}
	}

}