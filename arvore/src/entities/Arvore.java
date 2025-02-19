package entities;

public class Arvore {

	private No raiz;
	
	public Arvore() {
		this.raiz = null;
	}
	
	public Arvore(int info) {
		this.raiz = new No(info);
	}
	
	public No getRaiz() {
		return raiz;
	}

	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}
	
	public boolean arvoreVazia() {
		return this.raiz == null;
	}
	
	public void emOrdem(){
        emOrdem(this.raiz);
    }

    private void emOrdem(No raiz){
        if(raiz == null){
            return;
        }
        emOrdem(raiz.getEsq());
        System.out.println(raiz.getInfo() + " ");
        emOrdem(raiz.getDir());
        return;
    }
    
    public void preOrdem() {
    	preOrdem(this.raiz);
    }
    
    private void preOrdem(No raiz) {
    	if (raiz == null) {
    		return;
    	}
    	System.out.println(raiz.getInfo() + " ");
    	preOrdem(raiz.getEsq());
    	preOrdem(raiz.getDir());
    }
	
	public void insere(int info) {
	    this.raiz = insere(info, this.raiz);
	}

	private No insere(int info, No atual) {
	    if (atual == null) {
	        return new No(info);
	    }

	    if (info < atual.getInfo()) {
	        atual.setEsq(insere(info, atual.getEsq()));
	    } else if (info > atual.getInfo()) {
	        atual.setDir(insere(info, atual.getDir()));
	    } 
	    return atual;  
	}
	
	public No buscar(int info) {
		if (arvoreVazia()) {
			return null;
		}
		return this.buscar(info, raiz);
	}

	private No buscar(int info, No atual) {
		if (info == atual.getInfo()) {
			return atual;
		}
		if (info < atual.getInfo()) {
			if (atual.getEsq() != null) {
				return this.buscar(info, atual.getEsq());
			}
		} else if (info >= atual.getInfo()) {
			if (atual.getDir() != null) {
				return this.buscar(info, atual.getDir());
			}
		}
		return null;
	}
	
	public No encontrarSucessor(int info) {
		No no = buscar(info);
		return encontrarSucessor(raiz, no);
	}
	
	private No encontrarSucessor(No raiz, No no) {
		if (no == null) {
			return null;
		}
		if (no.getDir() != null) {
			return encontrarMenor(no.getDir());
		}
		
		No sucessor = null;
		No atual = raiz;
		
		while (atual != null) {
			if (no.getInfo() < atual.getInfo()) {
				sucessor = atual;
				atual = atual.getEsq();
			} else if (no.getInfo() > atual.getInfo()) {
				atual = atual.getDir();
			} else {
				break;
			}
		}
		
		return sucessor;
	}


	private No encontrarMenor(No no) {
	    while (no.getEsq() != null) {
	        no = no.getEsq();
	    }
	    return no;
	}
    
    
	public No maximo() {
		return maximo(this.raiz);
	}

	
	private No maximo(No raiz) {
		if (raiz.getDir() != null) {
			return maximo(raiz.getDir());
		}
		return raiz;

	}
	
	public void remove(int info) {
		this.raiz = remove(info, this.raiz);
	}
	
	
	private No remove(int info, No atual) {
		if (atual == null) {
			return null;
		}
		if (info < atual.getInfo()) {
			atual.setEsq(remove(info, atual.getEsq()));
		}
		else if (info > atual.getInfo()) {
			atual.setDir(remove(info, atual.getDir()));
		} else {
			if (atual.getEsq() == null && atual.getDir() == null) {
				return null;
			}
			else if (atual.getDir() == null) {
				return atual.getEsq();
			}
			else if (atual.getEsq() == null) {
				return atual.getDir();
			} else {
				No sucessor = encontrarMenor(atual.getDir());
				atual.setInfo(sucessor.getInfo());
				atual.setDir(remove(sucessor.getInfo(), atual.getDir()));
			}
		}
		return atual;
		
	}
}
