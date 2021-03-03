package cobranca.boleto.acao;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import cobranca.entidade.Boleto;
import cobranca.entidade.Contrato;
import cobranca.services.BoletoDAO;
import cobranca.services.ContratoDao;
import cobranca.util.Utilitario;

public class AcaoGeraBoleto {

	
	private HttpServletRequest req;
	
	public AcaoGeraBoleto(HttpServletRequest req ) {
	this.req = req;
	}
	
	
	public void executa() {
		
		Contrato contrato = new ContratoDao().get(Long.parseLong(req.getParameter("id")));		
		Boleto boleto = new Boleto();		
		Date dataDeInscricao = new Date();
		
		boleto.setData(dataDeInscricao);
		boleto.setCodigo(Utilitario.geraCodigo());
		boleto.setContrato(contrato);	
		BoletoDAO bdao = new BoletoDAO();		
		bdao.salvar(boleto);	
		
	}
}
