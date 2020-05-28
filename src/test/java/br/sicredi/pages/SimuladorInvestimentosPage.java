package br.sicredi.pages;

import static br.sicredi.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.sicredi.core.BasePage;
import br.sicredi.core.Propriedades.UnidadeTempo;

/**
 * Classe com os locators e os m�todos utilizados no Page Object
 * do Simulador de Investimentos - Poupan�a Sicredi.
 * 
 * @author Giovanni D. Brancher
 */
public class SimuladorInvestimentosPage extends BasePage {

	/** Defini��o para esperas expl�citas. */
	WebDriverWait wait = new WebDriverWait(getDriver(), 15);

	/** Locator da aplica��o inicial. */
	private By campoAplicacaoInicial = By.id("valorAplicar");
	/** Locator da aplica��o mensal. */
	private By campoAplicacaoMensal = By.id("valorInvestir");
	/** Locator do tempo de investimento. */
	private By campoTempoInvestimento = By.id("tempo");
	/** Locator do combo da unidade de tempo do investimento. */
	private By comboUnidadeTempoInvest = By.cssSelector("a.btSelect");
	/** Locator da op��o Meses do combo da unidade de tempo do investimento. */
	private By opcaoUnidadeTempoInvestMeses = By.cssSelector("ul.listaSelect > li:nth-child(1) > a");
	/** Locator da op��o Anos do combo da unidade de tempo do investimento. */
	private By opcaoUnidadeTempoInvestAnos = By.cssSelector("ul.listaSelect > li:nth-child(2) > a");
	/** Locator do bot�o Simular. */
	private By botaoSimular = By.cssSelector("li.simular > button");
	/** Locator do link Limpar formul�rio. */
	private By linkLimparFormul�rio = By.cssSelector("a.btnLimpar");
	/** Locator da op��o 'Para Voc�' do radio tipo perfil. */
	private By radioPerfilPessoal = By.cssSelector("input[value='paraVoce']");
	/** Locator da op��o 'Para sua empresa ou agroneg�cio' do radio tipo perfil. */
	private By radioPerfilEmpresarial = By.cssSelector("input[value='paraEmpresa']");
	/** Locator do formul�rio do resultado da simula��o. */
	private By formsSimulacao = By.cssSelector("div.formularioBlocoResultado");

	/** Locator da mensagem do tempo de investimento no resultado da simula��o. */
	private By msgTempoInvestimento = By.cssSelector("div.blocoResultadoSimulacao > span.texto > strong");
	/** Locator da mensagem de erro no tempo de investimento. */
	private By msgErroTempoInvestimento = By.id("tempo-error");
	/** Locator da mensagem de erro na aplica��o inicial. */
	private By msgErroAplicacaoInicial = By.id("valorAplicar-error");
	/** Locator da mensagem de erro na aplica��o mensal. */
	private By msgErroAplicacaoMensal = By.id("valorInvestir-error");

	/**
	 * Preenche o valor da aplica��o inicial.
	 * 
	 * @param aplicacaoInicial Valor da aplica��o inicial.
	 */
	public void setAplicacaoInicial(String aplicacaoInicial) {
		escrever(campoAplicacaoInicial, aplicacaoInicial);
	}

	/**
	 * Preenche o valor da aplica��o mensal.
	 * 
	 * @param aplicacaoMensal Valor da aplica��o mensal.
	 */
	public void setAplicacaoMensal(String aplicacaoMensal) {
		escrever(campoAplicacaoMensal, aplicacaoMensal);
	}

	/**
	 * Preenche o tempo de investimento da simula��o no formato de meses.
	 * 
	 * @param tempoInvestimento Valor do tempo em meses.
	 */
	public void setTempoInvestimentoEmMeses(String tempoInvestimento) {
		setTempoInvestimento(tempoInvestimento, UnidadeTempo.MESES);
	}

	/**
	 * Preenche o tempo de investimento da simula��o no formato de anos.
	 * 
	 * @param tempoInvestimento Valor do tempo em anos.
	 */
	public void setTempoInvestimentoEmAnos(String tempoInvestimento) {
		setTempoInvestimento(tempoInvestimento, UnidadeTempo.ANOS);
	}

	/**
	 * Clica no bot�o Simular.
	 */
	public void simularInvestimento() {
		wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(botaoSimular)));
		wait.until(ExpectedConditions.elementToBeClickable(getDriver().findElement(botaoSimular)));
		clicarBotao(botaoSimular);
	}
	
	/**
	 * Clica no link Limpar formul�rio.
	 */
	public void limparFormulario() {
		wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(linkLimparFormul�rio)));
		wait.until(ExpectedConditions.elementToBeClickable(getDriver().findElement(linkLimparFormul�rio)));
		clicarLink(linkLimparFormul�rio);
	}

	/**
	 * Seleciona a op��o 'Para voc�' no radio tipo perfil.
	 */
	public void setPerfilPessoal() {
		clicarBotao(radioPerfilPessoal);
	}

	/**
	 * Seleciona a op��o 'Para sua empresa ou agroneg�cio' no radio tipo perfil.
	 */
	public void setPerfilEmpresarial() {
		clicarBotao(radioPerfilEmpresarial);
	}

	/**
	 * Obt�m a mensagem com o tempo de investimento do resultado da simula��o.
	 * 
	 * @return A mensagem contendo o tempo de investimento simulado.
	 */
	public String getMsgTempoInvestimento() {
		wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(msgTempoInvestimento)));
		return obterTexto(msgTempoInvestimento);
	}

	/**
	 * Obt�m a mensagem de erro do campo que cont�m o tempo de investimento.
	 * 
	 * @return A mensagem de erro.
	 */
	public String msgErroTempoInvestimento() {
		wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(msgErroTempoInvestimento)));
		return obterTexto(msgErroTempoInvestimento);
	}

	/**
	 * Obt�m a mensagem de erro do campo que cont�m a aplica��o inicial.
	 * 
	 * @return A mensagem de erro.
	 */
	public String msgErroAplicacaoInicial() {
		wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(msgErroAplicacaoInicial)));
		return obterTexto(msgErroAplicacaoInicial);
	}

	/**
	 * Obt�m a mensagem de erro do campo que cont�m a aplica��o mensal.
	 * 
	 * @return A mensagem de erro.
	 */
	public String msgErroAplicacaoMensal() {
		wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(msgErroAplicacaoMensal)));
		return obterTexto(msgErroAplicacaoMensal);
	}

	/**
	 * Verifica se o formul�rio do resultado da simula��o existe.
	 * 
	 * @return Se o formul�rio existir retorna true, sen�o false.
	 */
	public Boolean formularioSimulacaoInvestimentosVisivel() {
		wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(formsSimulacao)));

		if (obterTexto(formsSimulacao).contains("Tempo (Meses) Valor")) {
			return true;
		}

		return false;
	}

	/**
	 * Preenche o tempo de investimento da simula��o no formato de informado.
	 * 
	 * @param tempoInvestimento Per�odo do tempo de investimento.
	 * @param unidadeTempo      Formato do tempo.
	 */
	public void setTempoInvestimento(String tempoInvestimento, UnidadeTempo unidadeTempo) {
		escrever(campoTempoInvestimento, tempoInvestimento);
		clicarLink(comboUnidadeTempoInvest);

		switch (unidadeTempo) {
		case MESES:
			wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(opcaoUnidadeTempoInvestMeses)));
			wait.until(ExpectedConditions.elementToBeClickable(getDriver().findElement(opcaoUnidadeTempoInvestMeses)));
			clicarLink(opcaoUnidadeTempoInvestMeses);
			break;

		case ANOS:
			wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(opcaoUnidadeTempoInvestAnos)));
			wait.until(ExpectedConditions.elementToBeClickable(getDriver().findElement(opcaoUnidadeTempoInvestAnos)));
			clicarLink(opcaoUnidadeTempoInvestAnos);
			break;
		}
	}
}
