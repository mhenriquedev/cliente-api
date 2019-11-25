package com.desafio.mirante.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.desafio.mirante.model.Cliente;

/**
 * @author mateushenrique
 *
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	public Page<Cliente> findByNomeContaining(String nome, Pageable pageable);
	
	public Cliente findByUsername(String username);

}
