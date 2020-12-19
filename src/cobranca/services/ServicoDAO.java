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
			em.persist(existente);
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
		
		ServicoDAO sdao = new ServicoDAO();
		
//		s.setNome("MANUTENÇÃO DE IMPRESSORA");
//		sdao.salvar(s);
		 s = sdao.get(1);
		 
		System.out.println("ID: -"+ s.getId() );
		System.out.println("Nome: -"+ s.getNome());
		
		s.setNome("SERVIÇOS DE INFORMATICA");

		System.out.println("NOVO ID: -"+ s.getId() );
		System.out.println("NOVO NOME: -"+ s.getNome());
		
		
		sdao.salvar(s);
		
		System.out.println("NOVO ID DEPOIS DE EDITAR: -"+ s.getId() );
		System.out.println("NOVO NOME DEPOIS DE EDITAR: -"+ s.getNome());
		

	}
}	
