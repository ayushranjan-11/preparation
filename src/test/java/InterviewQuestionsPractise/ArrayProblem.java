package InterviewQuestionsPractise;

import java.util.Scanner;

public class ArrayProblem {
	public static void main(String[] args) {
		int[] array = { 1, 34, 167, 143, 99, 10, 26, 999, 111 };
		//Storing Arrays values directly. To do this:
		/*
		int [] oneDArray = {1,2,3,4,5}
		* int[][] twoDArray = {{100, 200},
		* 						{300, 400},
		* 						{500, 600}}
		* */
//		printArray(array);
//		findSmallestNumber(array);
//		twoDimensionalArray();
		differentTypesOfDataInAnArray();
	}

	public static void printArray(int[] array) {
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
}
