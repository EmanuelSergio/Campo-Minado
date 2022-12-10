package br.com.emanuel.cm.visao;

import java.util.Scanner;

import br.com.emanuel.cm.excecao.ExplosaoException;
import br.com.emanuel.cm.excecao.SairException;
import br.com.emanuel.cm.logica.Tabuleiro;

public class TabuleiroConsole {

	private Tabuleiro tabuleiro;
	private Scanner leia = new Scanner(System.in);
	
	public TabuleiroConsole(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		executarJogo(); 
		
	}
	

	private void executarJogo() {
		try {
			boolean continuar = true;
			
			while(continuar) {
			cicloDoJogo();
				
				
				System.out.println("Outra partida? (S/n) ");
				String resposta = leia.nextLine();
				
				
				if("n".equalsIgnoreCase(resposta)) {
					continuar = false;
				}else {
					tabuleiro.reiniciar();
				}
				
			}
			
			
		}catch(SairException e) {
			System.out.println("Tchauuu");
		}finally {
			leia.close();
		}
	}
	
	private void cicloDoJogo() {
		
		try {
			
			while(tabuleiro.objetivoAlcancado()) {
				System.out.println(tabuleiro.toString());
				
				String digitado = capturarValorDigitado("Digite (x, y): ");
			}
			
			
			System.out.println("Voce ganhou!");
		}catch(ExplosaoException e) {
			System.out.println("Voce perdeu!");
		}
		
	}
	
	private String capturarValorDigitado (String texto) {
		System.out.println(texto);
		String digitado = leia.nextLine();
		
		if("sair".equalsIgnoreCase(digitado)) {
			throw new SairException();
	
		}
	
		return digitado;
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
