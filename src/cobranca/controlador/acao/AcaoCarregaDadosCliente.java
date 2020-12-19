package cobranca.controlador.acao;

import javax.servlet.http.HttpServletRequest;

import cobranca.entidade.Cliente;
import cobranca.services.ClienteDAO;

public class AcaoCarregaDadosCliente {

	
	private HttpServletRequest req;
	
	public AcaoCarregaDadosCliente(HttpServletRequest req) {
		this.req = req;
	}
	
	public String executa() {
		String cnpj = req.getParameter("cnpj");
		Cliente cliente = new ClienteDAO().get(cnpj);
		req.setAttribute("cliente", cliente);
		return "cadastro-cliente.jsp";
	}
}