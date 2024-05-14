package br.com.amanda.bancario.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.amanda.bancario.entidades.Cliente;
import br.com.amanda.bancario.servicos.ClienteServico;

@RestController
@RequestMapping("/cliente")
public class ClienteControlador {

	@Autowired
	private ClienteServico clienteServico;
	
	@GetMapping
	public List<Cliente> listarClientes(){
		
		return clienteServico.listarClientes();
	}
	
	@GetMapping("/{cod}")
	public ResponseEntity<Cliente> encontrarClientePorId(@PathVariable Integer cod){
		
		Optional<Cliente> cliente = clienteServico.encontrarClientePorId(cod);
		return cliente.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente){
		
		Cliente novoCliente = clienteServico.criarCliente(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
	}
	
	@PutMapping("/{cod}")
	public ResponseEntity<Cliente> atualizarCliente(@PathVariable Integer cod, @RequestBody Cliente cliente){
		
		Optional<Cliente> clienteOptional = clienteServico.encontrarClientePorId(cod);
		
		if(clienteOptional.isPresent()) {
			Cliente clienteExistente = clienteOptional.get();
			clienteExistente.setEmail(cliente.getEmail());
			
			Cliente clienteAtualizado = clienteServico.atualizarCliente(cod, clienteExistente);
			return ResponseEntity.ok(clienteAtualizado);
		} else {
			
			return ResponseEntity.notFound().build();
		}
		
		
	}
	
	@DeleteMapping("/{cod}")
	public ResponseEntity<Void> deletarCliente(@PathVariable Integer cod){
		
		clienteServico.deletarCliente(cod);
		return ResponseEntity.noContent().build();
	}
	
}
