package br.com.amanda.bancario.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.amanda.bancario.entidades.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
	

}
