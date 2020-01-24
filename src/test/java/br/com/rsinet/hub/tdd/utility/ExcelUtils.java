package br.com.rsinet.hub.tdd.utility;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;

	/* Método que define o caminho  e abre o arquivo do Excel */
	public static void setExcelFile(String Path, String SheetName) throws Exception {

		try {
			/* Abre o arquivo do Excel */
			FileInputStream ExcelFile = new FileInputStream(Path);

			/* Acessa a folha de dados "Aba" */
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e) {
			throw (e);
		}
	}

	/* Método que faz a leitura da célula do arquivo do Excel, para isso deve ser informado os parâmetros linha e coluna */
	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;

		} catch (Exception e) {
			return "";
		}
	}
}
