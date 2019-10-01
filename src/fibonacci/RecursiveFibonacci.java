import java.util.Scanner;
import java.io.*;
class RecursiveFibonacci{
   
    public static int fibonacci(int x)
    {
       if(x==1)
       return 1;
       else
       return x*fibonacci(x-1);
    }
    public static void main(String[] args)
    { Scanner sc=new Scanner(System.in);
     int x=sc.nextInt();
     int y=fibonacci(x);
    
     System.out.println(y);   
    }
}
