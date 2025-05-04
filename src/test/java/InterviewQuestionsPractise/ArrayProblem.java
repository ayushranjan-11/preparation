package InterviewQuestionsPractise;

public class ArrayProblem {
	public static void main(String[] args) {
		int[] array = { 1, 34, 167, 143, 99, 10, 26, 999, 111 };
		printArray(array);
		findSmallestNumber(array);
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
}
