import java.io.PrintStream;
import java.util.Scanner;

class InvertPrintStream extends PrintStream {

	public InvertPrintStream(PrintStream ps) {
		super(ps);
	}
	
	public void print(int n) {
		String a = Integer.toString(n);
		for(int i=0; i<a.length();i++) {
			int c = Integer.parseInt(Character.toString(a.charAt(i)));
			super.printf("%d",9-c);
		}
	}
	public void print(String str) {
		char[] res = str.toCharArray();
		for(int i=0; i<res.length;i++) {
			if(Character.isAlphabetic(res[i])) {
				if(Character.isLowerCase(res[i]))super.print(Character.toUpperCase(res[i]));
				else super.print(Character.toLowerCase(res[i]));
			}
			else super.print(res[i]);
			}
		}
}



public class Invert {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintStream ss = new PrintStream(System.out);
		InvertPrintStream ps = new InvertPrintStream(System.out);
		String[] linebag = new String[1000];
		int size =0;
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			linebag[size++] = line;
		}
		for(int i=0; i<size;i++) {
			String aline = linebag[i];
			String[] strbag;
			strbag = aline.split(" ");
			for(int j=0; j<strbag.length; j++) {
				char[] arr  = strbag[j].toCharArray();
				if(Character.isDigit(arr[0])) {
					if(Character.isDigit(arr[arr.length-1]))ps.print(Integer.parseInt(strbag[j]));
					else {
						ps.print(Integer.parseInt(strbag[j].substring(0, arr.length-1)));
						ps.print(arr[arr.length-1]);
					}
				}
				else ps.print(strbag[j]);
				if(j != (strbag.length -1)) ss.print(" ");
			}
			ss.print("\n");
		}
		sc.close();
		ss.close();
		ps.close();

	}

}
