import java.util.Scanner;
import java.util.*;
/*
hackerRank.com
PracticeJava->Data Structures->Java Arraylist
INPUT:
5
5 41 77 74 22 44
1 12
4 37 34 36 52
0
3 20 22 33
5
1 3
3 4
3 1
4 3
5 5

OUTPUT:
74
52
37
ERROR!
ERROR!
*/

public class multiDimArrayList {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer> > outer=new ArrayList<ArrayList<Integer>>();        
        int n,l;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();

        for(int i=0;i<n;i++){            
            l=sc.nextInt();
            ArrayList<Integer> inner=new ArrayList<Integer>();
            inner.clear();
            for(int j=0;j<l;j++){
                inner.add(j,sc.nextInt());
            }
            outer.add(inner);            
        }
        
        int noOfqueryuery=sc.nextInt();
        int[] query=new int[2*noOfqueryuery];
        for(int i=0;i<2*noOfqueryuery;i++){
            query[i]=sc.nextInt();
        }
        sc.close();
        for(int i=0;i<2*noOfqueryuery;i=i+2){
                try{
                    System.out.println(outer.get(query[i]-1).get(query[i+1]-1));
                }
                catch(IndexOutOfBoundsException e){
                    System.out.println("ERROR!");
                }         
        }     


    }
}