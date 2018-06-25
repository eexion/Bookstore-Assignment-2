package tests;

import java.util.ArrayList;
import java.util.Scanner;

import bookstore.*;
import functions.MainFunctions;
public class TestBookstore {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		MainFunctions functions = new MainFunctions();
		boolean isContinue = true;
		try {
			do {
				System.out.println("Where Whould you like to go ?\n1. Admin menu\n2. Customer Menu\n3. Non Customer menu\n4. Exit");
				String option = scanner.nextLine();
				switch(option) {
				case "1":
					functions.adminMenu();
					break;
				case "2":
					functions.customerMenu();
					break;
				case "3":
					functions.nonCustomerMenu();
					break;
				case "4":
					isContinue = false;
					break;
				default:
					System.out.println("Invalid input");
					break;
				}
			}while(isContinue);		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
