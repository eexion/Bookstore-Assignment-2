package tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TestReadFile {
	public static void main(String args[]) {

		boolean isMatch = false;
		Scanner console = new Scanner(System.in);
		System.out.print("Enter file name : ");
		String fName = console.nextLine();
		System.out.print("Enter string to match : ");
		String match = console.nextLine();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fName));
			String s;
			System.out.println("Matching lines are ");
			while ((s = br.readLine()) != null) {
				if (s.indexOf(match) != -1) {
					System.out.println(s);
					isMatch = true;
				}
			}
			if (isMatch == false)
				System.out.println("No matching line found.");
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		}

	}
}
