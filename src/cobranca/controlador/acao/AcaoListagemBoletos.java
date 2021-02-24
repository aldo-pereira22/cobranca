package cobranca.controlador.acao;

import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import cobranca.entidade.Contrato;
import cobranca.entidade.Cliente;
import cobranca.services.ContratoDao;
import cobranca.services.ClienteDAO;

public class AcaoListagemBoletos {
	
	
	private HttpServletRequest req;
	
	public AcaoListagemBoletos(HttpServletRequest req) {
		this.req = req;
	}
	
	public String executa() {
		String cnpj = req.getParameter("cnpj");
		Cliente cliente = new ClienteDAO().get(cnpj);
		
		List<Contrato> lista = new ContratoDao().lista();
		List<Contrato> boletos = new ArrayList<Contrato>();

		
		for(Contrato boleto: lista) {
			
			if(boleto.getCliente().equals(cliente)) {
				System.out.println("Cliente: "+ boleto.getCliente().getNome());
				boletos.add(boleto);
			}
		}
		
		req.setAttribute("boletos", boletos);
		return ("cliente-boleto.jsp");
	}
}
