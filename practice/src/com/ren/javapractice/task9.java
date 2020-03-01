package com.ren.javapractice;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 从按制台接收用户的输入的出生日期，输出从用户出生的那一年到今年为止，每年的生日当月的日历，生日当天标＊号，
 * 并统计这么多年用户生日当天为一周中每一天的百分比（即生日为周一的在这么多年中占的百分比，生日为周二的在这
 * 么多年中占的百分比。。。。。）
 */


public class task9 {

    private static int getCurrentMonthDay(int year, int month) {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month);
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        return a.get(Calendar.DATE);
    }

    public static void main(String[] args) {

        // construct d as current date
        GregorianCalendar d = new GregorianCalendar();
        Scanner in = new Scanner(System.in);
        System.out.print("Please input your birthday: ");
        int year = in.nextInt();
        int month = in.nextInt() - 1;
        int bday = in.nextInt();
        int[] aya = new int[8];
        int num = 0;//统计总共过了几次生日


        int tomonth = d.get(Calendar.MONTH);
        int today = d.get(Calendar.DAY_OF_MONTH);
        int toyear = d.get(Calendar.YEAR);

        while (year <= toyear) {
            if (year == toyear && month < tomonth) break;
            if (year == toyear && month == tomonth && bday < today) break;
            System.out.println();

            d.set(Calendar.YEAR, year);

            int dayOfWeek = -1;
            // set d to start date of the month

            d.set(Calendar.MONTH, month);
            d.set(Calendar.DAY_OF_MONTH, 1);

            /*处理2月29号的情况*/
            int days = getCurrentMonthDay(year, month);
            if (bday > days) continue;

            System.out.println(year + "年\t" + (month + 1) + "月");

            int weekday = d.get(Calendar.DAY_OF_WEEK);

            // get first day of week (Sunday in the U.S.)
            int firstDayOfWeek = d.getFirstDayOfWeek();

            // determine the required indentation for the first line
            int indent = 0;
            while (weekday != firstDayOfWeek) {
                indent++;
                d.add(Calendar.DAY_OF_MONTH, -1);
                weekday = d.get(Calendar.DAY_OF_WEEK);
            }

            // print weekday names
            String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();

            do {
                System.out.printf("%3s", weekdayNames[weekday]);
                d.add(Calendar.DAY_OF_MONTH, 1);
                weekday = d.get(Calendar.DAY_OF_WEEK);
            }
            while (weekday != firstDayOfWeek);
            System.out.println();

            for (int i = 1; i <= indent; i++)
                System.out.print("    ");


            d.set(Calendar.DAY_OF_MONTH, 1);
            do {
                // print day
                int day = d.get(Calendar.DAY_OF_MONTH);
                System.out.printf("%3d", day);

                // mark current day with *
                if (day == bday) {
                    System.out.print("*");
                } else System.out.print(" ");

                // advance d to the next day
                d.add(Calendar.DAY_OF_MONTH, 1);
                weekday = d.get(Calendar.DAY_OF_WEEK);

                if (day == bday) {

                    dayOfWeek = weekday - 1;
                    if (dayOfWeek == 0) dayOfWeek = 7;
                    aya[dayOfWeek]++;
                }

                // start a new line at the start of the week
                if (weekday == firstDayOfWeek) System.out.println();
            }
            while (d.get(Calendar.MONTH) == month);
            // the loop exits when d is day 1 of the next month

            // print final end of line if necessary
            if (weekday != firstDayOfWeek) System.out.println();

            System.out.println();
            num++;
            year++;
        }
        String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
        /*输出统计结果*/
        for (int i = 1; i <= 7; i++) {
            System.out.println(weekdayNames[i] + " : " + (double) (aya[i] * 100 / num) + "%");
        }
    }
}
