package br.udesc.otes12.treinamentos.model;

import java.util.Date;

public class Funcionario {
	
	private int id;
	private int departamentoId;
	private String nome;
	private int idade;
	private Date dtContratacao;
	private double qtTotalHorasTreinamento;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDepartamentoId() {
		return departamentoId;
	}
	public void setDepartamentoId(int departamentoId) {
		this.departamentoId = departamentoId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Date getDtContratacao() {
		return dtContratacao;
	}
	public void setDtContratacao(Date dtContratacao) {
		this.dtContratacao = dtContratacao;
	}
	public double getQtTotalHorasTreinamento() {
		return qtTotalHorasTreinamento;
	}
	public void setQtTotalHorasTreinamento(double qtTotalHorasTreinamento) {
		this.qtTotalHorasTreinamento = qtTotalHorasTreinamento;
	}
}
