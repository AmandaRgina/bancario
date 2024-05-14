package br.com.amanda.bancario.servico;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.amanda.bancario.entidades.Cliente;
import br.com.amanda.bancario.repositorio.ClienteRepositorio;

@Service
public class ClienteServico {
	
	private ClienteRepositorio clienteRepositorio;
	
	public List<Cliente> listarClientes(){
		return clienteRepositorio.findAll();
	}

}
