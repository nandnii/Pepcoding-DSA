import java.util.*;

public class RemovePrime {

	public static void solution(ArrayList<Integer> list){
		// write your code here
		for(int i = list.size() - 1; i >= 0; i--){
			int num = list.get(i);
			if(isPrime(num)){
				list.remove(i);
			}
		}
	}

	public static boolean isPrime(int n){
		for(int div=2; div*div<=n; div++){
			if(n%div == 0){
				return false;
			}
		}
        return true;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		for(int i = 0 ; i < n; i++){
			al.add(scn.nextInt());
		}
		solution(al);
		System.out.println(al);
        scn.close();
	}

}