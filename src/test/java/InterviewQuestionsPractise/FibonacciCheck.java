package InterviewQuestionsPractise;

public class FibonacciCheck {
    public static void main(String[] args) {
        fibonacciPrint(10);
    }

    static void fibonacciPrint(int tillWhen) {
        int initialNumber = 0, initialNumberSecond = 1, sum = 0;
        for(int i = 0; i<tillWhen; i++) {
            sum = initialNumber + initialNumberSecond;
            initialNumber = initialNumberSecond;
            initialNumberSecond = sum;

            System.out.print(initialNumberSecond+", ");
        }
    }
}
