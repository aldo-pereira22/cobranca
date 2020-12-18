package cobranca.services;

import javax.persistence.EntityManager;

import cobranca.entidade.Cliente;
import cobranca.entidade.Municipio;
import cobranca.entidade.Servico;
import cobranca.jpa.util.JPAUtil;

public class ServicoDAO {
	

	/*
	 * 	public void salvar(Municipio municipio) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(municipio);
		em.getTransaction().commit();
		em.close();
	}
	 * */
	
	public void salvar (Servico servico) {
		EntityManager em =  JPAUtil.getEntityManager();
		em.getTransaction().begin();
		Servico existente = get(servico.getId() );
		if(existente == null) {
			em.persist(servico);
		}else {
			existente.setNome(servico.getNome());
		}
	
		em.getTransaction().commit();
		em.close();
	}
	
	
	
	public Servico get(long id) {
		EntityManager em =  JPAUtil.getEntityManager();
		return em.find(Servico.class, id);
	}
	
	
	
	
	public static void main(String[] args) {
		
		Servico s = new Servico();
		
		s.setNome("INFORMATICA");
		ServicoDAO sdao = new ServicoDAO();
		//sdao.salvar(s);
		
		Servico s2 = new Servico();
		s2 = sdao.get(1);
		
		s2.setNome("Serviços de Limpeza");
		sdao.salvar(s2);
		System.out.println("AQUIII");
	}
}	
