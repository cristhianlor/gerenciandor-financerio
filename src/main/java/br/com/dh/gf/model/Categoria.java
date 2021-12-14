package br.com.dh.gf.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private TipoCategoria tipoCategoria;
	@ManyToOne
	@JoinColumn(name = "orcamento_id", foreignKey = @ForeignKey(name = "ORCAMENTO_ID_FK"))
	private Orcamento orcamento;

	public Categoria() {
	}

	public Categoria(TipoCategoria tipoCategoria, Orcamento orcamento) {
		this.tipoCategoria = tipoCategoria;
		this.orcamento = orcamento;
	}

	public Long getId() {
		return id;
	}

	public void setTipoCategoria(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public TipoCategoria getTipoCategoria() {
		return tipoCategoria;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
