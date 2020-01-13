package br.com.rsinet.hub.tdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import br.com.rsinet.hub.tdd.utility.Constant;
import br.com.rsinet.hub.tdd.utility.ExcelUtils;

public class HomePage {

	private WebDriver driver;
	private static WebElement elemento = null;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public static WebElement pesquisaCategoriaTelaPrincipal(WebDriver driver, String categoria) {
		elemento = driver.findElement(By.xpath("//*[. ='" + categoria + "']"));
		return elemento;
	}

	public static WebElement pesquisaProdutoTela(WebDriver driver, String produto) {
		elemento = driver.findElement(By.xpath("//*[. ='" + produto + "']"));
		return elemento;
	}

	public static WebElement clicaLupaParaPesquisarProduto(WebDriver driver) {
		elemento = driver.findElement(By.id("menuSearch"));
		return elemento;
	}

	public static WebElement pesquisaProdutoLupa(WebDriver driver) {
		elemento = driver.findElement(By.id("autoComplete"));
		return elemento;
	}

	public static WebElement selecionaProdutoLupa(WebDriver driver, String produto) throws Exception {
		elemento = driver.findElement(By.xpath("//*[. ='" + produto + "']"));
		return elemento;
	}
	
	public static String produtoObtido(WebDriver driver) {
		WebElement elemento = driver.findElement(By.xpath("//*[@id=\"Description\"]/h1"));
		String produtoObtido = elemento.getText();
		return produtoObtido;
	}
	
	public static String produtoInvalidoObtido(WebDriver driver) {
		WebElement elemento = driver.findElement(By.xpath("//*[@id=\"searchPage\"]/div[3]/div/label/span"));
		String produtoInvalidoObtido = elemento.getText();
		return produtoInvalidoObtido;
	}

}
