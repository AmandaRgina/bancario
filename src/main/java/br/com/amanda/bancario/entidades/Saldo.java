package br.com.amanda.bancario.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Saldo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private Integer cod;
	
	@Getter
	@Setter
	private Double saldo;
	
	@Getter
	@Setter
	private Double limite;

}
