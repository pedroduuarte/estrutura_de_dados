package entities;

public class AVL {

	private No raiz;

	public AVL() {
		this.raiz = null;
	}

	public AVL(int info) {
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
	
	public String preOrdem() {
	    StringBuilder sb = new StringBuilder();
	    preOrdem(this.raiz, sb);
	    return sb.toString();
	}

	private void preOrdem(No raiz, StringBuilder sb) {
	    if (raiz == null) {
	        return;
	    }
	    sb.append(raiz.getInfo()).append("(").append(raiz.getBalanceamento()).append(")");
	    preOrdem(raiz.getEsquerda(), sb);
	    preOrdem(raiz.getDireita(), sb);
	}

	private int calcAltura(No no) {
		if (no == null) {
			return 0;
		}
		return no.getAltura();
	}

	private void atualizarAltura(No no) {
		if (no == null) {
			return;

		} 
		int alturaEsq = calcAltura(no.getEsquerda());
		int alturaDir = calcAltura(no.getDireita());
		// altura passa a ser 1 + o filho com altura de valor maior
		no.setAltura(1 + Math.max(alturaEsq, alturaDir));
		no.setBalanceamento(getFatorBalanceamento(no));
	
	}

	private int getFatorBalanceamento(No no) {
		if (no == null) {
			return 0;
		}
		// Fator de balanceamento respeitando a regra altura da esquerda - alttura da direita
		return calcAltura(no.getEsquerda()) - calcAltura(no.getDireita());
	}
	
	
	public void insere(int info) {
		if (arvoreVazia()) {
			this.raiz = new No(info);
		}
	    this.raiz = insere(info, this.raiz);
	}

	private No insere(int info, No atual) {
	    if (atual == null) {
	        return new No(info);
	    }
	    // inserção a esquerda
	    if (info < atual.getInfo()) {
	        atual.setEsquerda(insere(info, atual.getEsquerda()));
	    } else if (info > atual.getInfo()) {
	    	// inserção a direita
	    	atual.setDireita(insere(info, atual.getDireita()));
	    } else {
	    	// retorna o nó inserido
	        return atual;
	    }
	    // atualiza altura após a inserção
	    atualizarAltura(atual);
	    // balanceia a árvore após inserção
	    return balancear(atual);
	}
	
	public No buscar(int info) {
		if (arvoreVazia()) {
			return null;
		}
		return this.buscar(info, raiz);
	}

	private No buscar(int info, No atual) {
		// nó encontrado imediatamente 
		if (info == atual.getInfo()) {
			return atual;
		}
		// busca à esquerda
		if (info < atual.getInfo()) {
			if (atual.getEsquerda() != null) {
				return this.buscar(info, atual.getEsquerda());
			}
		} else if (info >= atual.getInfo()) {
			//busca à direita
			if (atual.getDireita() != null) {
				return this.buscar(info, atual.getDireita());
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
		if (no.getDireita() != null) {
			// procurando o sucessor no filho a direita
			return encontrarMenor(no.getDireita());
		}
		
		No sucessor = null;
		No atual = raiz;
		
		while (atual != null) {
			if (no.getInfo() < atual.getInfo()) {
				sucessor = atual;
				atual = atual.getEsquerda();
			} else if (no.getInfo() > atual.getInfo()) {
				atual = atual.getDireita();
			} else {
				break;
			}
		}
		
		return sucessor;
	}


	private No encontrarMenor(No no) {
		// vai para esquerda até ser nulo
	    while (no.getEsquerda() != null) {
	        no = no.getEsquerda();
	    }
	    return no;
	}
    
    
	public No maximo() {
		return maximo(this.raiz);
	}

	
	private No maximo(No raiz) {
		if (raiz.getDireita() != null) {
			return maximo(raiz.getDireita());
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
			atual.setEsquerda(remove(info, atual.getEsquerda()));
		}
		else if (info > atual.getInfo()) {
			atual.setDireita(remove(info, atual.getDireita()));
		} else {
			if (atual.getEsquerda() == null && atual.getDireita() == null) {
				return null;
			}
			else if (atual.getDireita() == null) {
				return atual.getEsquerda();
			}
			else if (atual.getEsquerda() == null) {
				return atual.getDireita();
			} else {
				No sucessor = encontrarMenor(atual.getDireita());
				atual.setInfo(sucessor.getInfo());
				atual.setDireita(remove(sucessor.getInfo(), atual.getDireita()));
			}
		}
		atualizarAltura(atual);
		return balancear(atual);
		
	}
	
	private No rotacionarDireita(No noCritico) {
		No novaRaiz = noCritico.getEsquerda();
		// filho a esquerda do nó critíco vira a raíz
		noCritico.setEsquerda(novaRaiz.getDireita());
		// filho a direita da nova raíz é seu antigo pai
		novaRaiz.setDireita(noCritico);
		
		atualizarAltura(noCritico);
		atualizarAltura(novaRaiz);
		
		return novaRaiz;
		
	}
	
	private No rotacionarEsquerda(No noCritico) {
		No novaRaiz = noCritico.getDireita();
		// filho a direita do nó crítico vira raíz 
		noCritico.setDireita(novaRaiz.getEsquerda());
		// filho a esquerda da nova raíz é seu antigo pai 
		novaRaiz.setEsquerda(noCritico);
		
		atualizarAltura(noCritico);
		atualizarAltura(novaRaiz);
		
		return novaRaiz;
	}
	
	private No balancear(No noCritico) {
		if (noCritico == null) {
			return null;
		}
		
		int fb = getFatorBalanceamento(noCritico);
		
		if (fb > 1) {

			if (getFatorBalanceamento(noCritico.getEsquerda()) >= 0) {
				// se o fator de balanceamento do filho a esqueda for maior ou igual a zero então rotação simples a dieita.
				return rotacionarDireita(noCritico);
			}
			else {
				// se não, rotação dupla, no filho a esquerda do nó crítico e no nó critíco.
				noCritico.setEsquerda(rotacionarDireita(noCritico.getEsquerda()));
				return rotacionarDireita(noCritico);
			}
		}
		
		else if (fb < -1) {
			if (getFatorBalanceamento(noCritico.getDireita()) <= 0) {
				// se o fator de balanceamento do filho a direita for menor ou igual a zero então rotação simples a esquerda.
				return rotacionarEsquerda(noCritico);
			}
			else {
				// se não, rotação dupla, no filho a direita do nó crítico e no nó crítico.
				noCritico.setDireita(rotacionarEsquerda(noCritico.getDireita()));
				return rotacionarEsquerda(noCritico);
			}
		}
		return noCritico;
	}
	
}