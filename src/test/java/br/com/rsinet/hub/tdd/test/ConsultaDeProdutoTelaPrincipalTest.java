package br.com.rsinet.hub.tdd.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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

public class ConsultaDeProdutoTelaPrincipalTest {

	WebDriver driver = null;

	@BeforeMethod
	public void iniciaNavegador() throws Exception {
		driver = Web.createChrome();
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Produtos");
	}

	@Test
	public void pesquisaProdutoValidoTelaPrincipal() throws Exception {
				
		HomePage.pesquisaCategoriaTelaPrincipal(driver, ExcelUtils.getCellData(4, 0).toUpperCase()).click();
		HomePage.pesquisaProdutoTela(driver, ExcelUtils.getCellData(4, 1)).click();
		Assert.assertEquals(ExcelUtils.getCellData(4, 2), HomePage.produtoTelaPrincipalValidoObtido(driver, ExcelUtils.getCellData(4, 1)));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000);");
		Screenshot.tirar(driver, "target/screenshot/" + Generator.dataHoraParaArquivo() + " pesquisaProdutoValidoTelaPrincipal.png");
	}

	@Test
	public void pesquisaProdutoQuantidadeInvalidaTelaPrincipal() throws Exception {
		
		HomePage.pesquisaCategoriaTelaPrincipal(driver, ExcelUtils.getCellData(2, 0).toUpperCase()).click();
		HomePage.pesquisaProdutoTela(driver, ExcelUtils.getCellData(2, 1)).click();
		HomePage.digitaQuantidadeDeProdutos(driver).sendKeys(ExcelUtils.getCellData(7, 0));
		HomePage.inserirProdutosCarrinho(driver).click();
		Assert.assertEquals(ExcelUtils.getCellData(7, 1), HomePage.valorInvalidoDeProdutos(driver));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scrollBy(0,200)", "");
		Screenshot.tirar(driver, "target/screenshot/" + Generator.dataHoraParaArquivo() + " pesquisaProdutoQuantidadeInvalidaTelaPrincipal.png");

	}

	@AfterMethod
	public void killDriver() {
		driver.quit();
	}

}
