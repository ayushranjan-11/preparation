package InterviewQuestionsPractise;

import java.util.Arrays;

public class StringRelated {

    public static void main(String[] args) {
//        everyNth("abcdefg", 3);
//        endUp("hello");
//        System.out.println(max1020(11, 21));
//        System.out.println(containsCheck("Welcome", "cme"));
//        System.out.println(equalsCheck("Welcome", "welcome"));
//        System.out.println(replaceCheck("sun is sun and sun is for heat and also it is beautiful", 'a', "Suraj dada"));
        subStringCheck("String which is long");
//        splitCheck("$10_20_30_40_50");
//        System.out.println(replaceCheck("1.1.1.1"));
//        makeOutWord("abyz", "YAY");
        makeOutWord("[[]]", "word");
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

    static void subStringCheck(String actionalableString) {

        System.out.println(actionalableString.substring(2, 4));
        System.out.println(actionalableString.substring(1));
    }

    static void splitCheck(String stringToBeSplit) {
        String[] stringWithoutLimit = stringToBeSplit.split("_");
        String[] arrayOfString = stringToBeSplit.split("_", 4);

        for (String arrayString : stringToBeSplit.split("_", 4)) {
            System.out.println(arrayString);
            /*Output: $10
            20
            30_40_50

             */
        }
        System.out.println(Arrays.toString(stringWithoutLimit));
        System.out.println(Arrays.toString(arrayOfString)); //Output: [$10, 20, 30_40_50]

        // *  %  ^  &  (  ) -> These cannot be used as regex for splitting string
    }

    static String replaceCheck(String stringToReplace) {

        return stringToReplace.replace(".", "[.]");
    }

    static void makeOutWord(String pattern, String word) {
        /*Given an "out" string length 4, such as "<<>>", and a word, return a new string where the word is in the middle
        of the out string, e.g. "<<word>>". Note: use str.substring(i, j) to extract the String starting at index i and
        going up to but not including index j.

        makeOutWord("<<>>", "Yay") → "<<Yay>>"
        makeOutWord("<<>>", "WooHoo") → "<<WooHoo>>"
        makeOutWord("[[]]", "word") → "[[word]]"
        * */
        if (pattern.length() % 2 != 0) {
            System.out.println("Pattern should be in group");
        } else {

            String toReplaceItem = pattern.substring((pattern.length() / 2)-1, (pattern.length() /2)+1);
            String withReplaceItem = pattern.charAt((pattern.length() /2)-1)+word+pattern.charAt((pattern.length() /2));

            pattern = pattern.replace(toReplaceItem,withReplaceItem);
            System.out.println(toReplaceItem);
            System.out.println(pattern);
        }
    }
}
