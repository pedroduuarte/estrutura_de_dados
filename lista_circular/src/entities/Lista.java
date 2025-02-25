package entities;

public class Lista {

	No ref;

	public Lista() {
		this.ref = null;
	}

	public No getRef() {
		return ref;
	}

	public void setRef(No ref) {
		this.ref = ref;
	}

	public boolean listaVazia() {
		return ref == null;
	}

	public void insere(int info) {
		No novoNo = new No(info, ref);
		if (listaVazia()) {
			this.ref = novoNo;
			novoNo.setProx(novoNo);
		}
		if (info < this.ref.getProx().getInfo()) {
			novoNo.setProx(this.ref.getProx());
			this.ref.setProx(novoNo);
			return;
		}
		for (No aux = this.ref.getProx(); aux.getProx() != this.ref.getProx(); aux = aux.getProx()) {
			if (info >= aux.getInfo() && info < aux.getProx().getInfo()) {
				novoNo.setProx(aux.getProx());
				aux.setProx(novoNo);
				return;
			}
		}

		novoNo.setProx(this.ref.getProx());
		this.ref.setProx(novoNo);
		this.ref = novoNo;
	}

	public String imprime() {
		if (listaVazia()) {
			return "lista vazia";
		}
		String resultado = "";
		for (No aux = this.ref.getProx(); aux != this.ref; aux = aux.getProx()) {
			resultado += aux.getInfo() + " ";
		}
		resultado += this.ref.getInfo();

		return resultado;
	}

	public void remove(int info, boolean duplicados) {
		if (listaVazia()) {
			return;
		}
		if (!duplicados) {
			if (info == this.ref.getInfo()) {
				if (this.ref.getProx() == this.ref) {
					this.ref = null;
					return;
				}
			}
			if (info == this.ref.getProx().getInfo()) {
				this.ref.setProx(this.ref.getProx().getProx());
			} else {
				for (No aux = this.ref.getProx(); aux != this.ref; aux = aux.getProx()) {
					if (info == aux.getProx().getInfo()) {
						if (aux.getProx() == this.ref) {
							aux.setProx(this.ref.getProx());
							this.ref = aux;
							return;
						}
						aux.setProx(aux.getProx().getProx());
						return;
					}
				}
			}

		} else {
			while (this.ref != null && this.ref.getInfo() == info) {
				if (this.ref.getProx() == this.ref) {
					this.ref = null;
					return;
				} else {
					No aux = this.ref;
					while (aux.getProx() != this.ref) {
						aux = aux.getProx();
					}
					aux.setProx(this.ref.getProx());
					this.ref = aux;
				}
			}
			for (No aux = this.ref; aux.getProx() != this.ref;) {
				if (info == aux.getProx().getInfo()) {
					aux.setProx(aux.getProx().getProx());
				} else {
					aux = aux.getProx();
				}
			}
		}
	}

}
