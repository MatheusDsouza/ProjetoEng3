package br.com.crud.fachada;

import br.com.crud.model.EntidadeDominio;
import br.com.crud.model.Resultado;

public interface IFachada {

	Resultado salvar(EntidadeDominio ent);
	Resultado consultar(EntidadeDominio ent);
	Resultado editar(EntidadeDominio ent);
	Resultado excluir(EntidadeDominio ent);
	
}
