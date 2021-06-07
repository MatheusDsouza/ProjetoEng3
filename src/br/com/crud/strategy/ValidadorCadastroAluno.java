package br.com.crud.strategy;

import br.com.crud.model.Aluno;
import br.com.crud.model.Endereco;
import br.com.crud.model.EntidadeDominio;

public class ValidadorCadastroAluno implements IStrategy {
	
	@Override
	public String processar(EntidadeDominio ent) {
		if(ent instanceof Aluno){
			Aluno aluno= (Aluno)ent;
			
			String ra = aluno.getRa();
			String nome = aluno.getNome();
			String nomeMae = aluno.getNomeMae();
			String nomePai = aluno.getNomePai();
			String telefone = aluno.getTelefone();

			Endereco endereco = aluno.getEndereco();
			String logradouro = endereco.getLogradouro();
			String cidade = endereco.getCidade().getCidade();
			String estado = endereco.getCidade().getEstado().getUf();
			
			StringBuilder sb = new StringBuilder();
			
			//Validador Aluno
			if(isEmpty(nome))
				sb.append("Insira o nome do aluno\n");
			
			if(isEmpty(ra))
				sb.append("Insira o RA do aluno\n");
			
			if(isEmpty(nomeMae))
				sb.append("Insira o nome do pai do aluno\n");
			
			if(isEmpty(nomePai))
				sb.append("Insira o nome da mãe do aluno\n");
			
			if(isEmpty(telefone))
				sb.append("Insira um telefone para contato\n");
			
			// Validador Endereco
			if(isEmpty(logradouro))
				sb.append("Insira o logradouro\n");
			
			if(isEmpty(cidade))
				sb.append("Insira a cidade\n");
			
			if(isEmpty(estado))
				sb.append("Insira o estado\n");
						
			if(sb.length() > 0) {
				return sb.toString();
			}else {
				return null;
			}
			
		}else{
			return "Deve ser registrado um cliente!";
		}
		
	}
	
	private boolean isEmpty(String dado) {
		if(dado == null || dado == "" || dado.trim().equals(""))
			return true;
		return false;
	}

	

}
