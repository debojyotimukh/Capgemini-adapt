import java.util.Scanner;
public class UniqueChars {
    public static int getUniqueCharacterCount(String str){
        return (int)str.toLowerCase().chars()
            .distinct()
            .count();
    }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=getUniqueCharacterCount(sc.next());
		System.out.println(n+" unique character/s");
		sc.close();
		
	 }

}



