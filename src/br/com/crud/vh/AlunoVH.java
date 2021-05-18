package br.com.crud.vh;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.crud.model.Aluno;
import br.com.crud.model.EntidadeDominio;
import br.com.crud.model.Resultado;

public class AlunoVH implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {

		HttpSession session = null;
		Aluno aluno = new Aluno();

        String operacao = request.getParameter("OPERACAO");

        if (operacao.equals("CONSULTAR")) {

            session = request.getSession();
            request.setAttribute("cliente", aluno);

        } else if (operacao.equals("SALVAR")) {

            session = request.getSession();
            aluno = buildAlunoSalvar(request);

        } else if (operacao.equals("EDITAR")) {

        	aluno = buildAlunoAlterar(request);

        } else if (operacao.equals("EXCLUIR")) {

            session = request.getSession();
            aluno = new Aluno();

        }
		return aluno; 
		
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}

	private Aluno buildAlunoAlterar(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	private Aluno buildAlunoSalvar(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
