package functions;

import java.util.Scanner;

public class AddItems {
	public void menu(boolean edit) {
		Scanner scanner = new Scanner(System.in);
		boolean isContinue = true;
		do {
			System.out.println(
					"What whould you like to add/add inventory ?\n1. Books\n2. DVDs \n3. Music CDs \n4. Hardware \n5. Software \n6. Stationary\n7. Go Back");
			String option = scanner.nextLine();
			switch (option) {
			case "1":
				if(edit)
					updateInventory("books");
				else
					addNewItems("books");
				break;
			case "2":
				if(edit)
					updateInventory("dvd");
				else
					addNewItems("dvd");
				break;
			case "3":
				if(edit)
					updateInventory("cd");
				else
					addNewItems("cd");
				break;
			case "4":
				if(edit)
					updateInventory("hardware");
				else
					addNewItems("hardware");
				break;
			case "5":
				if(edit)
					updateInventory("software");
				else
					addNewItems("software");
				break;
			case "6":
				if(edit)
					updateInventory("stationary");
				else
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
	public void updateInventory(String toUpdate) {
		
	}

	public void addNewItems(String toAdd) {
		
	}
}
