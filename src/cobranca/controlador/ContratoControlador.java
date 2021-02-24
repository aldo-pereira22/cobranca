package cobranca.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cobranca.boleto.acao.AcaoCarregaContrato;
import cobranca.controlador.acao.AcaoCarregaDadosCliente;
import cobranca.controlador.acao.AcaoListagemBoletos;
import cobranca.controlador.acao.AcaoSalvaBoletos;
import cobranca.entidade.Contrato;
import cobranca.entidade.Cliente;
import cobranca.entidade.Servico;
import cobranca.services.ContratoDao;
import cobranca.services.ClienteDAO;
import cobranca.services.ServicoDAO;
import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.Dispatcher;

@WebServlet(urlPatterns = "/contrato")
public class ContratoControlador extends HttpServlet {


	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String acao = req.getParameter("acao");
		String cnpj = req.getParameter("cnpj");
		
		if(acao.equals("contratos")) {
				
			ClienteDAO cdao = new ClienteDAO();			
			Cliente cliente = new Cliente();			
			cliente = cdao.get(cnpj);
			req.setAttribute("cliente", cliente);
			
			List<Contrato> listaDeContrato = new ArrayList<Contrato>();
			ContratoDao bdao = new ContratoDao();			
			listaDeContrato = bdao.lista();			
			req.setAttribute("listaDeContrato", listaDeContrato);
						
			RequestDispatcher dispatcher = req.getRequestDispatcher("cliente-boleto.jsp");
			dispatcher.forward(req, resp);
			
//			AcaoListagemBoletos acaoListagemBoleto = new AcaoListagemBoletos(req);
//			String pagina= acaoListagemBoleto.executa();
//			RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
//			dispatcher.forward(req, resp);
		}
			
		if(acao.equals("novoContrato")) {
			Cliente cliente = new ClienteDAO().get(cnpj);
			List<Servico> servico = new ServicoDAO().lista();
			
	
			req.setAttribute("servico", servico);
			req.setAttribute("cliente", cliente);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("cadastro-contrato.jsp");
			dispatcher.forward(req, resp);
		}
		if(acao.equals("novo")) {
			
			Cliente cliente = new ClienteDAO().get(cnpj);
			List<Servico> lsitaServico = new ServicoDAO().lista();
			
			req.setAttribute("cliente", cliente);
			req.setAttribute("listaServico", lsitaServico);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("cadastro-boleto.jsp");
			dispatcher.forward(req, resp);
			
		}
		
		if(acao.equals("gerar")){
			
		}
		
			if(acao.equals("editar")) {
				
	
				AcaoCarregaContrato acaoCarregaDadosBoleto = new AcaoCarregaContrato(req);
				String pagina = acaoCarregaDadosBoleto.executa();
				RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
				dispatcher.forward(req, resp);
			}
		
		if(acao.equals("excluir")) {
			
		}

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
}







