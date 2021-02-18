package cobranca.entidade;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Boleto {

	@Id
	private long id;
	
	private double preco;
	private double descricao;
	private String codigo;
	private Servico servico;
	private Cliente cliente;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public double getDescricao() {
		return descricao;
	}
	public void setDescricao(double descricao) {
		this.descricao = descricao;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
		
	
	
	
}
