package br.com.rsinet.hub.tdd.suport;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	WebDriver driver;
	Wait wait;
	
	/* Construtor */
	public Wait(WebDriver driver) {
		this.driver = driver;
	}

	/* M�todo de Espera Implicita */
	public void esperaCarregarPaginaImplicita() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/* M�todo de Espera utilizando JavaScript */
	public static void esperarCarregarPagina(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000);");
	}
	
	/* M�todo que usa o Scroll na p�gina, utilizado para tirar screenshot corretamente em alguns casos */
	public static void usaScrollNaPagina(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scrollBy(0,200)", "");
	}
	
	/* M�todo que espera o elemento ser clic�vel */
	public static WebElement esperaElementoSerClicavel(WebDriver driver, String produto) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[. ='"+ produto +"']")));
		return element;
	}
}
