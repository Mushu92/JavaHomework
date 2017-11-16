import java.util.*;

class LoopException extends Exception{
	private static final long serialVersionUID = 1L;
	public LoopException(){
		System.out.println("LOOP");
	}
	
}
public class Looking {
	static public void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		ArrayList<Integer> cl = new ArrayList<Integer>();
		String[] a = line.split(" ");
		try {
			Check(a,a[0],cl);
		} catch (LoopException e) {
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("RANGE");
		}
		sc.close();
	}
	public static void Check(String[] as, String a, ArrayList<Integer> cl) 
			throws LoopException,ArrayIndexOutOfBoundsException{
		if(Character.isAlphabetic(a.charAt(0))){
			System.out.println(a);
		}
		else if(Character.isDigit(a.charAt(0))){
			int n = Integer.parseInt(a)-1;
			if(cl.contains(n)){
				throw new LoopException();
			}
			else {
				cl.add(n);
				Check(as, as[n], cl);
			}
		}
	}
}
