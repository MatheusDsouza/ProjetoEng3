package br.com.crud.command;

import br.com.crud.model.EntidadeDominio;
import br.com.crud.model.Resultado;

public interface ICommand {

	Resultado executar(EntidadeDominio ent);
	
}
