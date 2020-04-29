import java.util.Scanner;
import java.util.regex.*;
class LuckyRegNo{
    public static int sumOfDigits(int Number){
        int Reminder,Sum=0;
        while(Number > 0) {
			Reminder = Number % 10;
			Sum += Reminder;
			Number = Number / 10;
        }
        return Sum;
    }
    public static int checkRegistrationNumber(final String regno) {
        if(regno==null) return -1;
        final Pattern pt = Pattern.compile("(KA|DL)(0[0-9]|10)[A-Z][A-Z]{0,1}[1-9][0-9]{3}");
        final Matcher mr = pt.matcher(regno);
        final Pattern numpt = Pattern.compile("[1-9][0-9]{3}");
        final Matcher mr2 = numpt.matcher(regno);
        if (mr.matches()) {
            while (mr2.find()) {
                final String lastPart = mr2.group();
                final int sum = sumOfDigits(Integer.parseInt(lastPart));
                final int b = (int) (sum % 10);
                final int a = (int) (sum / 10);
                if (a + b == 6)
                    return 1;
                else
                    return 0;
            }
        }
        return -1;
    }

    public static void main(final String[] argc) {
        final Scanner sc = new Scanner(System.in);
        final String carRegNo = sc.next();
        switch(checkRegistrationNumber(carRegNo)){
            case 0:
                System.out.println("Valid registration number");
            break;
            case 1:
                System.out.println("Lucky registration number");
            break;
            case -1:
                System.out.println("Invalid registration number");
            break;
        }
        sc.close();
    }
}