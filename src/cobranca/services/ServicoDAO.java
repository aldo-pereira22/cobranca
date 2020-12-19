package cobranca.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import cobranca.entidade.Servico;
import cobranca.jpa.util.JPAUtil;

public class ServicoDAO {
	private JPAUtil jpaUtil;
	private EntityManager em;
	
	public ServicoDAO() {
		jpaUtil = new JPAUtil();
		em = jpaUtil.getEntityManager();
	}
	
	public void salvar(Servico servico) {
		em.getTransaction().begin();
		Servico existente = getServico(servico.getId());
		System.out.println(existente);
		if(existente == null) {
			em.persist(servico);
		} else {
			existente.setNome(servico.getNome());
			em.persist(existente);
		}
		em.getTransaction().commit();
		em.close();
	}

	public void excluir(Servico servico) {
		em.getTransaction().begin();
		servico = em.find(Servico.class, servico.getId());
		em.remove(servico);
		em.getTransaction().commit();
		em.close();
	}
	
	public Servico retornaServico(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		Servico servicoEncontrado = new Servico();
		servicoEncontrado = em.find(Servico.class, id);
		return servicoEncontrado;
	}
	
	public List<Servico> lista(){
		TypedQuery<Servico> qry = em.createQuery("from Servico", Servico.class);
		return qry.getResultList();
	}
	
	public Servico getServico(long id) {
		return em.find(Servico.class, id);
	}
	
}