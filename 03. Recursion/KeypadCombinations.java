import java.util.*;

public class KeypadCombinations {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList<String> ans = getKPC(str);
        System.out.println(ans);

        scn.close();
    }

    // input is 789
    static String[] codes = {".,", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    
    public static ArrayList<String> getKPC(String str) {
        if(str.length() == 0){
            ArrayList<String> BaseAns = new ArrayList<>();
            BaseAns.add("");
            return BaseAns;
        }

        char ch = str.charAt(0);  // character 7
        String ros = str.substring(1);  // 89
        
        ArrayList<String> tempAns = getKPC(ros);  // 6 combination words of 89 (3*2)
        
        ArrayList<String> finalAns = new ArrayList<>(); // should give 12 words (2*6)

        // Right now ch is '6' which inform of integer is 54, so we have to subract '0'/48 to convert it to 6 integer
        String code_for_ch = codes[ch - '0']; // "tu"

        for(int i=0; i<code_for_ch.length(); i++){  // length is 2
            for(String recursion_string: tempAns){
                finalAns.add(code_for_ch.charAt(i) + recursion_string);
            }
        }
        return finalAns;
    }

}