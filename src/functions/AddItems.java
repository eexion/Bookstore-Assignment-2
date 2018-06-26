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

public class AddItems {

	@SuppressWarnings("resource")
	public void menu() throws Exception {
		Scanner scanner = new Scanner(System.in);
		boolean isContinue = true;
		do {
			System.out.println(
					"What whould you like to add/add inventory ?\n1. Books\n2. DVDs \n3. Music CDs \n4. Hardware \n5. Software \n6. Stationary\n7. Go Back");
			String option = scanner.nextLine();
			switch (option) {
			case "1":
				addNewItems("books");
				break;
			case "2":
				addNewItems("dvd");
				break;
			case "3":
				addNewItems("cd");
				break;
			case "4":
				addNewItems("hardware");
				break;
			case "5":
				addNewItems("software");
				break;
			case "6":
				addNewItems("stationary");
				break;
			case "7":
				boolean backConfirm = false;
				do {
					System.out.println("Are your sure you would like to go back ? y/n");
					String input = scanner.nextLine();
					if (input.equalsIgnoreCase("y")) {
						isContinue = false;
						backConfirm = true;
					} else if (input.equalsIgnoreCase("n")) {
						backConfirm = true;
					}
				} while (!backConfirm);
				break;
			default:
				System.out.println("Invalid input");
				break;
			}
		} while (isContinue);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public void addNewItems(String toAdd) throws FileNotFoundException, IOException, ParseException {
		Scanner scanner = new Scanner(System.in);
		JSONObject obj2 = new JSONObject();
		try {
			System.out.println("Name of " + toAdd + " you want to add : ");
			String name = scanner.nextLine();
			obj2.put("name", name);

			System.out.println("Description of " + toAdd + " you want to add : ");
			String description = scanner.nextLine();
			obj2.put("description", description);

			System.out.println("Number of " + toAdd + " you want to add : ");
			String inventory = scanner.nextLine();
			obj2.put("inventory", inventory);

			System.out.println("Type of " + toAdd + " you want to add : ");
			String type = scanner.nextLine();
			obj2.put("type", type);

			System.out.println("Price of " + toAdd + " you want to add : ");
			String price = scanner.nextLine();
			obj2.put("price", Double.parseDouble(price));

			if (toAdd.equalsIgnoreCase("cd") || toAdd.equalsIgnoreCase("dvd") || toAdd.equalsIgnoreCase("books")) {

				System.out.println("Author of " + toAdd + " you want to add : ");
				String author = scanner.nextLine();
				obj2.put("Author", author);

				System.out.println("Rental Price of " + toAdd + " you want to add : ");
				String rentalPrice = scanner.nextLine();
				obj2.put("rentalPrice", rentalPrice);

				System.out.println("Year of " + toAdd + " you want to add : ");
				String year = scanner.nextLine();
				obj2.put("year", year);
			} else if (toAdd.equals("Hardware")) {
				System.out.println("Manufacturer of " + toAdd + " you want to add : ");
				String manufacturer = scanner.nextLine();
				obj2.put("manufacturer", manufacturer);
				System.out.println("Model of " + toAdd + " you want to add : ");
				String model = scanner.nextLine();
				obj2.put("model", model);
			} else {
				System.out.println("Manufacturer of " + toAdd + " you want to add : ");
				String manufacturer = scanner.nextLine();
				obj2.put("manufacturer", manufacturer);
			}
			obj2.put("rented", "0");
			obj2.put("status", "Available");

			JSONParser parser = new JSONParser();
			Object obj;
			obj = parser.parse(new FileReader("products.json"));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray msg = (JSONArray) jsonObject.get(toAdd);
			msg.add(obj2);
			try (FileWriter file = new FileWriter("products.json")) {
				file.write(obj.toString());
			}
		} catch (Exception ex) {
			System.err.println("Error on input of price/Rental price/inventory  " + ex.getLocalizedMessage());
		}

	}
}
