package br.com.rsinet.hub.tdd.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub.tdd.pages.HomePage;
import br.com.rsinet.hub.tdd.pages.InfoFormPage;
import br.com.rsinet.hub.tdd.suport.Web;
import br.com.rsinet.hub.tdd.utility.Constant;
import br.com.rsinet.hub.tdd.utility.ExcelUtils;

public class ConsultaDeProdutoTelaPrincipalTest {

	WebDriver driver = null;

	@Before
	public void iniciaNavegador() throws Exception {
		driver = Web.createChrome();
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Planilha1");
	}

	@Test
	public void pesquisaProdutoTelaPrincipal() throws Exception {
		String categoria = ExcelUtils.getCellData(1, 14);	
		String produto = ExcelUtils.getCellData(1, 15);	
		
		HomePage.pesquisaCategoriaTelaPrincipal(driver, categoria).click();
		HomePage.pesquisaProdutoTela(driver, produto).click();
	}
	
	@Test
	public void pesquisaProdutoInexistenteTelaPrincipal() throws Exception {
		String categoria = ExcelUtils.getCellData(1, 14);	
		String produto = ExcelUtils.getCellData(1, 99);	
		
		HomePage.pesquisaCategoriaTelaPrincipal(driver, categoria).click();
		HomePage.pesquisaProdutoTela(driver, produto).click();
	}

	@After
	public void killDriver() {
		driver.quit();
	}

}
