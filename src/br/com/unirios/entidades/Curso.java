package br.com.unirios.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the curso database table.
 * 
 */
@Entity
@NamedQuery(name="Curso.findAll", query="SELECT c FROM Curso c")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codcurso;

	private String nome;

	//bi-directional many-to-one association to Aluno
	@OneToMany(mappedBy="curso")
	private List<Aluno> alunos;

	//bi-directional many-to-one association to Coordenador
	@OneToMany(mappedBy="curso")
	private List<Coordenador> coordenadors;

	//bi-directional many-to-one association to Problematica
	@OneToMany(mappedBy="curso")
	private List<Problematica> problematicas;

	public Curso() {
	}

	public Integer getCodcurso() {
		return this.codcurso;
	}

	public void setCodcurso(Integer codcurso) {
		this.codcurso = codcurso;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Aluno> getAlunos() {
		return this.alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Aluno addAluno(Aluno aluno) {
		getAlunos().add(aluno);
		aluno.setCurso(this);

		return aluno;
	}

	public Aluno removeAluno(Aluno aluno) {
		getAlunos().remove(aluno);
		aluno.setCurso(null);

		return aluno;
	}

	public List<Coordenador> getCoordenadors() {
		return this.coordenadors;
	}

	public void setCoordenadors(List<Coordenador> coordenadors) {
		this.coordenadors = coordenadors;
	}

	public Coordenador addCoordenador(Coordenador coordenador) {
		getCoordenadors().add(coordenador);
		coordenador.setCurso(this);

		return coordenador;
	}

	public Coordenador removeCoordenador(Coordenador coordenador) {
		getCoordenadors().remove(coordenador);
		coordenador.setCurso(null);

		return coordenador;
	}

	public List<Problematica> getProblematicas() {
		return this.problematicas;
	}

	public void setProblematicas(List<Problematica> problematicas) {
		this.problematicas = problematicas;
	}

	public Problematica addProblematica(Problematica problematica) {
		getProblematicas().add(problematica);
		problematica.setCurso(this);

		return problematica;
	}

	public Problematica removeProblematica(Problematica problematica) {
		getProblematicas().remove(problematica);
		problematica.setCurso(null);

		return problematica;
	}

}