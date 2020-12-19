package cobranca.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cobranca.controlador.acao.AcaoCarregaDadosServico;
import cobranca.controlador.acao.AcaoExcluiServico;
import cobranca.controlador.acao.AcaoListagemServicos;
import cobranca.controlador.acao.AcaoSalvaServicos;

@WebServlet(urlPatterns = "/servicos")
public class ServicoControlador extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao = req.getParameter("acao");
		String id = req.getParameter("id");
		if(acao != null) {
			if(acao.equals("editar")) {
				if(id != null) {
					AcaoCarregaDadosServico acaoCarregaDadosServico = new AcaoCarregaDadosServico(req);
					String pagina = acaoCarregaDadosServico.executa();
					RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
					dispatcher.forward(req, resp);
				}
			}
			if(acao.equals("excluir")) {
				if(id != null) {
					String pagina = new AcaoExcluiServico(req).executa();
					RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
					dispatcher.forward(req, resp);
				}
			}
		} else {
			String pagina = new AcaoListagemServicos(req).executa();
			RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
			dispatcher.forward(req, resp);	
		}	
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String id = req.getParameter("id");
		String pagina = new AcaoSalvaServicos(req).executa();
		RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
		dispatcher.forward(req, resp);
	}
}