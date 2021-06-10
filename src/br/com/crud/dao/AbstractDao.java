package br.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.crud.model.EntidadeDominio;
import br.com.crud.model.Resultado;
import br.com.crud.util.Conexao;

public abstract class AbstractDao implements IDAO {
	
	protected Connection conexao;
	protected String idTable;
	protected String nomeTabela;
	protected boolean ctrlTransacao = true;

	public AbstractDao(String nomeTabela, String idTabela) {

        this.nomeTabela = nomeTabela;
        this.idTable = idTabela;
    }
	
	
	@Override
	public Resultado excluir(EntidadeDominio ent) {
		abrirConexao();

		Resultado resultado = new Resultado();

		PreparedStatement pst = null;
		StringBuilder sql = new StringBuilder();

		sql.append("DELETE FROM " + nomeTabela + " WHERE " + idTable + "=?");

		try {
			pst = conexao.prepareStatement(sql.toString());
			pst.setInt(1, ent.getId());
			pst.execute();
			conexao.commit();

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

}
