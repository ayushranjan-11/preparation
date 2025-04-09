package InterviewQuestionsPractise;

import java.util.Objects;
import java.util.Scanner;

public class JavaTopics {
    public static void main(String[] args) {
//        System.out.println("Main method with main");
//        main("Main method without main");
//        main(100);
//        System.out.println(stringCompare("hello", "Hello"));
//        stringReverse("Hello");
        matrixInput();
    }

    public static void main(String string) {
        System.out.println(string);
    }

    public static void main(int number) {
        System.out.println(number);
    }

    public static boolean stringCompare(String a, String b) {
        if (Objects.equals(a, b)) {
            return true;
        }

        return false;
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
        if(scanner.hasNextInt()) {
            for (int i = 0; i< twoDArray.length; i++) {
                for(int j = 0; j < twoDArray.length; j++) {
                    twoDArray[i][j] = scanner.nextInt();
                }
            }
        } else {
            System.out.println("Please provide number inputs only");
            matrixInput();
        }

        for (int[] ints : twoDArray) {
            for (int j = 0; j < twoDArray.length; j++) {
                System.out.print(ints[j]+" ");
            }
            System.out.println();
        }

    }

}
