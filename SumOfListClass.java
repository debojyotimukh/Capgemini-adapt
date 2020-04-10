import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class SumOfListClass {
	public static List<Integer> getSumOfListElements(List<Integer> first,List<Integer> second){
    //CODE HERE
        List<Integer> res=new ArrayList<Integer>();
        if(first==null){
            res=second;
        }
        if(second==null){
            res=first;
        }
        if(first.size()==second.size()){
            for(int i=0;i<first.size();i++){
                res.add(first.get(i)+second.get(i));
            }
        }
        else if(first.size()>second.size()){
            for(int i=0;i<second.size();i++){
                res.add(first.get(i)+second.get(i));
            }
            for(int j=second.size();j<first.size();j++){
                res.add(first.get(j));
            }
        }
        else if(first.size()<second.size()){
            for(int i=0;i<first.size();i++){
                res.add(first.get(i)+second.get(i));
            }
            for(int j=first.size();j<second.size();j++){
                res.add(second.get(j));
            }
        }
        return res;
        
	}

	public static void main(String[] args) {
	    
	    Scanner sc=new Scanner(System.in);
	    List<Integer> f=new ArrayList<Integer>();
	    List<Integer> s=new ArrayList<Integer>();
	    List<Integer> res;
	    String line1,line2;
	    String[] lineVector1,lineVector2;
        
        line1=sc.nextLine();
        lineVector1=line1.split(",");
	    for(int i=0;i<lineVector1.length;i++){
	        s.add(Integer.parseInt(lineVector1[i]));
	    }
	    System.out.println(f);
	    sc.next();
	    line2=sc.nextLine();
	    lineVector2=line2.split(",");
	    for(int i=0;i<lineVector2.length;i++){
	        s.add(Integer.parseInt(lineVector2[i]));
	    }
	    sc.close();
	    System.out.println(s);
	    res=getSumOfListElements(f,s);
	    System.out.println(res);
	}
}
