package br.sicredi.core;

/**
 * Classe com m�todos auxiliares.
 * 
 * @author Giovanni D. Brancher
 */
public class Utils {

	/**
	 * Obt�m o n�mero de meses para a quantidade de anos informados.
	 * 
	 * @param qtdAnos Quantidade de anos.
	 * @return Quantidade de meses.
	 */
	public static Integer obterAnosEmMeses(String qtdAnos) throws NumberFormatException {
		return Integer.parseInt(qtdAnos) * 12;
	}
}