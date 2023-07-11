import java.io.*;
import java.util.*;

public class SmallestNumFollowingPattern{

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    // code

    int num = 1;
    Stack<Integer> st = new Stack<>();
    for(int j=0; j<str.length(); j++){
        char ch = str.charAt(j);
    
        if (ch=='d'){
            st.push(num);
            num++;
        }
        else {
            st.push(num);
            num++;
            while(st.size()>0){
                System.out.print(st.pop());
            }
        }
    }

    // After coming out of stack, if elements left
    // we'll add +1 to num cause we gotta print one extra for after last character
    st.push(num);
    while(st.size()>0){
        System.out.print(st.pop());
    }

}
}