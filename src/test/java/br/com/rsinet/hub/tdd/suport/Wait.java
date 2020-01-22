package br.com.rsinet.hub.tdd.suport;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Wait {
	WebDriver driver;
	Wait wait;
	
	public Wait(WebDriver driver) {
		this.driver = driver;
	}

	public void esperaCarregarPaginaImplicita() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void esperarCarregarPagina(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000);");
	}
	
	public static void usaScrollNaPagina(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scrollBy(0,200)", "");
	}
}
