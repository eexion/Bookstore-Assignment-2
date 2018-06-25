package functions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import bookstore.Customer;

public class AddCustomer {
	public void addNew() throws FileNotFoundException, IOException, ParseException {
		Scanner scanner = new Scanner(System.in);
		Customer customer = new Customer();
		System.out.println("Enter Customer name : ");
		String name = scanner.nextLine();
		System.out.println("Enter Customer Age : ");
		String age = scanner.nextLine();
		System.out.println("Enter Customer Phone number : ");
		String phone = scanner.nextLine();
		customer.setAge(Integer.parseInt(age));
		customer.setName(name);
		customer.setPhone(phone);
		customer.setAmountSpent(0.0);
		JSONObject obj2 = new JSONObject();
		obj2.put("name", customer.getName());
		obj2.put("age", customer.getAge());
		obj2.put("phone",customer.getPhone());
		obj2.put("amountSpent",customer.getAmountSpent());
		JSONParser parser = new JSONParser();
		Object obj;
		obj = parser.parse(new FileReader("customer.json"));
		JSONObject jsonObject = (JSONObject) obj;
		JSONArray msg = (JSONArray) jsonObject.get("customers");
		msg.add(obj2);
		try (FileWriter file = new FileWriter("customer.json")) {
			file.write(obj.toString());
		}
	}
}
