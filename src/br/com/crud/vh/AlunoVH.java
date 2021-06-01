package br.com.crud.vh;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.crud.dao.AlunoDao;
import br.com.crud.dao.TurmaDao;
import br.com.crud.model.Aluno;
import br.com.crud.model.Cidade;
import br.com.crud.model.Endereco;
import br.com.crud.model.EntidadeDominio;
import br.com.crud.model.Estado;
import br.com.crud.model.Resultado;

public class AlunoVH implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {

		Aluno aluno = new Aluno();

		String operacao = request.getParameter("OPERACAO");

		if (operacao.equals("CONSULTAR")) {
			
			request.setAttribute("aluno", aluno);

		} else if (operacao.equals("SALVAR")) {

			
			aluno = buildAlunoSalvar(request);

		} else if (operacao.equals("EDITAR")) {

			aluno = buildAlunoAlterar(request);

		} else if (operacao.equals("EXCLUIR")) {

			aluno = new Aluno();

		}
		return aluno;

	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		Aluno aluno = (Aluno) resultado.getResultado();
		RequestDispatcher rd = null;
		String operacao = request.getParameter("OPERACAO");
		
		if (operacao.equals("SALVAR")) {

//			AlunoDao dao = new AlunoDao();
//			List<Aluno> lista = new ArrayList<Aluno>();
//
//			for(EntidadeDominio ent : resultado.getResultados()) {
//				Aluno aln = (Aluno) ent;
//				lista.add(aln);
//			}
			
			//request.getSession().setAttribute("listaAlunos", lista);
			
			
			rd = request.getRequestDispatcher("index.html");
			
			rd.forward(request, response);
		}

	}

	private Aluno buildAlunoAlterar(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	private Aluno buildAlunoSalvar(HttpServletRequest request) {
		Aluno aln = new Aluno();
		
		String raAluno = request.getParameter("raAluno");
		String nomeAluno = request.getParameter("nomeAluno");
		
		String turmaAluno = request.getParameter("turmaAluno");
		System.out.println("- "+ turmaAluno);
		
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

		if (raAluno != null) {
			aln.setRa(raAluno);
		} else {
			aln.setRa("");
		}
		
		if (nomeAluno != null) {
			aln.setNome(nomeAluno);
		} else {
			aln.setNome("");
		}

		if (turmaAluno != null) {
			TurmaDao tDao = new TurmaDao();
			int id = Integer.parseInt(turmaAluno);
			aln.setTurma(tDao.consultarById(id));
		} else {
			aln.setTurma(null);
		}

		if (paiAluno != null) {
			aln.setNomePai(paiAluno);
		} else {
			aln.setNomePai("");
		}

		if (maeAluno != null) {
			aln.setNomeMae(maeAluno);
		} else {
			aln.setNomeMae("");
		}

		if (telefoneAluno != null) {
			aln.setTelefone(telefoneAluno);
		} else {
			aln.setTelefone("");
		}

		if (cepAluno != null) {
			endereco.setCep(cepAluno);
		} else {
			endereco.setCep("");
		}

		if (logradouroAluno != null) {
			endereco.setLogradouro(logradouroAluno);
		} else {
			endereco.setLogradouro("");
		}

		if (cidadeAluno != null) {
			cidade.setCidade(cidadeAluno);;
		} else {
			cidade.setCidade("");
		}

		if (estadoAluno != null) {
			estado.setUf(estadoAluno);
		} else {
			estado.setUf("");
		}

		cidade.setEstado(estado);
		endereco.setCidade(cidade);
		aln.setEndereco(endereco);
		
		System.out.println("- Entidade aln montada com sucesso no VH");
		return aln;
	}

}
