package br.com.crud.command;

import br.com.crud.model.EntidadeDominio;
import br.com.crud.model.Resultado;

public class SalvarCommand extends AbstractCommand {

	@Override
	public Resultado executar(EntidadeDominio ent) {
		
		return fachada.salvar(ent);
	}

}
