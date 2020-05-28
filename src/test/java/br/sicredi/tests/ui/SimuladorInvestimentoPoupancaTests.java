package br.sicredi.tests.ui;

import static br.sicredi.core.Utils.*;
import static br.sicredi.pages.Mensagens.*;
import static org.junit.Assert.*;

import org.junit.Test;

import br.sicredi.core.BaseTest;
import br.sicredi.pages.SimuladorInvestimentosPage;

/**
 * Classe de testes do Simulador de Investimento - Poupança Sicredi.
 * 
 * @author Giovanni D. Brancher
 */
public class SimuladorInvestimentoPoupancaTests extends BaseTest {

	/** Page Object do Simulador de Investimento. */
	SimuladorInvestimentosPage simInvestPage = new SimuladorInvestimentosPage();

	/**
	 * Deve simular um investimento do tipo 'Para você' com sucesso.
	 */
	@Test
	public void deveSimularInvestimentoTipoParaVoce() {
		this.simInvestPage.setPerfilPessoal();
		this.simInvestPage.setAplicacaoInicial("500,00");
		this.simInvestPage.setAplicacaoMensal("30,00");
		this.simInvestPage.setTempoInvestimentoEmMeses("23");
		this.simInvestPage.simularInvestimento();
		assertEquals("23 meses", this.simInvestPage.getMsgTempoInvestimento());
		assertTrue(this.simInvestPage.formularioSimulacaoInvestimentosVisivel());
	}
	
	/**
	 * Deve simular um investimento do tipo 'Para sua empresa ou agronegócio' com sucesso.
	 */
	@Test
	public void deveSimularInvestimentoTipoParaSuaEmpresaOuAgronegocio() {
		this.simInvestPage.setPerfilEmpresarial();
		this.simInvestPage.setAplicacaoInicial("2000,00");
		this.simInvestPage.setAplicacaoMensal("300,00");
		this.simInvestPage.setTempoInvestimentoEmAnos("14");
		this.simInvestPage.simularInvestimento();
		assertEquals(obterAnosEmMeses("14") + " meses", this.simInvestPage.getMsgTempoInvestimento());
		assertTrue(this.simInvestPage.formularioSimulacaoInvestimentosVisivel());
	}

	@Test
	/**
	 * Não deve simular um investimento com campos obrigatórios em branco.
	 */
	public void naoDeveSimularInvestimentoComCamposObrigatoriosEmBranco() {
		this.simInvestPage.setPerfilEmpresarial();
		this.simInvestPage.simularInvestimento();
		assertEquals(msgCampoObrigatorio(), this.simInvestPage.msgErroTempoInvestimento());
		assertEquals(msgValorMinAplicacaoInicial(), this.simInvestPage.msgErroAplicacaoInicial());
		assertEquals(msgValorMinAplicacaoMensal(), this.simInvestPage.msgErroAplicacaoMensal());
	}
	
	/**
	 * Não deve simular um investimento após limpar o formulário.
	 */
	@Test
	public void naoDeveSimularInvestimentoAposLimparFormulario() {
		this.simInvestPage.setPerfilEmpresarial();
		this.simInvestPage.simularInvestimento();
		this.simInvestPage.setAplicacaoInicial("2000,00");
		this.simInvestPage.setAplicacaoMensal("300,00");
		this.simInvestPage.setTempoInvestimentoEmAnos("10");
		this.simInvestPage.limparFormulario();
		this.simInvestPage.simularInvestimento();
		assertEquals(msgCampoObrigatorio(), this.simInvestPage.msgErroTempoInvestimento());
		assertEquals(msgValorMinAplicacaoInicial(), this.simInvestPage.msgErroAplicacaoInicial());
		assertEquals(msgValorMinAplicacaoMensal(), this.simInvestPage.msgErroAplicacaoMensal());
	}

	/**
	 * Não deve simular um investimento com tempo zero.
	 */
	@Test
	public void naoDeveSimularInvestimentoComTempoZero() {
		this.simInvestPage.setPerfilEmpresarial();
		this.simInvestPage.simularInvestimento();
		this.simInvestPage.setAplicacaoInicial("850,00");
		this.simInvestPage.setAplicacaoMensal("150,00");
		this.simInvestPage.setTempoInvestimentoEmAnos("0");
		this.simInvestPage.simularInvestimento();
		assertEquals(msgValorEsperadoNaoConfere(), this.simInvestPage.msgErroTempoInvestimento());
	}
	
	/**
	 * Não deve simular um investimento com Aplicação Inicial INFERIOR a 20 reais.
	 */
	@Test
	public void naoDeveSimularInvestimentoComAplicacaoInicialInferior20Reais() {
		this.simInvestPage.setPerfilPessoal();
		this.simInvestPage.setAplicacaoInicial("19,99");
		this.simInvestPage.setAplicacaoMensal("100,00");
		this.simInvestPage.setTempoInvestimentoEmAnos("3");
		this.simInvestPage.simularInvestimento();
		assertEquals(msgValorMinAplicacaoInicial(), this.simInvestPage.msgErroAplicacaoInicial());
	}

	/**
	 * Deve simular um investimento com Aplicação Inicial IGUAL a 20 reais.
	 */
	@Test
	public void deveSimularInvestimentoComAplicacaoInicialIgual20Reais() {
		this.simInvestPage.setPerfilPessoal();
		this.simInvestPage.setAplicacaoInicial("20,00");
		this.simInvestPage.setAplicacaoMensal("30,00");
		this.simInvestPage.setTempoInvestimentoEmAnos("4");
		this.simInvestPage.simularInvestimento();
		assertEquals(obterAnosEmMeses("4") + " meses", this.simInvestPage.getMsgTempoInvestimento());
		assertTrue(this.simInvestPage.formularioSimulacaoInvestimentosVisivel());
	}

	/**
	 * Deve simular um investimento com Aplicação Inicial SUPERIOR a 20 reais.
	 */
	@Test
	public void deveSimularInvestimentoComAplicacaoInicialSuperior20Reais() {
		this.simInvestPage.setPerfilPessoal();
		this.simInvestPage.setAplicacaoInicial("20,01");
		this.simInvestPage.setAplicacaoMensal("975,00");
		this.simInvestPage.setTempoInvestimentoEmAnos("5");
		this.simInvestPage.simularInvestimento();
		assertEquals(obterAnosEmMeses("5") + " meses", this.simInvestPage.getMsgTempoInvestimento());
		assertTrue(this.simInvestPage.formularioSimulacaoInvestimentosVisivel());
	}

	/**
	 * Não deve simular um investimento com Aplicação Mensal INFERIOR a 20 reais.
	 */
	@Test
	public void naoDeveSimularInvestimentoComAplicacaoMensalInferior20Reais() {
		this.simInvestPage.setPerfilPessoal();
		this.simInvestPage.setAplicacaoInicial("200,00");
		this.simInvestPage.setAplicacaoMensal("19,99");
		this.simInvestPage.setTempoInvestimentoEmMeses("18");
		this.simInvestPage.simularInvestimento();
		assertEquals(msgValorMinAplicacaoMensal(), this.simInvestPage.msgErroAplicacaoMensal());
	}

	/**
	 * Deve simular um investimento com Aplicação Mensal IGUAL a 20 reais.
	 */
	@Test
	public void deveSimularInvestimentoComAplicacaoMensalIgual20Reais() {
		this.simInvestPage.setPerfilPessoal();
		this.simInvestPage.setAplicacaoInicial("450,00");
		this.simInvestPage.setAplicacaoMensal("20,00");
		this.simInvestPage.setTempoInvestimentoEmMeses("10");
		this.simInvestPage.simularInvestimento();
		assertEquals("10 meses", this.simInvestPage.getMsgTempoInvestimento());
		assertTrue(this.simInvestPage.formularioSimulacaoInvestimentosVisivel());
	}

	/**
	 * Deve simular um investimento com Aplicação Mensal SUPERIOR a 20 reais.
	 */
	@Test
	public void deveSimularInvestimentoComAplicacaoMensalSuperior20Reais() {
		this.simInvestPage.setPerfilPessoal();
		this.simInvestPage.setAplicacaoInicial("90,00");
		this.simInvestPage.setAplicacaoMensal("20,01");
		this.simInvestPage.setTempoInvestimentoEmMeses("14");
		this.simInvestPage.simularInvestimento();
		assertEquals("14 meses", this.simInvestPage.getMsgTempoInvestimento());
		assertTrue(this.simInvestPage.formularioSimulacaoInvestimentosVisivel());
	}

	/**
	 * Não deve simular um investimento com Aplicação Inicial e Mensal inferior a 20 reais.
	 */
	@Test
	public void naoDeveSimularInvestimentoComAplicacaoInicialEMensalInferior20Reais() {
		this.simInvestPage.setPerfilPessoal();
		this.simInvestPage.setAplicacaoInicial("19,99");
		this.simInvestPage.setAplicacaoMensal("19,99");
		this.simInvestPage.setTempoInvestimentoEmMeses("30");
		this.simInvestPage.simularInvestimento();
		assertEquals(msgValorMinAplicacaoInicial(), this.simInvestPage.msgErroAplicacaoInicial());
		assertEquals(msgValorMinAplicacaoMensal(), this.simInvestPage.msgErroAplicacaoMensal());
	}
}
