package com.ren.javapractice.time;

import java.util.Calendar;

/**
 * 完成Time类，要求该类能够实现以下功能：
 * a.该类以小时和分钟显示一天中的时间；提供两种计时功能，一种以24小时计时，一种以12小时计时；默认以24小时计时；
 * b.可以以当前时间构造对象；
 * c.可以设置一个特定的时间来构造对象；
 * d.能够访问时间的小时数；
 * e.能够访问时间的分钟数；
 * f.提供方法能够将时间增加1小时；
 * g.提供方法能够将时间增加特定的小时；
 * h.提供方法能够将时间增加1分钟；
 * i.提供方法能够将时间增加n分钟；
 * j.提供toString( )方法用来打印时间，以24小时计时，输出“23：30”；以12小时计时，输出“00：15AM”，“12：00PM”，“11：59PM”。
 * 测试自己写的类。
 */


public class Time {
    private int hour;
    private int minute;
    private String type;

    public Time()                   //b.set with instant time
    {
        Calendar ca = Calendar.getInstance();
        hour = ca.get(Calendar.HOUR);
        minute = ca.get(Calendar.MINUTE);
        type = "A";
    }

    public Time(int hr , int min) //c.set with specified time
    {
        hour = hr;
        minute = min;
        type = "A";
    }

    public Time(int hr , int min , String AssignedType) //a.set with specified time with 24-h or 12-h format
    {
        hour = hr;
        minute = min;
        type = AssignedType;
    }

    public int getHour()             //d.access the hour of the time
    {
        return hour;
    }

    public int getMinute() {                //e.access the minute of the time
        return minute;
    }

    public void addOneHour()                 //f.add 1 hour to the time
    {
        hour++;
    }

    public void addSpecificHour(int increment)  //g,add specified hour to the time
    {
        hour += increment;
    }

    public void addOneMinute()                 //h.add 1 minute to the time
    {
        minute++;
    }

    public void addSpecificMinute(int increment)  //g.add specified minute to the time
    {
        minute += increment;
    }

    public String toString()  //h.print the time using toString()
    {
        StringBuffer sb = new StringBuffer();
        hour += minute / 60;
        if (hour / 12 > 0) {
            if (type.equals("AM"))
                type = "PM";
            else if (type.equals("PM")) {
                type = "AM";
                hour -= 12;
            }
        }
        minute = minute % 60;

        if (hour < 10) {
            sb.append("0").append(hour).append(":");
        } else {
            sb.append(hour).append(":");
        }

        if (minute < 10)
            sb.append("0").append(minute);
        else sb.append(minute);

        if (type.equals("AM")||type.equals("PM")) sb.append(type);
        return sb.toString();
    }
}
