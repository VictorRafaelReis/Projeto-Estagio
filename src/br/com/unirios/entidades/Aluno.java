package br.com.unirios.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the aluno database table.
 * 
 */
@Entity
@NamedQuery(name="Aluno.findAll", query="SELECT a FROM Aluno a")
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer codaluno;

	private String email;

	private Integer matricula;

	private String nome;

	private String senha;

	private Integer telefone;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="codcurso")
	private Curso curso;

	//bi-directional many-to-one association to Problematica
	@OneToMany(mappedBy="aluno")
	private List<Problematica> problematicas;

	public Aluno() {
	}

	public Integer getCodaluno() {
		return this.codaluno;
	}

	public void setCodaluno(Integer codaluno) {
		this.codaluno = codaluno;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getMatricula() {
		return this.matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getTelefone() {
		return this.telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Problematica> getProblematicas() {
		return this.problematicas;
	}

	public void setProblematicas(List<Problematica> problematicas) {
		this.problematicas = problematicas;
	}

	public Problematica addProblematica(Problematica problematica) {
		getProblematicas().add(problematica);
		problematica.setAluno(this);

		return problematica;
	}

	public Problematica removeProblematica(Problematica problematica) {
		getProblematicas().remove(problematica);
		problematica.setAluno(null);

		return problematica;
	}

}