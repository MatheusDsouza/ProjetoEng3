package br.com.crud.dao;

import java.sql.Connection;
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
		// TODO Auto-generated method stub
		return null;
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
