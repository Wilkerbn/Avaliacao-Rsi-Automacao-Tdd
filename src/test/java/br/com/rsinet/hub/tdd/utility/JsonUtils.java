package br.com.rsinet.hub.tdd.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtils {
			
	static String categoria;
	static String produto;
	static String validaProduto;
	static String categoriaInvalida;
	static String validaProdutoInvalido;

	public static void main (String [] args) {
				 
			JSONObject jsonObject;
			JSONParser parser = new JSONParser();
			try {
				jsonObject = (JSONObject) parser.parse(new FileReader("src/test/java/br/com/rsinet/hub/tdd/testdata/TestData.json"));
				categoria = ((String) jsonObject.get("categoria"));
				produto = ((String) jsonObject.get("produto"));
				validaProduto = ((String) jsonObject.get("validaProduto"));
				categoriaInvalida =((String) jsonObject.get("categoriaInvalida"));
				validaProdutoInvalido = ((String) jsonObject.get("validaProdutoInvalido"));
			
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}


	
	
	
	

		
		
		
		

		 
	
	
		
	}

