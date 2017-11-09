import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Scanner;

abstract class Data  {
	public abstract void print(PrintStream ps);
}

interface Weightable {
	public BigInteger Weight();
}

class IntData extends Data implements Weightable {
	long[] a;
	BigInteger min;
	BigInteger max;
	
	IntData(String line){
		String[] s = line.split(" ");
		a = new long[s.length];
		for(int i=0; i<s.length; i++) {
			a[i] = Long.parseLong(s[i]);
		}
	}
	@Override
	public BigInteger Weight() {
		BigInteger sum=BigInteger.ZERO;
		min = BigInteger.valueOf(a[0]);
		max = BigInteger.valueOf(a[0]);
		for(int i=0; i<a.length; i++) {
			sum=sum.add(BigInteger.valueOf(a[i]));
			if(min.compareTo(BigInteger.valueOf(a[i]))==0||min.compareTo(BigInteger.valueOf(a[i])) == 1)min = BigInteger.valueOf(a[i]);
			else if(max.compareTo(BigInteger.valueOf(a[i]))==0||max.compareTo(BigInteger.valueOf(a[i]))== -1)max = BigInteger.valueOf(a[i]);
		}
		return sum;
	}

	@Override
	public void print(PrintStream ps) {
		BigInteger big = Weight();
		ps.println(max +" "+min);
		ps.println(big);
		
	}

}

class StrData extends Data implements Weightable {
	String[] str;
	String min;
	String max;
	BigInteger minvalue;
	BigInteger maxvalue;
	
	StrData(String line){
		str = line.split(" ");
	}
	
	@Override
	public BigInteger Weight() {
		
		BigInteger res = BigInteger.ZERO;
		
		char[] a;
		a= str[0].toCharArray();
		for(int j=0; j<a.length; j++) {
			BigInteger asc = BigInteger.valueOf(a[j]);
			BigInteger cal = BigInteger.valueOf(128);
			cal = cal.pow(a.length-1-j);
			cal = cal.multiply(asc);
			res = res.add(cal);
		}
		min = str[0];
		max = str[0];
		minvalue = res;
		maxvalue = res;
		
		for(int i=1; i<str.length; i++) {
			a=str[i].toCharArray();
			BigInteger sum = BigInteger.ZERO;
			for(int j=0; j<a.length; j++) {
				BigInteger asc = BigInteger.valueOf(a[j]);
				BigInteger cal = BigInteger.valueOf(128);
				cal = cal.pow(a.length-1-j);
				cal = cal.multiply(asc);
				sum = sum.add(cal);
			}
			res = res.add(sum);
			if(minvalue.compareTo(sum)==0||minvalue.compareTo(sum) == 1) {
				minvalue = sum;
				min = str[i];
			}
			else if(maxvalue.compareTo(sum)==0||maxvalue.compareTo(sum)== -1) {
				maxvalue = sum;
				max = str[i];
			}
		}
		return res;
	}

	@Override
	public void print(PrintStream ps) {
		BigInteger Big = Weight();
		ps.println("\""+max+"\""+" "+"\""+min+"\"");
		ps.println(Big);
	}
	
}

public class Weight {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintStream ps = new PrintStream(System.out);
		String line = sc.nextLine();
		Scanner sc1 = new Scanner(line);
		if (sc1.hasNextInt()) {
			IntData a = new IntData(line);
			a.print(ps);
		} 
		else {
			StrData a = new StrData(line);
			a.print(ps);
		}
		sc.close();
		sc1.close();
	}
}