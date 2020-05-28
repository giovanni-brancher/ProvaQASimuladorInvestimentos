package br.sicredi.core;

import static br.sicredi.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

/**
 * Classe com os métodos básicos para Page Objects.
 * 
 * @author Giovanni D. Brancher
 */
public class BasePage {
	/**
	 * Escreve no campo de texto.
	 * 
	 * @param by    Locator do campo.
	 * @param texto Texto a ser escrito.
	 */
	public void escrever(By by, String texto) {
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);
	}

	/**
	 * Clica no radio.
	 * 
	 * @param by Locator do radio.
	 */
	public void clicarRadio(By by) {
		getDriver().findElement(by).click();
	}

	/**
	 * Clica no botão.
	 * 
	 * @param by Locator do botão.
	 */
	public void clicarBotao(By by) {
		getDriver().findElement(by).click();
	}

	/**
	 * Clica no link.
	 * 
	 * @param link Locator do link.
	 */
	public void clicarLink(By link) {
		getDriver().findElement(link).click();
	}

	/**
	 * Obtém o texto.
	 * 
	 * @param by Locator do texto.
	 * @return O texto.
	 */
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
}
