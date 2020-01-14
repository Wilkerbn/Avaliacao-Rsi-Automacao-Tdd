package br.com.rsinet.hub.tdd.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub.tdd.pages.InfoFormPage;
import br.com.rsinet.hub.tdd.pages.LoginPage;
import br.com.rsinet.hub.tdd.suport.Generator;
import br.com.rsinet.hub.tdd.suport.Screenshot;
import br.com.rsinet.hub.tdd.suport.Web;
import br.com.rsinet.hub.tdd.utility.Constant;
import br.com.rsinet.hub.tdd.utility.ExcelUtils;

public class CadastroDeUsuarioTest {

	WebDriver driver = null;

	@Before
	public void iniciaNavegador() throws Exception {
		driver = Web.createChrome();
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
	}

	@Test
	public void cadastroValido() throws Exception {
		
		LoginPage.botaoUsuario(driver).click();
		LoginPage.criarNovaConta(driver).sendKeys(Keys.ENTER);
		InfoFormPage.campoApelido(driver).sendKeys(ExcelUtils.getCellData(1, 0));
		InfoFormPage.campoSenha(driver).sendKeys(ExcelUtils.getCellData(1, 1));
		InfoFormPage.campoConfirmaSenha(driver).sendKeys(ExcelUtils.getCellData(1, 2));
		InfoFormPage.campoEmail(driver).sendKeys(ExcelUtils.getCellData(1, 3));
		InfoFormPage.campoPrimeiroNome(driver).sendKeys(ExcelUtils.getCellData(1, 4));
		InfoFormPage.campoUltimoNome(driver).sendKeys(ExcelUtils.getCellData(1, 5));
		InfoFormPage.campoTelefone(driver).sendKeys(ExcelUtils.getCellData(1, 6));
		InfoFormPage.campoPais(driver).selectByVisibleText(ExcelUtils.getCellData(1, 7));
		InfoFormPage.campoCidade(driver).sendKeys(ExcelUtils.getCellData(1, 8));
		InfoFormPage.campoEndereco(driver).sendKeys(ExcelUtils.getCellData(1, 9));
		InfoFormPage.campoEstado(driver).sendKeys(ExcelUtils.getCellData(1, 10));
		InfoFormPage.campoCep(driver).sendKeys(ExcelUtils.getCellData(1, 11));
		InfoFormPage.campoAceitaTermos(driver).click();
		InfoFormPage.botaoRegistra(driver).click();
		
		assertEquals(ExcelUtils.getCellData(1, 0), InfoFormPage.capturaTexto(driver));
		Screenshot.tirar(driver, "target/screenshot/" + Generator.dataHoraParaArquivo() + " cadastroValido.png");
	}

	@Test
	public void cadastroDuplicado() throws Exception {

		LoginPage.botaoUsuario(driver).click();
		LoginPage.criarNovaConta(driver).sendKeys(Keys.ENTER);
		InfoFormPage.campoApelido(driver).sendKeys(ExcelUtils.getCellData(1, 0));
		InfoFormPage.campoSenha(driver).sendKeys(ExcelUtils.getCellData(1, 1));
		InfoFormPage.campoConfirmaSenha(driver).sendKeys(ExcelUtils.getCellData(1, 2));
		InfoFormPage.campoEmail(driver).sendKeys(ExcelUtils.getCellData(1, 3));
		InfoFormPage.campoPrimeiroNome(driver).sendKeys(ExcelUtils.getCellData(1, 4));
		InfoFormPage.campoUltimoNome(driver).sendKeys(ExcelUtils.getCellData(1, 5));
		InfoFormPage.campoTelefone(driver).sendKeys(ExcelUtils.getCellData(1, 6));
		InfoFormPage.campoPais(driver).selectByVisibleText(ExcelUtils.getCellData(1, 7));
		InfoFormPage.campoCidade(driver).sendKeys(ExcelUtils.getCellData(1, 8));
		InfoFormPage.campoEndereco(driver).sendKeys(ExcelUtils.getCellData(1, 9));
		InfoFormPage.campoEstado(driver).sendKeys(ExcelUtils.getCellData(1, 10));
		InfoFormPage.campoCep(driver).sendKeys(ExcelUtils.getCellData(1, 11));
		InfoFormPage.campoAceitaTermos(driver).click();
		InfoFormPage.botaoRegistra(driver).click();
		
		assertEquals(ExcelUtils.getCellData(1, 18), InfoFormPage.capturaTextoCadastroDuplicado(driver));
		Screenshot.tirar(driver, "target/screenshot/" + Generator.dataHoraParaArquivo() + " cadastroDuplicado.png");

	}


		
	
	
	@After
	public void killDriver() {
		//driver.quit();
	}

}
