package br.com.amanda.bancario.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
import br.com.amanda.bancario.entidades.Saldo;
import br.com.amanda.bancario.entidades.Transacao;
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
		
		try {
			Cliente clienteAtualizado = clienteServico.atualizarCliente(cod, cliente);
			return ResponseEntity.ok(clienteAtualizado);
		}catch(Exception e){
			
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{cod}")
	public ResponseEntity<Void> deletarCliente(@PathVariable Integer cod){
		
		clienteServico.deletarCliente(cod);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping ("/{cod}/transacoes")
	public ResponseEntity<Saldo> criarTransacao(@PathVariable Integer cod, @RequestBody Transacao transacao){
		
		
	}
	
}
