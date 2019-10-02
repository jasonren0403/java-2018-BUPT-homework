/**
 * 编写程序，从控制台接收用户输入，并产生如下所示输出（黑体表示用户输入）
 * Enter an integer: 12
 * Enter a floating point number: 33.44
 * Enter your name: Peter
 * Hi! Peter, the sum of 12 and 33.44 is 45.44
 */

import java.util.Scanner;

public class Task_Two {
    public static void main(String []args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an integer:");
        int first = in.nextInt();
        System.out.print("Enter a floating point number:");
        double second = in.nextDouble();
        System.out.print("Enter your name:");
        String third = in.next();
        double result = (double)first + second;
        System.out.print("Hi! " + third + ", the sum of " + first + " and " + second + " is " + result + " .");
    }
}
