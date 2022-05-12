package com.txtexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Csv {
	public static void main(String[] args) throws IOException {
		File arquivo = new File("C:\\Users\\william.jose\\Documents\\curso.csv");
		FileWriter escrever = new FileWriter(arquivo);
		
		Pessoa pessoa1 = new Pessoa("William", "william.jose.wjd@gmail.com", "27");
		Pessoa pessoa2 = new Pessoa("narcisio", "narcisio.jose.wjd@gmail.com", "27");
		Pessoa pessoa3 = new Pessoa("karolaine", "karolaine.jose.wjd@gmail.com", "27");

		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.addAll(Arrays.asList(pessoa1, pessoa2, pessoa3));
		
		for (Pessoa p : pessoas) {
			escrever.write(p.getNome() + ";" + p.getEmail() + ";" + p.getIdade() + "\n");
		}
		escrever.flush();
		escrever.close();
	}
}
