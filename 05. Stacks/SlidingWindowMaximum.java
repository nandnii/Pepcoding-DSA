import java.io.*;
import java.util.*;

public class SlidingWindowMaximum{

    public static int[] solveNGE(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        //NGETR code
        st.push(n-1);
        nge[n-1] = n;

        for(int i=n-2; i>=0; i--){
            while(st.size() > 0 && arr[i] >= arr[st.peek()]){
                st.pop();
            }

            if(st.size() == 0){
                nge[i] = n;
            }
            else{
                nge[i] = st.peek();
            }

            st.push(i);
        }
        return nge;
    }
  
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
        arr[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());

        // code

        int[] nge = solveNGE(arr);

        for(int i=0 ;i<arr.length;i++){
           System.out.print(arr[i]+" ");
        }
        
        System.out.println(" ");
        
        for(int i=0 ;i<nge.length;i++){
           System.out.print(nge[i]+" ");
        }
        
        System.out.println(" ");

        int prevWinMax = 0;

        // this loop to find max of window starting from i
        for (int i = 0; i <= n-k; i++) {
            if(prevWinMax<i){
                prevWinMax=i;
            }
            
            int curr;
            if (prevWinMax >= i && prevWinMax < i + k) // prevWinMax in current Window
                curr = prevWinMax;
            else curr = i;

            while (nge[curr] >= i && nge[curr] < i + k) // exists in current window
                curr = nge[curr];
            
            prevWinMax = curr;
            
            System.out.println(arr[curr]);
        }
    }
}