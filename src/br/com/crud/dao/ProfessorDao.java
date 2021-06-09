package br.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.crud.model.EntidadeDominio;
import br.com.crud.model.Professor;
import br.com.crud.util.Conexao;

public class ProfessorDao  {

	protected Connection conexao;
	protected String idTable;
	protected String nomeTabela;
	protected boolean ctrlTransacao = true;
	protected void abrirConexao() {

		try {
			if (conexao == null || conexao.isClosed()) {
				conexao = Conexao.getConnection();
				conexao.setAutoCommit(false);
			}  
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Professor> consultar(EntidadeDominio ent) {
		abrirConexao();

		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Professor> professores = new ArrayList<Professor>();

		String sql = "SELECT * FROM professores";

		try {

			
			pst = conexao.prepareStatement(sql);

			rs = pst.executeQuery();
			
			while (rs.next()) {
				
				Professor professor = new Professor();
				professor.setId(rs.getInt("pro_id"));
				professor.setRp(rs.getString("pro_rp"));
				professor.setNome(rs.getString("pro_nome"));
				professor.setTelefone(rs.getString("pro_telefone"));
				professor.setEmail(rs.getString("pro_email"));
				professores.add(professor);
				
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

		return professores;
	}
	
	public Professor consultarById(int id) {
		abrirConexao();

		PreparedStatement pst = null;
		ResultSet rs = null;
		Professor professor = new Professor();

		String sql = "SELECT * FROM professores WHERE PRO_ID = " + id;

		try {

			
			pst = conexao.prepareStatement(sql);

			rs = pst.executeQuery();
			
			if (rs.next()) {
				
				professor.setId(rs.getInt("pro_id"));
				professor.setRp(rs.getString("pro_rp"));
				professor.setNome(rs.getString("pro_nome"));
				professor.setTelefone(rs.getString("pro_telefone"));
				professor.setEmail(rs.getString("pro_email"));
								
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

		return professor;
	}

}
