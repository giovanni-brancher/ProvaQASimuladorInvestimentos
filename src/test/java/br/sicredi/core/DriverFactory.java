package br.sicredi.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Classe responsável pelo WebDriver.
 * 
 * @author Giovanni D. Brancher
 *
 */
public class DriverFactory {

	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {
		@Override
		protected synchronized WebDriver initialValue() {
			return initDriver();
		}
	};

	/**
	 * Construtor da class.
	 */
	private DriverFactory() {
	}

	/**
	 * Obtém o driver.
	 * 
	 * @return O driver.
	 */
	public static WebDriver getDriver() {
		return threadDriver.get();
	}

	/**
	 * Inicializa o driver.
	 * 
	 * @return O driver.
	 */
	public static WebDriver initDriver() {
		WebDriver driver = null;
		switch (Propriedades.browser) {
		case CHROME:
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		}
		driver.manage().window().setSize(new Dimension(1200, 765));
		return driver;
	}

	/**
	 * Finaliza o driver.
	 */
	public static void killDriver() {
		WebDriver driver = getDriver();
		if (driver != null) {
			driver.quit();
			driver = null;
		}
		if (threadDriver != null) {
			threadDriver.remove();
		}
	}

}
