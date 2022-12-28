package br.com.emanuel.cm;

import br.com.emanuel.cm.logica.Tabuleiro;
import br.com.emanuel.cm.visao.TabuleiroConsole;

public class Aplicacao {
public static void main(String[] args) {
	
	
	Tabuleiro t = new Tabuleiro(6, 6, 6);
	new TabuleiroConsole(t);
	
	System.out.println("funcionau");
	
	
}
}
