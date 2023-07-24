import java.util.*;

public class PalindromicStrings {

    public static boolean isPalindrome(String s){
        
        int i = 0;
        int j = s.length() - 1;

        while(i <= j){
            char f = s.charAt(i);
            char l = s.charAt(j);
            if(f != l){
                return false;
            } 
            else{
                i++;
                j--;
            }
        }
        return true;
    }

	public static void solution(String str){
        for(int i=0; i<str.length(); i++){
			for(int j=i+1; j<=str.length(); j++){
                String ss = str.substring(i,j);
				if(isPalindrome(ss) == true){
                    System.out.println(ss);
                }
			}
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);

        scn.close();
	}

}