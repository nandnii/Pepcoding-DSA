import java.util.*;
import java.lang.Math;
   
public class Rotate{

public static void main(String[] args) {
    // write your code here  
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int k = scn.nextInt();

    // first we calculate no of digits
    int temp = n;
    int nod = 0; // no of digits
    while(temp>0){
        temp = temp/10;
        nod++;
    }

    // OR DO IN ONE LINE IN O(1)
    // int nod = (int) Math.floor(Math.log10(n) + 1);

    // for k bigger than nod
    k = k % nod;

    // for negative k
    if(k < 0){
        k = nod + (k % (-nod));
    }

    // int div = 1;
    // int mul = 1;
    // for(int i=1; i<=nod; i++){
    //     if(i<=k){
    //         div = div * 10;
    //     }
    //     else{
    //         mul = mul * 10;
    //     }
    // }

    // Eg n = 23456, k = 2
    // q = 234, r = 56
    // ans = 56*1000 + 234 = 56234

    int div = (int) (Math.pow(10, (k)));
    int mul = (int) (Math.pow(10, nod - k));

    int q = n / div;    // to get digits before k
    int r = n % div;    // to get digits after k

    int ans = r * mul + q;
    System.out.println(ans);

    scn.close();
}

}