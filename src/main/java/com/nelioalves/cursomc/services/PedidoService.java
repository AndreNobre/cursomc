package com.nelioalves.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Pedido;
import com.nelioalves.cursomc.repositories.PedidoRepository;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		
		// versao 1.5.x springboot
		//Pedido obj = repo.findOne(id);
		//return obj;		
			
		//Versao 2.x.x springboot - sem tratamento de retorno
		//Optional<Pedido> obj = repo.findById(id);
		//return obj.orElse(null);		
		
		//Versao 2.x.x springboot - Com tratamento de retorno
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(
					() -> new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName())
				);		
		
	}
}
