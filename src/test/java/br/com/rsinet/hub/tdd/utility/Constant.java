package br.com.rsinet.hub.tdd.utility;

import br.com.rsinet.hub.tdd.pages.InfoFormPage;

public class Constant {

	public static final String Path_TestData = "C:\\Users\\wilker.nogueira\\eclipse-workspace\\avaliacao-automacao-tdd\\src\\test\\java\\br\\com\\rsinet\\hub\\tdd\\testdata\\";

	public static final String File_TestData = "TestData.xlsx";

	public static void recebeDadosDoExcel (String planilha) throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, planilha);
		
	}
	
	public static String campoApelido()         throws Exception { return ExcelUtils.getCellData(1, 1);	}
	public static String campoSenha()           throws Exception { return ExcelUtils.getCellData(2, 1); }
	public static String campoConfirmaSenha()   throws Exception { return ExcelUtils.getCellData(3, 1); }
	public static String campoEmail()           throws Exception { return ExcelUtils.getCellData(4, 1); }
		
	
	

}
