import java.util.*;

public class LongestConsecutiveSequence{

    public static void main(String[] args) throws Exception {
        // write your code here

        Scanner scn = new Scanner(System.in);
            
        // first array input
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }

        scn.close();

        HashMap<Integer, Boolean> hm = new HashMap<>();

        // in first loop we put true infront of all numbers
        for(int val: arr){
            hm.put(val, true);
        }

        // in second loop, we put false infront of those whose smaller element is present
        // this lets starting elements remain true
        for(int val: arr){
            if(hm.containsKey(val - 1)){
                hm.put(val, false);
            }
        }

        // in third loop we get start point of subsequence & it's max length
        int subsequenceStart = 0;
        int subsequenceLength = 0;
        for(int val: arr){
            if(hm.get(val) == true){
                int tempStart = val;
                int tempLength = 1;

                while(hm.containsKey(tempStart + tempLength)){
                    tempLength++;
                }

                if(tempLength > subsequenceLength){
                    subsequenceStart = tempStart;
                    subsequenceLength = tempLength;
                }
            }
        }

        for(int i=0; i<subsequenceLength; i++){
            System.out.println(subsequenceStart + i);
        }

    }

}