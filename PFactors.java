import java.io.PrintStream;
import java.util.*;

public class PFactors {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintStream ps = System.out;
		ArrayList<Integer> al = new ArrayList<>();
		ArrayList<Integer> bl = new ArrayList<>();
		int a = sc.nextInt();
		int sumf = 0;
		for(int i = 2; i<a;i++) {
			if((a%i)==0) {
				al.add(i);
				sumf += i; 
			}
		}
		int sumb = 0;
		for(int i=2; i<=a; i++) {
			if(a%i==0) {
				a/=i;
				bl.add(i);
				sumb += i;
				i=1;
			}
		}
		if(sumf == 0) {
			ps.println(0);
		}
		else ps.println(sumf-sumb);
		sc.close();
	}
}
