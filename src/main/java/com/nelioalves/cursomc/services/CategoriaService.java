package com.nelioalves.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		
		// versao 1.5.x springboot
		//Categoria obj = repo.findOne(id);
		//return obj;		
		
		//Versao 2.x.x springboot
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);		
	}
}
