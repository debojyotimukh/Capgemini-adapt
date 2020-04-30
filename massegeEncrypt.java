import java.util.Scanner;

/**
 * The input message String to the method should be encrypted as per the below rules. 
 * encrypted message should be returned back.
message should be converted to lower case #
a and e should be replaced with each other #
o and u should be replaced with each other #
i should be replaced with ! and space should be replaced with + #
In case of Consonant, It should be replaced with next immediate consonant#
In case of digit, it should be replaced with next digit#
z should be replaced with b and 0 with 1 #
Assume that the input string is alphanumeric without special characters
zdhnt  019 
*/

public class massegeEncrypt {
    private static boolean isConsonant(char c) {
        return "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ".contains(String.valueOf(c));
    }
    private static char nextConsonant(char c){
        int i="bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ".indexOf(c);
        return "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ".charAt(i+1);
    }
 
    public static String encrypt(String mString){
        //message should be converted to lower case
        StringBuilder sBuilder=new StringBuilder(mString.toLowerCase());
        int num=0;
        char ch;
        for(int i=0;i<sBuilder.length();i++){
            //a and e should be replaced with each other
            if(sBuilder.charAt(i)=='a') sBuilder.setCharAt(i, 'e');
            else if(sBuilder.charAt(i)=='e') sBuilder.setCharAt(i, 'a');
            //o and u should be replaced with each other
            if(sBuilder.charAt(i)=='o') sBuilder.setCharAt(i, 'u');            
            else if(sBuilder.charAt(i)=='u') sBuilder.setCharAt(i, 'o');
            //i should be replaced with ! and space should be replaced with +
            if(sBuilder.charAt(i)=='i') sBuilder.setCharAt(i, '!');
            if(sBuilder.charAt(i)==' ') sBuilder.setCharAt(i, '+');
            
            //In case of digit, it should be replaced with next digit
            if(sBuilder.charAt(i)=='9') sBuilder.setCharAt(i, '0');
            else if(Character.isDigit(sBuilder.charAt(i))) {
                num=(int)(sBuilder.charAt(i))+1;
                sBuilder.setCharAt(i, (char)num);
                num=0;
            }
            //In case of Consonant, It should be replaced with next immediate consonant
            //z should be replaced with b
            if(sBuilder.charAt(i)=='z') sBuilder.setCharAt(i, 'b');
            else if(isConsonant(sBuilder.charAt(i))){
                ch=nextConsonant(sBuilder.charAt(i));
                sBuilder.setCharAt(i, ch);
            }
        }
        return sBuilder.toString();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(encrypt(sc.nextLine()));
        sc.close();
    }
}