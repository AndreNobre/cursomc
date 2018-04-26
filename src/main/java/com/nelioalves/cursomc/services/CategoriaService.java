package com.nelioalves.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		
		// versao 1.5.x springboot
		//Categoria obj = repo.findOne(id);
		//return obj;		
		
		//Versao 2.x.x springboot - sem tratamento de retorno
		//Optional<Categoria> obj = repo.findById(id);
		//return obj.orElse(null);		
		
		//Versao 2.x.x springboot - Com tratamento de retorno
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(
					() -> new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName())
				);		
		
	}
}
