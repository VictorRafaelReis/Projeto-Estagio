package br.com.unirios.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the coordenador database table.
 * 
 */
@Entity
@NamedQuery(name="Coordenador.findAll", query="SELECT c FROM Coordenador c")
public class Coordenador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer codcoord;

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
	@OneToMany(mappedBy="coordenador")
	private List<Problematica> problematicas;

	public Coordenador() {
	}

	public Integer getCodcoord() {
		return this.codcoord;
	}

	public void setCodcoord(Integer codcoord) {
		this.codcoord = codcoord;
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
		problematica.setCoordenador(this);

		return problematica;
	}

	public Problematica removeProblematica(Problematica problematica) {
		getProblematicas().remove(problematica);
		problematica.setCoordenador(null);

		return problematica;
	}

}