package br.com.rsinet.hub.tdd.utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import br.com.rsinet.hub.tdd.test.CadastroDeUsuarioTest;

public class Report {

	public static WebDriver driver;

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	
	public static ExtentReports setExtent() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/myReport.html");

		htmlReporter.config().setDocumentTitle("Relatorio de Automacao"); // Titulo do report
		htmlReporter.config().setReportName("Relatorio Funcional"); // Nome do report
		htmlReporter.config().setTheme(Theme.DARK); // Seleciona o tema

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Tester Name", "Wilker");
		extent.setSystemInfo("Browser", "Chrome");
		
		return extent;
	}


	public static void closeReport(ExtentReports extent) {
		extent.flush();
	}

	
	public static ExtentTest setUp(String report) {
		test = extent.createTest(report);
		return test;
	}

	
	public static void tearDown(ITestResult result, ExtentTest test) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // Para adicionar no extent report
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // Para adicionar erro ou exception

//			String screenshotPath = CadastroDeUsuarioTest.getScreenshot(driver, result.getName());
//			test.addScreenCaptureFromPath(screenshotPath); // Adiciona a screenshot
			
			

		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
			
		}
		
		

	}

}
