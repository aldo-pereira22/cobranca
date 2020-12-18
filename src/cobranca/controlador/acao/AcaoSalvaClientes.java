package cobranca.controlador.acao;

import javax.servlet.http.HttpServletRequest;

import cobranca.entidade.Cliente;
import cobranca.services.ClienteDAO;

import cobranca.util.Utilitario;

public class AcaoSalvaClientes {

	private HttpServletRequest req;

	public AcaoSalvaClientes(HttpServletRequest req) {
		this.req = req;
	}
	
	public String executa() {

		
		String pagina = new AcaoListagemClientes(req).executa();
		return pagina;
	}
	
	//id to load is required for loading ERRO ERRO ERRO ERRO ERRO ERRO ERRO ERRO ERRO 
	
}