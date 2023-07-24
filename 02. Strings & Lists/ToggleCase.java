 import java.util.*;

public class ToggleCase {

	public static String toggleCase(String str){

        // since we have to update string, so we can't use String type
        StringBuilder sb = new StringBuilder(str);
		
        for(int i = 0; i < sb.length(); i++){
			char letter = sb.charAt(i);		// get that letter
			if(letter >= 'a' && letter <= 'z'){
                char uch = (char)('A' + letter - 'a');
                sb.setCharAt(i, uch);
			}
			else if(letter >= 'A' && letter <= 'Z'){
                char lch = (char)('a' + letter - 'A');
                sb.setCharAt(i, lch);
			}
		}

		return sb.toString();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(toggleCase(str));
        scn.close();
	}

}