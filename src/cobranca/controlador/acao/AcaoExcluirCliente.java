package cobranca.controlador.acao;

import javax.servlet.http.HttpServletRequest;

import cobranca.entidade.Cliente;
import cobranca.services.ClienteDAO;

public class AcaoExcluirCliente {
	
	
	private HttpServletRequest req;

	public AcaoExcluirCliente(HttpServletRequest req) {
		this.req = req;
	}
	
	public String executa() {
		Cliente cliente = new Cliente();
		String cnpj = req.getParameter("cnpj");
		
		cliente.setCnpj(cnpj);
		new ClienteDAO().excluir(cliente);
		String pagina = new AcaoListagemClientes(req).executa();
		return pagina;
	}
}