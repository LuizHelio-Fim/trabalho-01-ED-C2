package structure;

import model.Aluno;
import model.No;

public class ListaDuplamenteEncadeada {
	private No prim;
	private No ult;
	private int quantNos;
	
	public ListaDuplamenteEncadeada(){
		this.prim = null;
		this.ult = null;
		this.quantNos = 0;
	}
	
	public int getQuantNos(){
		return this.quantNos;
	}
	public No getPrim(){
		return this.prim;
	}
	public No getUlt(){
		return this.ult;
	}
	
	public void setQuantNos(int valorNovo){
		this.quantNos = valorNovo;
	}
	public void setPrim(No novoNo){
		this.prim = novoNo;
	}
	public void setUlt(No novoNo){
		this.ult = novoNo;
	}
	
	public boolean eVazia (){
		return (this.prim == null);
	}
	
	public void inserirUltimo (Aluno aluno){
		No novoNo = new No (aluno);
		this.quantNos++;
		if (this.eVazia()) {
			this.prim = novoNo;
		} else {
			novoNo.setAnt(this.ult);
			this.ult.setProx(novoNo);
		}
		this.ult = novoNo;
	}
	
	public void inserirOrdenado (Aluno aluno) {
		No novoNo = new No (aluno);
		this.quantNos++;
		if (this.eVazia()) {
			this.prim = novoNo;
			this.ult = novoNo;
			
		} else if (this.prim.getInfo().getMatricula() > aluno.getMatricula()) {
			novoNo.setProx(this.prim);
			this.prim.setAnt(novoNo);
			this.prim = novoNo;
			
		} else if (this.ult.getInfo().getMatricula() < aluno.getMatricula()) {
			novoNo.setAnt(this.ult);
			this.ult.setProx(novoNo);
			this.ult = novoNo;
			
		} else {
			No atual = this.prim;
			while ((atual != null) && (atual.getInfo().getMatricula() < aluno.getMatricula())) {
				atual = atual.getProx();
			}
			novoNo.setProx(atual);
			novoNo.setAnt(atual.getAnt());		
			atual.getAnt().setProx(novoNo);
			atual.setAnt(novoNo);
		}
	}
	
	public Aluno buscarPorNome(String nome) {
		No atual = this.prim;
		while ((atual != null) && (!atual.getInfo().getNome().equalsIgnoreCase(nome))) {
			atual = atual.getProx();
		}
		return (atual != null) ? atual.getInfo() : null;
	}
	
	public boolean removerAluno (int matricula){
		No atual = this.prim;
		while ((atual != null) && (atual.getInfo().getMatricula() != matricula)){
			atual = atual.getProx();
		}
		if (atual == null) {
			return false;
		}else {
			if (atual == this.prim){
				this.prim = prim.getProx();
				if (this.prim == null) {
					this.ult=null;
				}else {
					this.prim.setAnt(null);
				}
			}else {
				if (atual == this.ult){
					this.ult = this.ult.getAnt();
					this.ult.setProx(null);
				} else {
					atual.getProx().setAnt(atual.getAnt());
					atual.getAnt().setProx(atual.getProx());
				}
			}
			this.quantNos--;
			return true;
		}
	}
	
	public String toString(){
		String msg="";
		No atual = this.prim;
		while (atual != null){
			msg += atual.getInfo() +"\n";
			atual = atual.getProx();
		}
		return msg;
	}
}