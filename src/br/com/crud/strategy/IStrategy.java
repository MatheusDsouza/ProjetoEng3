package br.com.crud.strategy;

import br.com.crud.model.EntidadeDominio;

public interface IStrategy {
	
	String processar(EntidadeDominio ent); 

}
