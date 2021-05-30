package br.com.crud.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.crud.model.Aluno;
import br.com.crud.model.Endereco;
import br.com.crud.model.EntidadeDominio;
import br.com.crud.model.Resultado;

public class AlunoDao extends AbstractDao {

	public AlunoDao() {
		super("alunos", "aln_id");
	}
	
	@Override
	public Resultado salvar(EntidadeDominio ent) {
		abrirConexao();

		Endereco end = new Endereco();
		EnderecoDao endDao = new EnderecoDao();
		
		Resultado resultado = new Resultado();
		PreparedStatement pst = null;
		Aluno aln = (Aluno) ent;
		end = (Endereco) endDao.salvar(aln.getEndereco()).getResultado();
		String sql;
		sql = "INSERT INTO " + nomeTabela + "(ALN_RA, ALN_NOME, ALN_TUR_ID, ALN_NOMEPAI, ALN_NOMEMAE, ALN_TELEFONE, ALN_END_ID)"
				+ "VALUES (?,?,?,?,?,?,?)";

		try {

			System.out.println("-ENTROU NO DAO DE ALUNO PARA FAZER O CADASTRO");
			pst = conexao.prepareStatement(sql);

			pst.setString(1, aln.getRa());
			pst.setString(2, aln.getNome());
			pst.setInt(3, aln.getTurma().getId());
			pst.setString(4, aln.getNomePai());
			pst.setString(5, aln.getNomeMae());
			pst.setString(6, aln.getTelefone());
			pst.setInt(7, end.getId());

			pst.executeUpdate();

			conexao.commit();
			
			resultado.setResultado(aln);

			System.out.println("-ALUNO SALVO NO BANCO");
		} catch (SQLException e) {
			try {
				conexao.rollback();
				e.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			resultado.setMensagens("Erro ao Cadastrar");
		} finally {
			try {
				pst.close();
				if (ctrlTransacao == true) {
					conexao.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return resultado;
	}

	@Override
	public Resultado consultar(EntidadeDominio ent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado editar(EntidadeDominio ent) {
		// TODO Auto-generated method stub
		return null;
	}

}
