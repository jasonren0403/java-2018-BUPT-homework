package com.ren.javapractice.calendar;

/**
 * 仔细阅读并理解CalendarTest.java程序，并按以下要求改写该程序
 * 从控制台接收用户输入三个值，分别代表年、月、日，按日历格式输出用户输入那一年全年的日历，并将用户输入的年月日所代表的日期加*号表示。
 */

class Calendar {
    private int year;
    private int month;

    public Calendar(int nian , int yue , int ri) {
        year = nian;
        month = yue;
    }

    private boolean isLeapYear(int y) {
        return ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0));
    }

    private int firstDay(int y) {
        long n = y * 365;
        for (int i = 1; i < y; i++)
            if (isLeapYear(i))
                n += 1;
        return (int)n % 7;
    }

    private int getMonthDay(int m , int year) {
        switch (m) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (isLeapYear(year))
                    return 29;
                else return 28;
            default:
                return 0;
        }
    }

    protected void printMonth(int month , int day , int year) {
        int weekDay = firstDay(year);
        for (int m = 1; m <= 12; m++) {
            System.out.println("          " + m + "月");
            System.out.println("  日  一  二  三  四  五  六");
            for (int j = 1; j <= weekDay; j++) {
                System.out.print("    ");
            }
            int monthDay = getMonthDay(m , year);
            for (int d = 1; d <= monthDay; d++) {
                System.out.printf("%3d" , d);
                if (m == month && day == d) System.out.print("*");
                else System.out.print(" ");
                weekDay = (weekDay + 1) % 7;
                if (weekDay == 0)
                    System.out.println();
            }
            System.out.println();
        }
    }
}


