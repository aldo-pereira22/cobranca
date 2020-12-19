package cobranca.controlador.acao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cobranca.entidade.Servico;
import cobranca.services.ServicoDAO;

public class AcaoListagemServicos {
	
	private HttpServletRequest req;

	public AcaoListagemServicos(HttpServletRequest req) {
		this.req = req;
	}
	
	public String executa() {
		List<Servico> lista = new ServicoDAO().lista();
		req.setAttribute("servicos", lista);
		return "servicos.jsp";
	}
}