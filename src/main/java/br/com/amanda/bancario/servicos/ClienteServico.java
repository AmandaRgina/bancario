package br.com.amanda.bancario.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amanda.bancario.entidades.Cliente;
import br.com.amanda.bancario.repositorios.ClienteRepositorio;

@Service
public class ClienteServico {
	
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	public List<Cliente> listarClientes(){
		return clienteRepositorio.findAll();
	}

	public Optional<Cliente> encontrarClientePorId(Integer cod){
		
		return clienteRepositorio.findById(cod);
	}
	
	public Cliente criarCliente(Cliente cliente) {
		
		return clienteRepositorio.save(cliente);
	}
	
	public void deletarCliente(Integer cod) {
		clienteRepositorio.deleteById(cod);
	}
} 
