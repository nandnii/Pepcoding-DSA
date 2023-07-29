import java.io.*;
import java.util.*;

public class KLargestElements {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // size of arr
        int n = Integer.parseInt(br.readLine());

        // array input
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // top k elements
        int k = Integer.parseInt(br.readLine());

        // write your code here

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0; i<arr.length; i++){
            if(i<k){
                pq.add(arr[i]);
            }
            else{
                if(arr[i] > pq.peek()){
                    pq.remove(pq.peek());
                    pq.add(arr[i]);
                }
            }
        }

        while(pq.size() > 0){
            System.out.println(pq.remove());
        }
      
    }

}