/**
 * 阅读JAVA帮助文档中String类，编写一个简单的Java应用程序，应用String类的方法，完成以下功能：
 * a.定义一个String对象，斌值为”I am a student of BUPT.”
 * b.输出该字符串的长度；
 * c.将该字符串中的字符全部转换为大写字母，并输出；
 * d.输出字母’s’第一次在字符串中出现的位置；
 */

public class second_task {

    public static void main(String[] args) {
        String introduction = "I am a student of BUPT.";
        System.out.println(introduction.length());
        System.out.println(introduction.toUpperCase());
        System.out.println(introduction.indexOf('s'));
    }
}
