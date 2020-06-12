package br.com.unirios.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the administrador database table.
 * 
 */
@Entity
@NamedQuery(name="Administrador.findAll", query="SELECT a FROM Administrador a")
public class Administrador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codadm;

	private String email;

	private String matricula;

	private String nome;

	private String senha;

	private String telefone;

	//bi-directional many-to-one association to Problematica
	@OneToMany(mappedBy="administrador")
	private List<Problematica> problematicas;

	public Administrador() {
	}

	public Integer getCodadm() {
		return this.codadm;
	}

	public void setCodadm(Integer codadm) {
		this.codadm = codadm;
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
		problematica.setAdministrador(this);

		return problematica;
	}

	public Problematica removeProblematica(Problematica problematica) {
		getProblematicas().remove(problematica);
		problematica.setAdministrador(null);

		return problematica;
	}

}