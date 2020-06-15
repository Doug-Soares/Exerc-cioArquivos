package controller;

import java.io.IOException;

public interface IRelatorioController {
	public String readFile (String path, String nome) throws IOException;
	public void transferFile (String path, String nome, String arquivo) throws IOException;
	public void openFile (String path, String nome) throws IOException;
}
