package cobranca.controlador.acao;

import javax.servlet.http.HttpServletRequest;

import cobranca.entidade.Contrato;

public class AcaoSalvaBoletos {

	private HttpServletRequest req;
	
	public AcaoSalvaBoletos(HttpServletRequest req) {
		this.req = req;
	}
	
	public String executa() {
		
		Contrato boleto = new Contrato();
		String idString = req.getParameter("id");
		
		if(idString != "") {
			long id = Long.parseLong(idString);
			boleto.setId(id);
		}
		
		
		String valor = req.getParameter("input-valor");
		String descricao = req.getParameter("input-descricao");
		String codigoBarras =  req.getParameter("input-codigo-baras");
		String codigoCliente = req.getParameter("codigo-cliente");
		String nomeCliente = req.getParameter("nome-cliente");
		
		
		String pagina = new AcaoListagemBoletos(req).executa();
		return pagina;
	}
}
