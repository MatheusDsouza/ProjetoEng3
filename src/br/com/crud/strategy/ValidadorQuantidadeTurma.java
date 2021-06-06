package br.com.crud.strategy;

import java.util.List;

import br.com.crud.dao.AlunoDao;
import br.com.crud.model.EntidadeDominio;

public class ValidadorQuantidadeTurma implements IStrategy {
	
	private final int MAX_ALUNOS = 5;

	@Override
	public String processar(EntidadeDominio ent) {
		AlunoDao dao = new AlunoDao();
		List<EntidadeDominio> alunos = dao.consultarTurmas(ent).getResultados();
		if(alunos.size() >= MAX_ALUNOS) {
			System.out.println("TAMANHO TURMA: " + alunos.size());
			return "O limite de " + MAX_ALUNOS + " de alunos por turma foi excedido";
		}
		return null;
	}

}
