package cobranca.controlador.acao;

import javax.servlet.http.HttpServletRequest;

import cobranca.entidade.Servico;
import cobranca.services.ServicoDAO;

public class AcaoCarregaDadosServico {
	
	
	private HttpServletRequest req;

	public AcaoCarregaDadosServico(HttpServletRequest req) {
		this.req = req;
	}
	
	public String executa() {
		
		Servico servico = new Servico();
		String idString = req.getParameter("id");
		long id = Long.parseLong(idString);
		
		servico = new ServicoDAO().getServico(id);
		req.setAttribute("servico", servico);
		return "cadastro-servicos.jsp";
	}
}