import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class NextGreaterElementOnRightAlt {
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
        
        //Push first first index to stack
        st.push(0);

        // Loop from first to last element
        for(int i=1; i<n; i++){
            // For every element 2 operations will happen
            // pop, answer in one step
            // push in another

            //1. We pop till the condition size of stack > 0 
                //   and until all smaller elements are popped
            while(st.size() > 0 && arr[i] >= arr[st.peek()]){
                int pos = st.peek(); //we set nge's pos or index as top index in stack (it's basically the previous index)
                nge[pos] = arr[i]; //we populate that index of nge with selected array value
                st.pop();
            }

            //2. Push that index to stack cause elements rught to it will check it
            st.push(i);
        }

        //For remaining elements, taht weren't removed/popped
        while(st.size() > 0){
            int pos = st.peek();
            nge[pos] = -1;
            st.pop();
        }

        return nge;
    }
}