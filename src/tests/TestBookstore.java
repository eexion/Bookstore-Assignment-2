package tests;

import java.util.ArrayList;
import java.util.Scanner;

import bookstore.*;
import functions.MainFunctions;
public class TestBookstore {
	public static void main(String args[]) {
		MainFunctions functions = new MainFunctions();
		try {
			functions.menu();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
