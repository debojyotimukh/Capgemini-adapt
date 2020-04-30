/**
 *  calculateAge(String):int[] 	 
Input parameter to the method should be the date of birth in format dd/mm/yyyy
Method should calculate and return the age in years and months as on 01/04/2019
Age should be returned in an integer array of length 2. The first element should contain the years part and the second element should contain months part of age
If the input date of birth is invalid (greater than or equal to 01/04/2019), method should return null
Note: Ignore the day part of date of birth for calculating age
 */
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class AgeCalculator {
    public static int[] calculateAge(String dob) throws ParseException {
    
        String pattern="dd/MM/yyyy";
        String refDate="01/04/2019";
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        Date dt=sdf.parse(dob);
        Date dt2=sdf.parse(refDate);
        int[] result={0,0};
        
        if(dt.before(dt2)){
            Calendar refDCalendar=Calendar.getInstance();
            refDCalendar.setTimeInMillis(dt2.getTime());
            Calendar dateOfBirth=Calendar.getInstance();
            dateOfBirth.setTimeInMillis(dt.getTime());
            result[0]=refDCalendar.get(Calendar.YEAR)-dateOfBirth.get(Calendar.YEAR);
            result[1]=refDCalendar.get(Calendar.MONTH)-dateOfBirth.get(Calendar.MONTH);
            if(result[1]<0){
                result[1]=result[1]+12;
                result[0]-=1;
            }
            return result;
        }
        return null;

    }

    public static String getDayOfDate(String date) throws ParseException {
        String pattern="dd/MM/yyyy";
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        Date dt=sdf.parse(date);
        Calendar dCalendar=Calendar.getInstance();
        dCalendar.setTimeInMillis(dt.getTime());
        switch(dCalendar.get(Calendar.DAY_OF_WEEK)){
            case Calendar.SUNDAY:
                return "Sunday";
            case Calendar.MONDAY:
                return "Monday";
            case Calendar.TUESDAY:
                return "Tuesday";
            case Calendar.WEDNESDAY:
                return "Wednesday";
            case Calendar.THURSDAY:
                return "Thursday";
            case Calendar.FRIDAY:
                return "Friday";
        }
        return "Saturday";
	}
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] result={0,0};
        try {
            result = calculateAge(sc.next());
        } catch (ParseException e) {
            // TODO Auto-generated catch block 
            e.printStackTrace();
        }
        finally{
            if(result==null) System.out.println("Invalid date of birth");
            else if(result[0]!=0) System.out.println("Years : "+result[0]+", Months : "+result[1]);
            else System.out.println("Months : "+result[1]);
        }
        sc.close();
    }
}