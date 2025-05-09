package InterviewQuestionsPractise;

import java.util.ArrayList;

public class ReverseNumber {
    
    public static void main(String[] args) {
        // reverseGiveNummber(1234);
        // pallindromCheck("141");
        // pallindromCheck(141);
        evenOddCheck(24687610);
    }

    static void reverseGiveNummber(int givenNumber) {
        ArrayList<Integer> reversedNumber = new ArrayList<>();
        int tempHolder = 0;
		int givenNummberReplica = givenNumber;

		while (givenNummberReplica > 0) {
			tempHolder = givenNummberReplica % 10;
//            System.out.print(tempHolder);
			reversedNumber.add(tempHolder);
			givenNummberReplica = givenNummberReplica / 10;
		}

		System.out.println("Given number: " + givenNumber + " and reverse is: " + reversedNumber);
	}

    static void pallindromCheck(String numberForPallindrom) {
        String reverseStore = "";

        for(int i = numberForPallindrom.length() -1; i>=0; i--) {
            reverseStore += numberForPallindrom.charAt(i);
        }
        System.out.println(reverseStore);

        if(reverseStore.contentEquals(numberForPallindrom)) {
            System.out.println("Given number is pallindrom");
        } else System.out.println("Given number is not pallindrom");
    }

    static void pallindromCheck(int numberToCheck) {
        int reversedNumberSave = 0, temp = 0;
        int numberToCheckCopy = numberToCheck;

        if(numberToCheck > 9) {
            while(numberToCheckCopy> 0) {
            temp = numberToCheckCopy %10;
            reversedNumberSave = reversedNumberSave*10+temp;
            numberToCheckCopy = numberToCheckCopy / 10;
        }
        } else System.out.println("Single digit number cannot be pallindrom");
        
        System.out.println(reversedNumberSave);

        if(reversedNumberSave == numberToCheck) System.out.println("Number is Pallindrom");
        else System.out.println("Number is not pallindrom");
    }

    static void evenOddCheck(int numberToCheck) {
        //Input = 24687610
        //Output = Even: 5 Odd: 3
        int numberToCheckCopy = numberToCheck;
        int temp = 0, oddCount = 0, evenCount = 0;
        if(numberToCheckCopy > 1) {
            if(numberToCheckCopy > 9) {
                while(numberToCheckCopy > 0) {
                temp = numberToCheckCopy % 10;
                if(temp % 2 == 0 && temp!= 0) {
                    evenCount++;
                } else oddCount ++;
                numberToCheckCopy = numberToCheckCopy / 10;
            }
            } else {
                if(numberToCheckCopy%2 == 0) {
                    evenCount++;
                } else oddCount++;
            }
            
            System.out.println("Given number was: "+numberToCheck+" even count is: "+evenCount+" odd count is: "+oddCount);
        } else System.out.println("Number should be greater than 1 to check even and odd");
    }
}
