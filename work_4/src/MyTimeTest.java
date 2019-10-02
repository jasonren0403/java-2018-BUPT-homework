/**
 * @author Jason Ren
 * Using IntelliJ IDEA (version 2018.1)
 * Date:2018.4.8
 * making a personal class-TIME
 */

import java.util.Scanner;

public class MyTimeTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Time test1 = new Time();
        Time test2 = new Time(23, 30);
        Time test3 = new Time(0, 15, "AM");
        Time test4 = new Time(11, 59, "PM");
        int fenzhong;
        int xiaoshi;

        System.out.println("Test 1:Local time:" + test1.toString());

        System.out.println("Test 2:Specified time(24-h format):" + test2.toString());

        System.out.println("Test 3 and 4: Specified time(12-h format):" + test3.toString() + "\n" + test4.toString());

        System.out.println("Set local time ahead of 2 hours:");
        test1.addSpecificHour(2);
        System.out.println(test1.toString());
        test1.addSpecificHour(-2);
        System.out.println("Set local time ahead of 67 minutes:");
        test1.addSpecificMinute(67);
        System.out.println(test1.toString());
        test1.addSpecificMinute(-67);

        System.out.println("Test 5:User input time and type.");
        System.out.println("Input format(12 for 12-h format,anything else for 24-h format)");
        String choice = input.next();
        if (choice.equals("12")) {//using 12-h format
            System.out.println("Input hour(0-12):");
            xiaoshi = input.nextInt();
            while (xiaoshi < 0 || xiaoshi >= 13) {
                System.out.println("Wrong number.Try again.");
                xiaoshi = input.nextInt();
            }

            System.out.println("Input minute(0-59):");
            fenzhong = input.nextInt();
            while (fenzhong < 0 || fenzhong >= 60) {
                System.out.println("Wrong number.Try again.");
                fenzhong = input.nextInt();
            }

            System.out.println("Input AM or PM for time symbol:");
            String leixing = input.next();
            while (!(leixing.equalsIgnoreCase("AM") || leixing.equalsIgnoreCase("PM"))) {
                System.out.println("Wrong type.Try again.");
                leixing = input.next();
            }
            Time test5 = new Time(xiaoshi, fenzhong, leixing);
            System.out.println(test5.toString());
            System.out.println("getHour():" + test5.getHour() + "  getMinute():" + test5.getMinute());
            test5.addOneHour();
            System.out.println("addOneHour():" + test5.toString());
            test5.addOneMinute();
            System.out.println("addOneMinute():" + test5.toString());


            System.out.print("Input minute increasement:");
            int delta_1 = input.nextInt();
            System.out.println("Before change:" + test5.toString());

            test5.addSpecificMinute(delta_1);
            System.out.println("After change:" + test5.toString());


            System.out.print("Input hour increasement:");
            int delta_2 = input.nextInt();
            System.out.println("Before change:" + test5.toString());

            test5.addSpecificHour(delta_2);
            System.out.println("After change:" + test5.toString());

        } else {//using 24-h format
            System.out.println("Input hour(0-24):");
            xiaoshi = input.nextInt();
            while (xiaoshi < 0 || xiaoshi >= 25) {
                System.out.println("Wrong number.Try again.");
                xiaoshi = input.nextInt();
            }

            System.out.println("Input minute(0-59):");
            fenzhong = input.nextInt();
            while (fenzhong < 0 || fenzhong >= 60) {
                System.out.println("Wrong number.Try again.");
                fenzhong = input.nextInt();
            }
            Time test5 = new Time(xiaoshi, fenzhong);
            System.out.println(test5.toString());
            System.out.println("getHour():" + test5.getHour() + "  getMinute():" + test5.getMinute());
            test5.addOneHour();
            System.out.println("addOneHour():" + test5.toString());
            test5.addOneMinute();
            System.out.println("addOneMinute():" + test5.toString());

            System.out.print("Input minute increment");
            int delta_1 = input.nextInt();
            System.out.println("Before change:" + test5.toString());

            test5.addSpecificMinute(delta_1);
            System.out.println("After change:" + test5.toString());


            System.out.print("Input hour increment");
            int delta_2 = input.nextInt();
            System.out.println("Before change:" + test5.toString());

            test5.addSpecificHour(delta_2);
            System.out.println("After change:" + test5.toString());

        }
        System.out.println("------------Test over-------------");
    }
}


