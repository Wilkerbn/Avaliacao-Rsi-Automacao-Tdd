package br.com.rsinet.hub.tdd.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub.tdd.pages.HomePage;
import br.com.rsinet.hub.tdd.suport.Generator;
import br.com.rsinet.hub.tdd.suport.Screenshot;
import br.com.rsinet.hub.tdd.suport.Web;
import br.com.rsinet.hub.tdd.utility.Constant;
import br.com.rsinet.hub.tdd.utility.ExcelUtils;

public class ConsultaDeProdutoCampoPesquisaTest {

	WebDriver driver = null;

	@BeforeMethod
	public void iniciaNavegador() throws Exception {
		driver = Web.createChrome();
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Produtos");
	}

	@Test
	public void pesquisaProdutoValidoCampoPesquisa() throws Exception {

		HomePage.clicaLupaParaPesquisarProduto(driver).click();
		HomePage.pesquisaProdutoLupa(driver).sendKeys(ExcelUtils.getCellData(3, 1));
		HomePage.selecionaProdutoLupa(driver, ExcelUtils.getCellData(3, 2)).click();
		Assert.assertEquals(ExcelUtils.getCellData(3, 2), HomePage.produtoLupaValidoObtido(driver));
		Screenshot.tirar(driver, "target/screenshot/" + Generator.dataHoraParaArquivo() + " pesquisaProdutoValidoCampoPesquisa.png");
	}

	@Test
	public void pesquisaProdutoInvalidoCampoPesquisa() throws Exception {

		HomePage.clicaLupaParaPesquisarProduto(driver).click();
		HomePage.pesquisaProdutoLupa(driver).sendKeys(ExcelUtils.getCellData(11, 0) + Keys.ENTER);
		Assert.assertEquals(ExcelUtils.getCellData(11, 1), HomePage.produtoLupaInvalidoObtido(driver));
		Screenshot.tirar(driver, "target/screenshot/" + Generator.dataHoraParaArquivo() + " pesquisaProdutoInvalidoCampoPesquisa.png");
	}

	@AfterMethod
	public void killDriver() {
		driver.quit();
	}

}
