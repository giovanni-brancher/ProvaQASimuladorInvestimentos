package br.sicredi.pages;

import static br.sicredi.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.sicredi.core.BasePage;
import br.sicredi.core.Propriedades.UnidadeTempo;

/**
 * Classe com os locators e os métodos utilizados no Page Object
 * do Simulador de Investimentos - Poupança Sicredi.
 * 
 * @author Giovanni D. Brancher
 */
public class SimuladorInvestimentosPage extends BasePage {

	/** Definição para esperas explícitas. */
	WebDriverWait wait = new WebDriverWait(getDriver(), 15);

	/** Locator da aplicação inicial. */
	private By campoAplicacaoInicial = By.id("valorAplicar");
	/** Locator da aplicação mensal. */
	private By campoAplicacaoMensal = By.id("valorInvestir");
	/** Locator do tempo de investimento. */
	private By campoTempoInvestimento = By.id("tempo");
	/** Locator do combo da unidade de tempo do investimento. */
	private By comboUnidadeTempoInvest = By.cssSelector("a.btSelect");
	/** Locator da opção Meses do combo da unidade de tempo do investimento. */
	private By opcaoUnidadeTempoInvestMeses = By.cssSelector("ul.listaSelect > li:nth-child(1) > a");
	/** Locator da opção Anos do combo da unidade de tempo do investimento. */
	private By opcaoUnidadeTempoInvestAnos = By.cssSelector("ul.listaSelect > li:nth-child(2) > a");
	/** Locator do botão Simular. */
	private By botaoSimular = By.cssSelector("li.simular > button");
	/** Locator do link Limpar formulário. */
	private By linkLimparFormulário = By.cssSelector("a.btnLimpar");
	/** Locator da opção 'Para Você' do radio tipo perfil. */
	private By radioPerfilPessoal = By.cssSelector("input[value='paraVoce']");
	/** Locator da opção 'Para sua empresa ou agronegócio' do radio tipo perfil. */
	private By radioPerfilEmpresarial = By.cssSelector("input[value='paraEmpresa']");
	/** Locator do formulário do resultado da simulação. */
	private By formsSimulacao = By.cssSelector("div.formularioBlocoResultado");

	/** Locator da mensagem do tempo de investimento no resultado da simulação. */
	private By msgTempoInvestimento = By.cssSelector("div.blocoResultadoSimulacao > span.texto > strong");
	/** Locator da mensagem de erro no tempo de investimento. */
	private By msgErroTempoInvestimento = By.id("tempo-error");
	/** Locator da mensagem de erro na aplicação inicial. */
	private By msgErroAplicacaoInicial = By.id("valorAplicar-error");
	/** Locator da mensagem de erro na aplicação mensal. */
	private By msgErroAplicacaoMensal = By.id("valorInvestir-error");

	/**
	 * Preenche o valor da aplicação inicial.
	 * 
	 * @param aplicacaoInicial Valor da aplicação inicial.
	 */
	public void setAplicacaoInicial(String aplicacaoInicial) {
		escrever(campoAplicacaoInicial, aplicacaoInicial);
	}

	/**
	 * Preenche o valor da aplicação mensal.
	 * 
	 * @param aplicacaoMensal Valor da aplicação mensal.
	 */
	public void setAplicacaoMensal(String aplicacaoMensal) {
		escrever(campoAplicacaoMensal, aplicacaoMensal);
	}

	/**
	 * Preenche o tempo de investimento da simulação no formato de meses.
	 * 
	 * @param tempoInvestimento Valor do tempo em meses.
	 */
	public void setTempoInvestimentoEmMeses(String tempoInvestimento) {
		setTempoInvestimento(tempoInvestimento, UnidadeTempo.MESES);
	}

	/**
	 * Preenche o tempo de investimento da simulação no formato de anos.
	 * 
	 * @param tempoInvestimento Valor do tempo em anos.
	 */
	public void setTempoInvestimentoEmAnos(String tempoInvestimento) {
		setTempoInvestimento(tempoInvestimento, UnidadeTempo.ANOS);
	}

	/**
	 * Clica no botão Simular.
	 */
	public void simularInvestimento() {
		wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(botaoSimular)));
		wait.until(ExpectedConditions.elementToBeClickable(getDriver().findElement(botaoSimular)));
		clicarBotao(botaoSimular);
	}
	
	/**
	 * Clica no link Limpar formulário.
	 */
	public void limparFormulario() {
		wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(linkLimparFormulário)));
		wait.until(ExpectedConditions.elementToBeClickable(getDriver().findElement(linkLimparFormulário)));
		clicarLink(linkLimparFormulário);
	}

	/**
	 * Seleciona a opção 'Para você' no radio tipo perfil.
	 */
	public void setPerfilPessoal() {
		clicarBotao(radioPerfilPessoal);
	}

	/**
	 * Seleciona a opção 'Para sua empresa ou agronegócio' no radio tipo perfil.
	 */
	public void setPerfilEmpresarial() {
		clicarBotao(radioPerfilEmpresarial);
	}

	/**
	 * Obtém a mensagem com o tempo de investimento do resultado da simulação.
	 * 
	 * @return A mensagem contendo o tempo de investimento simulado.
	 */
	public String getMsgTempoInvestimento() {
		wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(msgTempoInvestimento)));
		return obterTexto(msgTempoInvestimento);
	}

	/**
	 * Obtém a mensagem de erro do campo que contém o tempo de investimento.
	 * 
	 * @return A mensagem de erro.
	 */
	public String msgErroTempoInvestimento() {
		wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(msgErroTempoInvestimento)));
		return obterTexto(msgErroTempoInvestimento);
	}

	/**
	 * Obtém a mensagem de erro do campo que contém a aplicação inicial.
	 * 
	 * @return A mensagem de erro.
	 */
	public String msgErroAplicacaoInicial() {
		wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(msgErroAplicacaoInicial)));
		return obterTexto(msgErroAplicacaoInicial);
	}

	/**
	 * Obtém a mensagem de erro do campo que contém a aplicação mensal.
	 * 
	 * @return A mensagem de erro.
	 */
	public String msgErroAplicacaoMensal() {
		wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(msgErroAplicacaoMensal)));
		return obterTexto(msgErroAplicacaoMensal);
	}

	/**
	 * Verifica se o formulário do resultado da simulação existe.
	 * 
	 * @return Se o formulário existir retorna true, senão false.
	 */
	public Boolean formularioSimulacaoInvestimentosVisivel() {
		wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(formsSimulacao)));

		if (obterTexto(formsSimulacao).contains("Tempo (Meses) Valor")) {
			return true;
		}

		return false;
	}

	/**
	 * Preenche o tempo de investimento da simulação no formato de informado.
	 * 
	 * @param tempoInvestimento Período do tempo de investimento.
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
