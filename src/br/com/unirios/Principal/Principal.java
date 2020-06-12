package br.com.unirios.Principal;

import java.util.List;

import br.com.unirios.dao.AdministradorDAO;
import br.com.unirios.entidades.Administrador;

public class Principal {

	public static void main(String[] args) {
		AdministradorDAO daoAdministrador = new AdministradorDAO();
		
		List<Administrador> listaAdministrador = daoAdministrador.listar("nome");
		
		for (Administrador administrador : listaAdministrador) {
			System.out.println("Nome do Administrador: " + administrador.getNome());
		}
	}

}
