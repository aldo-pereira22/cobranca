package cobranca.boleto.acao;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
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

	public AcaoGeraBoleto(HttpServletRequest req) {
		this.req = req;
	}

	public void executa() {
		
		Boleto boleto = new Boleto();
		BoletoDAO bdao = new BoletoDAO();
		
		//RECUPERAR O CONTRATO DO BANCO DE DADOS
		Contrato contrato = new ContratoDao().get(Long.parseLong(req.getParameter("id")));
		System.out.println("Contrato: "+contrato.getCodigo());
		System.out.println("ID: "+contrato.getId());
		
		
		//PREENCHER OS DADOS DO BOLETO
		boleto.setCodigo(Utilitario.geraCodigo());
		boleto.setContrato(contrato);
		
		Date data = new Date();
		
		boleto.setData(data);
		bdao.salvar(boleto);
		
		System.out.println("Boleto codigo: "+ boleto.getCodigo());
		System.out.println("Boleto numero do contrato: "+ boleto.getContrato().getCodigo());
		
		Document documento = new Document(PageSize.A4, 100, 100, 100, 100);
		
		try {
			
		//	PdfWriter.getInstance(documento, new FileOutputStream("relatorio.pdf"));
			PdfWriter pdf = PdfWriter.getInstance(documento, new FileOutputStream("boleto.pdf"));
			documento.open();
			
			Paragraph pnome = new Paragraph("Nome do cliente: "+boleto.getContrato().getCliente().getNome());
			Paragraph pcodigoContrato = new Paragraph("Numero de Contrato: "+boleto.getContrato().getCodigo());
			Paragraph pservico = new Paragraph("Servico: "+ boleto.getContrato().getServico().getNome());
			

			Barcode128 code = new Barcode128();
			code.setCode(boleto.getCodigo());
			Image img = code.createImageWithBarcode(pdf.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK);
			
			img.scalePercent(300);	
			
			documento.add(pnome);
			documento.add(pcodigoContrato);
			documento.add(pservico);
			
			documento.add(img);
			documento.close();
			
//			JOptionPane.showMessageDialog(null, this, "PDF GERADO", 0);
			JOptionPane.showMessageDialog( null, "Pdf Gerado com sucesso!!! ", "Atenção", JOptionPane.INFORMATION_MESSAGE);
			
			try {
				Desktop.getDesktop().open(new File("boleto.pdf"));
				
			} catch (IOException e) {
				
				
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {

			
			
			e.printStackTrace();
		} catch (DocumentException e) {
			
			
			e.printStackTrace();
		}
	}
	
	
	
	
}








