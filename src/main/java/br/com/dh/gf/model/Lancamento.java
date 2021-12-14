package br.com.dh.gf.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_lancamento")
public class Lancamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private TipoLancamento tipoLancamento;
	private String descricaoLancamento;
	private BigDecimal valorLancamento = BigDecimal.ZERO;

	public Lancamento() {

	}

	public Lancamento(TipoLancamento tipoLancamento, String descricaoLancamento, BigDecimal valorLancamento) {
		this.tipoLancamento = tipoLancamento;
		this.descricaoLancamento = descricaoLancamento;
		this.valorLancamento = valorLancamento;
	}

	public Long getId() {
		return id;
	}

	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}

	public String getDescricaoLancamento() {
		return descricaoLancamento;
	}

	public BigDecimal getValorLancamento() {
		return valorLancamento;
	}

}
