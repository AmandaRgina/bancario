package br.com.amanda.bancario.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.amanda.bancario.entidades.Cliente;
import br.com.amanda.bancario.servicos.ClienteServico;

@RestController
@RequestMapping("/clientes")
public class ClienteControlador {

	@Autowired
	private ClienteServico clienteServico;
	
	@GetMapping
	public List<Cliente> listarClientes(){
		
		return clienteServico.listarClientes();
	}
	
	
	
}
