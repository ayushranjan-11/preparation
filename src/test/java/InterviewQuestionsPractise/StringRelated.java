package InterviewQuestionsPractise;

import java.util.Arrays;

public class StringRelated {

    public static void main(String[] args) {
//        everyNth("abcdefg", 3);
//        endUp("hello");
//        System.out.println(max1020(11, 21));
//        System.out.println(containsCheck("Welcome", "cme"));
//        System.out.println(equalsCheck("Welcome", "welcome"));
        System.out.println(replaceCheck("sun is sun and sun is for heat and also it is beautiful", 'a', "Suraj dada"));
        subStringCheck("String which is long");
        splitCheck("$10_20_30_40_50");
        stringBuffer("$10_20_30_40_50");
    }

    static void everyNth(String str, int n) {
        String newString = "";
        //StringBuilder extractedText = new StringBuilder();
        for (int i = 0; i < str.length(); i += n) {
            //    extractedText.append(str.charAt(i));
            newString += str.charAt(i);
        }
        //System.out.println(extractedText);
        System.out.println(newString);
    }

    static void endUp(String str) {
        String text = "", text2 = "";
        if (str.length() <= 3) {
            System.out.println(str.toUpperCase());
        } else {
            for (int i = str.length() - 3; i < str.length(); i++) {
                text2 += str.charAt(i);
            }
        }
        for (int j = 0; j < str.length() - 3; j++) {
            text += str.charAt(j);
        }
        System.out.println(text + text2.toUpperCase());

//        if (str.length() <= 3) return str.toUpperCase();
//        int cut = str.length() - 3;
//        String front = str.substring(0, cut);
//        String back  = str.substring(cut);  // this takes from cut to the end
//
//        return front + back.toUpperCase();
    }

    static int max1020(int a, int b) {
        if (a < 10 || a > 20 && (b < 10 || b > 20)) {
            return 0;
        } else {
            return Math.max(a, b);
        }
    }

    static boolean containsCheck(String text, String toCheck) {
        return text.contains(toCheck);
        //contains() is case sensitive
        /*
        It will only check sequential texts or character array
        That means contains("come") for "welcome" is true but contains("cme") is false
        * */
    }

    static boolean equalsCheck(String string1, String string2) {
        return string1.equals(string2);
        //return string1.equalsIgnoreCase(string2);
        //return string1==string2;

    }

    static String replaceCheck(String stringForAction, char charToReplace, String stringForReplace) {
        //return stringForAction.replace('s',charToReplace);
        return stringForAction.replace("sun", stringForReplace);
        /* Works for character and character sequence
        * */
    }

    static void subStringCheck(String actionalableString){

        System.out.println(actionalableString.substring(2, 4));
        System.out.println(actionalableString.substring(1));
    }

    static void splitCheck(String stringToBeSplit){
        String [] arrayOfString = stringToBeSplit.split("_",3);
        System.out.println(Arrays.toString(arrayOfString));
    }

    static void stringBuffer(String experimenatalString){
        StringBuffer stringBuffer = new StringBuffer(experimenatalString);
        stringBuffer.reverse();
        System.out.println(stringBuffer);
    }
}
