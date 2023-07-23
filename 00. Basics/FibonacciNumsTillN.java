import java.util.*;
  
public class FibonacciNumsTillN{

    public static void main(String[] args) {
    // write your code here

    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int a=0;
    int b=1;
    // System.out.println(a);
    // System.out.println(b);

    for(int i=0; i<=n; i++){
        System.out.println(a);
        int sum = a+b;
        a=b;
        b=sum;
        // System.out.println(sum);
    }
    scn.close();
    }
}