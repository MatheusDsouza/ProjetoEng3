package br.com.crud.strategy;

import java.util.List;

import br.com.crud.dao.AlunoDao;
import br.com.crud.model.Aluno;
import br.com.crud.model.EntidadeDominio;


public class ValidadorExistencia implements IStrategy {

	@Override
	public String processar(EntidadeDominio ent) {
		AlunoDao dao = new AlunoDao();
		List<EntidadeDominio> alunos = dao.consultar(ent).getResultados();
		
		for (EntidadeDominio aluno : alunos) {
			if(((Aluno) aluno).getRa().equals(((Aluno) ent).getRa())) 
				return "O RA " + ((Aluno) ent).getRa() + " já está cadastrado";	
		}
		return null;
	}

}
