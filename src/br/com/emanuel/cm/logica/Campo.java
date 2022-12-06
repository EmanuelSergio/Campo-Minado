package br.com.emanuel.cm.logica;

import java.util.ArrayList;
import java.util.List;

public class Campo {

	private final int linha; 
	private final int coluna;
	
	private boolean aberto;
	private boolean minado;
	private boolean marcado;
	
	private List<Campo> vizinhos = new ArrayList<Campo>();
	
	
	
	public Campo(int linha, int coluna) {
		super();
		this.linha = linha;
		this.coluna = coluna;
	}
	
	public boolean adicionarVizinho(Campo candidatoVizinho) {
		boolean linhaDiferente = linha != candidatoVizinho.linha;
		boolean colunaDiferente = coluna != candidatoVizinho.coluna;
		boolean diagonal = linhaDiferente && colunaDiferente;
		
		int deltaLinha = Math.abs(linha-candidatoVizinho.linha);
		int deltaColuna = Math.abs(coluna-candidatoVizinho.coluna);
		int deltaGeral = deltaColuna + deltaLinha;
		
		if(deltaGeral == 1 && !diagonal) {
			vizinhos.add(candidatoVizinho);
			return true;
		}else if(deltaGeral == 2 && diagonal) {
			vizinhos.add(candidatoVizinho);
			return true;
		}else {
			return false;
		}
		
		
		
		
		
	}
	
	
	
}
