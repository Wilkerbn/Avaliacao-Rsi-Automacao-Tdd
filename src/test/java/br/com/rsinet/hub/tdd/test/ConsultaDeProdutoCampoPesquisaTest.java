package br.com.rsinet.hub.tdd.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub.tdd.pages.HomePage;
import br.com.rsinet.hub.tdd.suport.Web;
import br.com.rsinet.hub.tdd.utility.Constant;
import br.com.rsinet.hub.tdd.utility.ExcelUtils;

public class ConsultaDeProdutoCampoPesquisaTest {

	WebDriver driver = null;

	@Before
	public void iniciaNavegador() throws Exception {
		driver = Web.createChrome();
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
	}

	@Test
	public void pesquisaProdutoValidoCampoPesquisa() throws Exception {
		String produtoEsperado = ExcelUtils.getCellData(1, 13);

		HomePage.clicaLupaParaPesquisarProduto(driver).click();
		HomePage.pesquisaProdutoLupa(driver).sendKeys(ExcelUtils.getCellData(1, 12));
		HomePage.selecionaProdutoLupa(driver, produtoEsperado).click();

		Assert.assertEquals(produtoEsperado, HomePage.produtoObtido(driver));
	}

	@Test
	public void pesquisaProdutoInvalidoCampoPesquisa() throws Exception {
		String produtoEsperado = ExcelUtils.getCellData(1, 17); 

		HomePage.clicaLupaParaPesquisarProduto(driver).click();
		HomePage.pesquisaProdutoLupa(driver).sendKeys(ExcelUtils.getCellData(1, 16) + Keys.ENTER);
		
		Assert.assertEquals(produtoEsperado, HomePage.produtoInvalidoObtido(driver));
	}

	@After
	public void killDriver() {
		// driver.quit();
	}

}
