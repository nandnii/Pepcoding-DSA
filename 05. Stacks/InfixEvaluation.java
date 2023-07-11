import java.io.*;
import java.util.*;

public class InfixEvaluation{

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

    public static int operation(int v1, int v2, char optor){
        if (optor == '+'){
            return v1+v2;
        }
        else if (optor == '-'){
            return v1-v2;
        }
        else if (optor == '*'){
            return v1*v2;
        }
        else {
            return v1/v2;
        }
    }
  
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        Stack<Integer> nums = new Stack<>();
        Stack<Character> symbols = new Stack<>();

        for(int i=0; i<exp.length(); i++){
            char ch = exp.charAt(i);

            if (ch == '('){
                symbols.push(ch);
            } 
            else if (Character.isDigit(ch)){
                nums.push(ch - '0'); // to convert charcater to integer we do (- '0') it's basically (- 48)
            } 
            else if(ch == ')'){
                while(symbols.peek() != '('){
                    char optor = symbols.pop();
                    int v2 = nums.pop();
                    int v1 = nums.pop();

                    int eq = operation(v1, v2, optor);
                    nums.push(eq);
                }
                symbols.pop();
                
            }
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' ){

                //ch is wanting higher priority operators to solve first
                while(symbols.size() > 0 && symbols.peek() != '(' && precendence(ch) <= precendence(symbols.peek())){
                    char optor = symbols.pop();
                    int v2 = nums.pop();
                    int v1 = nums.pop();

                    int eq = operation(v1, v2, optor);
                    nums.push(eq);
                }

                //ch is pushing itself now
                symbols.push(ch);
            }
        }

        // This is done incase stack still has symbols & numbers
        while(symbols.size() > 0){
            char optor = symbols.pop();
            int v2 = nums.pop();
            int v1 = nums.pop();

            int eq = operation(v1, v2, optor);
            nums.push(eq);
        }

        // since whole calculation is happening in nums stack, hence ans is getting updated there only
        System.out.println(nums.peek()); 

    }

}