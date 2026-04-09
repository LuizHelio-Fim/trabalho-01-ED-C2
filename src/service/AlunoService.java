package service;

import model.Aluno;
import model.No;
import structure.ListaDuplamenteEncadeada;

public class AlunoService {
	ListaDuplamenteEncadeada alunos = new ListaDuplamenteEncadeada();
	ListaDuplamenteEncadeada transferidos = new ListaDuplamenteEncadeada();
	
	public void inserirAluno (Aluno aluno) {
		alunos.inserirUltimo(aluno);
	}
	
	public boolean removerAluno (int matricula) {
		return alunos.removerAluno(matricula);
	}
	
	public boolean transferirAluno (int matricula) {
		No atual = alunos.getPrim();
		while ((atual != null) && atual.getInfo().getMatricula() != matricula) {
			atual = atual.getProx();
		}
		
		if (atual == null) return false;
		
		transferidos.inserirOrdenado(atual.getInfo());
		return alunos.removerAluno(matricula);
		
	}
	
	public Aluno buscarPorNome (String nome) {
		return alunos.buscarPorNome(nome);
	}
}
