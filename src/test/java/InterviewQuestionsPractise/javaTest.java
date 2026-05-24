package InterviewQuestionsPractise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		terneryOperator();
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
		 * Given number a and b, find the biggest between them if both a and b are in range between 10-20
		 * else print / return 0
		 * Ex: (19, 11) -> 19
		 * (29,9) -> 0
		 * (9,8) -> 0
		 * (11, 21) -> 11
		 */
		if(b>a){
			int temp = b;
			b = a;
			a = temp;
		}
		if(a>=10 && a<=20) return a;
		if(b>=10 && b<=20) return b;
		return 0;
	}

	public static void checkDoWhile(int doWhileLimit){

		do{
			System.out.println(doWhileLimit);
			doWhileLimit++;
		} while (doWhileLimit<=10);
	}

	public static void typeConversion(){
		//Converting int to byte, which is bigger in range that byte
		int a = 352;
		byte b = (byte)a; //If the number is out of range then calculation is = Given number % range of the converting type (range for byte is -128 to 127 = 256 {width of the range})

		System.out.println("The conversion of "+a+" from int to byte is: "+b);
	}

	public static void postAndPreIncrement(){
		int a = 10; //Using this for post increment
		int b = a++;
		System.out.println(b); //Output: 10

		int c = 10; //Using this for pre increment
		int d = ++b;
		System.out.println(d); //Output: 11
	}

	//Ternery operator

	public static void terneryOperator(){
		int a =10, b=20;
		System.out.println((a>b) ? a++: (b%2==0) ? "even": "odd");
	}

}
