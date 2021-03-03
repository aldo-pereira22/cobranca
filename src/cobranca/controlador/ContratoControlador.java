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
import javax.sql.rowset.serial.SerialJavaObject;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import cobranca.boleto.acao.AcaoCarregaContrato;
import cobranca.boleto.acao.AcaoClienteContratos;
import cobranca.boleto.acao.AcaoLinstagemContratos;
import cobranca.boleto.acao.AcaoNovoContrato;
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
		
		if(acao != null ) {
		
			if(acao.equals("contratos")) {				
				
				AcaoClienteContratos acaoClienteContratos = new AcaoClienteContratos(req);
				String pagina = acaoClienteContratos.executa();				
				RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
				dispatcher.forward(req, resp);			
			}
			
			if(acao.equals("novoContrato")) {
				
				String pagina = new  AcaoNovoContrato(req).executa();			
				RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
				dispatcher.forward(req, resp);
			}
			
			
			if(acao.equals("excluir")) {
				
				String id = req.getParameter("id");
				Contrato contrato = new Contrato();
				ContratoDao cdao = new ContratoDao();
				contrato = cdao.get(Long.parseLong(id));
				
				cdao.excluir(contrato);
				
				String pagina = new AcaoLinstagemContratos(req).executa();
				RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
				dispatcher.forward(req, resp);
				
				
			}
			
			
//			if(acao.equals("contratos")) {
//				
//				ClienteDAO cdao = new ClienteDAO();			
//				Cliente cliente = new Cliente();			
//				cliente = cdao.get(cnpj);
//				req.setAttribute("cliente", cliente);
//				
//				List<Contrato> listaTemporaria = new ArrayList<Contrato>();
//				ContratoDao bdao = new ContratoDao();
//				
//				listaTemporaria = bdao.lista();	
//				
//				List<Contrato> listaDeContrato = new ArrayList<>();
//				
//				for (Contrato contrato : listaTemporaria) {
//					
//					if(contrato.getCliente().getCnpj().equals(cnpj)) {
//						listaDeContrato.add(contrato);
//					}
//				}
//				
//				
//				req.setAttribute("listaDeContrato", listaDeContrato);						
//				RequestDispatcher dispatcher = req.getRequestDispatcher("cliente-contratos.jsp");
//				dispatcher.forward(req, resp);
//			}


		}else {
			
			
			String pagina = new AcaoLinstagemContratos(req).executa();
			RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
			dispatcher.forward(req, resp);
			
//			ClienteDAO cdao = new ClienteDAO();			
//			Cliente cliente = new Cliente();			
//			cliente = cdao.get(cnpj);
//			req.setAttribute("cliente", cliente);
//			
//			List<Contrato> listaTemporaria = new ArrayList<Contrato>();
//			ContratoDao bdao = new ContratoDao();
//			
//			listaTemporaria = bdao.lista();	
//			
//			List<Contrato> listaDeContrato = new ArrayList<>();
//			
//			for (Contrato contrato : listaTemporaria) {
//				
//				if(contrato.getCliente().getCnpj().equals(cnpj)) {
//					listaDeContrato.add(contrato);
//				}
//			}
//			
//			
//			req.setAttribute("listaDeContrato", listaDeContrato);						
//			RequestDispatcher dispatcher = req.getRequestDispatcher("cliente-contrato.jsp");
//			dispatcher.forward(req, resp);
		}
					
				
		
//		if(acao.equals("novo")) {
//			Cliente cliente = new ClienteDAO().get(cnpj);
//			List<Servico> lsitaServico = new ServicoDAO().lista();
//			
//			req.setAttribute("cliente", cliente);
//			req.setAttribute("listaServico", lsitaServico);
//			
//			RequestDispatcher dispatcher = req.getRequestDispatcher("cliente-contratos.jsp");
//			dispatcher.forward(req, resp);
//			
//		}
		
		
//		if(acao.equals("editar")) {					
//				AcaoCarregaContrato acaoCarregaDadosBoleto = new AcaoCarregaContrato(req);
//				String pagina = acaoCarregaDadosBoleto.executa();
//				RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
//				dispatcher.forward(req, resp);
//		}else 
		


	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cnpj = req.getParameter("cnpj");
		
		if(cnpj != null ) {
			
		Cliente cliente = new ClienteDAO().get(cnpj);
		Servico servico = new ServicoDAO().getServico(Long.parseLong( req.getParameter("id") ));
		
		Contrato contrato = new Contrato();
		ContratoDao cdao = new ContratoDao();
		
		contrato.setValor(Double.parseDouble(req.getParameter("input-valor")));
		contrato.setDescricao(req.getParameter("input-descricao"));
		contrato.setCodigo(req.getParameter("input-codigo"));		
		contrato.setServico(servico);
		contrato.setCliente(cliente);
		cdao.salvar(contrato);
		
		//RequestDispatcher dispatcher = req.getRequestDispatcher("cliente-contratos.jsp");
		//dispatcher.forward(req, resp);	
		
		String pagina = new AcaoLinstagemContratos(req).executa();
		RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
		dispatcher.forward(req, resp);
		
		
		}
		
	}
}
