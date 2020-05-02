import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class SumOfListClass {
    /**
     * Find the sum of two unequally sized lists
     * @param first First List
     * @param second    Second List
     * @return  Sum of the first and second
     */
    public static List<Integer> getSumOfListElements(List<Integer> first, List<Integer> second) {
        List<Integer> res = new ArrayList<Integer>();

        try {
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
        } catch (NullPointerException e) {
            if (first == null && second == null) {
                return res;
            } else if (first == null) {
                return second;
            } else if (second == null) {
                return first;
            } else
                e.printStackTrace();
        }
        return res;
    }

    public static void main(String[] args) {
        //Take two comma separated lists as input
        //      "10, 20, 30, 40, 50"
        //      "12, 23, 34"
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        List<Integer> f = new ArrayList<Integer>();
        List<Integer> s = new ArrayList<Integer>();

        String line0 = sc.next();
        line0 = line0.replace("\"", "").replaceAll("\t", "").replaceAll(" ", "");

        String line1 = sc.next();
        line1 = line1.replace("\"", "").replaceAll("\t", "").replaceAll(" ", "");

        sc.reset();
        sc.close();
        String[] flistData = line0.split("\\D");
        String[] slistData = line1.split("\\D");
        try {
            for (String data : flistData) {
                f.add(Integer.parseInt(data));
            }

            for (String data : slistData) {
                s.add(Integer.parseInt(data));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        System.out.println(getSumOfListElements(f, s));
    }
}
