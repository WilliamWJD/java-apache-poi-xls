package com.txtexcel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class PlanilhaComApachePOI {

	public static void main(String[] args) throws IOException {
		File arquivo = new File("C:\\java-projetcs\\TxtExcelPOI\\src\\arquivo_excel.xls");
		
		if(!arquivo.exists()) {
			arquivo.createNewFile();
		}
		
		Pessoa pessoa1 = new Pessoa("William", "william.jose.wjd@gmail.com", "27");
		Pessoa pessoa2 = new Pessoa("narcisio", "narcisio.jose.wjd@gmail.com", "27");
		Pessoa pessoa3 = new Pessoa("karolaine", "karolaine.jose.wjd@gmail.com", "27");
		Pessoa pessoa4 = new Pessoa("karolaine", "karolaine.jose.wjd@gmail.com", "27");

		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.addAll(Arrays.asList(pessoa1, pessoa2, pessoa3, pessoa4));
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(); // é usado para escrever a planilha
		HSSFSheet linhaPessoa = hssfWorkbook.createSheet("Planilha de Pessoas"); // criar a planilha
		
		int numerolinha = 0;
		for(Pessoa p: pessoas) {
			Row linha = linhaPessoa.createRow(numerolinha ++); // criando a linha na planilha
			
			int celula = 0;
			
			Cell celNome = linha.createCell(celula ++);
			celNome.setCellValue(p.getNome());
			
			Cell celEmail = linha.createCell(celula ++);
			celEmail.setCellValue(p.getEmail());
			
			Cell celIdade = linha.createCell(celula ++);
			celIdade.setCellValue(p.getIdade());
		}
		
		FileOutputStream saida = new FileOutputStream(arquivo);
		hssfWorkbook.write(saida); // escreve a planilha em arquivo
		saida.flush();
		saida.close();
		
		System.out.println("Planilha criada com sucesso!!");
	}

}
