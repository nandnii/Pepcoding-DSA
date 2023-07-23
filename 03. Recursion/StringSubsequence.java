import java.util.*;

public class StringSubsequence {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList<String> ans = getSS(str);
        System.out.println(ans);

        scn.close();
    }

    // Faith (remaining) - bc --> [--, -b, -c, bc]
    // Expectation       - abc -> [---, --b, --c, -bc,
    //                             a--, a-b, a-c, abc]
    public static ArrayList<String> getSS(String str) {
        if(str.length() == 0){
            ArrayList<String> BaseAns = new ArrayList<>();
            BaseAns.add("");
            return BaseAns;
        }
        
        char ch = str.charAt(0);             // a
        String ros = str.substring(1);  // bc
        ArrayList<String> tempAns = getSS(ros);    // [--, -b, -c, bc]
        
        ArrayList<String> finalAns = new ArrayList<>();

        // first is -
        for(String st: tempAns){        // iterate on all elements of tempAns
            finalAns.add("-" + st);
        }

        // first is character
        for(String st: tempAns){
            finalAns.add(ch + st);
        } 

        return finalAns;
    }

}