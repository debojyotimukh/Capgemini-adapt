import java.util.Scanner;
import java.util.regex.*;
class ColourCodeValidator{
//Match a pattern for 6 digit hex colour code e.g. #f5deb3
    public static int validateHexCode(String code){
        if(code.length()==7){
            Pattern pt=Pattern.compile("#[0-9a-fA-F]+");
            Matcher mr=pt.matcher(code);
            if(mr.matches()) return 1;
        }
        
        return -1;
    }
    
//Match a pattern rgb(2,55,255)
    public static int validateDecimalCode(String code){
        int i=0;
        String[] str;
        //Check for number between 0-255
        Pattern pt=Pattern.compile("\\b(1?[0-9]{1,2}|2[0-4][0-9]|25[0-5])\\b");
        Matcher mr=pt.matcher(code);
        str=pt.split(code);
        //Check for 3 numbers 
        while(mr.find()){
            ++i;
        }
        if(i==3&&str[0].equals("rgb(")&&str[1].equals(",")&&str[2].equals(",")&&str[3].equals(")")) return 1;
        return 0;
    }
}

class CodeValidator{
    public static void main(String[] args){
        
        Scanner sc=new Scanner(System.in);
        int op=sc.nextInt();
        String colourCode;
        switch(op){
            case 1:
                colourCode=sc.next();
                if(ColourCodeValidator.validateHexCode(colourCode)==1) 
                    System.out.println("Valid Code");
                break;
            case 2:
                colourCode=sc.next();
                if(ColourCodeValidator.validateDecimalCode(colourCode)==1)
                        System.out.println("Valid Code");
                break;
            default:
                System.out.println("Invalid choice");
        }
        sc.close();
    }
}