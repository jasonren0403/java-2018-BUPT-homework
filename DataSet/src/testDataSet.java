import java.util.Scanner;

public class testDataSet {
    public static void main(String args[]) {
        DataSet d = new DataSet();
        Scanner input = new Scanner(System.in);
        System.out.println("Please input the value of the 'Human' object.");
        double num1 = input.nextDouble();
        Human h = new Human("human" , num1);
        System.out.println("Please input the value of the 'Student' object.");
        double num2 = input.nextDouble();
        Student s = new Student("student" , num2);
        Measurable[]m=new Measurable[2];
        d.add(h,s);
        m[0]=h;
        m[1]=s;
        System.out.println("After d.add():");
        for (Measurable x :m )
            System.out.println(x.getType() +":"+ x.getMeasure());

        System.out.println("The average value of these two objects is:"+d.getAverage());     //调用getAverage()得到所有测量对象的平均值
        if(h.getMeasure()>s.getMeasure())
            System.out.println("The object which contains the maximum value is:"+h.getType());
        else
            System.out.println("The object which contains the maximum value is:"+s.getType());
        System.out.println("The value is:"+d.getMaximum());
        //得到最大值所在类及其值
    }
}
