import java.io.PrintStream;
import java.util.Scanner;

abstract class Bag implements Range {
	public abstract void addItems(String line);

	public abstract int count();
}

interface Range {
	public Object min();

	public Object max();

	public int length();
}

class IntBag extends Bag {
	private int[] a;
	private int min;
	private int max;

	@Override
	public Object min() {
		min = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] < min)
				min = a[i];
		}
		return min;
	}

	@Override
	public Object max() {
		max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
		}
		return max;
	}

	@Override
	public int length() {
		return max - min + 1;
	}

	@Override
	public void addItems(String line) {
		String[] s = line.split(" ");
		a = new int[s.length];
		for (int i = 0; i < s.length; i++) {
			//System.out.println(Integer.parseInt(s[i]));
			a[i] = Integer.parseInt(s[i]);
		}
	}

	@Override
	public int count() {
		return a.length;
	}

}

class CharBag extends Bag {
	private char[] a = null;
	private int min;
	private int max;

	@Override
	public Object min() {
		min = 52;
		char cmin = a[0];
		for (int i = 0; i < a.length; i++) {
			int order = a[i];
			if (Character.isLowerCase(a[i])) order -= 96;
			else if (Character.isUpperCase(a[i])) order -= 38;

			if (min >= order) {
				min = order;
				cmin = a[i];
			}
		}
		return cmin;
	}

	@Override
	public Object max() {
		max = 0;
		char cmax = a[0];
		for (int i = 0; i < a.length; i++) {
			int order = a[i];
			if (Character.isLowerCase(a[i]))
				order -= 96;
			else if (Character.isUpperCase(a[i]))
				order -= 38;

			if (max <= order) {
				max = order;
				cmax = a[i];
			}
		}
		return cmax;
	}

	@Override
	public int length() {
		return max - min + 1;
	}

	@Override
	public void addItems(String line) {
		String[] c = line.split(" ");
		a = new char[c.length];
		for (int i = 0; i < c.length; i++) {
			a[i] = c[i].charAt(0);
		}
	}

	@Override
	public int count() {
		return a.length;
	}

}

public class Density {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintStream ps = new PrintStream(System.out);
		String line = sc.nextLine();
		Scanner sc1 = new Scanner(line);
		if(sc1.hasNextInt()){
			IntBag a = new IntBag();
			a.addItems(line);
			ps.print(a.min()+ " ");
			ps.print(a.max()+ " ");
			ps.printf("%.2f\n",a.count()/(float)a.length());
		}
		else{
			CharBag a = new CharBag();
			a.addItems(line);
			ps.print(a.min()+" ");
			ps.print(a.max()+" ");
			ps.printf("%.2f\n", a.count()/(float)a.length());
		}
		sc.close();
		sc1.close();
	}
}