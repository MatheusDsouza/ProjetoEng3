package br.com.crud.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crud.dao.AlunoDao;
import br.com.crud.model.Aluno;
import br.com.crud.model.EntidadeDominio;
import br.com.crud.model.Resultado;

public class ServletEditarAluno extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Aluno aluno = new Aluno();
		AlunoDao dao = new AlunoDao();
		
		int idAluno = Integer.parseInt(request.getParameter("idAluno"));
		aluno = dao.consultarById(idAluno);

		request.setAttribute("aluno", aluno);
		
		RequestDispatcher rd = request.getRequestDispatcher("editarAluno.jsp");
		
		rd.forward(request, response);

	}

}
