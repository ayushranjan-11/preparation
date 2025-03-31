package InterviewQuestionsPractise;

public class JavaTopics {
    public static void main(String[] args) {
        System.out.println("Main method with main");
        main("Main method without main");
        main(100);
    }

    public static void main(String string) {
        System.out.println(string);
    }

    public static void main(int number) {
        System.out.println(number);
    }
}
