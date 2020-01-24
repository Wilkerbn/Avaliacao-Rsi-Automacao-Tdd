package br.com.rsinet.hub.tdd.test;

import java.io.IOException;

import org.openqa.selenium.Keys;
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
import br.com.rsinet.hub.tdd.suport.Web;
import br.com.rsinet.hub.tdd.utility.Constant;
import br.com.rsinet.hub.tdd.utility.Report;

public class ConsultaDeProdutoCampoPesquisaTest extends Constant {

	WebDriver driver = null;
	HomePage homePage;
	ExtentTest test;
	public ExtentReports extent;
	
	@BeforeTest
	public void iniciaReport() {
		extent = Report.setExtent();
	}

	@BeforeMethod
	public void iniciaNavegador() throws Exception {
		driver = Web.createChrome();
		homePage = new HomePage(driver);
		Constant.recebeDadosDoExcel("Produtos");
	}

	@Test
	public void pesquisaProdutoValidoCampoPesquisa() throws Exception {
		test = Report.setUp("pesquisaProdutoValidoCampoPesquisa");
		
		HomePage.clicaLupaParaPesquisarProduto().click();
		HomePage.pesquisaProdutoLupa().sendKeys(Constant.produtoValido());
		HomePage.selecionaProdutoLupa(Constant.produtoValido().toUpperCase()).click();
		Assert.assertEquals(Constant.produtoValido().toUpperCase(), HomePage.produtoLupaValidoObtido());
		
	}

	@Test
	public void pesquisaProdutoInvalidoCampoPesquisa() throws Exception {
		test = Report.setUp("pesquisaProdutoInvalidoCampoPesquisa");
		
		HomePage.clicaLupaParaPesquisarProduto().click();
		HomePage.pesquisaProdutoLupa().sendKeys(Constant.produtoInvalido() + Keys.ENTER);
		Assert.assertEquals(Constant.mensagemEsperadaParaProdutoInvalidoObtido(), HomePage.produtoLupaInvalidoObtido());
		
	}

	@AfterMethod
	public void killDriver(ITestResult result) throws IOException {
		
		Report.tearDown(result, test, driver);
		Report.closeReport(extent);
		Web.killDriver(driver);
	}

}
