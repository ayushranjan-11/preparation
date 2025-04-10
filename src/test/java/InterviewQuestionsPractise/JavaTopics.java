package InterviewQuestionsPractise;

import java.util.*;

public class JavaTopics {
    public static void main(String[] args) {
//        System.out.println("Main method with main");
//        main("Main method without main");
//        main(100);
//        System.out.println(stringCompare("hello", "Hello"));
//        stringReverse("Hello");
//        matrixInput();
//        System.out.println(stringReverseWithStringBuilder("Ayush"));
//        listTesting();
        vowelCheck("Ayush Ranjan");
    }

    public static void main(String string) {
        System.out.println(string);
    }

    public static void main(int number) {
        System.out.println(number);
    }

    public static boolean stringCompare(String a, String b) {
        return Objects.equals(a, b);
    }

    public static void stringReverse(String providedString) {
        StringBuilder temporaryString = new StringBuilder();
        for (int i = providedString.length() - 1; i >= 0; i--) {
            temporaryString.append(providedString.charAt(i));
        }
        System.out.println("Reversed String: " + temporaryString);
    }

    public static void method1() {
        System.out.println("Method without parameter");
    }

    //Method overloading. Method overloading is done with parameters only, having different return type don't qualify method for overloading
    public static String method1(String str) {
        System.out.println("Method with parameter but different return type");
        return str;
    }

    public static void matrixInput() {
        System.out.println("Provide 4 number input for 2D array");
        int[][] twoDArray = new int[2][2];
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            for (int i = 0; i < twoDArray.length; i++) {
                for (int j = 0; j < twoDArray.length; j++) {
                    twoDArray[i][j] = scanner.nextInt();
                }
            }
        } else {
            System.out.println("Please provide number inputs only");
            matrixInput();
        }

        for (int[] ints : twoDArray) {
            for (int j = 0; j < twoDArray.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }

    }

    public static String stringReverseWithStringBuilder(String stringToBeReversed) {
        return new StringBuilder(stringToBeReversed).reverse().toString().toLowerCase();
    }

    public static void listTesting() {
        List<Integer> integerList = new ArrayList<>();

        //integerList.add(0,1);
        int listInput = 0;

        for (int i = 0; i < 10; i++) {
            integerList.add(i, listInput++);
        }

        for (Integer integer : integerList) {
            System.out.println(integer);
        }
    }

    public static String vowelCheck(String stringToCheck) {
        StringBuilder vowelkeeper = new StringBuilder();
        stringToCheck = stringToCheck.toLowerCase();

        Map<Character, Integer> vowelCount = new LinkedHashMap<>();
        vowelCount.put('a', 0);
        vowelCount.put('e', 0);
        vowelCount.put('i', 0);
        vowelCount.put('o', 0);
        vowelCount.put('u', 0);
        for (int i = 0; i < stringToCheck.length(); i++) {
            if (stringToCheck.charAt(i) == 'a' || stringToCheck.charAt(i) == 'e' || stringToCheck.charAt(i) == 'i'
                    || stringToCheck.charAt(i) == 'o' || stringToCheck.charAt(i) == 'u') {

                vowelkeeper.append(stringToCheck.charAt(i));
                vowelCount.put(stringToCheck.charAt(i), vowelCount.get(stringToCheck.charAt(i))+1);

                //TODO: Improve the duplicate addition of the characters
            }
        }
        System.out.println("Present vowels were: " + vowelkeeper);
        for(Map.Entry<Character, Integer> e: vowelCount.entrySet()) {
            System.out.printf("  %c: %d%n", e.getKey(), e.getValue());
        }
        return vowelkeeper.toString();
    }

    public void nonStaticMethod() {
        System.out.println("Non static method for this class");
    }
}
