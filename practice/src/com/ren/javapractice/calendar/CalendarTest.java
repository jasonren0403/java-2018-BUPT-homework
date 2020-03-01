package com.ren.javapractice.calendar;

import java.util.Scanner;

public class CalendarTest {
    public static void main(String[] args) {
        //create scanner for user input
        Scanner input = new Scanner(System.in);

        //receive date in sequence of year-month-day
        System.out.print("Please input year.");
        int nian = input.nextInt();
        System.out.print("Input month.");
        int yue = input.nextInt();
        System.out.print("Input day.");
        int ri = input.nextInt();

        Calendar c = new Calendar(nian , yue , ri);
        System.out.println("\n          " + nian + "年          ");
        c.printMonth(yue , ri , nian);
        input.close();
    }
}
