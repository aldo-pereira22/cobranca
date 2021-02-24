package cobranca.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import cobranca.entidade.Contrato;
import cobranca.entidade.Cliente;
import cobranca.entidade.Servico;
import cobranca.jpa.util.JPAUtil;

public class ContratoDao {
	
	private JPAUtil jpaUtil;
	private EntityManager em;
	
	
	public ContratoDao() {
		jpaUtil = new JPAUtil();
		em = jpaUtil.getEntityManager();
	}
	
	public void salvar(Contrato contrato) {
		em.getTransaction().begin();
		Contrato existente = get(contrato.getId());
		
		if(existente == null) {
			em.persist(contrato);
		}else {
			

			existente.setValor(contrato.getValor());
			existente.setDescricao(contrato.getDescricao());
			existente.setCodigo(contrato.getCodigo());
			existente.setCliente(contrato.getCliente());
			existente.setServico(contrato.getServico());
			
			
			em.persist(existente);
		}
		em.getTransaction().commit();
		em.close();
	}
	
	public void excluir(Contrato contrato) {
		em.getTransaction().begin();
		contrato = em.find(Contrato.class, contrato.getId());
		
		em.remove(contrato);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Contrato> lista(){
		TypedQuery<Contrato> qry = em.createQuery("from Contrato", Contrato.class);
		return qry.getResultList();
	}
	
	public Contrato get(Long id) {		
		return em.find(Contrato.class, id);
	}
	

	
public static void main(String[] args) {
	Cliente cliente = new ClienteDAO().get("111");
	Servico servico = new ServicoDAO().getServico(1);
	
	Contrato contrato = new Contrato();
	ContratoDao cdao = new ContratoDao();
	
	contrato.setCliente(cliente);
	contrato.setServico(servico);
	contrato.setCodigo("150");
	contrato.setDescricao("SERVICO DE IMPRESSÃO");
	contrato.setValor(180);
	cdao.salvar(contrato);
	
}
	
	
}







