package br.com.emanuel.cm.logica;

import java.util.ArrayList;
import java.util.List;

import br.com.emanuel.cm.excecao.ExplosaoException;

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
	
	boolean adicionarVizinho(Campo candidatoVizinho) {
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

	void alternarMarcacao() {
		if(!aberto) {
			marcado = !marcado;
		}
	}
	
	boolean abrir () {
		
		if(!aberto && !marcado) {
			aberto = true;
		
		if(minado) {
			throw new ExplosaoException(); //criamos essa excecao para quando o jogador abrir um campo minado, o normal � o jogador abrir um campo vazio, quando ele abrir o mindao causa a excecao
		}
		
		if(vizinhancaSegura()) {
			vizinhos.forEach(v -> v.abrir());
		}
		
		return true;
		
		}else {
			return false;
		}
		
	}
	
	boolean vizinhancaSegura() {
		return vizinhos.stream().noneMatch(v -> v.minado);
	}
	
	
}
