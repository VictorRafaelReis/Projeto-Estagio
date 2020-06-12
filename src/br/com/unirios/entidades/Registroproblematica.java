package br.com.unirios.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the registroproblematica database table.
 * 
 */
@Entity
@NamedQuery(name="Registroproblematica.findAll", query="SELECT r FROM Registroproblematica r")
public class Registroproblematica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer codregistro;

	private String descricao;

	//bi-directional many-to-one association to Aluno
	@ManyToOne
	@JoinColumn(name="codaluno")
	private Aluno aluno;

	//bi-directional many-to-one association to Problematica
	@ManyToOne
	@JoinColumn(name="codproblematica")
	private Problematica problematica;

	public Registroproblematica() {
	}

	public Integer getCodregistro() {
		return this.codregistro;
	}

	public void setCodregistro(Integer codregistro) {
		this.codregistro = codregistro;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Problematica getProblematica() {
		return this.problematica;
	}

	public void setProblematica(Problematica problematica) {
		this.problematica = problematica;
	}

}