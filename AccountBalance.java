import java.util.Scanner;
class Account{
    int accountNo;
    double balance;
    String accountType;
    static int counter = 0;

    Account(double balance, String accountType){
        this.balance = balance;
        if(accountType=="Savings"||accountType=="Current")
                    this.accountType = accountType;
        this.accountNo = ++counter;
    }
    public void depositAmount(double amount){
        this.balance+=amount;
        System.out.println("New Balance : "+balance);
    }
    public void printAccountDetails(){
        System.out.println("[Acct No : "+accountNo+", "+
                    "Type : "+accountType+", "+"Balance : "+balance+"]");
        
    }
}
class AccountBalance{
    public static void main (String [] args){
        Scanner in  = new Scanner(System.in);
 
        Account a1 = new Account(in.nextDouble(),in.next());
        a1.printAccountDetails();
        a1.depositAmount(in.nextDouble());

        Account a2 = new Account(in.nextDouble(),in.next());
        a2.printAccountDetails();
        a2.depositAmount(in.nextDouble());
        
        in.close();
    }
}