import java.util.*;

public class HighestFrequencyCharacter {

    public static void main(String[] args) throws Exception {
        // write your code here

        Scanner scn = new Scanner(System.in);
		String str = scn.next();
        scn.close();

        HashMap< Character, Integer> hm = new HashMap< >();

        // this will build a hashmap with lettrr & it's frequency
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);                // get the letter
            
            // if letter present then increase freq
            if(hm.containsKey(ch)){
                int oldFreq = hm.get(ch);
                int newFreq = oldFreq + 1;
                hm.put(ch, newFreq);
            }
            // else populate new character
            else{
                hm.put(ch, 1);
            }
        }

        // we assume first letter has max freq & compare it to every letter
        char maxFreqCh = str.charAt(0);
        for (Character key: hm.keySet()) {

            // if freq of current char is more than maxFreqCh, then it becomes maxFreqCh
            if(hm.get(key) > hm.get(maxFreqCh)){
                maxFreqCh = key;
            }
        }

        System.out.println(maxFreqCh);
    }
}