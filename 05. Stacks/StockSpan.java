import java.io.*;
import java.util.Stack;

public class StockSpan{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] span = solve(a);
    display(span);
 }

 public static int[] solve(int[] arr){
    // write your code here

    int n = arr.length;
    int[] span = new int[n];
    Stack<Integer> st = new Stack<>();
    
    st.push(0);
    span[0] = 1;

    
    for(int i=1; i<n; i++){
      
      // Pop all smaller elements
      while(st.size() > 0 && arr[i] > arr[st.peek()]){
        st.pop();
      }
      
      // if will be executed when current element is bigger hence it popped every (small) element out
      // else will be executed when current element is smaller than some element before hence stack couldn't get empty
      // and then span will be that index minus biggest element index before that
      
      if (st.size() == 0) { 
        span[i] = i + 1;
      } 
      // else basically returns how many elements it could pop + 1 (it's own count)
      // which can be calculated by how back it went (subtraction)
      //index of current element - index of top element just before that (it could only go that far)
      else {
        span[i] = i - st.peek(); 
      } 

      st.push(i);
    }

    return span;

  }
}