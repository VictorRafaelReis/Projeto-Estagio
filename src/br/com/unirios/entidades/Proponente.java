package br.com.unirios.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proponente database table.
 * 
 */
@Entity
@NamedQuery(name="Proponente.findAll", query="SELECT p FROM Proponente p")
public class Proponente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer codproponente;

	private String email;

	private String matricula;

	private String nome;

	private String senha;

	private String telefone;

	//bi-directional many-to-one association to Problematica
	@OneToMany(mappedBy="proponente")
	private List<Problematica> problematicas;

	public Proponente() {
	}

	public Integer getCodproponente() {
		return this.codproponente;
	}

	public void setCodproponente(Integer codproponente) {
		this.codproponente = codproponente;
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

	public List<Problematica> getProblematicas() {
		return this.problematicas;
	}

	public void setProblematicas(List<Problematica> problematicas) {
		this.problematicas = problematicas;
	}

	public Problematica addProblematica(Problematica problematica) {
		getProblematicas().add(problematica);
		problematica.setProponente(this);

		return problematica;
	}

	public Problematica removeProblematica(Problematica problematica) {
		getProblematicas().remove(problematica);
		problematica.setProponente(null);

		return problematica;
	}

}