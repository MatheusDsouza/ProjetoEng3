package br.com.crud.command;

import br.com.crud.fachada.Fachada;
import br.com.crud.fachada.IFachada;

public abstract class AbstractCommand implements ICommand {

	protected IFachada fachada = new Fachada();
	
}
