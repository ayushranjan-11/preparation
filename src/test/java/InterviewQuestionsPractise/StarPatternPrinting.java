package InterviewQuestionsPractise;

public class StarPatternPrinting {

    public static void main(String[] args) {
        printStarPattern(4);
        printStarPatternReverse(4);
    }

    public static void printStarPattern(int noOfStars) {
        for (int i = 0; i <= noOfStars; ++i) {
            //System.out.print("Checking what i is doing");
            for (int j = 0; j <= i; ++j) {
                //System.out.print("checking what j is doing");
                System.out.print("#");
            }
            System.out.println();
        }
    }

    public static void printStarPatternReverse(int noOfStars) {
        for (int i = 0; i <= noOfStars; ++i) {
            //System.out.print("Checking what i is doing");
            for (int j = noOfStars; j >=i; j--) {
                //System.out.print("checking what j is doing");
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
