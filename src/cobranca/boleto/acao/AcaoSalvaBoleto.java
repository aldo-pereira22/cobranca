package cobranca.boleto.acao;


import javax.servlet.http.HttpServletRequest;

import cobranca.entidade.Contrato;
import cobranca.entidade.Cliente;
import cobranca.entidade.Servico;
import cobranca.services.ContratoDao;
import cobranca.services.ClienteDAO;
import cobranca.services.ServicoDAO;

public class AcaoSalvaBoleto {

	
	private HttpServletRequest req;
	
	
	public AcaoSalvaBoleto(HttpServletRequest req) {
	
		this.req = req;
	}
	
	public String executa() {
		
		Cliente cliente = new Cliente();
		ClienteDAO cdao = new ClienteDAO();
		
		cdao.get(req.getParameter("cnpj"));

		Servico servico = new Servico();
		ServicoDAO sdao = new ServicoDAO();
				
		Contrato boleto = new Contrato();
		ContratoDao bdao = new ContratoDao();
		
		String valor = req.getParameter("");
		String descricao = req.getParameter("");
		String codigo = req.getParameter("");
		
				
		return "";
	}
	
}
