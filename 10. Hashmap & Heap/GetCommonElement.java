import java.util.*;

public class GetCommonElement{

    public static void main(String[] args) throws Exception {
        // write your code here
        
        Scanner scn = new Scanner(System.in);
		
        // first array input
        int n1 = scn.nextInt();
        int[] a1 = new int[n1];
        for(int i=0; i<n1; i++){
            a1[i] = scn.nextInt();
        }

        // second array input
        int n2 = scn.nextInt();
        int[] a2 = new int[n2];
        for(int i=0; i<n2; i++){
            a2[i] = scn.nextInt();
        }

        scn.close();

        HashMap<Integer, Integer> hm = new HashMap< >();

        // this will build a hashmap with number & it's frequency
        for(int val: a1){
            if(hm.containsKey(val)){
                int freq = hm.get(val);
                freq++;
                hm.put(val, freq);
            }
            else{
                hm.put(val, 1);
            }
        }
        
        for(int val: a2){
            if(hm.containsKey(val)){
                System.out.println(val);
                hm.remove(val);
            }
        }
    
    }

}