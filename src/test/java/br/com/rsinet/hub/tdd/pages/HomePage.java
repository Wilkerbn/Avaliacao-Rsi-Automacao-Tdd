package br.com.rsinet.hub.tdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.rsinet.hub.tdd.suport.Wait;
import br.com.rsinet.hub.tdd.utility.Constant;
import br.com.rsinet.hub.tdd.utility.JsonUtils;

public class HomePage extends Wait {

	private static WebDriver driver;
	private static WebElement elemento = null;

	public HomePage(WebDriver driver) {
		super(driver);
		HomePage.driver = driver;
	}

	/* Métodos utilizados para capturar elementos da Home Page */
	public static WebElement pesquisaCategoriaTelaPrincipal(String categoria) {
		elemento = driver.findElement(By.xpath("//*[. ='" + categoria + "']"));
		return elemento;
	}

	public static WebElement pesquisaProdutoTela(String produto) {
		esperarCarregarPagina(driver);
		//esperaElementoSerClicavel(driver, produto);
		elemento = driver.findElement(By.xpath("//*[. ='" + produto + "']"));
		return elemento;
	}

	public static WebElement clicaLupaParaPesquisarProduto() {
		elemento = driver.findElement(By.id("menuSearch"));
		return elemento;
	}

	public static WebElement pesquisaProdutoLupa() {
		esperarCarregarPagina(driver);
		//esperaElementoSerClicavel(driver, produto);
		elemento = driver.findElement(By.id("autoComplete"));
		return elemento;
	}

	public static WebElement selecionaProdutoLupa(String produto) throws Exception {
		elemento = driver.findElement(By.xpath("//*[. ='" + produto + "']"));
		return elemento;
	}
	
	public static String produtoLupaValidoObtido() {
		//esperarCarregarPagina(driver);
		WebElement elemento = driver.findElement(By.xpath("//*[@id=\"Description\"]/h1"));
		String produtoObtido = elemento.getText();
		return produtoObtido;
	}
	
	public static String produtoLupaInvalidoObtido() {
		esperarCarregarPagina(driver);
		WebElement elemento = driver.findElement(By.xpath("//*[@id=\"searchPage\"]/div[3]/div/label/span"));
		String produtoInvalidoObtido = elemento.getText();
		return produtoInvalidoObtido;
	}
	
	public static String produtoTelaPrincipalValidoObtido(String produto) {
		WebElement elemento = driver.findElement(By.xpath("//*[. ='" + produto + "']"));
		String produtoValido = elemento.getText().toUpperCase();
		return produtoValido;
	}
	
	public static WebElement digitaQuantidadeDeProdutos() {
		elemento = driver.findElement(By.name("quantity"));
		return elemento;
	}
	
	public static WebElement inserirProdutosCarrinho() {
		usaScrollNaPagina(driver);
		elemento = driver.findElement(By.name("save_to_cart"));
		return elemento;
	}
	
	public static String valorInvalidoDeProdutos() {
		elemento = driver.findElement(By.xpath("//*[@id=\"productProperties\"]/label"));
		String quantidadeInvalidaProduto = elemento.getText();
		return quantidadeInvalidaProduto;
	}
	
	public static void consultaProdutoValidoCampoPesquisa() throws Exception {
		clicaLupaParaPesquisarProduto().click();
		pesquisaProdutoLupa().sendKeys(Constant.produtoValido());
		selecionaProdutoLupa(Constant.produtoValido().toUpperCase()).click();
	}
	
	public static void consultaProdutoInvalidoCampoPesquisa() throws Exception {
		clicaLupaParaPesquisarProduto().click();
		pesquisaProdutoLupa().sendKeys(Constant.produtoInvalido() + Keys.ENTER);
	}
	
	public static void consultaProdutoValidoTelaPrincipal() throws Exception {
		pesquisaCategoriaTelaPrincipal(Constant.categoria().toUpperCase()).click();
		pesquisaProdutoTela(Constant.produtoValido()).click();
	}
	
	public static void consultaProdutoComQuantidadeInvalidaTelaPrincipal() throws Exception {
		pesquisaCategoriaTelaPrincipal(Constant.categoria().toUpperCase()).click();
		pesquisaProdutoTela(Constant.produtoValido()).click();
		digitaQuantidadeDeProdutos().sendKeys(Constant.quantidadeDeProdutosDoCarrinho());
		inserirProdutosCarrinho().click();
	}

}
