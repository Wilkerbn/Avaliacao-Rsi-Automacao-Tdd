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
import br.com.rsinet.hub.tdd.suport.Web;
import br.com.rsinet.hub.tdd.utility.Constant;
import br.com.rsinet.hub.tdd.utility.JsonUtils;

import br.com.rsinet.hub.tdd.utility.Report;

public class ConsultaDeProdutoTelaPrincipalTest {

	WebDriver driver = null;
	HomePage homepage;
	ExtentTest test;
	public ExtentReports extent;
	JsonUtils dadosCarregados = new JsonUtils();
	
	@BeforeTest
	public void iniciaReport() {
		extent = Report.setExtent();
	}

	@BeforeMethod
	public void iniciaNavegador() throws Exception {
		driver = Web.createChrome();
		homepage = new HomePage(driver);
		Constant.recebeDadosDoExcel("Produtos");
	}

	@Test
	public void pesquisaProdutoValidoTelaPrincipal() throws Exception {
		test = Report.setUp("pesquisaProdutoValidoTelaPrincipal");
		HomePage.consultaProdutoValidoTelaPrincipal();
		Assert.assertEquals(Constant.produtoValido().toUpperCase(), HomePage.produtoTelaPrincipalValidoObtido(Constant.produtoValido().toUpperCase()));
	}

	@Test
	public void pesquisaProdutoQuantidadeInvalidaTelaPrincipal() throws Exception {
		test = Report.setUp("pesquisaProdutoQuantidadeInvalidaTelaPrincipal");
		HomePage.consultaProdutoComQuantidadeInvalidaTelaPrincipal();
		Assert.assertEquals(Constant.mensagemEsperadaParaQuantidadeDeProdutosInvalidos(), HomePage.valorInvalidoDeProdutos());
	}

	@AfterMethod
	public void killDriver(ITestResult result) throws IOException {
		Report.tearDown(result, test, driver);
		Report.closeReport(extent);
		Web.killDriver(driver);
	}

}
