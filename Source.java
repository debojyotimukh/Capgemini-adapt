import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Source {
	public static List<Integer> getSumOfListElements(final List<Integer> first, final List<Integer> second) {
        // CODE HERE
        List<Integer> res = new ArrayList<Integer>();
        if (first == null) {
            res = second;
        }
        if (second == null) {
            res = first;
        }
        if (first.size() == second.size()) {
            for (int i = 0; i < first.size(); i++) {
                res.add(first.get(i) + second.get(i));
            }
        } else if (first.size() > second.size()) {
            for (int i = 0; i < second.size(); i++) {
                res.add(first.get(i) + second.get(i));
            }
            for (int j = second.size(); j < first.size(); j++) {
                res.add(first.get(j));
            }
        } else if (first.size() < second.size()) {
            for (int i = 0; i < first.size(); i++) {
                res.add(first.get(i) + second.get(i));
            }
            for (int j = first.size(); j < second.size(); j++) {
                res.add(second.get(j));
            }
        }
        return res;

    }

    public static void main(final String[] args) {

        final Scanner sc = new Scanner(System.in).useDelimiter(",|\"");
        final List<Integer> f = new ArrayList<Integer>();
        final List<Integer> s = new ArrayList<Integer>();
	    List<Integer> res;
	    while(sc.hasNextInt()){
	        f.add(sc.nextInt());
	    }
	    
	    //System.out.println(f);
	    sc.nextLine();
	    while(sc.hasNextInt()){
	        s.add(sc.nextInt());
	    }
        sc.nextLine();
	    sc.close();
	    //System.out.println(s);
	    res=getSumOfListElements(f,s);
        System.out.println(res);
        sc.close();
	}
}
