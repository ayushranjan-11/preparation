package InterviewQuestionsPractise;

public class StringRelated {

    public static void main(String[] args) {
        everyNth("abcdefg", 3);
        endUp("hello");
        System.out.println(max1020(11, 21));
    }

    static void everyNth(String str, int n) {
        String newString="";
        //StringBuilder extractedText = new StringBuilder();
        for(int i = 0; i<str.length(); i+=n) {
        //    extractedText.append(str.charAt(i));
            newString+=str.charAt(i);
        }
        //System.out.println(extractedText);
        System.out.println(newString);
    }

    static void endUp(String str) {
        String text="", text2="";
        if(str.length()<=3) {
            System.out.println(str.toUpperCase());
        } else  {
            for(int i = str.length()-3; i<str.length(); i++) {
                text2 += str.charAt(i);
            }
        }
        for (int j = 0; j<str.length()-3;j++) {
            text+=str.charAt(j);
        }
        System.out.println(text+text2.toUpperCase());

//        if (str.length() <= 3) return str.toUpperCase();
//        int cut = str.length() - 3;
//        String front = str.substring(0, cut);
//        String back  = str.substring(cut);  // this takes from cut to the end
//
//        return front + back.toUpperCase();
    }

    static int max1020(int a, int b){
        if(a<10 || a>20 && (b<10 || b>20)) {
            return 0;
        } else {
            return Math.max(a, b);
        }
    }
}
