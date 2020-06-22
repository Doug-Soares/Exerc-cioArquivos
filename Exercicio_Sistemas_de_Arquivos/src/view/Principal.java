package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.ArquivosController;
import controller.IArquivosController;

public class Principal {

	public static void main(String[] args) {
		
		String arquivo = "Cadastro.csv";
		int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código:"));
		String nome = JOptionPane.showInputDialog("Digite o nome:");
		String email=JOptionPane.showInputDialog("Digite o Email:");
		IArquivosController arqCont = new ArquivosController();
		try {
			arqCont.verificaDirTemp();
			arqCont.verificaRegistro(arquivo, codigo);
			arqCont.insereCadastro(arquivo, codigo, nome, email);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
