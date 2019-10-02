import java.util.Scanner;

public class Fibo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        int first = 0;
        int second = 1;

        while (first <= n){
            System.out.println(first);
            int t = first + second;
            first = second;
            second = t;
        }


    }
}
