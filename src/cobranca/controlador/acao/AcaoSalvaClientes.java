package cobranca.controlador.acao;

import javax.servlet.http.HttpServletRequest;

import cobranca.entidade.Cliente;
import cobranca.services.ClienteDAO;

public class AcaoSalvaClientes {

	private HttpServletRequest req;

	public AcaoSalvaClientes(HttpServletRequest req) {
		this.req = req;
	}
	
	public String executa() {
		
		Cliente cliente = new Cliente();
		
		
		String cnpj = req.getParameter("input-cnpj");
		String nome = req.getParameter("input-nome");
		String nomeFantasia = req.getParameter("input-nomeFantasia");
		String cep = req.getParameter("input-cep");
		String logradouro = req.getParameter("input-logradouro");
		String numero = req.getParameter("input-numero");
		String complemento = req.getParameter("input-complemento");
		String uf = req.getParameter("cbx-uf");
		String municipio = req.getParameter("cbx-municipio");
//		Cliente cliente = new Cliente(cnpj, nome, nomeFantasia, cep, logradouro, numero, 
//				complemento, uf, municipio);
		cliente.setCnpj(cnpj);
		cliente.setNome(nome);
		cliente.setNomeFantasia(nomeFantasia);
		cliente.setCep(cep);
		cliente.setLogradouro(logradouro);
		cliente.setNumero(numero);
		cliente.setComplemento(complemento);
		cliente.setUf(uf);
		cliente.setMunicipio(municipio);
		ClienteDAO dao = new ClienteDAO();
		dao.salvar(cliente);
		
		String pagina = new AcaoListagemClientes(req).executa();
		return pagina;
	}
	
	//id to load is required for loading ERRO ERRO ERRO ERRO ERRO ERRO ERRO ERRO ERRO 
	
}