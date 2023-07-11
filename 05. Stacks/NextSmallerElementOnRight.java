import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class NextSmallerElementOnRight {
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
        
        // //Push first index to stack
        st.push(arr[n-1]);
        nge[n-1] = -1;

        // Loop from first to last element
        for(int i=n-2; i>=0; i--){

            // Run while until stackk empty or
            // all bigger elements on left popped out
            while(st.size() > 0 && arr[i] < st.peek()){
                st.pop();
            }

            // if stack empty means it doesn't have smaller element (it's smallest)
            // else return top
            if(st.size() == 0){
                nge[i] = -1;
            }
            else{
                nge[i] = st.peek();
            }
            
            st.push(arr[i]);
        }

        return nge;
    }
}