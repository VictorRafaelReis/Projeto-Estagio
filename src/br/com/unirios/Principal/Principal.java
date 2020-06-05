package br.com.unirios.Principal;

import java.util.List;

import br.com.unirios.dao.CursoDAO;
import br.com.unirios.entidades.Curso;

public class Principal {

	public static void main(String[] args) {
		CursoDAO daoCurso = new CursoDAO();
		
		List<Curso> listaCurso = daoCurso.listar("nome");
		
		for (Curso curso : listaCurso) {
			System.out.println("Nome do Curso: " + curso.getNome());
		}
	}

}
