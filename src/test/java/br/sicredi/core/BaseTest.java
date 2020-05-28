package br.sicredi.core;

import static br.sicredi.core.DriverFactory.getDriver;
import static br.sicredi.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * Classe destinada para inicializar e finalizar cada teste.
 * 
 * @author Giovanni D. Brancher
 */
public class BaseTest {

	/**
	 * Nome do teste em execução.
	 */
	@Rule
	public TestName testName = new TestName();

	/**
	 * Método a ser executado antes de cada execução de teste.
	 */
	@Before
	public void inicializa() {
		DriverFactory.getDriver().manage().window().maximize();
		DriverFactory.getDriver().get("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");
	}

	/**
	 * Método a ser executado depois de cada execução de teste.
	 * 
	 * @throws IOException
	 */
	@After
	public void finaliza() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File(
				"target" + File.separator + "screenshot" + File.separator + testName.getMethodName() + ".jpg"));
		killDriver();
	}
}