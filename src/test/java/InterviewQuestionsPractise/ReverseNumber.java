package InterviewQuestionsPractise;

public class ReverseNumber {
    
    public static void main(String[] args) {
        reverseGiveNummber(1234);
    }

    static void reverseGiveNummber(int givenNumber) {
        int tempHolder = 0;
        int givenNummberReplica = givenNumber;

        while(givenNummberReplica>0) {
            tempHolder = givenNummberReplica%10;
            givenNummberReplica /= givenNummberReplica;
        }

        System.out.println("Given number: "+givenNumber+ " and reverse is: "+tempHolder);
    }
}
