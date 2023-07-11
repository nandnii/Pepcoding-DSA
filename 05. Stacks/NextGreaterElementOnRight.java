import java.io.*;
import java.util.*;

public class NextGreaterElementOnRight{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Input array
    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    // nge is answer array
    int[] nge = solve(a);
    display(nge);
 }

 // array `a` will get passed on as array `arr`
 public static int[] solve(int[] arr){
   // write code here
   
   int n = arr.length;
   int[] nge = new int[n];
   Stack<Integer> st = new Stack<>();
   
   //Push last element to stack
   st.push(arr[n-1]);

   // Last element's nge would be -1 so last place in nge[] is equal to -1
   nge[n-1] = -1;

   // Loop from second last element
   for(int i=n-2; i>=0; i--){
	  // For every element 3 operations will happen
    // pop, answer, push

    //1. We pop till the condition size of stack > 0 
		//   and until all smaller elements are popped
    while(st.size() > 0 && arr[i] >= st.peek()){
        st.pop();
    }

    //2. If stack gets empty (means it's the biggest element) 
    //   then return -1 or return element on top
    if(st.size() == 0){
        nge[i] = -1;
    }
    else{
        nge[i] = st.peek();
    }

    //3. Push that element to stack cause elements left to it will check it
    st.push(arr[i]);
   }

   return nge;
 }

}