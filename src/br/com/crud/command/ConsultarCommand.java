package br.com.crud.command;

import br.com.crud.model.EntidadeDominio;
import br.com.crud.model.Resultado;

public class ConsultarCommand extends AbstractCommand {

	@Override
	public Resultado executar(EntidadeDominio ent) {
		
		return fachada.consultar(ent);
	}

}
