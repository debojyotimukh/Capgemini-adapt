import java.util.Scanner;
import java.lang.Math;

/**
 * Main class
 */
public class armstrong {
    /**
    * Main method
    * @param args 
    */
    	// Student code starts
    
    
    
    public static void main(String[] args) {
	
	int num,a,b,c;
	Scanner sc=new Scanner(System.in);
    num=sc.nextInt();
    sc.close();
	if(num>99&&num<1000){
	    c=num%10;
	    b=(num/10)%10;
	    a=num/100;

	    if(Math.pow(a,3)+Math.pow(b,3)+Math.pow(c,3)==num){
	        System.out.println("ARMSTRONG");
	    }
	    else System.out.println("NOT ARMSTRONG");
	}
	else System.out.println("INVALID_INPUT");
	// Student code ends
    }
}