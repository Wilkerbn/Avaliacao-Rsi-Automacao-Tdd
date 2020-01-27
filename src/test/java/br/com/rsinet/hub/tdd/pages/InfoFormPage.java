package br.com.rsinet.hub.tdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import br.com.rsinet.hub.tdd.suport.Wait;
import br.com.rsinet.hub.tdd.utility.Constant;

public class InfoFormPage extends Wait {

	private static WebDriver driver;
	private static WebElement elemento = null;
	private static Select select = null;
	

	public InfoFormPage(WebDriver driver) {
		super(driver);
		InfoFormPage.driver = driver;
	}

	/* Métodos utilizados para capturar elementos da página de formulário para criação da conta */
	public static WebElement campoApelido() {
		elemento = driver.findElement(By.name("usernameRegisterPage"));
		return elemento;
	}

	public static WebElement campoSenha() {
		elemento = driver.findElement(By.xpath("//*[@id=\"formCover\"]/div[1]/div[2]/sec-view[1]/div/input"));
		return elemento;
	}

	public static WebElement campoConfirmaSenha() {
		elemento = driver.findElement(By.xpath("//*[@id=\"formCover\"]/div[1]/div[2]/sec-view[2]/div/input"));
		return elemento;
	}

	public static WebElement campoEmail() {
		elemento = driver.findElement(By.name("emailRegisterPage"));
		return elemento;
	}

	public static WebElement campoPrimeiroNome() {
		elemento = driver.findElement(By.name("first_nameRegisterPage"));
		return elemento;
	}

	public static WebElement campoUltimoNome() {
		elemento = driver.findElement(By.name("last_nameRegisterPage"));
		return elemento;
	}

	public static WebElement campoTelefone() {
		elemento = driver.findElement(By.name("phone_numberRegisterPage"));
		return elemento;
	}

	public static Select campoPais() {
		WebElement selecionaPais = driver.findElement(By.name("countryListboxRegisterPage"));
		select = new Select(selecionaPais);
		return select;
	}

	public static WebElement campoCidade() {
		elemento = driver.findElement(By.name("cityRegisterPage"));
		return elemento;
	}

	public static WebElement campoEndereco() {
		elemento = driver.findElement(By.name("addressRegisterPage"));
		return elemento;
	}

	public static WebElement campoEstado() {
		elemento = driver.findElement(By.name("state_/_province_/_regionRegisterPage"));
		return elemento;
	}

	public static WebElement campoCep() {
		elemento = driver.findElement(By.name("postal_codeRegisterPage"));
		return elemento;
	}

	public static WebElement campoAceitaTermos() {
		elemento = driver.findElement(By.name("i_agree"));
		return elemento;
	}

	public static WebElement botaoRegistra()  {
		usaScrollNaPagina(driver);
		elemento = driver.findElement(By.id("register_btnundefined"));
		return elemento;
	}
	
	public static String capturaTexto() throws Exception {
		esperarCarregarPagina(driver);
		WebElement textoCapturado = driver.findElement(By.xpath("//*[@id=\"menuUserLink\"]/span"));
		String textoUsuarioLogado = textoCapturado.getText();
		return textoUsuarioLogado;
	}
	
	public static String capturaTextoCadastroDuplicado() throws Exception {
		esperarCarregarPagina(driver);
		WebElement textoCapturado = driver.findElement(By.xpath("//*[@id=\"registerPage\"]/article/sec-form/div[2]/label[1]"));
		String mensagemCadastroDuplicado = textoCapturado.getText();
		return mensagemCadastroDuplicado;
	}
	
	public static void efetuaCadastro() throws Exception {
		campoApelido().sendKeys(Constant.apelido());
		campoSenha().sendKeys(Constant.confirmaSenha());
		campoConfirmaSenha().sendKeys(Constant.confirmaSenha());
		campoEmail().sendKeys(Constant.email());
		campoPrimeiroNome().sendKeys(Constant.primeiroNome());
		campoUltimoNome().sendKeys(Constant.ultimoNome());
		campoTelefone().sendKeys(Constant.telefone());
		campoPais().selectByVisibleText(Constant.pais());
		campoCidade().sendKeys(Constant.cidade());
		campoEndereco().sendKeys(Constant.endereco());
		campoEstado().sendKeys(Constant.estado());
		campoCep().sendKeys(Constant.cep());
		campoAceitaTermos().click();
		botaoRegistra().click();
	}
	
}


