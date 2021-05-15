package br.com.crud.dao;

import br.com.crud.model.EntidadeDominio;
import br.com.crud.model.Resultado;

public interface IDAO {
	Resultado salvar(EntidadeDominio ent);
	Resultado consultar(EntidadeDominio ent);
	Resultado editar(EntidadeDominio ent);
	Resultado excluir(EntidadeDominio ent);
}
