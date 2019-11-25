package com.desafio.mirante.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.mirante.model.Cliente;
import com.desafio.mirante.repository.ClienteRepository;

/**
 * @author mateushenrique
 *
 */
@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public void deleteById(Long codigo) {
		clienteRepository.deleteById(codigo);
	}
	
	public List<Cliente> findAllList() {
		return clienteRepository.findAll();
	}
	
	public Optional<Cliente> findById(Long id) {
		return clienteRepository.findById(id);
	}
}
