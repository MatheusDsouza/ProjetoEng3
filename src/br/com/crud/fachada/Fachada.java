package br.com.crud.fachada;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.crud.dao.AlunoDao;
import br.com.crud.dao.EnderecoDao;
import br.com.crud.dao.IDAO;
import br.com.crud.model.Aluno;
import br.com.crud.model.Endereco;
import br.com.crud.model.EntidadeDominio;
import br.com.crud.model.Resultado;
import br.com.crud.strategy.IStrategy;
import br.com.crud.strategy.ValidacaoAluno;

public class Fachada implements IFachada {

	private Map<String, IDAO> daos;
	private Map<String, List<IStrategy>> regrasNegocio;
	private StringBuilder msgErro = new StringBuilder();
	Resultado resultado = null;
	IDAO dao = null;
	String nomeClasse = null;
	List<IStrategy> rng = null;

	public Fachada() {
		
		daos = new HashMap<String, IDAO>();
		regrasNegocio = new HashMap<String, List<IStrategy>>();

		daos.put(Aluno.class.getName(), new AlunoDao());
		daos.put(Endereco.class.getName(), new EnderecoDao());

		// CRIA LISTAS PARA REGRAS DE CADA DOMINIO
		List<IStrategy> rngAluno = new ArrayList<IStrategy>();

		IStrategy validar = new ValidacaoAluno();

		

		rngAluno.add(validar);

		// ADICIONA AS REGRAS DE NEG�CIO NO MAP CORRESPONDENTE
		regrasNegocio.put(Aluno.class.getName(), rngAluno);
	}

	@Override
	public Resultado salvar(EntidadeDominio ent) {
		
		System.out.println("-FACHADA SALVAR");
		resultado = new Resultado();
		nomeClasse = ent.getClass().getName();
		System.out.println("-Nome da Classe da entidade: " + nomeClasse);
		rng = regrasNegocio.get(nomeClasse);
		msgErro.setLength(0);

		executarRegras(rng, ent);

		if (msgErro.length() == 0 || msgErro.toString().trim().equals("")) {
			try {
				dao = daos.get(nomeClasse);
				System.out.println("-CHAMANDO METODO DAO DE SALVAR");
				resultado = dao.salvar(ent);
				resultado.add(ent);
				System.out.println("- PRONTO, DEU DE SALVAR O OBJETO");
			} catch (Exception e) {
				e.printStackTrace();
				resultado.setMensagens("-VOLTOU PRA FACHADA DANDO ERRO");
			}
		} else {

			resultado.add(ent);
			resultado.setMensagens(msgErro.toString());
		}

		return resultado;
	}

	@Override
	public Resultado consultar(EntidadeDominio ent) {

		System.out.println("-FACHADA CONSULTAR");
		resultado = new Resultado();
		nomeClasse = ent.getClass().getName();
		System.out.println("-Nome da Classe da entidade: " + nomeClasse);
		rng = regrasNegocio.get(nomeClasse);
		msgErro.setLength(0);

		executarRegras(rng, ent);

		if (msgErro.length() == 0 || msgErro.toString().trim().equals("")) {
			try {
				dao = daos.get(nomeClasse);
				System.out.println("-CHAMANDO METODO DAO DE CONSULTAR");
				resultado = dao.consultar(ent);
				resultado.add(ent);
				System.out.println("- PRONTO, DEU DE CONSULTAR O OBJETO");
			} catch (Exception e) {
				e.printStackTrace();			
				resultado.setMensagens("-VOLTOU PRA FACHADA DANDO ERRO");

			}
		} else {

			resultado.add(ent);
			resultado.setMensagens(msgErro.toString());
		}

		return resultado;
	}

	@Override
	public Resultado editar(EntidadeDominio ent) {
		
		System.out.println("-FACHADA EDITAR");
		resultado = new Resultado();
		nomeClasse = ent.getClass().getName();
		System.out.println("-Nome da Classe da entidade: " + nomeClasse);
		rng = regrasNegocio.get(nomeClasse);
		msgErro.setLength(0);

		executarRegras(rng, ent);

		if (msgErro.length() == 0 || msgErro.toString().trim().equals("")) {
			try {
				dao = daos.get(nomeClasse);
				System.out.println("-CHAMANDO METODO DAO DE EDITAR");
				resultado = dao.editar(ent);
				resultado.add(ent);
				System.out.println("- PRONTO, DEU DE EDITAR O OBJETO");
			} catch (Exception e) {
				e.printStackTrace();
				resultado.setMensagens("-VOLTOU PRA FACHADA DANDO ERRO");

			}
		} else {

			resultado.add(ent);
			resultado.setMensagens(msgErro.toString());
		}

		return resultado;
	}

	@Override
	public Resultado excluir(EntidadeDominio ent) {
		
		System.out.println("-FACHADA EXCLUIR");
		resultado = new Resultado();
		nomeClasse = ent.getClass().getName();
		System.out.println("-Nome da Classe da entidade: " + nomeClasse);
		rng = regrasNegocio.get(nomeClasse);
		msgErro.setLength(0);

		executarRegras(rng, ent);

		if (msgErro.length() == 0 || msgErro.toString().trim().equals("")) {
			try {
				dao = daos.get(nomeClasse);
				System.out.println("-CHAMANDO METODO DAO DE EXCLUIR");
				resultado = dao.excluir(ent);
				resultado.add(ent);
				System.out.println("- PRONTO, DEU DE EXCLUIR O OBJETO");
			} catch (Exception e) {
				e.printStackTrace();
				resultado.setMensagens("-VOLTOU PRA FACHADA DANDO ERRO");

			}
		} else {

			resultado.add(ent);
			resultado.setMensagens(msgErro.toString());
		}

		return resultado;
	}

	private void executarRegras(List<IStrategy> rngEntidade, EntidadeDominio entidade) {
		String msg = "";
		for (IStrategy strategy : rngEntidade) {
			msg = strategy.processar(entidade);
			if (msg != null) {
				msgErro.append(msg + "\n");
				System.out.println(msg);
			}
		}
	}

}
