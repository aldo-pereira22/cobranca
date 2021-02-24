package cobranca.boleto.acao;

import javax.servlet.http.HttpServletRequest;

import cobranca.entidade.Contrato;
import cobranca.services.ContratoDao;

public class AcaoCarregaContrato {

	private HttpServletRequest req;
	
	public AcaoCarregaContrato(HttpServletRequest req) {
	
		this.req = req;
	}
	
	public String executa() {
		
		String codigo = req.getParameter("codigo");
		Contrato boleto = new ContratoDao().get(Long.parseLong(codigo));
		req.setAttribute("boleto", boleto);		
		return "cadastro-boleto.jsp";
	}
	
}
