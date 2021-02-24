package cobranca.boleto.acao;

import javax.servlet.http.HttpServletRequest;

import cobranca.entidade.Contrato;

public class AcaoExcluirContrato {

	
	private HttpServletRequest req;
	
	public AcaoExcluirContrato(HttpServletRequest req) {
	
		this.req = req;	
	}
	
	public String executa() {
		
		return "";
	}
	
}

