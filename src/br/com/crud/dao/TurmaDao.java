package br.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.crud.model.Turma;
import br.com.crud.util.Conexao;

public class TurmaDao{

	protected Connection conexao;
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
	
	public List<Turma> consultar() {
		
		abrirConexao();

		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Turma> turmas = new ArrayList<Turma>();

		String sql = "SELECT * FROM turmas";

		try {

			
			pst = conexao.prepareStatement(sql);

			rs = pst.executeQuery();
			
			while (rs.next()) {
				
				ProfessorDao dao = new ProfessorDao();
				Turma turma = new Turma();
				turma.setId(rs.getInt("tur_id"));
				turma.setProfessor(dao.consultarById(rs.getInt("tur_pro_id")));
				turma.setTurma(rs.getString("tur_turma"));
				turma.setIdade(Integer.parseInt(rs.getString("tur_idade")));
				turma.setTurno(rs.getString("tur_turno"));
				turmas.add(turma);
				
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

		return turmas;
	}

	
	public Turma consultarById(int id) {
		
		abrirConexao();

		PreparedStatement pst = null;
		ResultSet rs = null;
		Turma turma = new Turma();

		String sql = "SELECT * FROM turmas WHERE tur_id = " + id;

		try {

			
			pst = conexao.prepareStatement(sql);

			rs = pst.executeQuery();
			
			while (rs.next()) {
				
				ProfessorDao dao = new ProfessorDao();
				turma.setId(rs.getInt("tur_id"));
				turma.setProfessor(dao.consultarById(rs.getInt("tur_pro_id")));
				turma.setTurma(rs.getString("tur_turma"));
				turma.setIdade(Integer.parseInt(rs.getString("tur_idade")));
				turma.setTurno(rs.getString("tur_turno"));
				
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

		return turma;
		
		
	}


}
