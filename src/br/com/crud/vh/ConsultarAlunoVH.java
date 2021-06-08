package br.com.crud.vh;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crud.model.Aluno;
import br.com.crud.model.EntidadeDominio;
import br.com.crud.model.Resultado;

public class ConsultarAlunoVH implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		Aluno aluno = new Aluno();
		
		return aluno;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		
		
		request.setAttribute("alunos", resultado.getResultados());
		System.out.println(resultado.getResultados().size());
		
		RequestDispatcher rd = request.getRequestDispatcher("/consultaAluno.jsp");
		
		rd.forward(request, response);
	}

}
