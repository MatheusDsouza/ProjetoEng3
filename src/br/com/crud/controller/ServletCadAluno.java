package br.com.crud.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crud.dao.AlunoDao;
import br.com.crud.dao.TurmaDao;
import br.com.crud.model.Aluno;
import br.com.crud.model.Turma;

public class ServletCadAluno extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		TurmaDao turmaDao = new TurmaDao();
		List<Turma> turmas = turmaDao.consultar();
			
		request.setAttribute("turmas", turmas);
		
		RequestDispatcher rd = request.getRequestDispatcher("cadAluno.jsp");
		
		rd.forward(request, response);
	}
}
