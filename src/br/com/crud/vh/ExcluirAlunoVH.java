package br.com.crud.vh;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crud.model.Aluno;
import br.com.crud.model.EntidadeDominio;
import br.com.crud.model.Resultado;

public class ExcluirAlunoVH implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		Aluno aluno = new Aluno();
		aluno.setId(Integer.parseInt(request.getParameter("idAluno")));
		return aluno;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		RequestDispatcher rd = request.getRequestDispatcher("index.html");
		rd.forward(request, response);

	}

}
