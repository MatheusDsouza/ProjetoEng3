package br.com.crud.model;

public class Aluno extends Pessoa{
	private String ra;
	private Turma turma;
	private String nomePai;
	private String nomeMae;
	
	
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}
	public Turma getCurso() {
		return turma;
	}
	public void setCurso(Turma turma) {
		this.turma = turma;
	}
	public String getNomePai() {
		return nomePai;
	}
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	
	
	
	
}
