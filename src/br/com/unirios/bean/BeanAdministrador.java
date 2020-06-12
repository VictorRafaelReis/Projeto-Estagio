package br.com.unirios.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.unirios.entidades.Administrador;
import br.com.unirios.dao.AdministradorDAO;
import br.com.unirios.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class BeanAdministrador implements Serializable {

	
	private List<Administrador> listaAdministrador;
	private AdministradorDAO daoAdministrador;
	private Administrador administrador;
	
	
	public BeanAdministrador() {
		daoAdministrador = new AdministradorDAO();
		administrador = new Administrador();
	}

	public List<Administrador> getListaAdministrador() {
		return listaAdministrador;
	}
	
	
	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	@PostConstruct
	public void carregaDadosTabela() {
		try {
			listaAdministrador= daoAdministrador.listar("nome");
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void preparaNovoAdministrador() {
		try {
			administrador = new Administrador();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void salvarAdministrador() {
		try {
			daoAdministrador.salvar(administrador);
			listaAdministrador = daoAdministrador.listar("nome");
			
			JSFUtil.mensagemSucesso("Administrador salvo com sucesso!");
		} catch (Exception e) {
			JSFUtil.mensagemErro("ERRO: " + e.getMessage());
		}
	}
	
	public void alterarAdministrador(ActionEvent evento) {
		administrador = (Administrador) evento.getComponent().getAttributes().get("administradorSelecionado");
	}
	
	
	public void removerAdministrador(ActionEvent evento) {
		try {
			administrador = (Administrador) evento.getComponent().getAttributes().get("administradorSelecionado");
			daoAdministrador.remover(administrador.getCodadm());
			listaAdministrador = daoAdministrador.listar("nome");
			
			JSFUtil.mensagemSucesso("Administrador excluído com sucesso!");
		} catch (Exception e) {
			JSFUtil.mensagemErro("ERRO: " + e.getMessage());
		}
	}
	
}
