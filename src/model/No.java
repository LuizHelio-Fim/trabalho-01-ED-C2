package model;

public class No {
	private Aluno info;
	private No prox;
	private No ant;
	
	public No (Aluno elem){
		this.info = elem;
		this.prox = null;
		this.ant = null;
	}
	
	public Aluno getInfo (){
		return this.info;
	}
	public No getProx(){
		return this.prox;
	}
	public No getAnt(){
		return this.ant;
	}
	
	public void setInfo(Aluno novo) {
		this.info = novo;
	}
	public void setProx(No novoNo){
		this.prox = novoNo;
	}
	public void setAnt(No novoNo){
		this.ant = novoNo;
	}
}