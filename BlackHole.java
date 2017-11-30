import java.util.*;

class LoopException extends Exception{
	private static final long serialVersionUID = 1L;
	public LoopException(){
		super("LOOP");
	}	
}
class OutOfFuelException extends Exception{
	private static final long serialVersionUID = 1L;
	public OutOfFuelException(){
		super("FUEL");
	}	
}
class BlackHoleException extends Exception{
	private static final long serialVersionUID = 1L;
	public BlackHoleException(){
		super("BLACKHOLE");
	}	
}
class OutOfRangeException extends Exception{
	private static final long serialVersionUID = 1L;
	public OutOfRangeException(){
		super("RANGE");
	}	
}

public class BlackHole {
	static public void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		int fuel = sc.nextInt();
		int location = 1;
		String line = sc1.nextLine();
		String[] a = line.split(" ");
		try {
			Check(fuel,a,a[0],location);
		} catch (LoopException e) {
			System.err.print(e.getMessage());
		} catch (BlackHoleException e) {
			System.err.print(e.getMessage());
		} catch (OutOfFuelException e) {
			System.err.print(e.getMessage());
		} catch (OutOfRangeException e) {
			System.err.print(e.getMessage());
		}
		sc.close();
		sc1.close();
	}
	public static void Check(int fuel,String[] as, String a,int location) 
			throws LoopException, BlackHoleException, OutOfFuelException, OutOfRangeException{
		if(a.equals("[B]")) {
			throw new BlackHoleException();
		}
		char[] ss = a.toCharArray();
		boolean bool = true;
		for(int i=0; i<ss.length; i++) {
			if(!Character.isDigit(ss[i]))bool = false;
		}
		if(bool){
			int x = Integer.parseInt(a);
			int xlocation = location;
			int fuse = Math.abs(x-location);
			location = x;
			int n = location-1;
			
			if(n >= as.length) {
				throw new OutOfRangeException();
			}
			
			if(location == xlocation){
				throw new LoopException();
			}
			else {
				fuel -= fuse;
				if(fuel <= 0) throw new OutOfFuelException();
				else Check(fuel, as, as[n], location);
			}
		}
		else {
			System.out.println(a+" "+fuel);
		}
	}
}
