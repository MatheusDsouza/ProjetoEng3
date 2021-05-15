package br.com.crud.model;

import java.util.ArrayList;
import java.util.List;

public class Resultado {
	private String mensagens;
	private EntidadeDominio resultado;
	private List<EntidadeDominio> resultados = new ArrayList<EntidadeDominio>();
	
	
	public String getMensagens() {
		return mensagens;
	}
	public void setMensagens(String mensagens) {
		this.mensagens = mensagens;
	}
	public EntidadeDominio getResultado() {
		return resultado;
	}
	public void setResultado(EntidadeDominio resultado) {
		this.resultado = resultado;
	}
	public List<EntidadeDominio> getResultados() {
		return resultados;
	}
	public void setResultados(List<EntidadeDominio> resultados) {
		this.resultados = resultados;
	}
	
	
}
