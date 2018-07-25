package progs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StdinScannerLogic {

	public static void main(String[] args) throws IOException {

		int listSize = -1;
		/*
		 * Scanner sc = new Scanner(System.in);
		 * System.out.println("Enter number of elements for list of Integers"); listSize
		 * = Integer.parseInt(sc.nextLine());
		 * 
		 * /// List of Integers List<Integer> list = new ArrayList<>();
		 * 
		 * for (int i = 0; i < listSize; i++) {
		 * list.add(Integer.parseInt(sc.nextLine())); }
		 * 
		 * for (int i = 0; i < listSize; i++) { System.out.println(list.get(i)); }
		 * 
		 * System.out.println("ENter number of elements for list of strings"); listSize
		 * = Integer.parseInt(sc.nextLine());
		 * 
		 * /// List of String List<String> strList = new ArrayList<>();
		 * 
		 * for (int i = 0; i < listSize; i++) { strList.add(sc.nextLine()); }
		 * 
		 * for (int i = 0; i < listSize; i++) { System.out.println(strList.get(i)); }
		 * 
		 */ // Using BufferReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Using BufferedReader, Enter number of elements for list of Integers");
		listSize = Integer.parseInt(br.readLine());
		/// List of Integers
		List<Integer> list1 = new ArrayList<>();

		for (int i = 0; i < listSize; i++) {
			list1.add(Integer.parseInt(br.readLine()));
		}

		for (int i = 0; i < listSize; i++) {
			System.out.println(list1.get(i));
		}

		System.out.println("ENter number of elements for list of strings");
		listSize = Integer.parseInt(br.readLine());

		/// List of String
		List<String> strList1 = new ArrayList<>();

		for (int i = 0; i < listSize; i++) {
			strList1.add(br.readLine());
		}

		for (int i = 0; i < listSize; i++) {
			System.out.println(strList1.get(i));
		}

	}

}
