package br.com.crud.command;

import br.com.crud.fachada.Fachada;
import br.com.crud.fachada.IFachada;
import br.com.crud.model.EntidadeDominio;
import br.com.crud.model.Resultado;

public abstract class AbstractCommand implements ICommand {

	protected IFachada fachada = new Fachada();
	
}
