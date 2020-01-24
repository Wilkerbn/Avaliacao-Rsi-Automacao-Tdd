package br.com.rsinet.hub.tdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private static WebDriver driver;
	private static WebElement elemento = null;

	/* Métodos utilizados para capturar elementos na página de login */
	public LoginPage(WebDriver driver) {
		LoginPage.driver = driver;
	}

	public static WebElement botaoUsuario() {
		elemento = driver.findElement(By.id("menuUserSVGPath"));
		return elemento;
	}

	public static WebElement criarNovaConta() throws Exception {
		elemento = driver.findElement(By.linkText("CREATE NEW ACCOUNT"));
		return elemento;

	}
}
