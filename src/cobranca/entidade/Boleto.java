package cobranca.entidade;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Boleto {

	@Id
	private long id;
	
	private double preco;
	private Servico servico;
	private Cliente cliente;
	
	
	
}
