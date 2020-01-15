package br.com.rsinet.hub.tdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;
	private static WebElement elemento = null;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public static WebElement botaoUsuario(WebDriver driver) {
		elemento = driver.findElement(By.id("menuUserSVGPath"));
		return elemento;
	}

	public static WebElement criarNovaConta(WebDriver driver) throws Exception {


		elemento = driver.findElement(By.linkText("CREATE NEW ACCOUNT"));
		return elemento;

	}
}
