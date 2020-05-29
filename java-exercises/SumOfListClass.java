import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class SumOfListClass {
    /**
     * Find the sum of two unequally sized lists (modifies original lists)
     * 
     * @param first  First List
     * @param second Second List
     * @return Sum of the first and second
     */
    public static List<Integer> getSumOfListElements(List<Integer> firstList, List<Integer> secondList) {
        try {
            if (firstList.size() >= secondList.size()) {
                for (int i = 0; i < secondList.size(); i++) {
                    firstList.set(i, firstList.get(i) + secondList.get(i));
                }
                return firstList;
            } else if (firstList.size() < secondList.size()) {
                for (int i = 0; i < firstList.size(); i++) {
                    secondList.set(i, firstList.get(i) + secondList.get(i));
                }
                return secondList;
            }
        } catch (NullPointerException e) {
            if (firstList == null && secondList == null) {
                return new ArrayList<Integer>();// return empty list
            } else if (firstList == null) {
                return secondList;
            } else if (secondList == null) {
                return firstList;
            } else
                e.printStackTrace();
        }
        return firstList;
    }

    /**
     * Find the sum of two unequally sized lists 
     * 
     * @param first  First List
     * @param second Second List
     * @return Sum of the first and second
     */
    public static List<Integer> getSumOfListElements1(List<Integer> first, List<Integer> second) {
        List<Integer> resultList = new ArrayList<Integer>();

        try {
            if (first.size() >= second.size()) {
                for (int i = 0; i < second.size(); i++) {
                    resultList.add(first.get(i) + second.get(i));
                }
                for (int j = second.size(); j < first.size(); j++) {
                    resultList.add(first.get(j));
                }
            } else if (first.size() < second.size()) {
                for (int i = 0; i < first.size(); i++) {
                    resultList.add(first.get(i) + second.get(i));
                }
                for (int j = first.size(); j < second.size(); j++) {
                    resultList.add(second.get(j));
                }
            }
        } catch (NullPointerException e) {
            if (first == null && second == null) {
                return resultList;
            } else if (first == null) {
                return second;
            } else if (second == null) {
                return first;
            } else
                e.printStackTrace();
        }
        return resultList;
    }

    public static void main(String[] args) {
        // Take two comma separated lists as input
        //      "10, 20, 30, 40, 50"
        //      "12, 23, 34"
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        List<Integer> first = new ArrayList<Integer>();
        List<Integer> second = new ArrayList<Integer>();

        String line0 = sc.next();
        line0 = line0.replace("\"", "").replaceAll("\t", "").replaceAll(" ", "");

        String line1 = sc.next();
        line1 = line1.replace("\"", "").replaceAll("\t", "").replaceAll(" ", "");

        sc.close();
        
        String[] flistData = line0.split("\\D");
        String[] slistData = line1.split("\\D");
        try {
            for (String data : flistData) {
                first.add(Integer.parseInt(data));
            }

            for (String data : slistData) {
                second.add(Integer.parseInt(data));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        System.out.println(getSumOfListElements1(first, second));        
    }
}
