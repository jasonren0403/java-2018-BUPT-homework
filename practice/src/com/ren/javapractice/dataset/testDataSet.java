package com.ren.javapractice.dataset;

import java.util.Scanner;

public class testDataSet {
    public static void main(String[] args) {
        DataSet d = new DataSet();
        Scanner input = new Scanner(System.in);
        System.out.println("Please input the value of the 'Human' object.");
        double num1 = input.nextDouble();
        Human h = new Human(num1);
        System.out.println("Please input the value of the 'Student' object.");
        double num2 = input.nextDouble();
        Student s = new Student(num2);
        d.add(h, s);

        System.out.println("The average value of these two objects is:" + d.getAverage());
        //调用getAverage()得到所有测量对象的平均值

        System.out.println("The max value and the object contains it is: " + d.getMaximum());
        //得到最大值所在类及对象
    }
}
