package cobranca.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cobranca.controlador.acao.AcaoCarregaDadosCliente;
import cobranca.controlador.acao.AcaoExcluirCliente;
import cobranca.controlador.acao.AcaoListagemClientes;

import cobranca.controlador.acao.AcaoSalvaClientes;


@WebServlet(urlPatterns = "/clientes")
public class ClienteControlador extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao = req.getParameter("acao");
		String cnpj = req.getParameter("cnpj");
		if(acao != null) {
			if(acao.equals("editar")) {
				AcaoCarregaDadosCliente acaoCarregaDadosCliente = new AcaoCarregaDadosCliente(req);
				String pagina = acaoCarregaDadosCliente.executa();
				RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
				dispatcher.forward(req, resp);
			}
			if(acao.equals("excluir")) {
				if(cnpj != null) {
					String pagina = new AcaoExcluirCliente(req).executa();
					RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
					dispatcher.forward(req, resp);
				}
			}

			
		} else {
			String pagina = new AcaoListagemClientes(req).executa();
			RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
			dispatcher.forward(req, resp);
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AQUIII LINHA 58");
		String pagina = new AcaoSalvaClientes(req).executa();
		RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
		dispatcher.forward(req, resp);

	}
}