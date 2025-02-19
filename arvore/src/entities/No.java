package entities;

public class No {
	
	private int info;
	private No esq;
	private No dir;
	
	public No(int info) {
		this.info = info;
		this.esq = null;
		this.dir = null;
		
	}
	

	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public No getEsq() {
		return esq;
	}

	public void setEsq(No esq) {
		this.esq = esq;
	}

	public No getDir() {
		return dir;
	}

	public void setDir(No dir) {
		this.dir = dir;
	}

}
