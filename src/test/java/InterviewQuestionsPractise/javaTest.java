package InterviewQuestionsPractise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class javaTest {
	// input array = [1, 2, 2, 3, 4, 5, 5, 3]
	// output array = [1, 3, 4, 3]
	Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		int[] passingArray = { 1, 2, 2, 3, 4, 5, 5, 3 };
		javaTest javaTest = new javaTest();
		// javaTest.arrayArrange(passingArray);
		// javaTest.arrayArrangeFromAI(passingArray);
		// javaTest.printArray(passingArray);
		// System.out.println(javaTest.findBiggest(1,20));
		// checkDoWhile(1);
		// typeConversion();
		// postAndPreIncrement();
		// terneryOperator();
		// turnNumberToBinary(72);
		// fibonacciAdd(5,0,1);
		// checkInputType();
		// checkInputTypeFromAI();
		endOfFileCheck();
	}

	void arrayArrange(int[] givenArray) {
		ArrayList<Integer> j = new ArrayList<>();

		for (int i = 0; i < givenArray.length - 1; i++) {
			if (givenArray[i] != givenArray[i + 1]) {
				j.add(givenArray[i]);
			} else {
				i += 1;
				continue;
			}

		}

		if (givenArray[givenArray.length - 1] != givenArray[givenArray.length - 2]) {
			j.add(givenArray[givenArray.length - 1]);
		}
		System.out.println(j);

	}

	void arrayArrangeFromAI(int[] arr) {
		List<Integer> result = new ArrayList<>();

		int i = 0;
		while (i < arr.length) {
			int j = i + 1;
			// skip forward over any identical elements
			while (j < arr.length && arr[j] == arr[i]) {
				j++;
			}
			// if there was exactly one of arr[i], j == i+1
			if (j == i + 1) {
				result.add(arr[i]);
			}
			// jump to the next new value
			i = j;
		}

		// print with brackets or comma‐separated
		System.out.println(result);
	}

	void printArray(int[] arrayInput) {
		map.put(1, 2);
		for (int i = 0; i < arrayInput.length; i++) {
			System.out.println(arrayInput[i]);

			if (map.containsKey(arrayInput[i])) {
				map.put(arrayInput[i], map.get(arrayInput[i]) + 1);
			} else {
				map.putIfAbsent(arrayInput[i], 1);
			}
		}

		map.entrySet().removeIf(entry -> entry.getValue() > 2);
		System.out.println(map);
	}

	int findBiggest(int a, int b) {
		/*
		 * Given number a and b, find the biggest between them if both a and b are in
		 * range between 10-20
		 * else print / return 0
		 * Ex: (19, 11) -> 19
		 * (29,9) -> 0
		 * (9,8) -> 0
		 * (11, 21) -> 11
		 */
		if (b > a) {
			int temp = b;
			b = a;
			a = temp;
		}
		if (a >= 10 && a <= 20)
			return a;
		if (b >= 10 && b <= 20)
			return b;
		return 0;
	}

	public static void checkDoWhile(int doWhileLimit) {

		do {
			System.out.println(doWhileLimit);
			doWhileLimit++;
		} while (doWhileLimit <= 10);
	}

	public static void typeConversion() {
		// Converting int to byte, which is bigger in range that byte
		int a = 352;
		byte b = (byte) a; // If the number is out of range then calculation is = Given number % range of
							// the converting type (range for byte is -128 to 127 = 256 {width of the
							// range})

		System.out.println("The conversion of " + a + " from int to byte is: " + b);
	}

	public static void postAndPreIncrement() {
		int a = 10; // Using this for post increment
		int b = a++;
		System.out.println(b); // Output: 10

		int c = 10; // Using this for pre increment
		int d = ++b;
		System.out.println(d); // Output: 11
	}

	// Ternery operator

	public static void terneryOperator() {
		int a = 10, b = 20;
		System.out.println((a > b) ? a++ : (b % 2 == 0) ? "even" : "odd");
	}

	public static void turnNumberToBinary(int numberToConvert) {
		// Only integer and positive numbers
		ArrayList<Integer> binaryArrayList = new ArrayList<>();

		while (numberToConvert > 0) {
			binaryArrayList.add(numberToConvert % 2);
			numberToConvert = numberToConvert / 2;
		}

		System.out.println(binaryArrayList); // with boxes and comma, the output
		for (int i = 0; i < binaryArrayList.size(); i++) {
			System.out.print(binaryArrayList.get(i) + " "); // Without boxes and comma, the output
		}

	}

	public static void fibonacciAdd(int numberToCalculate, int initialNumber, int nextNumber) {
		if (initialNumber >= 0 && nextNumber >= 0) {
			int tempCalculationHolder;

			for (int i = 1; i <= numberToCalculate; i++) {
				tempCalculationHolder = initialNumber + nextNumber;
				initialNumber = nextNumber;
				nextNumber = tempCalculationHolder;

				System.out.print(tempCalculationHolder + " ");
			}

		} else
			System.out.println("Please provide number greater than 0");

	}

	public static void checkInputType() {
		// Coding challenge from hacker rank, to rank the input accoring to there data
		// types
		/*
		 * Ex:
		 * 2
		 * 13
		 * 13 can be fitted in:
		 * byte
		 * short
		 * int
		 * long
		 * 5590
		 * 5590 can be fitted in:
		 * short
		 * int
		 * long
		 */
		Scanner scanner = new Scanner(System.in);
		int inputCount = scanner.nextInt(); // Picks the count for how many times loops should run
		while (inputCount > 0) {
			if (scanner.hasNextLong()) {
				long n = scanner.nextLong();

				if (n >= -128 && n <= 127) {
					System.out.println(n + " can be fitted in:");
					System.out.println("* byte");
					System.out.println("* short");
					System.out.println("* int");
					System.out.println("* long");
				} else if (n >= -32768 && n <= 32767) {
					System.out.println(n + " can be fitted in:");
					// System.out.println("* byte");
					System.out.println("* short");
					System.out.println("* int");
					System.out.println("* long");
				} else if (n >= (Math.pow(-2, 31)) && n <= (Math.pow(2, 31)) - 1) {
					System.out.println(n + " can be fitted in:");
					// System.out.println("* short");
					System.out.println("* int");
					System.out.println("* long");
				} else if (n >= Math.pow(-2, 63) && n <= (Math.pow(2, 63)) - 1) {
					System.out.println(n + " can be fitted in:");
					// System.out.println("* short");
					// System.out.println("* int");
					System.out.println("* long");
				}
			} else
				System.out.println(scanner.next() + " can't be fitted anywhere.");
			inputCount--;
		}
		scanner.close();
	}

	public static void checkInputTypeFromAI(){
		Scanner scanner = new Scanner(System.in);
    
    // Ensure there is actually an integer to read for the test case count
    if (!scanner.hasNextInt()) {
        return;
    }
    int inputCount = scanner.nextInt(); 
    
    while (inputCount > 0) {
        // Read the input as a String first
        String input = scanner.next();
        
        try {
            // Try to parse the input as a long
            long n = Long.parseLong(input);
            
            System.out.println(n + " can be fitted in:");
            
            // Check each type independently using Java's built-in constants
            if (n >= Byte.MIN_VALUE && n <= Byte.MAX_VALUE) {
                System.out.println("* byte");
            }
            if (n >= Short.MIN_VALUE && n <= Short.MAX_VALUE) {
                System.out.println("* short");
            }
            if (n >= Integer.MIN_VALUE && n <= Integer.MAX_VALUE) {
                System.out.println("* int");
            }
            
            // If it successfully parsed as a long, it always fits in a long!
            System.out.println("* long");
            
        } catch (NumberFormatException e) {
            // This triggers if the number is too large for a long (or not a valid number)
            System.out.println(input + " can't be fitted anywhere.");
        }
        
        inputCount--;
    }
    scanner.close();
	}

	public static void endOfFileCheck(){

		//Taking input os the strings
		Scanner scanner = new Scanner(System.in);
		int currentLineCount = 0;

		while(scanner.hasNextLine()){
			currentLineCount++;
			String currentLine = scanner.nextLine();
			if(!currentLine.contains(" end-of-file.")){
				System.out.println(currentLineCount+". "+currentLine);
			} else {
				System.out.println(currentLineCount+". "+currentLine);
				break;
			}
		}
		scanner.close();
	}
}
