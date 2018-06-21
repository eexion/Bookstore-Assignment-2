package functions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import bookstore.Book;
import bookstore.CD;
import bookstore.Common;
import bookstore.DVD;

public class ReturnItems {
	public void returning() throws Exception {
		Scanner scanner = new Scanner(System.in);
		boolean isContinue = true;
		do {
			System.out.println(
					"\nWhat whould you like to return :\n1. CD's\n2. DVD's\n3. Book's\n4. go back");
			String option = scanner.nextLine();
			switch(option) {
			case "1":
				returnCD();
				break;
			case "2":
				returnDVD();
				break;
			case "3":
				returnBook();
				break;
			case "4":
				isContinue = false;
				break;
			}
			
		}while(isContinue);

	}
	public void returnBook() throws Exception {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Book> books = new ArrayList<Book>();
		try {
			ArrayList<JSONObject> products = JsonHandler.readJson("books");

			MainFunctions.show(products);
			System.out.println("\nWhat Book Would you Like To Return ?");
			String inputName = scanner.nextLine();
			System.out.println("\nHow many are you returning ?");
			String returning = scanner.nextLine();

			boolean found = false;
			for (JSONObject item : products) {
				String name = (String) item.get("name");
				String description = (String) item.get("description");
				String type = (String) item.get("type");
				String status = (String) item.get("status");
				double price = (double) item.get("price");
				String rentalPrice = (String) item.get("rentalPrice");
				String author = (String) item.get("Author");
				int year = (int) Integer.parseInt((String) item.get("year"));
				int rented = (int) Integer.parseInt((String) item.get("rented"));
				int inventory = (int) Integer.parseInt((String) item.get("inventory"));
				if (Pattern.compile(Pattern.quote(inputName), Pattern.CASE_INSENSITIVE).matcher(name).find()) {
					Book book = new Book();
					book.setName(name);
					book.setDescription(description);
					book.setInventory(inventory);
					book.setPrice(Double.parseDouble(rentalPrice));
					book.setAuthor(author);
					book.setQuantity(1);
					book.setRentalPrice(rentalPrice);
					book.setStatus(status);
					book.setType(type);
					book.setYear(year);
					book.setCategory("books");
					book.setRented(rented);
					book.setIsRented(true);
					books.add(book);
					found = true;
				}
			}
			if (found) {
				System.out.println("\nThis is what we have found to select a book please input the index ");
				System.out.println(String.format("%20s %30s %30s %20s %20s %20s %20s", "Index", "Name", "Description",
						"Inventory", "Type", "Status", "price"));
				System.out.println(
						"______________________________________________________________________________________________________________________________________________________________________________________________________________________");

				for (Book item : books) {
					int i = 1;
					System.out.println(String.format("%20s %30s %30s %20s %20s %20s %20s", i, item.getName(),
							item.getDescription(), item.getInventory(), item.getType(), item.getStatus(),
							item.getPrice()));
					i++;
				}
				int index = Integer.parseInt(scanner.nextLine());
				Book bookToReturn = books.get(index - 1);
				JsonHandler handler = new JsonHandler();
				if (bookToReturn.getRented() < Integer.parseInt(returning)) {
					System.out.println("There are only " + bookToReturn.getRented() + " books rented out");
				} else {
					int update = bookToReturn.getRented() - Integer.parseInt(returning);
					handler.updateJson("books", bookToReturn.getName(), "rented", Integer.toString(update));				
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void returnCD() throws Exception {
		Scanner scanner = new Scanner(System.in);
		ArrayList<CD> cds = new ArrayList<CD>();
		try {
			ArrayList<JSONObject> products = JsonHandler.readJson("cd");

			MainFunctions.show(products);
			System.out.println("\nWhat CD Would you Like To Return ?");
			String inputName = scanner.nextLine();
			System.out.println("\nHow many are you returning ?");
			String returning = scanner.nextLine();

			boolean found = false;
			for (JSONObject item : products) {
				String name = (String) item.get("name");
				String description = (String) item.get("description");
				String type = (String) item.get("type");
				String status = (String) item.get("status");
				double price = (double) item.get("price");
				String rentalPrice = (String) item.get("rentalPrice");
				String author = (String) item.get("Author");
				int year = (int) Integer.parseInt((String) item.get("year"));
				int rented = (int) Integer.parseInt((String) item.get("rented"));
				int inventory = (int) Integer.parseInt((String) item.get("inventory"));
				if (Pattern.compile(Pattern.quote(inputName), Pattern.CASE_INSENSITIVE).matcher(name).find()) {
					CD cd = new CD();
					cd.setName(name);
					cd.setDescription(description);
					cd.setInventory(inventory);
					cd.setPrice(Double.parseDouble(rentalPrice));
					cd.setQuantity(1);
					cd.setRentalPrice(rentalPrice);
					cd.setStatus(status);
					cd.setType(type);
					cd.setYear(year);
					cd.setCategory("books");
					cd.setRented(rented);
					cd.setIsRented(true);
					cds.add(cd);
					found = true;
				}
			}
			if (found) {
				System.out.println("\nThis is what we have found to select a book please input the index ");
				System.out.println(String.format("%20s %30s %30s %20s %20s %20s %20s", "Index", "Name", "Description",
						"Inventory", "Type", "Status", "price"));
				System.out.println(
						"______________________________________________________________________________________________________________________________________________________________________________________________________________________");

				for (CD item : cds) {
					int i = 1;
					System.out.println(String.format("%20s %30s %30s %20s %20s %20s %20s", i, item.getName(),
							item.getDescription(), item.getInventory(), item.getType(), item.getStatus(),
							item.getPrice()));
					i++;
				}
				int index = Integer.parseInt(scanner.nextLine());
				CD toReturn = cds.get(index - 1);
				JsonHandler handler = new JsonHandler();
				if (toReturn.getRented() < Integer.parseInt(returning)) {
					System.out.println("There are only " + toReturn.getRented() + " cds rented out");
				} else {
					int update = toReturn.getRented() - Integer.parseInt(returning);
					handler.updateJson("cd", inputName, "rented", Integer.toString(update));
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void returnDVD() throws Exception {
		Scanner scanner = new Scanner(System.in);
		ArrayList<DVD> dvds = new ArrayList<DVD>();
		try {
			ArrayList<JSONObject> products = JsonHandler.readJson("dvd");

			MainFunctions.show(products);
			System.out.println("\nWhat CD Would you Like To Return ?");
			String inputName = scanner.nextLine();
			System.out.println("\nHow many are you returning ?");
			String returning = scanner.nextLine();

			boolean found = false;
			for (JSONObject item : products) {
				String name = (String) item.get("name");
				String description = (String) item.get("description");
				String type = (String) item.get("type");
				String status = (String) item.get("status");
				double price = (double) item.get("price");
				String rentalPrice = (String) item.get("rentalPrice");
				String author = (String) item.get("Author");
				int year = (int) Integer.parseInt((String) item.get("year"));
				int rented = (int) Integer.parseInt((String) item.get("rented"));
				int inventory = (int) Integer.parseInt((String) item.get("inventory"));
				if (Pattern.compile(Pattern.quote(inputName), Pattern.CASE_INSENSITIVE).matcher(name).find()) {
					DVD dvd = new DVD();
					dvd.setName(name);
					dvd.setDescription(description);
					dvd.setInventory(inventory);
					dvd.setPrice(Double.parseDouble(rentalPrice));
					dvd.setQuantity(1);
					dvd.setRentalPrice(rentalPrice);
					dvd.setStatus(status);
					dvd.setType(type);
					dvd.setYear(year);
					dvd.setCategory("books");
					dvd.setRented(rented);
					dvd.setIsRented(true);
					dvds.add(dvd);
					found = true;
				}
			}
			if (found) {
				System.out.println("\nThis is what we have found to select a book please input the index ");
				System.out.println(String.format("%20s %30s %30s %20s %20s %20s %20s", "Index", "Name", "Description",
						"Inventory", "Type", "Status", "price"));
				System.out.println(
						"______________________________________________________________________________________________________________________________________________________________________________________________________________________");

				for (DVD item : dvds) {
					int i = 1;
					System.out.println(String.format("%20s %30s %30s %20s %20s %20s %20s", i, item.getName(),
							item.getDescription(), item.getInventory(), item.getType(), item.getStatus(),
							item.getPrice()));
					i++;
				}
				int index = Integer.parseInt(scanner.nextLine());
				DVD toReturn = dvds.get(index - 1);
				JsonHandler handler = new JsonHandler();
				if (toReturn.getRented() < Integer.parseInt(returning)) {
					System.out.println("There are only " + toReturn.getRented() + " DVD's rented out");
				} else {
					int update = toReturn.getRented() - Integer.parseInt(returning);
					handler.updateJson("dvd", toReturn.getName(), "rented", Integer.toString(update));
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
