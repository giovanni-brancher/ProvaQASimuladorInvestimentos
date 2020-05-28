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
	 * Browsers disponíveis para os testes.
	 */
	public enum Browsers {
		CHROME, FIREFOX
	}

	/**
	 * Formatos de tempo disponíveis.
	 */
	public enum UnidadeTempo {
		MESES, ANOS
	}
}
