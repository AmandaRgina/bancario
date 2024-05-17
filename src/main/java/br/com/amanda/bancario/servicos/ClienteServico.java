package br.com.amanda.bancario.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.amanda.bancario.entidades.Cliente;
import br.com.amanda.bancario.entidades.Saldo;
import br.com.amanda.bancario.entidades.Transacao;
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

	public Cliente atualizarCliente(Integer cod, Cliente cliente) throws Exception {

		Optional<Cliente> clienteOptional = clienteRepositorio.findById(cod);

		if(clienteOptional.isPresent()) {
			Cliente clienteExistente = clienteOptional.get();
			clienteExistente.setEmail(cliente.getEmail());

			Cliente clienteAtualizado = clienteRepositorio.save(clienteExistente);
			
			return clienteAtualizado;
		}
		throw new Exception("Cliente não encontrado: " + cod);
	}
	
	public Saldo criarTransacao(Integer cod,Transacao transacao) {
		
		//Fazer as validacoes descritas no documento. Sugestao: criar um metodo privado para fazer as validacoes
		// e lançar excecoes em caso de falha de validacao
		// Verificar se existe um cliente com o codigo informado. Criar classes de excecoes diferentes para validacoes 
		// e caso não encontrar cliente
		//Verificar se for uma operacao de debito. O saldo não pode ficar menor que o limite. Caso seja, não salvar a transação
		//lancar uma excecao para este caso
		// por fim, salvar a transaçao e atualizar saldo do cliente e retornar novo saldo
		
		return null;
		
	}
} 
