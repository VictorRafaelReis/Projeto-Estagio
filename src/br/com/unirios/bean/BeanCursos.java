package br.com.unirios.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.unirios.dao.CursoDAO;
import br.com.unirios.entidades.Curso;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class BeanCursos implements Serializable {
	
	private List<Curso> listaCurso;
	private CursoDAO daoCurso;
	private Curso curso;
	
	
	public BeanCursos() {
		daoCurso = new CursoDAO();
		curso = new Curso();
	}

	public List<Curso> getListaCurso() {
		return listaCurso;
	}
	
	
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@PostConstruct
	public void carregaDadosTabela() {
		listaCurso= daoCurso.listar("nome");
	}

}
