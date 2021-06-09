package br.com.crud.vh;

import java.io.IOException;
import java.util.List;

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
import br.com.crud.model.Turma;

public class EditarAlunoVH implements IViewHelper {
	
	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		Aluno aluno = new Aluno();
		
		aluno = buildAluno(request);
		
		return aluno;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		RequestDispatcher rd;
		
		if(resultado.getMensagens() == null || resultado.getMensagens().isBlank() || resultado.getMensagens().isEmpty()) {
			resultado.setMensagens("Editado com sucesso!");
			rd = request.getRequestDispatcher("ConsultarAluno?OPERACAO=CONSULTAR");
		} else {
			resultado.setMensagens(resultado.getMensagens().replaceAll("\n", " | "));
			request.setAttribute("aluno", resultado.getResultado());
			
			TurmaDao turmaDao = new TurmaDao();
			List<Turma> turmas = turmaDao.consultar();
			request.setAttribute("turmas", turmas);
			
			rd = request.getRequestDispatcher("editarAluno.jsp");
			
		}
			request.setAttribute("mensagem", resultado.getMensagens());
			rd.forward(request, response);

	}
	
	private Aluno buildAluno(HttpServletRequest request) {
		Aluno aluno = new Aluno();
		
		String idAluno = request.getParameter("idAluno");
		String idEndereco = request.getParameter("idEndereco");
		
		String raAluno = request.getParameter("raAluno");
		String nomeAluno = request.getParameter("nomeAluno");
		String turmaAluno = request.getParameter("turmaAluno");
		String paiAluno = request.getParameter("paiAluno");
		String maeAluno = request.getParameter("maeAluno");
		String telefoneAluno = request.getParameter("telefoneAluno");
		
		int idadeAluno = Integer.parseInt(request.getParameter("idadeAluno"));
		
		String cepAluno = request.getParameter("cepAluno");
		String logradouroAluno = request.getParameter("logradouroAluno");
		String cidadeAluno = request.getParameter("cidadeAluno");
		String estadoAluno = request.getParameter("estadoAluno");

		
		Endereco endereco = new Endereco();
		Cidade cidade = new Cidade();
		Estado estado = new Estado();
		
		TurmaDao tDao = new TurmaDao();
		
		aluno.setId(Integer.parseInt(idAluno));
		aluno.setRa(raAluno);

		aluno.setNome(nomeAluno);
		
		aluno.setTurma(tDao.consultarById(Integer.parseInt(turmaAluno)));

		aluno.setNomePai(paiAluno);
		aluno.setNomeMae(maeAluno);
		aluno.setTelefone(telefoneAluno);
		
		aluno.setIdade(idadeAluno);
		
		endereco.setId(Integer.parseInt(idEndereco));
		
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
