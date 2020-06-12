package br.com.unirios.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	private String autorizacao;

	private String descfunc;

	private String descricao;

	private String estagio;

	private String nome;

	private String referencia;

	private String resolucaoti;

	private String statusandamento;

	//bi-directional many-to-one association to Administrador
	@ManyToOne
	@JoinColumn(name="codadm")
	private Administrador administrador;

	//bi-directional many-to-one association to Proponente
	@ManyToOne
	@JoinColumn(name="codproponente")
	private Proponente proponente;

	//bi-directional many-to-one association to Registroproblematica
	@OneToMany(mappedBy="problematica")
	private List<Registroproblematica> registroproblematicas;

	public Problematica() {
	}

	public Integer getCodproblematica() {
		return this.codproblematica;
	}

	public void setCodproblematica(Integer codproblematica) {
		this.codproblematica = codproblematica;
	}

	public String getAutorizacao() {
		return this.autorizacao;
	}

	public void setAutorizacao(String autorizacao) {
		this.autorizacao = autorizacao;
	}

	public String getDescfunc() {
		return this.descfunc;
	}

	public void setDescfunc(String descfunc) {
		this.descfunc = descfunc;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public String getStatusandamento() {
		return this.statusandamento;
	}

	public void setStatusandamento(String statusandamento) {
		this.statusandamento = statusandamento;
	}

	public Administrador getAdministrador() {
		return this.administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public Proponente getProponente() {
		return this.proponente;
	}

	public void setProponente(Proponente proponente) {
		this.proponente = proponente;
	}

	public List<Registroproblematica> getRegistroproblematicas() {
		return this.registroproblematicas;
	}

	public void setRegistroproblematicas(List<Registroproblematica> registroproblematicas) {
		this.registroproblematicas = registroproblematicas;
	}

	public Registroproblematica addRegistroproblematica(Registroproblematica registroproblematica) {
		getRegistroproblematicas().add(registroproblematica);
		registroproblematica.setProblematica(this);

		return registroproblematica;
	}

	public Registroproblematica removeRegistroproblematica(Registroproblematica registroproblematica) {
		getRegistroproblematicas().remove(registroproblematica);
		registroproblematica.setProblematica(null);

		return registroproblematica;
	}

}