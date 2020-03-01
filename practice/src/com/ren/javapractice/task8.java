package com.ren.javapractice;

import java.util.Scanner;

/**
 * 从控制台接收用户输入的一行英文句子，把句子的最前面两个单词移到句子的最后面去，并整理句子的大小写及标点符号，将新的句子输出。
 * input: The dog ran through the gate and down the street.
 * output: Ran through the gate and down the street, the dog?
 * input: My coat was too heavy for this warm day!
 * output: Was too heavy for this warm day, my coat?
 */


public class task8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        System.out.print("Input:");
        String input = in.nextLine();

        char last = input.toCharArray()[input.length() - 1];
        String[] words = input.split(" ");
        int len = words.length;
        String[] output = new String[len];
        for (int i = 2; i < len; i++) {
            char[] cs = words[i].toCharArray();
            if (i == 2) {
                cs[0] -= 32;
                output[i - 2] = String.valueOf(cs);
            } else output[i - 2] = words[i];
        }
        output[len - 2] = words[0].toLowerCase();
        output[len - 1] = words[1];
        for (String s : output)
            sb.append(s).append(" ");
        sb.setCharAt(sb.lastIndexOf(" "), '?');
        sb.setCharAt(sb.lastIndexOf(String.valueOf(last)), ',');
        System.out.print("Output:" + sb.toString());
    }
}
