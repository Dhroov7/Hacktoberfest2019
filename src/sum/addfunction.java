import java.util.Scanner;
import java.io.*;
class Solution{
   
    public static int add(int x,int y)
    {
        return(x+y);
    }
    public static void main(String[] args)
    { Scanner sc=new Scanner(System.in);
     int x=sc.nextInt();
     int y=sc.nextInt();
     int z=add(x,y);
     System.out.println(z);   
    }
}