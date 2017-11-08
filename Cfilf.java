import java.io.PrintStream;
import java.util.Scanner;

class Line{
	private String line;
	
	public Line() {}
	public void addLine(String line) {
		this.line = line;
	}
	public int cf(char c) {
		int fcount =0;
		for(int i=0; i<line.length(); i++) {
			if(line.charAt(i) == c) {
				fcount++;
			}
		}
		return fcount;
	}
}

class LineBag{
	private Line[] linebag;
	private int size;
	private int nMaxLines = 10000;
	
	public LineBag() {
		linebag = new Line[nMaxLines];
		size =0;
	}
	
	public void addLine(Line line) {
		this.linebag[size++] = line;
	}
	public void print() {
		System.out.println(size);
	}
	public double ilf(char c) {
		double res = 0;
		int count = 0;
		for(int i=0; i<size; i++) {
			if(linebag[i].cf(c) > 0) count++;
		}
		if(count != 0) res = Math.log(size/(double)count);
		return res;
	}
	public Line[] getLinebag() {
		return linebag;
	}

	public void setLinebag(Line[] linebag) {
		this.linebag = linebag;
	}

}

public class Cfilf {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintStream ps = new PrintStream(System.out);
		LineBag bag = new LineBag();
		char[] c1 = new char[10000];
		int csize =0;
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			line = line.toLowerCase();
			c1[csize++] = line.charAt(0);
			Line l1 = new Line();
			l1.addLine(line);
			bag.addLine(l1);
		}
		for(int i =0; i<csize; i++) {
			double result;
			Line[] res = bag.getLinebag();
			result = res[i].cf(c1[i])*bag.ilf(c1[i]);
			if(i==csize-1) ps.printf("%.2f", result);
			else ps.printf("%.2f\n",result);
		}
		sc.close();
	}

}
