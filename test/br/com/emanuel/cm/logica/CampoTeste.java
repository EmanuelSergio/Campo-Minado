package br.com.emanuel.cm.logica;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.emanuel.cm.excecao.ExplosaoException;
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
	void testeNaoVizinho() {
		Campo vizinho = new Campo(3,1);
		boolean resultado = campo.adicionarVizinho(vizinho);
		
		assertFalse(resultado);	//se vier false  o resultado vai retornar bem sucessido
		
	}
	
	@Test
	void testeAlternarMarcacao1() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
		
	}
	
	@Test
	void testeAlternarMarcacaoDuasChamadas() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
		
	}
	
	@Test
	void testeValorPadraoAtributoMarcado() {
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAbrirNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
		
	}
	
	@Test
	void testeAbrirNaoMinadoMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
		
	}
	
	@Test
	void testeAbrirMinadoMarcado() {
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
		
	}
	
	@Test
	void testeAbrirMinadoNaoMarcado() {
		campo.minar();
		
		assertThrows(ExplosaoException.class, ()->{//aqui ele espera que seja lançada essa excecao
		campo.abrir(); });
		
	}
	
	@Test
	void testeAbrirComVizinho1() {

		Campo campo11 = new Campo(1,1);
		Campo campo22 = new Campo(2,2);
		
		campo22.adicionarVizinho(campo11);
		
		campo.adicionarVizinho(campo22);
		
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isAberto());
		
	}
	
	@Test
	void testeAbrirComVizinho2() {

		Campo campo11 = new Campo(1,1);
		Campo campo12 = new Campo(1,1);
		Campo campo22 = new Campo(2,2);
		
		campo12.minar();
		
		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);
		
		campo.adicionarVizinho(campo22);
		
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isFechado()
				);
	}
	
	
	
}
