/*************************************************
 * Write a function that accepts a String sentence as argument and returns a List<String> 
 * containing the words from the String input. The List should be sorted based on the length. 
 * The word with the least length should be on the top. In case if two words have the same length, 
 * then they are arranged alphabatically in ascending order. * 
 * 
 **********************************************************/
import java.util.*;
import java.text.BreakIterator;
public class sort_list_string {
    //CODE HERE
	public static void main(final String[] args) {
        // CODE HERE
        final List<String> words = new ArrayList<String>();
        final Scanner sc = new Scanner(System.in);
        final String text = sc.nextLine();
        sc.close();
        final BreakIterator breakIterator = BreakIterator.getWordInstance();
        breakIterator.setText(text);
        int lastIndex = breakIterator.first();
        while (BreakIterator.DONE != lastIndex) {
            final int firstIndex = lastIndex;
            lastIndex = breakIterator.next();
            if (lastIndex != BreakIterator.DONE && Character.isLetterOrDigit(text.charAt(firstIndex))) {
                words.add(text.substring(firstIndex, lastIndex));
            }
        }

        // words.sort((String s1, String s2) -> s1.length() - s2.length());
        Collections.sort(words, new Comparator<String>() {
            public int compare(final String s1, final String s2) {
            return s1.length() - s2.length();
        }
    });
    System.out.println(words);
	}
}
