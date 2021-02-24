package cobranca.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import cobranca.entidade.Cliente;
import cobranca.jpa.util.JPAUtil;

public class ClienteDAO {
	private JPAUtil jpaUtil;
	private EntityManager em;
	
	public ClienteDAO() {
		jpaUtil = new JPAUtil();
		em = jpaUtil.getEntityManager();	
	}
	
	public void salvar(Cliente cliente) {
		em.getTransaction().begin();
		Cliente existente = get(cliente.getCnpj());
		if(existente == null) {
			em.persist(cliente);
		} else {
			existente.setCnpj(cliente.getCnpj());
			existente.setNome(cliente.getNome());
			existente.setNomeFantasia(cliente.getNomeFantasia());
			existente.setCep(cliente.getCep());
			existente.setLogradouro(cliente.getLogradouro());
			existente.setNumero(cliente.getNumero());
			existente.setComplemento(cliente.getComplemento());
			existente.setUf(cliente.getUf());
			existente.setMunicipio(cliente.getMunicipio());
			em.persist(existente);
		}
		em.getTransaction().commit();
		em.close();
	}
	
	public void excluir(Cliente cliente) {
		em.getTransaction().begin();
		cliente = em.find(Cliente.class, cliente.getCnpj());
		em.remove(cliente);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public List<Cliente> lista(){
		TypedQuery<Cliente> qry = em.createQuery("from Cliente", Cliente.class);
		return qry.getResultList();
	}
	
	public Cliente get(String cnpj) {
		return em.find(Cliente.class, cnpj);
	}
	
}