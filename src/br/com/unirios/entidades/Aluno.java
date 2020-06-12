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

	private String curso;

	private String email;

	private String matricula;

	private String nome;

	private String senha;

	private String telefone;

	//bi-directional many-to-one association to Registroproblematica
	@OneToMany(mappedBy="aluno")
	private List<Registroproblematica> registroproblematicas;

	public Aluno() {
	}

	public Integer getCodaluno() {
		return this.codaluno;
	}

	public void setCodaluno(Integer codaluno) {
		this.codaluno = codaluno;
	}

	public String getCurso() {
		return this.curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
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

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Registroproblematica> getRegistroproblematicas() {
		return this.registroproblematicas;
	}

	public void setRegistroproblematicas(List<Registroproblematica> registroproblematicas) {
		this.registroproblematicas = registroproblematicas;
	}

	public Registroproblematica addRegistroproblematica(Registroproblematica registroproblematica) {
		getRegistroproblematicas().add(registroproblematica);
		registroproblematica.setAluno(this);

		return registroproblematica;
	}

	public Registroproblematica removeRegistroproblematica(Registroproblematica registroproblematica) {
		getRegistroproblematicas().remove(registroproblematica);
		registroproblematica.setAluno(null);

		return registroproblematica;
	}

}