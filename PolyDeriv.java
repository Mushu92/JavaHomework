import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

class Polynomial {
	private int[] c;
	private int size;
	
	public Polynomial(int[] c) {
		this.c = c;
		this.size = c.length-1;
	}

	public void print(PrintStream ps) {
		if(c[0]==0) {
			int count = 0;
			for(int i=0; i<=size; i++) {
				if(c[i] != 0) {
					int[] res =Arrays.copyOfRange(c, i, size+1);
					ps.println(Arrays.toString(res).replaceAll("^.|.$","").replaceAll(", ", " "));
					count++;
					break;
				}
			}
			if(count == 0)ps.printf("0\n");
		}
		else ps.println(Arrays.toString(c).replaceAll("^.|.$", "").replace(", ", " "));
	}
	
	public Polynomial deriv() {
		int [] res = new int[size];
		for(int i=0; i<=size-1; i++) {
			res[i] = c[i]*(size-i);
		}
		Polynomial r = new Polynomial(res);
		return r;
	}
	
	public Polynomial add(Polynomial a) {
		int[] test = a.getC();
		int[] result;
		int[] add;
		int sub =0;
		if(c.length < test.length) {
			result = test;
			add = c;
			sub = test.length - c.length;
		}
		else {
			result = c;
			add = test;
			sub = c.length - test.length;
		}
		for(int i=sub; i<result.length;i++) {
			result[i] += add[i-sub];
		}
		Polynomial res = new Polynomial(result);
		return res;
	}
	
	public int[] getC() {
		return c;
	}

	public void setC(int[] c) {
		this.c = c;
	}

}

public class PolyDeriv {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintStream ps = System.out;
		int size1;
		size1 = sc.nextInt();
		int[] fx = new int[size1+1];
		for(int i=0; i<=size1; i++) {
			fx[i] = sc.nextInt();
		}
		Polynomial f = new Polynomial(fx);
		size1= sc.nextInt();
		int[] gx= new int[size1+1];
		for(int i=0; i<=size1; i++) {
			gx[i] = sc.nextInt();
		}
		Polynomial g = new Polynomial(gx);
		Polynomial df = f.deriv();
		Polynomial dg = g.deriv();
		Polynomial h = df.add(dg);
		h.print(ps);
		sc.close();
	}
}
