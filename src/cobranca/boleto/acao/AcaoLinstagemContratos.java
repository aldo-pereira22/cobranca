package cobranca.boleto.acao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cobranca.entidade.Contrato;
import cobranca.services.ContratoDao;

public class AcaoLinstagemContratos {
	
	private HttpServletRequest req;	
	public AcaoLinstagemContratos(HttpServletRequest req) {
		
		this.req = req;

	}
	
	
	public String executa() {
		List<Contrato> lista = new ContratoDao().lista();
		req.setAttribute("listaDeContrato", lista);
		return("cliente-contratos.jsp");
	}
}
