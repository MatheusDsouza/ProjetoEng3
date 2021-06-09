package br.com.crud.strategy;

import br.com.crud.model.Aluno;
import br.com.crud.model.EntidadeDominio;

public class ValidadorRa implements IStrategy {

	private final int MAX_RA = 12;
	
	@Override
	public String processar(EntidadeDominio ent) {
		if(((Aluno) ent).getRa().length() != MAX_RA) 
			return "O RA deve conter " + MAX_RA + " dígitos";	
		
		try {  
		    Double.parseDouble(((Aluno) ent).getRa());  
		  } catch(NumberFormatException e){  
		    return "O RA só pode conter números";  
		  } 
		return null;
	}

}
