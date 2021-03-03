package cobranca.boleto.acao;

import javax.servlet.http.HttpServletRequest;

import cobranca.entidade.Contrato;
import cobranca.services.ContratoDao;

public class AcaoRetornaContrato {

	private HttpServletRequest req;
	
	public AcaoRetornaContrato( HttpServletRequest req) {

		this.req = req;

	
	}
	
	public String executa() {
		
		String id = req.getParameter("id");
		Contrato contrato = new ContratoDao().get(Long.parseLong(id));
		
		req.setAttribute("contrato", contrato);
		return"boletos.jsp";
	}
}
