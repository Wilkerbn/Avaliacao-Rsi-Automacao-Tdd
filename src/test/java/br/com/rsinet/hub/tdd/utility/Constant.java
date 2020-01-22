package br.com.rsinet.hub.tdd.utility;

public class Constant {

	public static final String Path_TestData = "C:\\Users\\wilker.nogueira\\eclipse-workspace\\avaliacao-automacao-tdd\\src\\test\\java\\br\\com\\rsinet\\hub\\tdd\\testdata\\";

	public static final String File_TestData = "TestData.xlsx";

	public static void recebeDadosDoExcel(String planilha) throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, planilha);
	}

	/* ----------------------- Dados extraídos do Excel e utilizados no Cadastro de Usuário -----------------------  */
	
	public static String apelido() throws Exception {
		return ExcelUtils.getCellData(1, 1);
	}

	public static String senha() throws Exception {
		return ExcelUtils.getCellData(2, 1);
	}

	public static String confirmaSenha() throws Exception {
		return ExcelUtils.getCellData(3, 1);
	}

	public static String email() throws Exception {
		return ExcelUtils.getCellData(4, 1);
	}
	
	public static String primeiroNome() throws Exception {
		return ExcelUtils.getCellData(5, 1);
	}
	
	public static String ultimoNome() throws Exception {
		return ExcelUtils.getCellData(6, 1);
	}
	
	public static String telefone() throws Exception {
		return ExcelUtils.getCellData(7, 1);
	}
	
	public static String pais() throws Exception {
		return ExcelUtils.getCellData(8, 1);
	}
	
	public static String cidade() throws Exception {
		return ExcelUtils.getCellData(9, 1);
	}
	
	public static String endereco()throws Exception {
		return ExcelUtils.getCellData(10, 1);
	}
	
	public static String estado() throws Exception {
		return ExcelUtils.getCellData(11, 1);
	}
	
	public static String cep() throws Exception {
		return ExcelUtils.getCellData(12, 1);
	}
	
	public static String usuarioJaExistente() throws Exception {
		return ExcelUtils.getCellData(13,1);
	}
	
	/* ------------- Dados extraídos do Excel e utilizados no Campo de Pesquisa e Tela Principal -------------  */
    
	public static String categoria() throws Exception {
		return ExcelUtils.getCellData(3, 0);
	}
	
	public static String produtoValido() throws Exception {
		return ExcelUtils.getCellData(3, 1);
	}
	
	public static String produtoInvalido() throws Exception {
		return ExcelUtils.getCellData(11, 0);
	}
	
	public static String mensagemEsperadaParaProdutoInvalidoObtido() throws Exception {
		return ExcelUtils.getCellData(11, 1);
	}
	
	public static String quantidadeDeProdutosDoCarrinho() throws Exception {
		return ExcelUtils.getCellData(7, 0);
	}
	
	public static String mensagemEsperadaParaQuantidadeDeProdutosInvalidos() throws Exception {
		return ExcelUtils.getCellData(7, 1);
	}


}
