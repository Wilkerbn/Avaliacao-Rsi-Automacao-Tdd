package br.com.rsinet.hub.tdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class InfoFormPage {

	private WebDriver driver;
	private static WebElement elemento = null;
	private static Select select = null;
	

	public InfoFormPage(WebDriver driver) {
		this.driver = driver;
	}

	public static WebElement campoApelido(WebDriver driver) {
		elemento = driver.findElement(By.name("usernameRegisterPage"));
		return elemento;
	}

	public static WebElement campoSenha(WebDriver driver) {
		elemento = driver.findElement(By.xpath("//*[@id=\"formCover\"]/div[1]/div[2]/sec-view[1]/div/input"));
		return elemento;
	}

	public static WebElement campoConfirmaSenha(WebDriver driver) {
		elemento = driver.findElement(By.xpath("//*[@id=\"formCover\"]/div[1]/div[2]/sec-view[2]/div/input"));
		return elemento;
	}

	public static WebElement campoEmail(WebDriver driver) {
		elemento = driver.findElement(By.name("emailRegisterPage"));
		return elemento;
	}

	public static WebElement campoPrimeiroNome(WebDriver driver) {
		elemento = driver.findElement(By.name("first_nameRegisterPage"));
		return elemento;
	}

	public static WebElement campoUltimoNome(WebDriver driver) {
		elemento = driver.findElement(By.name("last_nameRegisterPage"));
		return elemento;
	}

	public static WebElement campoTelefone(WebDriver driver) {
		elemento = driver.findElement(By.name("phone_numberRegisterPage"));
		return elemento;
	}

	public static Select campoPais(WebDriver driver) {
		WebElement selecionaPais = driver.findElement(By.name("countryListboxRegisterPage"));
		select = new Select(selecionaPais);
		return select;
	}

	public static WebElement campoCidade(WebDriver driver) {
		elemento = driver.findElement(By.name("cityRegisterPage"));
		return elemento;
	}

	public static WebElement campoEndereco(WebDriver driver) {
		elemento = driver.findElement(By.name("addressRegisterPage"));
		return elemento;
	}

	public static WebElement campoEstado(WebDriver driver) {
		elemento = driver.findElement(By.name("state_/_province_/_regionRegisterPage"));
		return elemento;
	}

	public static WebElement campoCep(WebDriver driver) {
		elemento = driver.findElement(By.name("postal_codeRegisterPage"));
		return elemento;
	}

	public static WebElement campoAceitaTermos(WebDriver driver) {
		elemento = driver.findElement(By.name("i_agree"));
		return elemento;
	}

	public static WebElement botaoRegistra(WebDriver driver)  {
		elemento = driver.findElement(By.id("register_btnundefined"));
		return elemento;
	}
	
	public static String capturaTexto(WebDriver driver) throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000);");
		WebElement textoCapturado = driver.findElement(By.xpath("//*[@id=\"menuUserLink\"]/span"));
		String textoUsuarioLogado = textoCapturado.getText();
		return textoUsuarioLogado;
	}
	
	public static String capturaTextoCadastroDuplicado(WebDriver driver) throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000);");
		WebElement textoCapturado = driver.findElement(By.xpath("//*[@id=\"registerPage\"]/article/sec-form/div[2]/label[1]"));
		String mensagemCadastroDuplicado = textoCapturado.getText();
		return mensagemCadastroDuplicado;
	}
	
	
	
	
}


