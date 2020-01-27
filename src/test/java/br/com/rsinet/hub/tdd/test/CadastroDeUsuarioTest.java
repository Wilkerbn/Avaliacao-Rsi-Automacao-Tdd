package br.com.rsinet.hub.tdd.test;

import static org.testng.AssertJUnit.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub.tdd.pages.InfoFormPage;
import br.com.rsinet.hub.tdd.pages.LoginPage;
import br.com.rsinet.hub.tdd.suport.Web;
import br.com.rsinet.hub.tdd.utility.Constant;
import br.com.rsinet.hub.tdd.utility.Report;

public class CadastroDeUsuarioTest extends Constant{

	WebDriver driver = null;
	InfoFormPage infoFormPage; 
	LoginPage loginPage; 
	ExtentTest test;
	public ExtentReports extent;

	@BeforeTest
	public void iniciaReport() {
		extent = Report.setExtent();
	}
	
	@BeforeMethod
	public void iniciaNavegador() throws Exception {
		driver = Web.createChrome();
		infoFormPage = new InfoFormPage(driver);
		loginPage = new LoginPage(driver);
		Constant.recebeDadosDoExcel("Cadastro");
	}

	@Test 
	public void cadastro() throws Exception {
		test = Report.setUp("cadastro");
		LoginPage.acessaCriarConta();
		InfoFormPage.efetuaCadastro();
		assertEquals(apelido(), InfoFormPage.capturaTexto());
	}

	@Test
	public void cadastroDuplicado() throws Exception {
		test = Report.setUp("cadastroDuplicado");
		LoginPage.acessaCriarConta();
		InfoFormPage.efetuaCadastro();
		assertEquals(Constant.usuarioJaExistente(), InfoFormPage.capturaTextoCadastroDuplicado());
	}
	
	@AfterMethod
	public void killDriver(ITestResult result) throws IOException {
		Report.tearDown(result, test, driver);
		Report.closeReport(extent);
		Web.killDriver(driver);
	}

}
