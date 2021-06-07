package br.com.crud.strategy;

import br.com.crud.dao.TurmaDao;
import br.com.crud.model.Aluno;
import br.com.crud.model.EntidadeDominio;
import br.com.crud.model.Turma;

public class ValidadorIdade implements IStrategy {

	@Override
	public String processar(EntidadeDominio ent) {
		Aluno aluno = (Aluno) ent;
		int idadeAluno = aluno.getIdade();
		
		TurmaDao turmaDao = new TurmaDao();
		
		Turma turma = turmaDao.consultarById(aluno.getTurma().getId());
		int idadeTurma = turma.getIdade();
		
		if(idadeAluno < idadeTurma) {
			return "A idade mínima para ingressar nesta turma é " + idadeTurma + " anos";
		}
		
		return null;
	}

}
