package br.com.amanda.bancario.entidades;

import br.com.amanda.bancario.enums.TipoTransacao;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Transacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private Integer cod;
	
	@Getter
	@Setter
	private Double valor;
	
	@Getter
	@Setter
	private TipoTransacao tipo;

}
