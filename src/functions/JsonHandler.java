package functions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonHandler {
	public void updateJson(String key, String itemToUpdate, String valueToUpdate, String valueToSet)
			throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		Object obj;
		obj = parser.parse(new FileReader("products.json"));
		JSONObject jsonObject = (JSONObject) obj;
		JSONArray msg = (JSONArray) jsonObject.get(key);
		Iterator<JSONObject> iterator = msg.iterator();
		while (iterator.hasNext()) {
			JSONObject json = (JSONObject) iterator.next();
			String name = (String) json.get("name");
			if (name.equalsIgnoreCase(itemToUpdate)) {
				json.put(valueToUpdate, valueToSet);
				try (FileWriter file = new FileWriter("products.json")) {
					file.write(obj.toString());
				}
			}
		}
	}
	
	public static ArrayList<JSONObject> readJson(String key) throws Exception {
		JSONParser parser = new JSONParser();
		Object obj;
		try {
			ArrayList<JSONObject> arr = new ArrayList<JSONObject>();
			obj = parser.parse(new FileReader("products.json"));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray msg = (JSONArray) jsonObject.get(key);
			Iterator<JSONObject> iterator = msg.iterator();
			while (iterator.hasNext()) {
				JSONObject json = (JSONObject) iterator.next();
				arr.add(json);
			}
			return arr;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw e;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	
	public void updateCustomerJson(String itemToUpdate, String valueToUpdate, String valueToSet)
			throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		Object obj;
		obj = parser.parse(new FileReader("customer.json"));
		JSONObject jsonObject = (JSONObject) obj;
		JSONArray msg = (JSONArray) jsonObject.get("customers");
		Iterator<JSONObject> iterator = msg.iterator();
		while (iterator.hasNext()) {
			JSONObject json = (JSONObject) iterator.next();
			String name = (String) json.get("name");
			if (name.equalsIgnoreCase(itemToUpdate)) {
				double amount = (double) json.get("amountSpent");
				
				double value = Double.parseDouble(valueToSet);
				double total = amount + value;
				json.put("amountSpent", total);
				try (FileWriter file = new FileWriter("customer.json")) {
					file.write(obj.toString());
				}
			}
		}
	}
}
