package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ArquivosController implements IArquivosController {
	public static String codImprime;
	public static String nomeImprime;
	public static String emailImprime;
	
	public void verificaDirTemp() throws IOException {
		String caminho = "C:\\TEMP";
		File dir = new File(caminho);
		if (dir.exists() && dir.isDirectory()) {
			System.out.println("\\TEMP existe");
		} else {
			dir.mkdir();
			System.out.println("TEMP criado");
		}
	}

	public boolean verificaRegistro(String arquivo, int codigo) throws IOException {

		String caminho = "C:\\TEMP";
		File arq = new File(caminho, arquivo);
		boolean archive = false;
		

		if (arq.exists() && arq.isFile()) {
			String cod[] = new String[3];
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			int x;
			while (linha != null) {
				linha = buffer.readLine();
				if (linha != null) {
					cod = linha.split(";");
					x = Integer.parseInt(cod[0]);
					if (codigo == x) {
						archive = true;
						codImprime = cod[0];
						nomeImprime = cod[1];
						emailImprime = cod[2];
					} 
				}
			}
			
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			
			throw new IOException("Arquivo não encontrado");
		}

		return archive;
	}

	public void imprimeCadastro(String arquivo, int codigo) throws IOException {
		if ((verificaRegistro(arquivo, codigo)) == true) {
			System.out.println("Código: " + codImprime+"\nNome: "+nomeImprime+"\nEmail: "+emailImprime);
		} 
	}

	public void insereCadastro(String arquivo, int codigo, String nome, String email) throws IOException {
		boolean confirm = verificaRegistro(arquivo, codigo);
		String caminho = "C:\\TEMP";
		File arq = new File(caminho, arquivo);
		
		if (confirm == false) {
			String conteudo = Integer.toString(codigo)+";"+nome+";"+email+"\r\n";
			FileWriter file = new FileWriter(arq, true);
			PrintWriter print = new PrintWriter(file);
			print.write(conteudo);
			print.flush();
			print.close();
			file.close();
		}
	}

}
