import java.util.*;

public class Inverse{

  public static void main(String[] args) {
    // write your code here  

    // The inverse of a number is defined as the number created by 
    // interchanging the face value and index of digits of number.

    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    // Initial ans is 0 and counter is index of original number starting from rightmost side
    int ans = 0;
    int counter = 1;

    while(n > 0){
      int digit = n % 10; // to get last digit which will decide place aka number of zeroes for new number
      n = n / 10;

      ans = ans + counter * (int)Math.pow(10, digit-1);
      counter++;
      
    }
    System.out.println(ans);

    scn.close();
  }

    
}
