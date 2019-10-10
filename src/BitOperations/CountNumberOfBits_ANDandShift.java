import java.util.Scanner;
public class CountNumberOfBits_ANDandShift{
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int input = scr.nextInt();
        int count = 0;
        while (input != 0) {
            /*
            101  010 001
            001  001 001
            ____________
            001  000 001
            */
            count = count + (input&1);
            input = input >>> 1;
        }
        System.out.println(count);

    }
}