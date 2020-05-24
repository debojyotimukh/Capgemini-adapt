import java.util.Scanner;
import java.util.regex.*;
public class MaxDigits
{
    /**
     * The input String to the method should be scanned for digits and the maximum digit should be returned.
        Input String can contain alphanumeric character, spaces and special characters
        If the input string is empty/null or does not contain any digits, -1 should be returned.
     * @param input
     * @return
     */
    public static int getMaxDigit(String input){
        if(input==null||input.length()==0) return -1;//if null or empty
        
        Pattern pt=Pattern.compile("\\d");//single digit regex
        Matcher m=pt.matcher(input);
        int maxDigit=-1;//if no digit found
        int num=0;
        while (m.find()) {
            num = Integer.parseInt(m.group());
            if (num > maxDigit)
                maxDigit = num;
            
        }
        return maxDigit;       
       
    }
    public static int getMaxDigit1(String input){
        if(input==null||input.length()==0) return -1;//if null or empty
        int maxDigit=-1;
        int num=0;
        for(int i=0;i<input.length();i++){
            if(Character.isDigit(input.charAt(i))){
                num=num*10+(input.charAt(i)-'0');//NOTE: properly converts char to int
                if(num>maxDigit)
                    maxDigit=num;
                num=0;//reset to 0
            } 
                
        }
        return maxDigit;
    }
    public static void main(String[] args){
        //Code here
        Scanner sc=new Scanner(System.in);
        int num=getMaxDigit1(sc.nextLine());
        if(num==-1) System.out.println("No digits in string");
        else System.out.println(num);
        sc.close();
    }
}