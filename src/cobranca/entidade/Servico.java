package cobranca.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

@Entity
public class Servico {
   
	  public Servico() {
			// TODO Auto-generated constructor stub
		}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
    private String nome;
   
//    @ManyToOne
//    @JoinColumn(name = "cliente", nullable = false)
//    @ForeignKey(name = "pessoa_fk")
//    private Cliente cliente = new Cliente();
    
//    public void setCliente(Cliente cliente) {
//		this.cliente = cliente;
//	}
//    public Cliente getCliente() {
//		return cliente;
//	}

    


	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}