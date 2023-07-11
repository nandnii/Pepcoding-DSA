import java.util.*;
    
public class DigitsOfNumber{

    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        // APPROACH 1
        Stack<Integer> st = new Stack<>();
        while(n > 0){
            st.push(n%10);
            n = n/10;
        }

        while(st.size() > 0){
            System.out.println(st.pop());
        }



        // APPROACH 2
        // int dig = 0;
        // int i = n;

        // while(i!=0){
        //     i = i / 10;
        //     dig++;
        //     // rem = n % dig;
        // }

        // int div = (int)Math.pow(10, dig-1);
        // while (div!=0){
        //     int q = n / div;
        //     System.out.println(q);

        //     n = n%div;
        //     div = div/10;
        // }



        // APPROACH 3
        // String string_number = Integer.toString(n);
 
        // for (int i = 0; i < string_number.length(); i++) {
         //     System.out.println(string_number.charAt(i));
        // }
        
        scn.close();

    }
}