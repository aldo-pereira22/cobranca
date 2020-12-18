package cobranca.services;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import cobranca.entidade.Municipio;
import cobranca.jpa.util.JPAUtil;

public class MunicipioDAO {
	public void salvar(Municipio municipio) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(municipio);
		em.getTransaction().commit();
		em.close();
	}

	public Municipio retornaMunicipio(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		Municipio municipioEncontrado = new Municipio();
		municipioEncontrado = em.find(Municipio.class, id);
		return municipioEncontrado;
	}

	public ArrayList<Municipio> listarMunicipio() {
		EntityManager em = JPAUtil.getEntityManager();
		ArrayList<Municipio> listaMunicipio = new ArrayList<>();
		Query query = em.createQuery("from Municipio a order by a.id");

		listaMunicipio = (ArrayList<Municipio>) query.getResultList();

		return listaMunicipio;
	}

	public ArrayList<Municipio> buscar(String nome) {
		EntityManager em = JPAUtil.getEntityManager();
		ArrayList<Municipio> listaDeMunicipio = new ArrayList<>();

		Query query = em.createQuery("from Municipio where nome ='" + nome + "'");

		listaDeMunicipio = (ArrayList<Municipio>) query.getResultList();

		return listaDeMunicipio;
	}

	public void excluir(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		Municipio municipioEncontrado = new Municipio();
		municipioEncontrado = em.find(Municipio.class, id);

		em.getTransaction().begin();
		em.remove(municipioEncontrado);
		em.getTransaction().commit();
		em.close();
	}
}