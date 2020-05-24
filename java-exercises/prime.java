/**
 * Find the sum of all prime numbers between the range (num1,num2)
 * where num1>3 and num2<1000
 */

import java.util.Scanner;

/**
 * Main class
 */
public class prime {
//PRIMALITY TEST
    public static boolean is_prime(int n){
        if(n<=3)
            throw new IllegalArgumentException("NUMBER >3 EXPECTED");
        else if(n%2==0||n%3==0) return false;
        for(int i=5;i*i<=n;i=i+6){
            if(n%i==0||n%(i+2)==0) return false;
                
        }
        return true;
    }

//MAIN
    public static void main(String[] args) {

	// Student Code begins
    int sum=0,num1,num2;
	Scanner sc=new Scanner(System.in);
	num1=sc.nextInt();
    num2=sc.nextInt();
    sc.close();
	if(num1<num2&&num1>3&&num2<=1000){
	    for(int i=num1;i<=num2;i++){
	        if(is_prime(i)) sum+=i;
    	}
    	System.out.println(sum);
	}
	else System.out.println("INVALID_INPUT");
	
    }
    
}
