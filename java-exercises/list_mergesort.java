import java.util.*;

public class list_mergesort {
	
	private static Scanner sc;

	public static void main(final String[] args) {
		final List<Integer> l1 = new ArrayList<Integer>();
		final List<Integer> l2 = new ArrayList<Integer>();
		List<Integer> res;
		sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			l1.add(i, sc.nextInt());
		}
		for (int i = 0; i < 5; i++) {
			l2.add(i, sc.nextInt());
		}
		res = mergeAndSort(l1, l2);
		System.out.println(res);
		sc.close();
	}

	public static List<Integer> mergeAndSort(final List<Integer> al1, final List<Integer> al2) {
		final List<Integer> l = new ArrayList<Integer>();
	    if(al1.size()==5&&al2.size()==5){
	         al1.addAll(5,al2);
	         Collections.sort(al1);
	         l.add(al1.get(2));
	         l.add(al1.get(6));
	         l.add(al1.get(8));
	    }
	    else{
	        throw new  IllegalArgumentException("Input list is of wrong size"); 
	    }
	    return l;
	}
	
}
