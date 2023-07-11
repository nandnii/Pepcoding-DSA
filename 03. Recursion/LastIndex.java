import java.util.*;

public class LastIndex {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr = new int[n]; 
        for(int i=0; i<n; i++){
          arr[i] = scn.nextInt();
        }

        int x = scn.nextInt();

        int li = lastIndex(arr, 0, x);
        System.out.println(li);
        scn.close();
    }

    public static int lastIndex(int[] arr, int idx, int x){
        if(idx == arr.length) return -1;

        int temp_li = lastIndex(arr, idx+1, x);

        // means x hasn't been found yet
        if(temp_li == -1){
            if(x == arr[idx]){
                return idx;
            }
            else{
                return -1;
            }
        }

        // keep returning last index value again & again if x is found
        else{
            return temp_li;
        }
    }

}