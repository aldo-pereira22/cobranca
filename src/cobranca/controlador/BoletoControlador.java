package cobranca.controlador;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cobranca.boleto.acao.AcaoGeraBoleto;
import cobranca.boleto.acao.AcaoLinstagemContratos;
import cobranca.boleto.acao.AcaoRetornaContrato;
import cobranca.entidade.Boleto;
import cobranca.entidade.Contrato;
import cobranca.services.BoletoDAO;
import cobranca.services.ContratoDao;
import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.Dispatcher;

@WebServlet(urlPatterns = "/boleto")
public class BoletoControlador extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		String acao = req.getParameter("acao");
			
		if(acao != null) {
				if(acao.equals("gerar")) {
					
					new AcaoGeraBoleto(req).executa();
					String pagina = new AcaoLinstagemContratos(req).executa();
					RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
					dispatcher.forward(req, resp);	
					
				
			}
				
			if(acao.equals("contratos")) {
				
				
				String pagina = new AcaoRetornaContrato(req).executa();				
				RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
				dispatcher.forward(req, resp);
			}
		}
		
		
	}
}
