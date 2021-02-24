package cobranca.services;

import cobranca.entidade.Contrato;
import cobranca.entidade.Cliente;
import cobranca.entidade.Servico;

public class TesteBoleto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Contrato boleto = new Contrato();
		Cliente cliente = new Cliente();
		ClienteDAO cdao = new ClienteDAO();
		Servico servico = new Servico();
		ServicoDAO sdao = new ServicoDAO();
		
		servico = sdao.getServico(Long.parseLong("1"));
		cliente = cdao.get("123");
		
		
		boleto.setCodigo("123");
		boleto.setDescricao("Diversos");
		boleto.setServico(servico);
		boleto.setCliente(cliente);
		
		ContratoDao bdao = new ContratoDao();
		bdao.salvar(boleto);

	}

}
