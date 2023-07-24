import java.util.*;

public class StringPermutations {

	public static void solution(String str){
		// write your code here

        int n = str.length();
        int f = factorial(n);       // to see how many permutations we'll get

        for(int i = 0; i < f; i++){
            StringBuilder sb = new StringBuilder(str);
            int temp = i;           // don't wanna disturb i as it's handling outer loop
            for(int div = n; div >= 1; div--){
                int q = temp / div;
                int r = temp % div; 

                System.out.print(sb.charAt(r));
                sb.deleteCharAt(r);

                temp = q;
            }
            System.out.println();
        }		
	}
    
    public static int factorial(int n){
        int ans = 1;
        for(int i = 2; i<=n; i++){
            ans = ans * i;
        }

        return ans;
    }
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
        scn.close();
	}

}