package cobranca.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Servico {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
    private String nome;

    public Servico() {
		// TODO Auto-generated constructor stub
	}


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