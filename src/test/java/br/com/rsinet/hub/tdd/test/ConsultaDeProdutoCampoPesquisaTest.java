package br.com.rsinet.hub.tdd.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub.tdd.suport.Web;

public class ConsultaDeProdutoCampoPesquisaTest {
	
	WebDriver driver = null;
	
	@Before
	public void iniciaNavegador() {
		driver = Web.createChrome();
	}
	
	@Test
	public void cadastro() {
	
	}
	
	
	@After
	public void killDriver() {
		
	}

}
