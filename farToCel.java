import java.util.Scanner;
import java.lang.Math;

class Utility{
    public static int fahrenheitToCelcius(final double far) {
        final double cel = (far - 32) * 5 / 9;
        return Math.round((float) cel);
    }

    public static String getLevel(final int[] arr) {
        double sum = 0;
        // for(Integer x:arr) sum+=x;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        if (sum >= 100)
            return "HIGH";
        if (sum >= 70)
            return "MEDIUM";
        else
            return "LOW";
    }
}

class farToCel {
    public static void main(final String[] argc) {
        final Scanner sc = new Scanner(System.in);
        final int op = sc.nextInt();
        switch (op) {
            case 1:
                final double far = sc.nextDouble();
                System.out.println(Utility.fahrenheitToCelcius(far));
                break;
            case 2:
                final int n = sc.nextInt();
                final int[] a = new int[n];
                
                for(int i=0;sc.hasNext();i++){
                    a[i]=sc.nextInt();
                }
                System.out.println(Utility.getLevel(a));
                break;
            default:
                System.out.println("Invalid Choice");
        }
        sc.close();
    }
}