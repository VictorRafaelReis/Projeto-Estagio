package br.com.unirios.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the problematica database table.
 * 
 */
@Entity
@NamedQuery(name="Problematica.findAll", query="SELECT p FROM Problematica p")
public class Problematica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer codproblematica;

	private String descfunc;

	private String email;

	private String estagio;

	private String nome;

	private String referencia;

	private String resolucaoti;

	private String resumo;

	private Integer telefone;

	//bi-directional many-to-one association to Aluno
	@ManyToOne
	@JoinColumn(name="codaluno")
	private Aluno aluno;

	//bi-directional many-to-one association to Coordenador
	@ManyToOne
	@JoinColumn(name="codcoord")
	private Coordenador coordenador;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="codcurso")
	private Curso curso;

	public Problematica() {
	}

	public Integer getCodproblematica() {
		return this.codproblematica;
	}

	public void setCodproblematica(Integer codproblematica) {
		this.codproblematica = codproblematica;
	}

	public String getDescfunc() {
		return this.descfunc;
	}

	public void setDescfunc(String descfunc) {
		this.descfunc = descfunc;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstagio() {
		return this.estagio;
	}

	public void setEstagio(String estagio) {
		this.estagio = estagio;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getReferencia() {
		return this.referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getResolucaoti() {
		return this.resolucaoti;
	}

	public void setResolucaoti(String resolucaoti) {
		this.resolucaoti = resolucaoti;
	}

	public String getResumo() {
		return this.resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public Integer getTelefone() {
		return this.telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Coordenador getCoordenador() {
		return this.coordenador;
	}

	public void setCoordenador(Coordenador coordenador) {
		this.coordenador = coordenador;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}