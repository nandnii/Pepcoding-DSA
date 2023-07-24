import java.util.*;

public class StringCompression {

	public static String compression1(String str){
		// this is supposed to turn convert multiple letter repetition into a single one

        String ans = str.charAt(0) + "";             // saving this so that new letters can be appended into this, converted character to string by ""

        for(int i = 1; i < str.length(); i++){
            char prev = str.charAt(i-1);
            char curr = str.charAt(i);
            
            if(curr != prev){
                ans += curr;
            }
        }

        return ans;
	}

	public static String compression2(String str){
		// this is supposed to turn convert multiple letter repetition into a single one plus the number of times it was repeated

        int count = 1;
        String ans = str.charAt(0) + "";

        for(int i = 1; i < str.length(); i++){
            char prev = str.charAt(i-1);
            char curr = str.charAt(i);
            
            if(curr == prev){
                count++;
            }
            else{
                if(count == 1){         // we'll only add count when count > 1, otherwise just add next character
                    ans += curr;
                }
                else{
                    ans += count;
                    count = 1;
                    ans += curr;
                }
                
            }
        }

        if(count > 1){                  // if at the end, count is remaining*for last character) then add count
            ans += count;
        }

		return ans;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(compression1(str));
		System.out.println(compression2(str));

        scn.close();
	}

}