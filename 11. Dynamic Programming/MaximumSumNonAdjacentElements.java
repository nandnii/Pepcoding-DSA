import java.util.*;

public class MaximumSumNonAdjacentElements {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        scn.close();


        int prevInc = arr[0];
        int prevExc = 0;

        for(int i=1; i<n; i++){
            int newInc = prevExc + arr[i];
            int newExc = Math.max(prevInc, prevExc);

            prevInc = newInc;
            prevExc = newExc;
        }
        
        int maxSum = Math.max(prevInc, prevExc);
        System.out.println(maxSum);
    }
}