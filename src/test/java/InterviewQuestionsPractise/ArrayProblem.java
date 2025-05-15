package InterviewQuestionsPractise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayProblem {
	public static void main(String[] args) {
		int[] array = { 1, 34, 167, 143, 99, 10, 26, 999, 111 };
		int [] arrayForCount = {10,20,30,60,50,60};
		//Storing Arrays values directly. To do this:
		/*
		int [] oneDArray = {1,2,3,4,5}
		* int[][] twoDArray = {{100, 200},
		* 						{300, 400},
		* 						{500, 600}}
		* */
//		printArray(array);
//		findSmallestNumber(array);
//		sumOfElementInAnArray(array);
//		twoDimensionalArray();
//		differentTypesOfDataInAnArray();
//		arrayArrangeWithString();
		arraySorting(array,"DESC"); //asc -> ascending order; desc -> decreasing order
//		arrayElementSearch(array, 10);
//		checkCount(arrayForCount);
//		countOccurence(arrayForCount, 60);
		arraysClassUsing(array);
	}

	static void printArray(int[] array) {
		// Printing numbers from array who is starting with 1
		int[] occuranceCount = new int[array.length];
		int rem = 0;
		for (int i = 0; i < array.length; i++) {
			int temp = array[i];
			if (temp == 1 || temp == 10) {
				System.out.println(temp);
				occuranceCount[i] = temp;
			} else if (temp > 10) {
				while (temp > 10) {
					temp = temp / 10;
					rem = temp;
					// System.out.println(array[i]);
				}
				if (rem == 1) {
					System.out.println(array[i]);
					occuranceCount[i] = array[i];
				}
			}
		}
		for (int j : occuranceCount) {
			System.out.print(j + " ");
		}

	}

	static void findSmallestNumber(int[] array) {
		int temp = array[0];

		for (int i = 0; i < array.length; i++) {
			if (array[i] < temp) {
				temp = array[i];
			}
		}
		System.out.println("Shortest number in an given aray is: " + temp);
	}

	static void sumOfElementInAnArray(int[] array){
		int sumHold= 0;
		for(int n: array){
			sumHold+=n;
		}
		System.out.println(sumHold);
	}

	static void twoDimensionalArray(){
		//Defining array size and storing values dynamically in that array


		int[][] twoDArray = new int[3][2]; //This means the array has 3 rows and 2 columns
		System.out.println(twoDArray.length); //rows count
		System.out.println(twoDArray[0].length); //column count

		System.out.println("Provide input for array");
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()) {
			for (int i = 0; i< twoDArray.length; i++) {
				for (int j = 0; j< twoDArray[0].length; j++) {
					twoDArray[i][j] = sc.nextInt();
				}
			}
			sc.close();
		}

		for (int i = 0; i< twoDArray.length; i++) {
			for (int j = 0; j < twoDArray[0].length; j++) {
				System.out.print(twoDArray[i][j]+" ");
			}
			System.out.println();
		}
	}

	static void differentTypesOfDataInAnArray() {
		/*This explains the way to store different data types in a single array
		Same data types can be stored in an array like:
		String[] stringArray = {"ABCD","EFGH","IJKL","LMOP"};
		Now to store something like this:
		{1, "ABCD", true, 12.25}
		we will use Object class instead of any data types
		Object[] differentKindOfArray = {1, "ABCD", true, 12.25};
		**Object is the root class for all predefined java class**
		 */
		Object[] differentKindOfArray = {1, "ABCD", true, 12.25};
		for(Object content : differentKindOfArray){
			System.out.println(content);
		}
//		for(int obj = 0; obj<differentKindOfArray.length; obj++){
//			System.out.println(differentKindOfArray[obj]);
//		}
	}

	static void arrayArrangeWithString(){
		Object[] arrayForIntAndString = {147,42,16,4,675,'a'};
		int[] arrayForObj = new int[arrayForIntAndString.length];
		for(int i = 0; i<arrayForIntAndString.length; i++) {
			Object elem = arrayForIntAndString[i];

			if (elem instanceof Character) {
				// Cast to Character, get primitive char, then its ASCII code
				char ch = (Character) elem;
				arrayForObj[i] = (int) ch;  // ASCII of 'a' is 97
			} else if (elem instanceof Number) {
				// Covers Integer, Long, etc.
				arrayForObj[i] = ((Number) elem).intValue();
			} else {
				throw new IllegalArgumentException(
						"Unsupported element type: " + elem.getClass()
				);
			}
		}
		for (int i = 0; i < arrayForObj.length - 1; i++) {
			if (arrayForObj[i] > arrayForObj[i + 1]) {
				int temp = arrayForObj[i];
				arrayForObj[i] = arrayForObj[i + 1];
				arrayForObj[i + 1] = temp;
			}
		}

        for (int i : arrayForObj) {
            System.out.println(i);
        }
	}

	static void arraySorting(int[] arrayToSort, String typeOfSorting){
		//Sorting of a given array in ascending and descending order

		int j = 0,k =0;
		switch (typeOfSorting.toLowerCase()){
			case "asc": {
				while(j< arrayToSort.length) {
					for (int i = 0; i < arrayToSort.length - 1; i++) {
						if (arrayToSort[i] > arrayToSort[i + 1]) {
							int temp = arrayToSort[i + 1];
							arrayToSort[i + 1] = arrayToSort[i];
							arrayToSort[i] = temp;
						}
					}
					j++;
				}

				System.out.println("Array in ascending order");
				for (int i: arrayToSort){
					System.out.print(i+" ");
				}
				System.out.println();
				break;
			}
			case "desc": {
				while(k< arrayToSort.length) {
					for (int i = 0; i < arrayToSort.length - 1; i++) {
						if (arrayToSort[i] < arrayToSort[i + 1]) {
							int temp = arrayToSort[i + 1];
							arrayToSort[i + 1] = arrayToSort[i];
							arrayToSort[i] = temp;
						}
					}
					k++;
				}

				System.out.println("Array in descending order");
				for (int i: arrayToSort){
					System.out.print(i+" ");
				}
				break;
			}
			default:
				System.out.println("Please check text. It should be either [asc] or [desc]");
		}
		System.out.println(); //Moving cursor to next line if this method is used along with other method
//		while(j< arrayToSort.length) {
//			for (int i = 0; i < arrayToSort.length - 1; i++) {
//				if (arrayToSort[i] > arrayToSort[i + 1]) {
//					int temp = arrayToSort[i + 1];
//					arrayToSort[i + 1] = arrayToSort[i];
//					arrayToSort[i] = temp;
//				}
//			}
//			j++;
//		}
//
//		System.out.println("Array in ascending order");
//		for (int i: arrayToSort){
//			System.out.print(i+" ");
//		}
//		System.out.println();
//
//		while(k< arrayToSort.length) {
//			for (int i = 0; i < arrayToSort.length - 1; i++) {
//				if (arrayToSort[i] < arrayToSort[i + 1]) {
//					int temp = arrayToSort[i + 1];
//					arrayToSort[i + 1] = arrayToSort[i];
//					arrayToSort[i] = temp;
//				}
//			}
//			k++;
//		}
//
//		System.out.println("Array in descending order");
//		for (int i: arrayToSort){
//			System.out.print(i+" ");
//		}
	}

	static void arrayElementSearch(int[] array, int toSearch){
		for(int i = 0; i<array.length; i++){
			if(array[i]==toSearch){
				System.out.println("Number " +toSearch+" found in position: "+i);
				break;
			}
		}
	}

	static void checkCount(int[] array){
		int countKeeper = 0;
		for (int i = 0; i< array.length; i++){
			for (int j = 0; j< array.length; j++){
				if (array[i]==array[j]) countKeeper++;
			}
			System.out.println("Count for "+array[i]+" is "+countKeeper);
			countKeeper=0;
		}
	}

	static void countOccurence(int[] array, int numberForOccurence){
		int count = 0;
		for (int i: array){
			if(i == numberForOccurence) count++;
		}
		System.out.println(numberForOccurence+" occured "+count+" times");
	}

	static void arraysClassUsing(int[] array){

		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
	}
}
