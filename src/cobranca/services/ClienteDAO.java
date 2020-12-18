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
	
//	public void salvar(Cliente cliente) {
//		em.getTransaction().begin();
//		Cliente existente = get(cliente.getId()); //ID TO LOAD IS REQUIRED FOR LOADING
//		if(existente == null) {
//			em.persist(cliente);
//		} else {
//			existente.setCnpj(cliente.getCnpj());
//			existente.setNome(cliente.getNome());
//			existente.setNomeFantasia(cliente.getNomeFantasia());
//			existente.setCep(cliente.getCep());
//			existente.setLogradouro(cliente.getLogradouro());
//			existente.setNumero(cliente.getNumero());
//			existente.setComplemento(cliente.getComplemento());
////			existente.setMunicipio(cliente.getMunicipio());
//			em.persist(existente);
//		}
//		em.getTransaction().commit();
//		em.close();
//	}
	
	public void salvar(Cliente cliente) {
		em.getTransaction().begin();
		Cliente existente = new Cliente();
		existente = get(cliente.getCnpj());
		if(existente == null) {
			em.persist(cliente);
		}else {
			existente.setCep(cliente.getCep());
			existente.setComplemento(cliente.getComplemento());
			existente.setLogradouro(cliente.getLogradouro());
			existente.setNome(cliente.getNome());
			existente.setNumero(cliente.getNumero());
			existente.setNomeFantasia(cliente.getNomeFantasia());
			
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
	
	public static void main(String[] args) {
		Cliente cli = new Cliente();
		cli.setNome("Aldo");
		cli.setCnpj("2");
		cli.setCep("74477233");
		cli.setComplemento("Trinfo -1 ");
		cli.setLogradouro("Rua 32");
		cli.setNomeFantasia("loja de informatica");
		cli.setNumero("0");

		ClienteDAO cdao = new ClienteDAO();
		//cdao.salvar(cli);
		
		Cliente c2 = new Cliente();	
		c2 = cdao.get("2");
		
		c2.setNome("Joao Vitor Gotijo");
		c2.setNomeFantasia("Loja de Doces");
		
		cdao.salvar(c2);
		teste
		
		System.out.println("Nome: "+c2.getNome());
		System.out.println("CNPJ "+ c2.getCnpj());
		System.out.println("Nome DA Loja: "+ c2.getNomeFantasia());
	}
	
	
	

	
	
	
}