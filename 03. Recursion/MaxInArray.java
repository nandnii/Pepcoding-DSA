import java.util.*;

public class MaxInArray {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        // input in array
        int[] arr = new int[n]; 
        for(int i=0; i<n; i++){
          arr[i] = scn.nextInt();
        }

        int max = maxOfArray(arr, 0);
        System.out.println(max);
        scn.close();
    }

    public static int maxOfArray(int[] arr, int idx){
        if(idx == arr.length - 1) return arr[idx];      // if assume last element is max, we'll start comparing with that

        int temp_max = maxOfArray(arr, idx+1);

        if(arr[idx] > temp_max) {
            return arr[idx];
        }
        else{
            return temp_max;
        }

    }

}