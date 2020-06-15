package controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class RelatorioController implements IRelatorioController {




	public void transferFile(String path, String nome, String arquivo) throws IOException {
		
		File dir = new File(path);
		File newArq = new File(path, nome+".csv");
		
		if (dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if(newArq.exists()) {
				existe = true;
			}
			FileWriter fileWriter = new FileWriter(newArq, existe);
			PrintWriter print = new PrintWriter(fileWriter);
			print.write(arquivo);
			print.flush();
			print.close();
			fileWriter.close();
		} else {
			throw new IOException("Diretório Inválido");
		}
		
	}


	public void openFile(String path, String nome) throws IOException {
		File arq = new File(path, nome+".csv");
		if (arq.exists() && arq.isFile()) {
			Desktop desktop = Desktop.getDesktop();
			desktop.open(arq);
		} else {
			throw new IOException("Arquivo Inválido");
		}
	}


	public String readFile(String path, String nome) throws IOException {
		String arquivo;
		File arq = new File(path, nome+".txt");
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo, "UTF-8");
			BufferedReader buffer = new BufferedReader(leitor);
			String aux = "";
			String aux2 = "";
			aux = buffer.readLine();
			aux2 = aux + "\n";
			
			
			do {
				aux = buffer.readLine();
				aux2 += aux + "\n";
			} while (aux != null);
			arquivo = aux2.replaceAll(" ", ";");
			
			buffer.close();
			leitor.close();
			fluxo.close();
			
		} else {
			throw new IOException("Arquivo Inválido");
		}
		return arquivo;
	}





}
