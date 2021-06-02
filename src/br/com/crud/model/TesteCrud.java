package br.com.crud.model;

import br.com.crud.dao.AlunoDao;

public class TesteCrud {

	public static void main(String[] args) {

		AlunoDao dao = new AlunoDao();
		Resultado resultado = dao.excluir(null);

		Aluno aluno = (Aluno) resultado.getResultados().get(1);
		
	}

}
