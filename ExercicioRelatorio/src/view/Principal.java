package view;

import java.io.IOException;

import controller.IRelatorioController;
import controller.RelatorioController;

public class Principal {

	public static void main(String[] args) {
		IRelatorioController relCont = new RelatorioController();
		String path = "C:\\Users\\Public\\Documents";
		String nome = "relatorio";
		
		try {
			String arquivo = relCont.readFile(path, nome);
			relCont.transferFile(path, nome, arquivo);
			relCont.openFile(path, nome);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
