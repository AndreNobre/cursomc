package com.nelioalves.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.repositories.ClienteRepository;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		
		// versao 1.5.x springboot
		//Cliente obj = repo.findOne(id);
		//return obj;		
		
		//Versao 2.x.x springboot - sem tratamento de retorno
		//Optional<Cliente> obj = repo.findById(id);
		//return obj.orElse(null);		
		
		//Versao 2.x.x springboot - Com tratamento de retorno
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(
					() -> new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName())
				);		
		
	}
}
