package br.com.crud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.crud.model.Cidade;
import br.com.crud.model.Endereco;
import br.com.crud.model.EntidadeDominio;
import br.com.crud.model.Estado;
import br.com.crud.model.Resultado;

public class EnderecoDao extends AbstractDao {
	
	public EnderecoDao() {
		super("enderecos", "end_id");
	}

	@Override
	public Resultado salvar(EntidadeDominio ent) {
		
		abrirConexao();
		
		Endereco end = (Endereco) ent;
		Resultado resultado = new Resultado();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql;
		sql = "INSERT INTO " + nomeTabela + "(END_CEP, END_LOGRADOURO, END_CIDADE, END_ESTADO)"
				+ "VALUES (?,?,?,?)";

		try {

			System.out.println("-ENTROU NO DAO DE ENDERECO PARA FAZER O CADASTRO");
			pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, end.getCep());
			pst.setString(2, end.getLogradouro());
			pst.setString(3, end.getCidade().getCidade());
			pst.setString(4, end.getCidade().getEstado().getUf());


			pst.executeUpdate();

			rs = pst.getGeneratedKeys();
			if (rs != null && rs.next()) {
				end.setId(rs.getInt(1));
			}else {
				end.setId(10000);
			}
			resultado.setResultado(end);
			conexao.commit();
			

			System.out.println("-ENDERECO SALVO NO BANCO");
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

	public Endereco consultarById(int id) {
		abrirConexao();

		PreparedStatement pst = null;
		ResultSet rs = null;
		Endereco end = new Endereco();

		String sql = "SELECT * FROM enderecos WHERE end_id = " + id;

		try {

			System.out.println("-ENTROU NO DAO DE ENDERECOS PARA FAZER CONSULTA POR ID");
			pst = conexao.prepareStatement(sql);

			rs = pst.executeQuery();
			
			while (rs.next()) {
				
				
				Cidade cid = new Cidade();
				Estado est = new Estado();
				
				end.setId(rs.getInt("end_id"));
				end.setCep(rs.getString("end_cep"));
				end.setLogradouro(rs.getString("end_logradouro"));
				est.setUf(rs.getString("end_estado"));
				cid.setEstado(est);
				cid.setCidade(rs.getString("end_cidade"));
				end.setCidade(cid);
				
			}

			conexao.commit();

			System.out.println("CONSULTA DE ENDERECO POR ID REALIZADA");
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

		return end;
	}

}
