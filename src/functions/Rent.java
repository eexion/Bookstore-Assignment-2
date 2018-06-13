package functions;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.json.simple.JSONObject;

import bookstore.Book;
import bookstore.CD;
import bookstore.Common;
import bookstore.DVD;

public class Rent {
	public Common rentBook() throws Exception {
		Scanner scanner = new Scanner(System.in);
		try {
			ArrayList<Book> books = new ArrayList<Book>();
			ArrayList<JSONObject> products = MainFunctions.readJson("books");

			MainFunctions.show(products);
			System.out.println("\nWhat Book Would you Like To Purchase?");
			String inputName = scanner.nextLine();
			boolean found = false;
			for (JSONObject item : products) {
				String name = (String) item.get("name");
				String description = (String) item.get("description");
				String type = (String) item.get("type");
				String status = (String) item.get("status");
				double price = (double) item.get("price");
				String rentalPrice = (String)item.get("rentalPrice");
				String author = (String) item.get("Author");
				int year = (int) Integer.parseInt((String) item.get("year"));
				int inventory = (int) Integer.parseInt((String)item.get("inventory"));
			    if (Pattern.compile(Pattern.quote(inputName), Pattern.CASE_INSENSITIVE).matcher(name).find()){
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
			        books.add(book);
			        found = true;
			    }
			}
			if(found) {
			System.out.println("\nThis is what we have found to select a book please input the index ");
			System.out.println(String.format("%20s %30s %30s %20s %20s %20s %20s","Index","Name" ,"Description" ,"Inventory" ,"Type" ,"Status", "price"));
			System.out.println("______________________________________________________________________________________________________________________________________________________________________________________________________________________");
			
			for(Book item: books) {
				int i = 1;
				System.out.println(String.format("%20s %30s %30s %20s %20s %20s %20s",i , item.getName() ,item.getDescription(),item.getInventory() , item.getType()
						,item.getStatus(),item.getPrice()));
			}
			int index = Integer.parseInt(scanner.nextLine());
			Book bookToReturn = books.get(index - 1);
			boolean isTrue = true;	
			do {
				System.out.println("Enter the quantity : ");
				String quantity = scanner.nextLine();
				if(bookToReturn.getInventory() < Integer.parseInt(quantity)) {
					System.out.println("Not enough inventory for this purchase there is only " + bookToReturn.getInventory() + " available");
				}else {
					bookToReturn.setQuantity(Integer.parseInt(quantity));
					isTrue = false;
				}
			}while(isTrue);
			return bookToReturn;
			}else {
				System.out.println("Nothing Found Please Try Again ");
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	
	public Common rentDVD() throws Exception {
		Scanner scanner = new Scanner(System.in);
		try {
			ArrayList<JSONObject> products = MainFunctions.readJson("dvd");

			MainFunctions.show(products);
			ArrayList<DVD> dvds = new ArrayList<DVD>();
			System.out.println("\nWhat Book Would you Like To Purchase?");
			String inputName = scanner.nextLine();
			boolean found = false;
			for (JSONObject item : products) {
				String name = (String) item.get("name");
				String description = (String) item.get("description");
				String type = (String) item.get("type");
				String status = (String) item.get("status");
				double price = (double) item.get("price");
				String rentalPrice = (String)item.get("rentalPrice");
				String author = (String) item.get("Author");
				int year = (int) Integer.parseInt((String) item.get("year"));
				int inventory = (int) Integer.parseInt((String)item.get("inventory"));

			    if (Pattern.compile(Pattern.quote(inputName), Pattern.CASE_INSENSITIVE).matcher(name).find()){
			    	DVD dvd = new DVD();		
			        dvd.setName(name);
			        dvd.setDescription(description);
			        dvd.setInventory(inventory);
			        dvd.setPrice(Double.parseDouble(rentalPrice));
			        dvd.setAuthor(author);
			        dvd.setQuantity(1);
			        dvd.setRentalPrice(rentalPrice);
			        dvd.setStatus(status);
			        dvd.setType(type);
			        dvd.setYear(year);
			        dvd.setCategory("dvd");
			        dvds.add(dvd);
			        found = true;
			    }
			}
			if(found) {
			System.out.println("\nThis is what we have found to select a book please input the index ");
			System.out.println(String.format("%20s %30s %30s %20s %20s %20s %20s","Index","Name" ,"Description" ,"Inventory" ,"Type" ,"Status", "price"));
			System.out.println("______________________________________________________________________________________________________________________________________________________________________________________________________________________");
			
			for(DVD item: dvds) {
				int i = 1;
				System.out.println(String.format("%20s %30s %30s %20s %20s %20s %20s",i , item.getName() ,item.getDescription(),item.getInventory() , item.getType()
						,item.getStatus(),item.getPrice()));
			}
			int index = Integer.parseInt(scanner.nextLine());
			DVD dvdToReturn = dvds.get(index - 1);
			boolean isTrue = true;	
			do {
				System.out.println("Enter the quantity : ");
				String quantity = scanner.nextLine();
				if(dvdToReturn.getInventory() < Integer.parseInt(quantity)) {
					System.out.println("Not enough inventory for this purchase there is only " + dvdToReturn.getInventory() + " available");
				}else {
					dvdToReturn.setQuantity(Integer.parseInt(quantity));
					isTrue = false;
				}
			}while(isTrue);
			return dvdToReturn;
			}else {
				System.out.println("Nothing Found Please Try Again ");
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	
	public Common rentCD() throws Exception {
		Scanner scanner = new Scanner(System.in);
		try {
			ArrayList<JSONObject> products = MainFunctions.readJson("cd");
			MainFunctions.show(products);
			ArrayList<CD> cds = new ArrayList<CD>();
			System.out.println("\nWhat Book Would you Like To Purchase?");
			String inputName = scanner.nextLine();
			boolean found = false;
			for (JSONObject item : products) {
				String name = (String) item.get("name");
				String description = (String) item.get("description");
				String type = (String) item.get("type");
				String status = (String) item.get("status");
				double price = (double) item.get("price");
				String rentalPrice = (String)item.get("rentalPrice");
				String author = (String) item.get("Author");
				int year = (int) Integer.parseInt((String) item.get("year"));
				int inventory = (int) Integer.parseInt((String)item.get("inventory"));
			    if (Pattern.compile(Pattern.quote(inputName), Pattern.CASE_INSENSITIVE).matcher(name).find()){
			    	CD cd = new CD();		
			        cd.setName(name);
			        cd.setDescription(description);
			        cd.setInventory(inventory);
			        cd.setPrice(Double.parseDouble(rentalPrice));
			        cd.setAuthor(author);
			        cd.setQuantity(1);
			        cd.setRentalPrice(rentalPrice);
			        cd.setStatus(status);
			        cd.setType(type);
			        cd.setYear(year);
			        cd.setCategory("cd");
			        cds.add(cd);
			        found = true;
			    }
			}
			if(found) {
			System.out.println("\nThis is what we have found to select a book please input the index ");
			System.out.println(String.format("%20s %30s %30s %20s %20s %20s %20s","Index","Name" ,"Description" ,"Inventory" ,"Type" ,"Status", "price"));
			System.out.println("______________________________________________________________________________________________________________________________________________________________________________________________________________________");
			
			for(CD item: cds) {
				int i = 1;
				System.out.println(String.format("%20s %30s %30s %20s %20s %20s %20s",i , item.getName() ,item.getDescription(),item.getInventory() , item.getType()
						,item.getStatus(),item.getPrice()));
			}
			int index = Integer.parseInt(scanner.nextLine());
			CD cdToReturn = cds.get(index - 1);
			boolean isTrue = true;	
			do {
				System.out.println("Enter the quantity : ");
				String quantity = scanner.nextLine();
				if(cdToReturn.getInventory() < Integer.parseInt(quantity)) {
					System.out.println("Not enough inventory for this purchase there is only " + cdToReturn.getInventory() + " available");
				}else {
					cdToReturn.setQuantity(Integer.parseInt(quantity));
					isTrue = false;
				}
			}while(isTrue);
			return cdToReturn;
			}else {
				System.out.println("Nothing Found Please Try Again ");
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
}
