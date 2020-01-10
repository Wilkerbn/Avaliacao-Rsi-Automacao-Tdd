package br.com.rsinet.hub.tdd.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub.tdd.suport.Web;

public class ConsultaDeProdutoTelaPrincipalTest {

	WebDriver driver = null;

	@Before
	public void iniciaNavegador() {
		driver = Web.createChrome();
	}

	@Test
	public void teste() throws Exception {

		driver.get("http://advantageonlineshopping.com");

		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"laptopsImg\"]")).click();

		driver.findElement(By.xpath("/html/body/div[3]/section/article/div[3]/div/div/div[2]/ul/li[1]")).click();

	}
	
	@After
	public void killDriver() {
		
	}
	

}
