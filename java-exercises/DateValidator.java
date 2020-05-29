import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidator {
        /**
     * The method input parameter(String) should be parsed and checked if it matches the formats given below
    dd/MM/yyyy
    dd-MM-yyyy
    dd.MM.yyyy

    1.  If the input is a valid date as per any of the above formats the method should return 1
    2.  If the input is a invalid date the method should return -1    
    3.  If any other input pattern which does not match with above formats the method should return -1
        * @param dateString
     * @return
     */
    public static int checkDate(String dateString) {
        String pattern1 = "dd/MM/yyyy";
        String pattern2 = "dd-MM-yyyy";
        String pattern3 = "dd.MM.yyyy";

        SimpleDateFormat sdf = new SimpleDateFormat(pattern1);
        sdf.setLenient(false);
        try {
            sdf.parse(dateString);
            return 1;
        } catch (ParseException e) {

        }
        try {
            sdf.applyPattern(pattern2);
            sdf.parse(dateString);
            return 1;
        } catch (ParseException e) {

        }
        try {
            sdf.applyPattern(pattern3);
            sdf.parse(dateString);
            return 1;
        } catch (ParseException e) {

        }

        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (checkDate(sc.nextLine()) == 1)
            System.out.println("Valid");
        else
            System.out.println("Invalid");

        sc.close();
    }

}