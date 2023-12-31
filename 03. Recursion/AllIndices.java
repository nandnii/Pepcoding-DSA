import java.io.*;

public class AllIndices {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int x = Integer.parseInt(br.readLine());
        int[] iarr = allIndices(arr, x, 0, 0);

        if(iarr.length == 0){
            System.out.println();
            return;
        }

        for(int i = 0; i < iarr.length; i++){
            System.out.println(iarr[i]);
        }
    }

    public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
        // write ur code here

        // when we reach end of array, create a new array of size 
        // same as the number of times x was found in array
        if(idx == arr.length){
            return new int[fsf];
        }

        // if we find, then increase fsf & also populate fsf array
        if(arr[idx] == x){
            int[] iarr = allIndices(arr, x, idx+1, fsf+1);
            iarr[fsf] = idx; 
            return iarr;
        }
        else{
            int[] iarr = allIndices(arr, x, idx+1, fsf);
            return iarr;
        }
        
    }

}