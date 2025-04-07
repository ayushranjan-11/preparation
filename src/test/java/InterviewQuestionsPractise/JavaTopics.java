package InterviewQuestionsPractise;

public class JavaTopics {
    public static void main(String[] args) {
        System.out.println("Main method with main");
        main("Main method without main");
        main(100);
        System.out.println(stringCompare("hello", "Hello"));
        stringReverse("Hello");
    }

    public static void main(String string) {
        System.out.println(string);
    }

    public static void main(int number) {
        System.out.println(number);
    }

    public static boolean stringCompare(String a, String b) {
        if (a == b) {
            return true;
        }

        return false;
    }

    public static void stringReverse(String providedString) {
        String temporaryString = "";
        for (int i = providedString.length() - 1; i >= 0; i--) {
            temporaryString += providedString.charAt(i);
        }
        System.out.println("Reversed String: " + temporaryString);
    }

}
