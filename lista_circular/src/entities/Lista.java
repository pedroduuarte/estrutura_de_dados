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
	        if (info > aux.getInfo() && info < aux.getProx().getInfo()) {
	            novoNo.setProx(aux.getProx());
	            aux.setProx(novoNo);
	            return;
	        }
	    }

		novoNo.setProx(this.ref.getProx());
		this.ref.setProx(novoNo);
		this.ref = novoNo;
	}

    public void imprimir() {
        if(listaVazia()) {
            System.out.println("Lista circular vazia!");
            return;
        }
        for(No aux = this.getRef().getProx(); aux != ref; aux = aux.getProx()) {
            System.out.print(aux.getInfo() + " ");
        }
        System.out.println(this.ref.getInfo());
    }
}

