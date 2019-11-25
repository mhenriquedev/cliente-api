package com.desafio.mirante.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Papel implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Modulo nome;

    @ManyToOne
    @JsonIgnore
    private Cliente cliente;

    @Override
    public String getAuthority() {
        return nome.toString();
    }

    public enum Modulo {
        DASHBOARD("ROLE_DASHBOARD"), CLIENTE("ROLE_CLIENTE");
        private String modulo;

        private Modulo(String modulo) {
            this.modulo = modulo;
        }

        @Override
        public String toString() {
            return this.modulo;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Modulo getNome() {
        return nome;
    }

    public void setNome(Modulo nome) {
        this.nome = nome;
    }

    public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
    public String toString() {
        return "Papel [id=" + id + ", nome=" + nome + "]";
    }
}
