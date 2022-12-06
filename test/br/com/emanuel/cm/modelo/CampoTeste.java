package br.com.emanuel.cm.modelo;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.emanuel.cm.logica.Campo;

public class CampoTeste {

	private Campo campo;
	
	
	@BeforeEach //para cada metodo ele vai chamar essa função
	void iniciarCampo() {
		  campo = new Campo(3, 3);
		
		
	}
	
	
	@Test //necessario para fazer o teste
	void testeVizinhoDistancia1Esquerda() {
		Campo vizinho = new Campo(3,2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		
		assertTrue(resultado);	//se vier true  o resultado vai retornar bem sucessido
		
	}
	
	@Test //necessario para fazer o teste
	void testeVizinhoDistancia1Direita() {
		Campo vizinho = new Campo(3,4);
		boolean resultado = campo.adicionarVizinho(vizinho);
		
		assertTrue(resultado);	//se vier true  o resultado vai retornar bem sucessido
		
	}
	
	@Test //necessario para fazer o teste
	void testeVizinhoDistancia1Emcima() {
		Campo vizinho = new Campo(2,3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		
		assertTrue(resultado);	//se vier true  o resultado vai retornar bem sucessido
		
	}
	
	@Test //necessario para fazer o teste
	void testeVizinhoDistancia1Embaixo() {
		Campo vizinho = new Campo(4,3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		
		assertTrue(resultado);	//se vier true  o resultado vai retornar bem sucessido
		
	}
	
	@Test //necessario para fazer o teste
	void testeVizinhoDistanciaDiagonal() {
		Campo vizinho = new Campo(2,2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		
		assertTrue(resultado);	//se vier true  o resultado vai retornar bem sucessido
		
	}
	
	@Test //necessario para fazer o teste
	void testeVizinhoDistancia2NaoVizinho() {
		Campo vizinho = new Campo(3,1);
		boolean resultado = campo.adicionarVizinho(vizinho);
		
		assertFalse(resultado);	//se vier false  o resultado vai retornar bem sucessido
		
	}
	
	
}
