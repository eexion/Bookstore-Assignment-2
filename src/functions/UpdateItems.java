package functions;

import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONObject;

public class UpdateItems {
	@SuppressWarnings("resource")
	public void menu() throws Exception {
		Scanner scanner = new Scanner(System.in);
		boolean isContinue = true;
		do {
			System.out.println(
					"What whould you like to update in inventory ?\n1. Books\n2. DVDs \n3. Music CDs \n4. Hardware \n5. Software \n6. Stationary\n7. Go Back");
			String option = scanner.nextLine();
			switch (option) {
			case "1":
				updateInventory("books");
				break;
			case "2":
				updateInventory("dvd");
				break;
			case "3":
				updateInventory("cd");
				break;
			case "4":
				updateInventory("hardware");
				break;
			case "5":
				updateInventory("software");
				break;
			case "6":
				updateInventory("stationary");
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
	public void updateInventory(String toUpdate) throws Exception {
		Scanner scanner = new Scanner(System.in);	
		ArrayList<JSONObject> products = JsonHandler.readJson(toUpdate);
		MainFunctions.show(products);
		
		System.out.println("What item would you like to update ? (please input the full name) : ");
		String name = scanner.nextLine();
		boolean invalid = true;
		String valueToUpdate = "";
		do {
			System.out.println("What value would you like to update ?\n1. Name\n2. description\n3. inventory\n4. rental price(only for books,cd and dvd)\n5. price : ");
			String option = scanner.nextLine();

			switch(option) {
			case "1":
				valueToUpdate = "name";
				invalid = false;
				break;
			case "2":
				valueToUpdate = "description";
				invalid = false;
				break;
			case "3":
				valueToUpdate = "inventory";
				invalid = false;
				break;
			case "4":
				valueToUpdate = "rentalPrice";
				invalid = false;
				break;
			case "5":
				valueToUpdate = "price";
				invalid = false;
				break;
			default:
				invalid = true;
			}
		}while(invalid);
		
		System.out.println("what is the new value ?: ");
		String valueToSet = scanner.nextLine();
		boolean correctVal = true;
		if(valueToUpdate.equalsIgnoreCase("price") || valueToUpdate.equalsIgnoreCase("rentalPrice")) {
			try {
				double checkIfInt = Double.parseDouble(valueToSet);
			}catch(Exception ex) {
				correctVal = false;
				System.out.println("\nThis is not a valid entry for the field \n");
			}

		}else if(valueToUpdate.equalsIgnoreCase("inventory")) {
			try {
				int checkIfInt = Integer.parseInt(valueToSet);
			}catch(Exception ex) {
				correctVal = false;
				System.out.println("\nThis is not a valid entry for the field \n");
			}
		}
		if(correctVal) {
			JsonHandler handler = new JsonHandler();
			handler.updateJson(toUpdate, name, valueToUpdate, valueToSet);
		}		
	}
}
