package InterviewQuestionsPractise;

import java.util.ArrayList;
import java.util.List;

public class javaTest {
	// input array = [1, 2, 2, 3, 4, 5, 5, 3]
	// output array = [1, 3, 4, 3]

	public static void main(String[] args) {
		int[] passingArray = { 1, 2, 2, 3, 4, 5, 5, 3 };
		javaTest javaTest = new javaTest();
		javaTest.arrayArrange(passingArray);
		javaTest.arrayArrangeFromAI(passingArray);
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

		if(givenArray[givenArray.length-1] != givenArray[givenArray.length-2]){
			j.add(givenArray[givenArray.length-1]);
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
}
