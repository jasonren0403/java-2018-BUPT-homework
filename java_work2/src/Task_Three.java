/**
 * 编写程序，从控制台接收用户输入的二进制，并输出相应的10进制数。以下为样例输出。
 * Enter a Binary string: 1011
 * The equivalent decimal number for binary "1011" is 11
 *
 * Enter a Binary string: 1234
 * Error: Invalid Binary String "1234"
 */

import java.util.Scanner;

public class Task_Three {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a Binary string:");
        String input = in.next();
        int result = 0;
        boolean flag = true;
        for (int i = 0; flag && i < input.length(); i++) {
            if (input.charAt(i) != '1' && input.charAt(i) != '0') flag = false;
            result *= 2;
            if (input.charAt(i) == '1') result += 1;
        }
        if (flag) System.out.println("The equivalent decimal number for binary \"" + input + "\" is " + result);
        else System.out.println("Error: Invalid Binary String \"" + input + "\"");
        in.close();
    }
}
