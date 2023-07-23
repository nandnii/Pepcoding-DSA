import java.util.*;

public class KeypadCombinations {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList<String> ans = getKPC(str);
        System.out.println(ans);

        scn.close();
    }

    // input is 789         {0,     1,     2,     3,     4,     5,     6,      7,    8,     9  }
    static String[] codes = {".,", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    
    public static ArrayList<String> getKPC(String str) {
        if(str.length() == 0){
            ArrayList<String> BaseAns = new ArrayList<>();
            BaseAns.add("");
            return BaseAns;
        }

        char ch = str.charAt(0);             // character 7
        String ros = str.substring(1);  // 89

        ArrayList<String> tempAns = getKPC(ros);   // 6 combination words of 89 (3*2)
        
        ArrayList<String> finalAns = new ArrayList<>(); // should give 12 words (2*6)

        // Right now ch is '7' which inform of integer is 54
        // so we have to subract '0'/48 to convert it to 7 integer
        String code_for_ch = codes[ch - '0'];       // "tu"

        for(int i=0; i<code_for_ch.length(); i++){  // length is 2 

            // code_for_ch.charAt(i) will pick ith letter of that code, so first "t" then "u"
            // and add it to each element of tempAns

            for(String st: tempAns){
                finalAns.add(code_for_ch.charAt(i) + st);
            }
        }
        return finalAns;
    }

}