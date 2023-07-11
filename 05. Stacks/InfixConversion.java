import java.io.*;
import java.util.*;

public class InfixConversion{
  
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        Stack<String> pre = new Stack<>();
        Stack<String> post = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for(int i=0; i<exp.length(); i++){
            char ch = exp.charAt(i);

            if (ch == '('){
                operator.push(ch);
            } 
            
            else if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
                // by adding empty string in character, it gets converted to string 
                // which is imp cause stack can only contain string
                pre.push(ch + ""); 
                post.push(ch  + "");
            } 
            
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' ){

                //ch is wanting higher priority operators to solve first
                while(operator.size() > 0 && operator.peek() != '(' && precendence(ch) <= precendence(operator.peek())){
                    char op = operator.pop();
                    
                    // FOR POST STACK
                    String postV2 = post.pop();
                    String postV1 = post.pop();
                    String postV = postV1 + postV2 + op;
                    post.push(postV);

                    // FOR PRE STACK
                    String preV2 = pre.pop();
                    String preV1 = pre.pop();
                    String preV = op + preV1 + preV2;
                    pre.push(preV);
                }

                //ch is pushing itself now
                operator.push(ch);
            }

            else if(ch == ')'){
                while(operator.size() > 0 && operator.peek() != '('){
                    
                    char op = operator.pop();
                    
                    // FOR POST STACK
                    String postV2 = post.pop();
                    String postV1 = post.pop();
                    String postV = postV1 + postV2 + op;
                    post.push(postV);

                    // FOR PRE STACK
                    String preV2 = pre.pop();
                    String preV1 = pre.pop();
                    String preV = op + preV1 + preV2;
                    pre.push(preV);
                }
                if (operator.size() > 0) operator.pop(); // to remove (
                
            }
        }

        // This is done incase stack still has operator & numbers
        while(operator.size() > 0){
            char op = operator.pop();
                    
            // FOR POST STACK
            String postV2 = post.pop();
            String postV1 = post.pop();
            String postV = postV1 + postV2 + op;
            post.push(postV);

            // FOR PRE STACK
            String preV2 = pre.pop();
            String preV1 = pre.pop();
            String preV = op + preV1 + preV2;
            pre.push(preV);
        }

        // since whole calculation is happening in nums stack, hence ans is getting updated there only
        System.out.println(post.peek()); 
        System.out.println(pre.peek()); 

    }

    public static int precendence(char optor){
        if (optor == '+'){
            return 1;
        }
        else if (optor == '-'){
            return 1;
        }
        else if (optor == '*'){
            return 2;
        }
        else {
            return 2;
        }
        
    }

}



