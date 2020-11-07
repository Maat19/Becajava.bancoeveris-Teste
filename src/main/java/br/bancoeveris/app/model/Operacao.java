package br.bancoeveris.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Operacao  extends BaseResponse{
	
	@Id
	private Long id;
	private String tipo;
	private double valor;
	
	
	@ManyToOne
    @JoinColumn (name ="IdContaOrigem")
    private Conta ContaO;
	
	@ManyToOne
    @JoinColumn (name ="IdContaDestino")
    private Conta ContaD;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Conta getContaO() {
		return ContaO;
	}

	public void setContaO(Conta contaO) {
		ContaO = contaO;
	}

	public Conta getContaD() {
		return ContaD;
	}

	public void setContaD(Conta contaD) {
		ContaD = contaD;
	}

	
}
