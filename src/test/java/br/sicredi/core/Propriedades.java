package br.sicredi.core;

/**
 * Classe com as propriedades do ambiente de testes.
 * 
 * @author Giovanni D. Brancher
 */
public class Propriedades {

	/**
	 * Browser a ser utilizado nos testes.
	 */
	public static Browsers browser = Browsers.CHROME;

	/**
	 * Browsers dispon�veis para os testes.
	 */
	public enum Browsers {
		CHROME, FIREFOX
	}

	/**
	 * Formatos de tempo dispon�veis.
	 */
	public enum UnidadeTempo {
		MESES, ANOS
	}
}
