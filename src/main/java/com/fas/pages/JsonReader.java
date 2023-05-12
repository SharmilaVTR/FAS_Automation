package com.fas.pages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonReader extends BaseTest {
	JSONParser parser = new JSONParser();

	public JSONObject unKnownJsonStructureReader(String filepath) throws IOException, ParseException {

		JSONObject jsonObject = null;
		try {

			Object obj = parser.parse(new FileReader(filepath));

			jsonObject = (JSONObject) obj;
		}
			
		 catch (FileNotFoundException e) {
			e.printStackTrace();

		} 
		
		return jsonObject;
	}
	
	
	public JSONArray readJSONDataFromFile(String jiraNumber) throws Exception {
		JSONArray dataArray = null;
		File file=null;
		try{
			file = new File(".\\src\\test\\resources\\TestData\\"+ jiraNumber + ".json");
			JsonReader fileReader = new JsonReader();
			JSONObject jsonObject = fileReader.unKnownJsonStructureReader(file.getCanonicalPath());
			dataArray = (JSONArray) jsonObject.get(jiraNumber);
		}catch(Exception e){
			dataArray = null;
		}finally{
			if(dataArray==null){
				throw new Exception("JSONDataReadError");
			}
			
		}
		return dataArray;
	}
	

	public String readKeyValueFromJsonObject(JSONObject jsonObject,String key) throws Exception {
		String data = null;
		try{
			data = jsonObject.get(key).toString();
		}catch(Exception e){
			data = null;
		}finally{
			if(data==null){
				throw new Exception("JSONDataReadError");
			}
		}
		return data;
	}
	
	
	public JSONArray readJSonArrayFromJsonObject(JSONObject jsonObject,String key) throws Exception {
		JSONArray data_array = null;
		try{
			data_array = (JSONArray) jsonObject.get(key);
		}catch(Exception e){
			data_array = null;
		}finally{
			if(data_array==null){
				throw new Exception("JSONDataReadError");
			}
		}
		return data_array;
	}
	
	


}
