package br.com.rsinet.hub.tdd.test;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub.tdd.pages.InfoFormPage;
import br.com.rsinet.hub.tdd.pages.LoginPage;
import br.com.rsinet.hub.tdd.suport.Generator;
import br.com.rsinet.hub.tdd.suport.Screenshot;
import br.com.rsinet.hub.tdd.suport.Web;
import br.com.rsinet.hub.tdd.utility.Constant;
import br.com.rsinet.hub.tdd.utility.ExcelUtils;

public class CadastroDeUsuarioTest extends Constant{

	WebDriver driver = null;

	@BeforeMethod
	public void iniciaNavegador() throws Exception {
		driver = Web.createChrome();
		//ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Cadastro");
		Constant.recebeDadosDoExcel("Cadastro");
	}

	@Test 
	public void cadastro() throws Exception {
		
		
		LoginPage.botaoUsuario(driver).click();
		LoginPage.criarNovaConta(driver).sendKeys(Keys.ENTER);
		InfoFormPage.campoApelido(driver).sendKeys(Constant.campoApelido());
		InfoFormPage.campoSenha(driver).sendKeys(Constant.campoSenha());
		InfoFormPage.campoConfirmaSenha(driver).sendKeys(Constant.campoConfirmaSenha());
		InfoFormPage.campoEmail(driver).sendKeys(Constant.campoEmail());
		InfoFormPage.campoPrimeiroNome(driver).sendKeys(ExcelUtils.getCellData(5, 1));
		InfoFormPage.campoUltimoNome(driver).sendKeys(ExcelUtils.getCellData(6, 1));
		InfoFormPage.campoTelefone(driver).sendKeys(ExcelUtils.getCellData(7, 1));
		InfoFormPage.campoPais(driver).selectByVisibleText(ExcelUtils.getCellData(8, 1));
		InfoFormPage.campoCidade(driver).sendKeys(ExcelUtils.getCellData(9, 1));
		InfoFormPage.campoEndereco(driver).sendKeys(ExcelUtils.getCellData(10, 1));
		InfoFormPage.campoEstado(driver).sendKeys(ExcelUtils.getCellData(11, 1));
		InfoFormPage.campoCep(driver).sendKeys(ExcelUtils.getCellData(12, 1));
		InfoFormPage.campoAceitaTermos(driver).click();
		InfoFormPage.botaoRegistra(driver).click();
		assertEquals(ExcelUtils.getCellData(1, 1), InfoFormPage.capturaTexto(driver));
		Screenshot.tirar(driver, "target/screenshot/" + Generator.dataHoraParaArquivo() + " cadastroValido.png");
	}

	@Test
	public void cadastroDuplicado() throws Exception {
		LoginPage.botaoUsuario(driver).click();
		LoginPage.criarNovaConta(driver).sendKeys(Keys.ENTER);
		InfoFormPage.campoApelido(driver).sendKeys(ExcelUtils.getCellData(1, 1));
		InfoFormPage.campoSenha(driver).sendKeys(ExcelUtils.getCellData(2, 1));
		InfoFormPage.campoConfirmaSenha(driver).sendKeys(ExcelUtils.getCellData(3, 1));
		InfoFormPage.campoEmail(driver).sendKeys(ExcelUtils.getCellData(4, 1));
		InfoFormPage.campoPrimeiroNome(driver).sendKeys(ExcelUtils.getCellData(5, 1));
		InfoFormPage.campoUltimoNome(driver).sendKeys(ExcelUtils.getCellData(6, 1));
		InfoFormPage.campoTelefone(driver).sendKeys(ExcelUtils.getCellData(7, 1));
		InfoFormPage.campoPais(driver).selectByVisibleText(ExcelUtils.getCellData(8, 1));
		InfoFormPage.campoCidade(driver).sendKeys(ExcelUtils.getCellData(9, 1));
		InfoFormPage.campoEndereco(driver).sendKeys(ExcelUtils.getCellData(10, 1));
		InfoFormPage.campoEstado(driver).sendKeys(ExcelUtils.getCellData(11, 1));
		InfoFormPage.campoCep(driver).sendKeys(ExcelUtils.getCellData(12, 1));
		InfoFormPage.campoAceitaTermos(driver).click();
		InfoFormPage.botaoRegistra(driver).click();
		assertEquals(ExcelUtils.getCellData(13,1), InfoFormPage.capturaTextoCadastroDuplicado(driver));
		Screenshot.tirar(driver, "target/screenshot/" + Generator.dataHoraParaArquivo() + " cadastroDuplicado.png");
	}
	
	@AfterMethod
	public void killDriver() {
		driver.quit();
	}

}
