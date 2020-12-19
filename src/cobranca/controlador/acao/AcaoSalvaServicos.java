package cobranca.controlador.acao;

import javax.servlet.http.HttpServletRequest;

import cobranca.entidade.Servico;
import cobranca.services.ServicoDAO;

public class AcaoSalvaServicos {
	
	private HttpServletRequest req;

	public AcaoSalvaServicos(HttpServletRequest req) {
		this.req = req;
	}
	
	public String executa() {
		
		Servico servico = new Servico();
		String idString = req.getParameter("id");
		
		if(idString != "") {
			long id = Long.parseLong(idString);
			servico.setId(id);
		}
		
		String nome = req.getParameter("input-nome");
		servico.setNome(nome);
		ServicoDAO dao = new ServicoDAO();
		dao.salvar(servico);
		
		String pagina = new AcaoListagemServicos(req).executa();
		return pagina;
	}
}