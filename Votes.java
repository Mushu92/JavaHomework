import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

class VotingBox<T>{
	public HashMap<T, Integer> hmap = new HashMap<T, Integer>();
	
	public void vote(T obj) {
		if(hmap.containsKey(obj)) {
			Integer i = hmap.get(obj);
			hmap.replace(obj, i+1);
		}
		else hmap.put(obj, 1);
	}
	public T elem(int i) {
		Set<T> ss = hmap.keySet();
		@SuppressWarnings("unchecked")
		T[] a = (T[]) ss.toArray();
		return a[i];
	}
	public int freq(T obj) {
		return hmap.get(obj);
	}
}
public class Votes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		VotingBox<String> vbox = new VotingBox<String>();
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			String[] strs = line.split(" ");
			for(int i=0; i<strs.length; i++) {
				vbox.vote(strs[i].toUpperCase());
			}
		}
		String sres=vbox.elem(0);
		int ires=vbox.freq(sres);
		int vsize = vbox.hmap.size();
		for(int i=0; i<vsize; i++) {
			int j = vbox.freq(vbox.elem(i));
			if(ires < j) {
				ires = j;
				sres = vbox.elem(i);
			}
			else if(ires == j) {
				if(sres.compareTo(vbox.elem(i)) > 0) {
					sres = vbox.elem(i);
					ires = j;
				}
			}
		}
		System.out.println(sres + " "+ ires);
		sc.close();
	}
}
