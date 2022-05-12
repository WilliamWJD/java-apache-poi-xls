package com.txtexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivoTxt {

	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream entradaArquivo = new FileInputStream(new File("C:\\Users\\william.jose\\Documents\\curso.txt"));
		
		// colocando arquivo em uma entrada de dados e setando o seu tipo para UTF8
		Scanner lerArquivo = new Scanner(entradaArquivo, "UTF-8");
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		while(lerArquivo.hasNext()) {
			// recupera informações linha a linha
			String linha = lerArquivo.nextLine();
			
			// imprime na tela somente se a linha for diferente de null e diferente de vazia
			if(linha != null && !linha.isEmpty()) {
				// separa os dados de uma linha em um array de string utilizando o delimitador ;
				String[] dados = linha.split("\\;");
				
				Pessoa pessoa = new Pessoa();
				
				pessoa.setNome(dados[0]);
				pessoa.setEmail(dados[1]);
				pessoa.setIdade(dados[2]);
				
				pessoas.add(pessoa);
			}
		}
		
		System.out.println(pessoas);
	}

}
