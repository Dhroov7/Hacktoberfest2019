//takes input and replaces the rightmost zeroes of the bit represenation 
import java.util.Scanner;
public class ReplacingRightmostZeroesWithOnes{
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int input = scr.nextInt();
        System.out.println(input == 0 ? 0 : (input | (input - 1)));
    }
}