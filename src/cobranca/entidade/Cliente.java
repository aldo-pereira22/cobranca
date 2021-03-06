package cobranca.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
//
//import cobranca.entidade.Servico;

@Entity
public class Cliente {
	

	@Id
	private String cnpj;

	private String nome;
	private String nomeFantasia;
	private String cep;
	private String logradouro;
	private String numero;
	private String complemento;
	private String uf;
	private String municipio;
	
	
//	@OneToMany(mappedBy="cliente", orphanRemoval = true)
//	@Cascade(value = {org.hibernate.annotations.CascadeType.ALL})
//	private  List<Servico> listaDeServicos = new ArrayList<Servico>();
	
//	public void setListaDeServicos(List<Servico> listaDeServicos) {
//		this.listaDeServicos = listaDeServicos;
//	}
//	
//	public List<Servico> getListaDeServicos() {
//		return listaDeServicos;
//	}
//	
	public Cliente() {

	}
	
	public Cliente(String cnpj, String nome, String nomeFantasia, String cep, String logradouro, String numero,
			String complemento, String uf, String municipio) {
		super();
		this.cnpj = cnpj;
		this.nome = nome;
		this.nomeFantasia = nomeFantasia;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.uf = uf;
		this.municipio = municipio;
	}

//	public Long getId() {
//		return id;
//	}
//	
//	public void setId(Long id) {
//		this.id = id;
//	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	

}