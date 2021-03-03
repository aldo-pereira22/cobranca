package cobranca.boleto.acao;

import java.io.FileOutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.Barcode39;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

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
		
		
		Document documento = new Document(PageSize.A4, 50,50,50,50);
		
		
		try {
			
			PdfWriter pdf = PdfWriter.getInstance(documento, new FileOutputStream(boleto.getContrato().getCliente().getNome()+"boleto.pdf"));
			documento.open();
			
			Paragraph pnome = new Paragraph();
			pnome.add("Nome do cliente: "+boleto.getContrato().getCliente().getNome());
			
			Paragraph pnumeroContrato = new Paragraph();
			pnome.add("\nNumero do contrato : "+boleto.getContrato().getCodigo());
			
			Paragraph pservico = new Paragraph();
			pnome.add("\nServico utilizado: "+boleto.getContrato().getServico().getNome());
			
			Paragraph pvalor = new Paragraph();
			pnome.add("\nValor do servico "+boleto.getContrato().getValor());
			
			Paragraph p = new Paragraph();
			pnome.add("\nCódigo de barras");
			
			Barcode128 code = new Barcode128();
			code.setCode(boleto.getCodigo());
			Image img = code.createImageWithBarcode(pdf.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK);
			
			img.scalePercent(300);	
			
			
//			documento.add(pnome);
//			documento.add(pnumeroContrato);
//			documento.add(pservico);
//			documento.add(pvalor);
//			documento.add(p);
			

			
			documento.add(img);
			
			
			
			documento.close();
			
			System.out.println("PDF GERADO");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}











