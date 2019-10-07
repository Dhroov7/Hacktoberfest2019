package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a number to find sum of digits: ");
        int num = scn.nextInt();
        System.out.print(digitalSum(num));
    }

    public static Integer digitalSum(int n) {
        if (n < 10) {
            return n;
        } else {
            return (n%10) + digitalSum(n/10);
        }
    }
}
