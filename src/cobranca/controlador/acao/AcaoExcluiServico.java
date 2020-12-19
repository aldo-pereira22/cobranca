package cobranca.controlador.acao;

import javax.servlet.http.HttpServletRequest;

import cobranca.entidade.Servico;
import cobranca.services.ServicoDAO;

public class AcaoExcluiServico {
	
	
	private HttpServletRequest req;

	public AcaoExcluiServico(HttpServletRequest req){
		this.req = req;
	}
	
	public String executa() {
		Servico servico = new Servico();
		String idString = req.getParameter("id");
		
		Long id = Long.parseLong(idString);
		servico.setId(id);
		new ServicoDAO().excluir(servico);
		String pagina = new AcaoListagemServicos(req).executa();
		return pagina;
	}
}