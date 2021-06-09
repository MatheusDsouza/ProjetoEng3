package br.com.crud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.crud.model.Aluno;
import br.com.crud.model.Endereco;
import br.com.crud.model.EntidadeDominio;
import br.com.crud.model.Resultado;
import br.com.crud.model.Turma;

public class AlunoDao extends AbstractDao {

	public AlunoDao() {
		super("alunos", "aln_id");
	}

	@Override
	public Resultado salvar(EntidadeDominio ent) {
		abrirConexao();

		Endereco end;
		EnderecoDao endDao = new EnderecoDao();

		Resultado resultado = new Resultado();
		PreparedStatement pst = null;
		Aluno aln = (Aluno) ent;
		end = (Endereco) endDao.salvar(aln.getEndereco()).getResultado();
		String sql;
		sql = "INSERT INTO " + nomeTabela
				+ "(ALN_RA, ALN_NOME, ALN_TUR_ID, ALN_NOMEPAI, ALN_NOMEMAE, ALN_TELEFONE, ALN_END_ID, ALN_IDADE)"
				+ "VALUES (?,?,?,?,?,?,?,?)";

		try {

			pst = conexao.prepareStatement(sql);

			pst.setString(1, aln.getRa());
			pst.setString(2, aln.getNome());
			pst.setInt(3, aln.getTurma().getId());
			pst.setString(4, aln.getNomePai());
			pst.setString(5, aln.getNomeMae());
			pst.setString(6, aln.getTelefone());
			pst.setInt(7, end.getId());
			pst.setInt(8, aln.getIdade());

			pst.executeUpdate();

			conexao.commit();

			resultado.setResultado(aln);

			
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
		abrirConexao();

		Resultado resultado = new Resultado();
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<EntidadeDominio> alunos = new ArrayList<EntidadeDominio>();

		String sql = "SELECT * FROM alunos";

		try {

			pst = conexao.prepareStatement(sql);

			rs = pst.executeQuery();
			TurmaDao tDao = new TurmaDao();
			EnderecoDao eDao = new EnderecoDao();
			int idTurma = 0;
			int idEnd = 0;
			int i = 1;

			while (rs.next()) {

				Aluno aluno = new Aluno();
				aluno.setId(rs.getInt("aln_id"));
				aluno.setRa(rs.getString("aln_ra"));
				aluno.setNome(rs.getString("aln_nome"));
				aluno.setNomeMae(rs.getString("aln_nomemae"));
				aluno.setNomePai(rs.getString("aln_nomepai"));
				aluno.setTelefone(rs.getString("aln_telefone"));
				aluno.setIdade(rs.getInt("aln_idade"));
				idTurma = rs.getInt("aln_tur_id");
				aluno.setTurma(tDao.consultarById(idTurma));

				idEnd = rs.getInt("aln_end_id");
				aluno.setEndereco(eDao.consultarById(idEnd));
				
				alunos.add(aluno);
				
			}
			
			conexao.commit();

		} catch (SQLException e) {
			try {
				conexao.rollback();
				e.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

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

		resultado.setResultados(alunos);
		return resultado;
	}

	@Override
	public Resultado editar(EntidadeDominio ent) {

		abrirConexao();

		Resultado resultado = new Resultado();
		Aluno aluno = (Aluno) ent;
		
		EnderecoDao endDao = new EnderecoDao();

		PreparedStatement pst = null;
		StringBuilder sql = new StringBuilder();
		endDao.editar(aluno.getEndereco()).getResultado();
		
		sql.append("UPDATE " + nomeTabela + " SET ");
		sql.append("ALN_RA=?, ");
		sql.append("ALN_NOME=?, ");
		sql.append("ALN_TUR_ID=?, ");
		sql.append("ALN_NOMEPAI=?, ");
		sql.append("ALN_NOMEMAE=?, ");
		sql.append("ALN_TELEFONE=?, ");
		sql.append("ALN_IDADE=? ");
		sql.append("WHERE " + idTable + " = " + aluno.getId() + ";");

		try {

			pst = conexao.prepareStatement(sql.toString());
			pst.setString(1, aluno.getRa());
			pst.setString(2, aluno.getNome());
			pst.setInt(3, aluno.getTurma().getId());
			pst.setString(4, aluno.getNomePai());
			pst.setString(5, aluno.getNomeMae());
			pst.setString(6, aluno.getTelefone());
			pst.setInt(7, aluno.getIdade());
			System.out.println(pst.toString());
			pst.executeUpdate();
			
			conexao.commit();
			
			resultado.setResultado(aluno);

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conexao.rollback();
			} catch (SQLException ex) {
				e.printStackTrace();
			}
		} finally {
			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return resultado;
	}
	
public Aluno consultarById(int id) {
	
		abrirConexao();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Aluno aluno= new Aluno();
		TurmaDao tDao = new TurmaDao();
		EnderecoDao eDao = new EnderecoDao();
		int idTurma = 0;
		int idEnd = 0;

		String sql = "SELECT * FROM " + nomeTabela + " WHERE " + idTable + " = " + id;
		try {
			pst = conexao.prepareStatement(sql);

			rs = pst.executeQuery();
			
			while (rs.next()) {
				
				aluno.setId(rs.getInt("aln_id"));
				aluno.setRa(rs.getString("aln_ra"));
				aluno.setNome(rs.getString("aln_nome"));
				aluno.setNomeMae(rs.getString("aln_nomemae"));
				aluno.setNomePai(rs.getString("aln_nomepai"));
				aluno.setTelefone(rs.getString("aln_telefone"));
				aluno.setIdade(rs.getInt("aln_idade"));
				idTurma = rs.getInt("aln_tur_id");
				aluno.setTurma(tDao.consultarById(idTurma));

				idEnd = rs.getInt("aln_end_id");
				aluno.setEndereco(eDao.consultarById(idEnd));

				
			}

			conexao.commit();
		} catch (SQLException e) {
			try {
				conexao.rollback();
				e.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
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

		return aluno;
		
		
	}


public Resultado consultarTurmas(EntidadeDominio ent) {
	abrirConexao();

	Resultado resultado = new Resultado();
	PreparedStatement pst = null;
	ResultSet rs = null;
	List<EntidadeDominio> alunos = new ArrayList<EntidadeDominio>();
	int idTurma = ((Aluno) ent).getTurma().getId();
	
	String sql = "SELECT * FROM alunos WHERE aln_tur_id=" + idTurma;

	try {

		pst = conexao.prepareStatement(sql);

		rs = pst.executeQuery();
		TurmaDao tDao = new TurmaDao();
		EnderecoDao eDao = new EnderecoDao();
		int idEnd = 0;

		while (rs.next()) {

			Aluno aluno = new Aluno();
			aluno.setId(rs.getInt("aln_id"));
			aluno.setRa(rs.getString("aln_ra"));
			aluno.setNome(rs.getString("aln_nome"));
			aluno.setNomeMae(rs.getString("aln_nomemae"));
			aluno.setNomePai(rs.getString("aln_nomepai"));
			aluno.setTelefone(rs.getString("aln_telefone"));
			aluno.setIdade(Integer.parseInt(rs.getString("aln_idade")));
			aluno.setTurma(tDao.consultarById(idTurma));

			idEnd = rs.getInt("aln_end_id");
			aluno.setEndereco(eDao.consultarById(idEnd));
			
			alunos.add(aluno);
			
		}
		
		conexao.commit();

	} catch (SQLException e) {
		try {
			conexao.rollback();
			e.printStackTrace();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}

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

	resultado.setResultados(alunos);
	return resultado;
}

}
