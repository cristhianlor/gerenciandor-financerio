package br.com.dh.gf.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_orcamento")
public class Orcamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "ano", nullable = false, length = 4)
	private LocalDate ano = LocalDate.now();
	@OneToMany(mappedBy = "orcamento", cascade = CascadeType.ALL)
	private List<Categoria> categorias = new ArrayList<>();
	@OneToMany(mappedBy = "orcamento", cascade = CascadeType.ALL)
	private List<Lancamento> lancamentos = new ArrayList<>();
	@Column(name = "vlr_total", nullable = false, length = 19, precision = 2)
	private BigDecimal valorTotal = BigDecimal.ZERO;

	public Orcamento() {
	}

	public Orcamento(BigDecimal valorTotal) {

		this.valorTotal = valorTotal;
	}

	private void adicionarCategoria(Categoria categoria) {
		categoria.setTipoCategoria(this);
		categorias.add(categoria);
	}

}
