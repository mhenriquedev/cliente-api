package com.desafio.mirante.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.mirante.model.Cliente;
import com.desafio.mirante.service.ClienteService;

/**
 * @author mateushenrique
 *
 */
@RestController
//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@CrossOrigin(origins = "http://localhost:3000/", allowedHeaders = "*")
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@PostMapping
	@CrossOrigin(origins = "http://localhost:3000/")
	public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente, HttpServletResponse response) {
		Cliente clientePersisted = clienteService.salvar(cliente);
		return ResponseEntity.status(HttpStatus.OK).body(clientePersisted);
	}
	
	@GetMapping(value = "lista")
	@CrossOrigin(origins = "http://localhost:3000/")
	public List<Cliente> listarTodos() {
		return clienteService.findAllList();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "http://localhost:3000/")
	public ResponseEntity<Long> remover(@PathVariable Long codigo) {
		clienteService.deleteById(codigo);
		return ResponseEntity.status(HttpStatus.OK).body(codigo);
	}

	@PutMapping("/{codigo}")
	@CrossOrigin(origins = "http://localhost:3000/")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long codigo, @RequestBody Cliente cliente) {
		Cliente clienteMerged = clienteService.salvar(cliente);
		return ResponseEntity.ok(clienteMerged);
	}

}
