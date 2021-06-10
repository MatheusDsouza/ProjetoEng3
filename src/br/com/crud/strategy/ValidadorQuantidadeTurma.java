package br.com.crud.strategy;

import java.util.List;

import br.com.crud.dao.AlunoDao;
import br.com.crud.dao.TurmaDao;
import br.com.crud.model.Aluno;
import br.com.crud.model.EntidadeDominio;

public class ValidadorQuantidadeTurma implements IStrategy {
	
	private final int MAX_ALUNOS = 5;

	@Override
    public String processar(EntidadeDominio ent) {
        AlunoDao Dao = new AlunoDao();
        List<EntidadeDominio> alunos = Dao.consultarTurmas(ent).getResultados();
             
    
        if(alunos.size() >= MAX_ALUNOS) {
        	for (EntidadeDominio aluno : alunos) {
            	if(aluno.getId() == ent.getId())
            		return null;       	
    		} 
        		return "O limite de " + MAX_ALUNOS + " de alunos por turma foi excedido";     	
        }
        
        return null;
    }

}
