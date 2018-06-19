package functions;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.json.simple.JSONObject;

import bookstore.Book;
import bookstore.CD;
import bookstore.Common;
import bookstore.DVD;
import bookstore.Hardware;
import bookstore.Software;

public class Purchase {
	public Book purchaseBook() throws Exception{
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
			        book.setPrice(price);
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

	
	 public DVD purchaseDVD() throws Exception {
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
					String producer = (String) item.get("Author");
					int year = (int) Integer.parseInt((String) item.get("year"));
					int inventory = (int) Integer.parseInt((String)item.get("inventory"));

				    if (Pattern.compile(Pattern.quote(inputName), Pattern.CASE_INSENSITIVE).matcher(name).find()){
				    	DVD dvd = new DVD();		
				        dvd.setName(name);
				        dvd.setDescription(description);
				        dvd.setInventory(inventory);
				        dvd.setPrice(price);
				        dvd.setProducer(producer);
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
	 public Common purchaseCD() throws Exception {
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
				        cd.setPrice(price);
				        cd.setProducer(author);
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
	 public Common purchaseSoftware() throws Exception {
		 Scanner scanner = new Scanner(System.in);
			try {
				ArrayList<JSONObject> products = MainFunctions.readJson("software");

				MainFunctions.show(products);
				ArrayList<Software> softwares = new ArrayList<Software>();
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
				    	Software software = new Software();		
				        software.setName(name);
				        software.setDescription(description);
				        software.setInventory(inventory);
				        software.setPrice(price);
				        software.setAuthor(author);
				        software.setQuantity(1);
				        software.setRentalPrice(rentalPrice);
				        software.setStatus(status);
				        software.setType(type);
				        software.setYear(year);
				        software.setCategory("software");
				        softwares.add(software);
				        found = true;
				    }
				}
				if(found) {
				System.out.println("\nThis is what we have found to select a book please input the index ");
				System.out.println(String.format("%20s %30s %30s %20s %20s %20s %20s","Index","Name" ,"Description" ,"Inventory" ,"Type" ,"Status", "price"));
				System.out.println("______________________________________________________________________________________________________________________________________________________________________________________________________________________");
				
				for(Software item: softwares) {
					int i = 1;
					System.out.println(String.format("%20s %30s %30s %20s %20s %20s %20s",i , item.getName() ,item.getDescription(),item.getInventory() , item.getType()
							,item.getStatus(),item.getPrice()));
				}
				int index = Integer.parseInt(scanner.nextLine());
				Software softwareToReturn = softwares.get(index - 1);
				boolean isTrue = true;	
				do {
					System.out.println("Enter the quantity : ");
					String quantity = scanner.nextLine();
					if(softwareToReturn.getInventory() < Integer.parseInt(quantity)) {
						System.out.println("Not enough inventory for this purchase there is only " + softwareToReturn.getInventory() + " available");
					}else {
						softwareToReturn.setQuantity(Integer.parseInt(quantity));
						isTrue = false;
					}
				}while(isTrue);
				return softwareToReturn;
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
	 public Common purchaseHardware() throws Exception {
		 Scanner scanner = new Scanner(System.in);
			try {
				ArrayList<JSONObject> products = MainFunctions.readJson("hardware");
				ArrayList<Hardware> Hardwares = new ArrayList<Hardware>();
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
					String manufacturer = (String)item.get("manufacturer");
					int inventory = (int) Integer.parseInt((String)item.get("inventory"));
					String modelNumber = (String)item.get("model");
				    if (Pattern.compile(Pattern.quote(inputName), Pattern.CASE_INSENSITIVE).matcher(name).find()){
				    	Hardware hardware = new Hardware();		
				        hardware.setName(name);
				        hardware.setDescription(description);
				        hardware.setInventory(inventory);
				        hardware.setPrice(price);
				        hardware.setManufacturer(manufacturer);
				        hardware.setQuantity(1);
				        hardware.setRentalPrice(rentalPrice);
				        hardware.setStatus(status);
				        hardware.setType(type);
				        hardware.setModelNumber(modelNumber);
				        hardware.setCategory("hardware");
				        Hardwares.add(hardware);
				        found = true;
				    }
				}
				if(found) {
				System.out.println("\nThis is what we have found to select a book please input the index ");
				System.out.println(String.format("%20s %30s %30s %20s %20s %20s %20s","Index","Name" ,"Description" ,"Inventory" ,"Type" ,"Status", "price"));
				System.out.println("______________________________________________________________________________________________________________________________________________________________________________________________________________________");
				for(Hardware item: Hardwares) {
					int i = 1;
					System.out.println(String.format("%20s %30s %30s %20s %20s %20s %20s",i , item.getName() ,item.getDescription(),item.getInventory() , item.getType()
							,item.getStatus(),item.getPrice()));
					
				}
				int index = Integer.parseInt(scanner.nextLine());
				Hardware hardwareToReturn = Hardwares.get(index - 1);
				boolean isTrue = true;	
				do {
					System.out.println("Enter the quantity : ");
					String quantity = scanner.nextLine();
					if(hardwareToReturn.getInventory() < Integer.parseInt(quantity)) {
						System.out.println("Not enough inventory for this purchase there is only " + hardwareToReturn.getInventory() + " available");
					}else {
						hardwareToReturn.setQuantity(Integer.parseInt(quantity));
						isTrue = false;
					}
				}while(isTrue);
				return hardwareToReturn;
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
	
	
	/*public void convert() {
		Common product = null;
		for (JSONObject item : arr) {
			switch(key) {
			case "books":
				product = new Book();
				break;
			case "hardware":
				product = new Hardware();
				break;
			case "dvd":
				product = new DVD();
				break;
			case "cd":
				product = new CD();
				break;
			case "software":
				product = new Software();
			}
			
			String name = (String) item.get("name");
			String description = (String) item.get("description");
			String type = (String) item.get("type");
			String status = (String) item.get("status");
			double price = (double) item.get("price");
			String rentalPrice = item.get("rentalPrice").toString();
			int inventory = (int) Integer.parseInt(item.get("inventory").toString());
			product.setInventory(inventory);
			product.setType(type);
			product.setDescription(description);
			product.setRentalPrice(rentalPrice);
			product.setPrice(price);
			product.setStatus(status);
			product.setName(name);
		}
	}*/
}
