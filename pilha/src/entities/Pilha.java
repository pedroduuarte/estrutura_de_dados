package entities;

public class Pilha {
	
	private No topo;
	
	public Pilha() {
		this.topo = null;
	}

	public No getTopo() {
		return topo;
	}

	public void setTopo(No topo) {
		this.topo = topo;
	}
	
	public boolean pilhaVazia() {
		return this.topo == null;
	}
	public void push(int info) {
		No novo = new No(info, this.topo);
		this.topo = novo;
	}
	
	public void imprime() {
		if (pilhaVazia()) {
			System.out.println("Pilha vazia!");
			return;
		}
		for(No aux = this.topo; aux != null; aux = aux.getProx()) {
			System.out.print(aux.getInfo() + " ");
		}
		System.out.println("");
	}
	
	public void pop() {
		if (!pilhaVazia()) {
			this.topo = this.topo.getProx();
		}
	}
}