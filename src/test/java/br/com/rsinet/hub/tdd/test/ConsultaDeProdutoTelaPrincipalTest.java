package br.com.rsinet.hub.tdd.test;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
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
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
	}

	@Test
	public void pesquisaProdutoValidoTelaPrincipal() throws Exception {
		String categoria = ExcelUtils.getCellData(1, 14);
		String produto = ExcelUtils.getCellData(1, 15);
		String resultadoEsperado = ExcelUtils.getCellData(4, 0);

		HomePage.pesquisaCategoriaTelaPrincipal(driver, categoria).click();
		HomePage.pesquisaProdutoTela(driver, produto).click();

		AssertJUnit.assertEquals(resultadoEsperado, HomePage.produtoTelaPrincipalValidoObtido(driver));
		Screenshot.tirar(driver, "target/screenshot/" + Generator.dataHoraParaArquivo() + " pesquisaProdutoValidoTelaPrincipal.png");
	}

	@Test
	public void pesquisaProdutoQuantidadeInvalidaTelaPrincipal() throws Exception {
		String categoria = ExcelUtils.getCellData(1, 14);
		String produto = ExcelUtils.getCellData(1, 15);
		String resultadoEsperado = ExcelUtils.getCellData(4, 1);

		HomePage.pesquisaCategoriaTelaPrincipal(driver, categoria).click();
		HomePage.pesquisaProdutoTela(driver, produto).click();

		HomePage.digitaQuantidadeDeProdutos(driver).sendKeys("999");
		HomePage.inserirProdutosCarrinho(driver).click();

		AssertJUnit.assertEquals(resultadoEsperado, HomePage.valorInvalidoDeProdutos(driver));
		Screenshot.tirar(driver, "target/screenshot/" + Generator.dataHoraParaArquivo() + " pesquisaProdutoQuantidadeInvalidaTelaPrincipal.png");

	}

	@AfterMethod
	public void killDriver() {
		driver.quit();
	}

}
