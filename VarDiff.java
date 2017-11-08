import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class VarDiff {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintStream ps = System.out;
		int[] x = new int[500];
		//
		int szx = 0;
		int sumx =0;
		for (int i = 0; sc.hasNextInt(); szx++, i++) {
			x[i] = sc.nextInt();
			sumx += x[i];
		}
		//
		double mu = sumx/(double)szx;
		double va =0;
		double sum = 0;
		for(int i =0; i<szx; i++) {
			sum+= (x[i] - mu)*(x[i] - mu);
		}
		va = sum/(double)szx;
		//
		int a = x[0]%2;
		int[] y = new int[szx];
		int sumy = 0;
		int sxy =0;
		for(int i= a; i<szx; i+=2) {
			y[sxy++] = x[i];
			sumy += x[i];
		}
		double muy = sumy/(double)sxy;
		double vy =0;
		sum =0;
		for(int i=0; i<sxy; i++) {
			sum += (y[i]-muy)*(y[i]-muy);
		}
		vy = sum/(double)(sxy-1);
		if((va-vy)<0) ps.printf("%.3f%n", -(va-vy));
		else ps.printf("%.3f%n",va-vy);
		sc.close();
	}
}