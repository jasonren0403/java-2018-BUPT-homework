/**
 * 编写程序，从控制台接收用户输入的十六进制，并输出对应的二进数，要求程序中用一个字符串数组表示16进制的“0”至“F”。如下所示：
 * String[] hexBits = {"0000", "0001", "0010", "0011",
 * "0100", "0101", "0110", "0111",
 * "1000", "1001", "1010", "1011",
 * "1100", "1101", "1110", "1111"};
 * 产生输出如下所示：
 * Enter a Hexadecimal string: 1abc
 * The equivalent binary for hexadecimal "1abc" is 0001 1010 1011 1100
 */

import java.util.Scanner;

public class Task_Four {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String[] hexBits = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
        System.out.print("Enter a hexadecimal string:");
        String in = input.next();
        System.out.print("The equivalent binary for hexadecimal \" " + in + "\" is ");
        for (int i = 0; i < in.length(); i++) {
            int flag = 0;
            if (in.charAt(i) >= '0' && in.charAt(i) <= '9') flag = in.charAt(i) - '0';
            else flag = in.charAt(i) - 'a' + 10;
            System.out.print(hexBits[flag] + " ");
        }
        input.close();
    }
}
