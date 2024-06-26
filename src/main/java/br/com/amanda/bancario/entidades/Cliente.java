package br.com.amanda.bancario.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity @ToString
public class Cliente {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private Integer cod;
	
	@Getter
	private String nome;
	
	@Getter
	private String cpf;
	
	@Getter
	@Setter
	private String email;
	
	@OneToOne
	@JoinColumn(name = "saldo_id")
	@Getter
	private Saldo saldo;

}