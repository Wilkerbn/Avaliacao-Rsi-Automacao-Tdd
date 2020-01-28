package br.com.rsinet.hub.tdd.suport;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Web {

	/* M�todo que recebe as configura��es do Driver e informa qual a aplica��o a ser executada */
	public static WebDriver createChrome() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://advantageonlineshopping.com/#/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	/* M�todo usado para encerrar o driver ao finalizar o teste */
	public static void killDriver(WebDriver driver) {
		if (null != driver) {
			driver.quit();
		}
	}
}
