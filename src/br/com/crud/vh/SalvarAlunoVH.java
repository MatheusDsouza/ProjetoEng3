package br.com.crud.vh;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crud.dao.TurmaDao;
import br.com.crud.model.Aluno;
import br.com.crud.model.Cidade;
import br.com.crud.model.Endereco;
import br.com.crud.model.EntidadeDominio;
import br.com.crud.model.Estado;
import br.com.crud.model.Resultado;

public class SalvarAlunoVH implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		Aluno aluno = new Aluno();
		
		aluno = buildAluno(request);
		
		return aluno;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		RequestDispatcher rd = request.getRequestDispatcher("index.html");
		
		rd.forward(request, response);
		
	}
	
	private Aluno buildAluno(HttpServletRequest request) {
		Aluno aluno = new Aluno();
		
		String raAluno = request.getParameter("raAluno");
		String nomeAluno = request.getParameter("nomeAluno");
		String turmaAluno = request.getParameter("turmaAluno");
		String paiAluno = request.getParameter("paiAluno");
		String maeAluno = request.getParameter("maeAluno");
		String telefoneAluno = request.getParameter("telefoneAluno");
		String cepAluno = request.getParameter("cepAluno");
		String logradouroAluno = request.getParameter("logradouroAluno");
		String cidadeAluno = request.getParameter("cidadeAluno");
		String estadoAluno = request.getParameter("estadoAluno");
		
		Endereco endereco = new Endereco();
		Cidade cidade = new Cidade();
		Estado estado = new Estado();
		
		TurmaDao tDao = new TurmaDao();

		aluno.setRa(raAluno);

		aluno.setNome(nomeAluno);
		
		aluno.setTurma(tDao.consultarById(Integer.parseInt(turmaAluno)));

		aluno.setNomePai(paiAluno);
		aluno.setNomeMae(maeAluno);
		aluno.setTelefone(telefoneAluno);
		
		endereco.setCep(cepAluno);
		endereco.setLogradouro(logradouroAluno);

		cidade.setCidade(cidadeAluno);;
		estado.setUf(estadoAluno);
	
		cidade.setEstado(estado);
		endereco.setCidade(cidade);
		aluno.setEndereco(endereco);

		return aluno;
	}

}
