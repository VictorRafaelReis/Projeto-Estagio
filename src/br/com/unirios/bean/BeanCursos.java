package br.com.unirios.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.com.unirios.dao.CursoDAO;
import br.com.unirios.entidades.Curso;
import br.com.unirios.util.JSFUtil;

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
		try {
			listaCurso= daoCurso.listar("nome");
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void preparaNovoCurso() {
		try {
			curso = new Curso();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void salvarCurso() {
		try {
			daoCurso.salvar(curso);
			listaCurso = daoCurso.listar("nome");
			
			JSFUtil.mensagemSucesso("Curso salvo com sucesso!");
		} catch (Exception e) {
			JSFUtil.mensagemErro("ERRO: " + e.getMessage());
		}
	}
	
	public void alterarCurso(ActionEvent evento) {
		curso = (Curso) evento.getComponent().getAttributes().get("cursoSelecionado");
	}
	
	
	public void removerCurso(ActionEvent evento) {
		try {
			curso = (Curso) evento.getComponent().getAttributes().get("cursoSelecionado");
			daoCurso.remover(curso.getCodcurso());
			listaCurso = daoCurso.listar("nome");
			
			JSFUtil.mensagemSucesso("Curso excluído com sucesso!");
		} catch (Exception e) {
			JSFUtil.mensagemErro("ERRO: " + e.getMessage());
		}
	}
	
	

}
