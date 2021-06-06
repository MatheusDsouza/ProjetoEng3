package br.com.crud.strategy;

import br.com.crud.model.Aluno;
import br.com.crud.model.EntidadeDominio;

public class ValidadorRa implements IStrategy {

	private final int MAX_RA = 12;
	
	@Override
	public String processar(EntidadeDominio ent) {
		if(((Aluno) ent).getRa().length() > MAX_RA) 
			return "O RA n�o pode conter mais que " + MAX_RA + " d�gitos";	
		return null;
	}

}
