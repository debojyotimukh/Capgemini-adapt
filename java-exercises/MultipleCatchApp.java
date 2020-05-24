import java.util.Scanner;

class Sequence{
    /**
     * I. Subtract first with second element and replace first element with result,
     * second with third element and so on.. till array reaches its end. (intarr[0]
     * =intarr[1] - intarr[0], intarr[1]=intarr[2]-intarr[1] .........intarr[n-1]=
     * inta[n]-inta[n-1])
     * 
     * II Repeat the iterations as shown below: 
     * Initial input string is "1,5,9,2,3,5,6"
     * Input Integer array is 1 5 9 2 3 5 6 
     * Elements in array : 7
     * No. of Iterations : 6
     * 
     * Result of iterations: (intarray[0] = intarr[1] - intarr[0]...)
     * 
     * Initial array : 1 5 9 2 3 5 6 
     * after iteration 1: 4 4 -7 1 2 1 
     * after iteration 2: 0 -11 8 1 -1 
     * after iteration 3: -11 19 -7 -2 
     * after iteration 4: 30 -26 5
     * after iteration 5: -56 31 
     * after iteration 6: 87
     * 
     * @param inputStr Comma separated number string
     * @return integer value after repeated substraction
     */
    public static int sequences(String inputStr) throws ArrayIndexOutOfBoundsException, NumberFormatException {
        if (inputStr.isEmpty())
            throw new ArrayIndexOutOfBoundsException("No input given");
        int i = 0;
        String[] splStrings = inputStr.split(",");
        int[] intarr = new int[splStrings.length];
        for (String numString : splStrings) {
            intarr[i] = Integer.parseInt(numString);
            i++;
        }
        int l = intarr.length;
        int result = 0;
        for (i = 0; i < intarr.length - 1; i++) {
            for (int j = 0; j < l - 1; j++) {
                //Subtract first with second element and replace first element with result,
                //second with third element and so on.. till array reaches its end.
                result = intarr[j + 1] - intarr[j];
                intarr[j] = result;
            }
            l--;//array length decreases after each iteration
        }
        return intarr[0];
    }
}

public class MultipleCatchApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int d = Sequence.sequences(sc.nextLine());
            System.out.println(d);
        } catch (ArrayIndexOutOfBoundsException e1) {
            System.out.println("ArrayIndexOutOfBoundsException: " + e1.getMessage());
        } catch (NumberFormatException e2) {
            System.out.println("NumberFormatException " + e2.getMessage());
        }

        sc.close();
    }

}