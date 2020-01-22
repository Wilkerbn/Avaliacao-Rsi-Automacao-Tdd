package br.com.rsinet.hub.tdd.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub.tdd.pages.HomePage;
import br.com.rsinet.hub.tdd.suport.Generator;
import br.com.rsinet.hub.tdd.suport.Screenshot;
import br.com.rsinet.hub.tdd.suport.Web;
import br.com.rsinet.hub.tdd.utility.Constant;
import br.com.rsinet.hub.tdd.utility.Report;

public class ConsultaDeProdutoTelaPrincipalTest extends Constant{

	WebDriver driver = null;
	HomePage homepage;
	ExtentTest test;
	public ExtentReports extent;
	
	@BeforeTest
	public void iniciaReport() {
		extent = Report.setExtent();
	}

	@BeforeMethod
	public void iniciaNavegador() throws Exception {
		driver = Web.createChrome();
		homepage = new HomePage(driver);
		//ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Produtos");
		Constant.recebeDadosDoExcel("Produtos");
	}

	@Test
	public void pesquisaProdutoValidoTelaPrincipal() throws Exception {
		test = Report.setUp("pesquisaProdutoValidoTelaPrincipal");
		
		HomePage.pesquisaCategoriaTelaPrincipal(Constant.categoria().toUpperCase()).click();
		HomePage.pesquisaProdutoTela(Constant.produtoValido()).click();
		Assert.assertEquals(Constant.produtoValido().toUpperCase(), HomePage.produtoTelaPrincipalValidoObtido(Constant.produtoValido().toUpperCase()));
		
		Screenshot.tirar(driver, "target/screenshot/" + Generator.dataHoraParaArquivo() + " pesquisaProdutoValidoTelaPrincipal.png");
	}

	@Test
	public void pesquisaProdutoQuantidadeInvalidaTelaPrincipal() throws Exception {
		test = Report.setUp("cadastroDuplicado");
		
		HomePage.pesquisaCategoriaTelaPrincipal(Constant.categoria().toUpperCase()).click();
		HomePage.pesquisaProdutoTela(Constant.produtoValido()).click();
		HomePage.digitaQuantidadeDeProdutos().sendKeys(Constant.quantidadeDeProdutosDoCarrinho());
		HomePage.inserirProdutosCarrinho().click();
		Assert.assertEquals(Constant.mensagemEsperadaParaQuantidadeDeProdutosInvalidos(), HomePage.valorInvalidoDeProdutos());
		
		Screenshot.tirar(driver, "target/screenshot/" + Generator.dataHoraParaArquivo() + " pesquisaProdutoQuantidadeInvalidaTelaPrincipal.png");
	}

	@AfterMethod
	public void killDriver(ITestResult result) throws IOException {
		
		Report.tearDown(result, test);
		Report.closeReport(extent);
		driver.quit();
	}

}
