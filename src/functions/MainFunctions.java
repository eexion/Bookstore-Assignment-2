package functions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import bookstore.Common;
import interfaces.ICDS;

@SuppressWarnings("deprecation")
public class MainFunctions {
	public void adminMenu() throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("What whould you like to do ?\n1. Update an Item\n2. Add new Items\n3. Add New Customer");
		String option = scanner.nextLine();
		switch (option) {
		case "1":
			UpdateItems updateItems = new UpdateItems();
			updateItems.menu();
			break;
		case "2":
			AddItems addItems = new AddItems();
			addItems.menu();
			break;
		case "3":
			AddCustomer addCustomer = new AddCustomer();
			addCustomer.addNew();
			break;
		}
	}

	public void nonCustomerMenu() throws Exception {
		Scanner scanner = new Scanner(System.in);
		boolean isContinue = true;
		Common common = new Common();
		ArrayList<Common> products = new ArrayList<Common>();
		do {
			boolean finishSale = false;
			ArrayList<Common> cart = new ArrayList<Common>();
			System.out.println(
					"\nWhat whould you like to do :\n1. Purchase\n2. Print Products\n3. Show Cart\n4. Finish Sale\n5. Exit");
			String option = scanner.nextLine();

			switch (option) {
			case "1":
				cart = cart(2);
				break;
			case "2":
				try {
					printProducts();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "3":
				System.out.println(String.format("%40s %50s %20s %20s %20s %20s", "Name", "Description", "Quantity",
						"Type", "Status", "price"));
				System.out.println(
						"______________________________________________________________________________________________________________________________________________________________________________________________________________________");
				for (Common item : products) {
					System.out.println(
							String.format("%40s %50s %20s %20s %20s %20s", item.getName(), item.getDescription(),
									item.getQuantity(), item.getType(), item.getStatus(), item.getPrice()));
				}
				break;
			case "4":
				finishSale = finishSale(products);
				break;
			case "5":
				isContinue = false;
				break;
			default:
				System.out.print("Invalid option");
			}
			for (Common item : cart) {
				products.add(item);
			}
			if (finishSale) {
				products = new ArrayList<Common>();
			}
		} while (isContinue);
	}

	public void customerMenu() throws Exception {
		Scanner scanner = new Scanner(System.in);
		boolean isContinue = true;
		Common common = new Common();
		ArrayList<Common> products = new ArrayList<Common>();
		do {
			boolean finishSale = false;
			ArrayList<Common> cart = new ArrayList<Common>();
			System.out.println(
					"\nWhat whould you like to do :\n1. Rent\n2. Purchase\n3. Print Products\n4. Show Cart\n5. Finish Sale\n6. Return Rented Item\n7. Exit");
			String option = scanner.nextLine();

			switch (option) {
			case "1":
				cart = cart(1);
				break;
			case "2":
				cart = cart(2);
				break;
			case "3":
				try {
					printProducts();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "4":
				System.out.println(String.format("%40s %50s %20s %20s %20s %20s", "Name", "Description", "Quantity",
						"Type", "Status", "price"));
				System.out.println(
						"______________________________________________________________________________________________________________________________________________________________________________________________________________________");
				for (Common item : products) {
					System.out.println(
							String.format("%40s %50s %20s %20s %20s %20s", item.getName(), item.getDescription(),
									item.getQuantity(), item.getType(), item.getStatus(), item.getPrice()));
				}
				break;
			case "5":
				System.out.println("Enter Customer Name: ");
				String customerName = scanner.nextLine();
				String total = Double.toString(common.calculateTotal(products));
				JsonHandler handler = new JsonHandler();
				handler.updateCustomerJson(customerName, "amountSpent", total);
				finishSale = finishSale(products);
				break;
			case "6":
				ReturnItems returnItems = new ReturnItems();
				returnItems.returning();
				break;
			case "7":
				isContinue = false;
				break;
			default:
				System.out.print("Invalid option");
			}
			for (Common item : cart) {
				products.add(item);
			}
			if (finishSale) {
				products = new ArrayList<Common>();
			}
		} while (isContinue);
	}

	public boolean finishSale(ArrayList<Common> products) throws FileNotFoundException, IOException, ParseException {
		Common common = new Common();
		JsonHandler update = new JsonHandler();
		for (Common item : products) {
			int remaining = item.getInventory() - item.getQuantity();
			if (item.getIsRented()) {
				int rented = item.getRented();
				update.updateJson(item.getCategory(), item.getName(), "rented",
						Integer.toString(rented += item.getQuantity()),0);
			} else {
				update.updateJson(item.getCategory(), item.getName(), "inventory", Integer.toString(remaining), 0);
			}

		}
		System.out.println(String.format("%40s %50s %20s %20s %20s %20s", "Name", "Description", "Quantity", "Type",
				"Status", "price"));
		System.out.println(
				"______________________________________________________________________________________________________________________________________________________________________________________________________________________");
		for (Common item : products) {
			System.out.println(String.format("%40s %50s %20s %20s %20s %20s", item.getName(), item.getDescription(),
					item.getQuantity(), item.getType(), item.getStatus(), item.getPrice()));
		}
		double total = common.calculateTotal(products);
		System.out.println("\nGrand Total " + total);
		
		return true;
	}

	public ArrayList<Common> cart(int option) throws Exception {
		ArrayList<Common> cart = new ArrayList<Common>();
		if (option == 1) {
			Common item = rent();
			cart.add(item);
		} else if (option == 2) {
			Common item = purchase();
			cart.add(item);
		}
		return cart;
	}

	public Common rent() throws Exception {
		Scanner scanner = new Scanner(System.in);
		Rent rent = new Rent();
		boolean isContinue = true;
		Common item = new Common();
		do {
			try {
				System.out.println("What whould you like to rent\n1. Book\n2. DVD \n3. Music\n 4. Go Back");
				String option = scanner.nextLine();
				switch (option) {
				case "1":
					item = rent.rentBook();
					isContinue = false;
					break;
				case "2":
					item = rent.rentDVD();
					isContinue = false;
					break;
				case "3":
					item = rent.rentCD();
					isContinue = false;
					break;
				case "4":
					isContinue = false;
					break;
				default:
					System.out.println("Invalid input");
					break;
				}
			} catch (Exception e) {
				throw e;
			}
		} while (isContinue);
		return item;
	}

	public Common purchase() {
		Scanner scanner = new Scanner(System.in);
		Purchase purchase = new Purchase();
		boolean isContinue = true;
		Common item = new Common();
		do {
			try {
				System.out.println(
						"\nWhat whould you like to Purchase \n\n1. Book\n2. DVD \n3. Music\n4. Software\n5. Computer hardware\n6. Stationary\n7. Go Back");
				String option = scanner.nextLine();
				switch (option) {
				case "1":
					item = purchase.purchaseBook();
					isContinue = false;
					break;
				case "2":
					item = purchase.purchaseDVD();
					isContinue = false;
					break;
				case "3":
					item = purchase.purchaseCD();
					isContinue = false;
					break;
				case "4":
					item = purchase.purchaseSoftware();
					isContinue = false;
					break;
				case "5":
					item = purchase.purchaseHardware();
					isContinue = false;
					break;
				case "6":
					item = purchase.purchaseStationary();
					isContinue = false;
					break;
				case "7":
					isContinue = false;
					break;
				default:
					System.out.println("Invalid input");
					break;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (isContinue);
		return item;
	}

	public void printProducts() throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"\nWhat products whould you like to see : \n1. Books \n2. DVDs \n3. Music CDs \n4.Hardware \n5. Software \n6. Stationary \n7. All");
		String inputOption = scanner.nextLine();
		String[] cat = new String[6];
		cat[0] = "books";
		cat[1] = "hardware";
		cat[2] = "dvd";
		cat[3] = "cd";
		cat[4] = "software";
		cat[5] = "stationary";
		try {
			ArrayList<JSONObject> products = null;
			switch (inputOption) {
			case "1":
				products = JsonHandler.readJson(cat[0]);
				MainFunctions.show(products);
				break;
			case "2":
				products = JsonHandler.readJson(cat[2]);
				MainFunctions.show(products);

				break;
			case "3":
				products = JsonHandler.readJson(cat[3]);
				MainFunctions.show(products);

				break;
			case "4":
				products = JsonHandler.readJson(cat[1]);
				MainFunctions.show(products);

				break;
			case "5":
				products = JsonHandler.readJson(cat[4]);
				MainFunctions.show(products);

				break;
			case "6":
				products = JsonHandler.readJson(cat[5]);
				MainFunctions.show(products);
				break;
			case "7":
				for (String c : cat) {
					System.out.println("\nAll " + c);
					products = JsonHandler.readJson(c);
					MainFunctions.show(products);
				}
				break;
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public static void show(ArrayList<JSONObject> products) {
		System.out.println(String.format("%40s %50s %20s %20s %20s %20s %20s", "Name", "Description", "Inventory",
				"Type", "Status", "price", "Rental Price"));
		System.out.println(
				"______________________________________________________________________________________________________________________________________________________________________________________________________________________");
		for (JSONObject item : products) {
			String name = (String) item.get("name");
			String description = (String) item.get("description");
			String type = (String) item.get("type");
			String status = (String) item.get("status");
			double price = (double)item.get("price");
			String rentalPrice = item.get("rentalPrice").toString();
			int inventory = (int) Integer.parseInt(item.get("inventory").toString());
			System.out.println(String.format("%40s %50s %20s %20s %20s %20s %20s", name, description, inventory, type,
					status, price, rentalPrice));
		}
	}
}
