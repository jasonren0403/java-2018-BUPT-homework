package com.ren.javapractice.PetVet;

/**
 * A simple vet program.
 *
 * @author Jason
 * This program does not test everything your class
 * system is supposed to do, so you might want to write
 * some of your own tests.
 */
public class P3main {

    /**
     * Main driver method.
     *
     * @param args the arguments (not used)
     */
    public static void main(String[] args) {
        Vet avet = new Vet(50 , "Pets R Us");
        Pet p;

        p = new Pet("Rudolph" , "Santa Claus" , 350);
        p.visit(1);
        avet.add(p);
        avet.add(new Pet("Tweetie Bird" , "Looney Tunes" , 1.75));
        System.out.println("visit1: " + p.visit(1));
        System.out.println();
        show(avet);

        p = new Cat("Tiger" , "Some Body" , 8);
        avet.add(p);
        System.out.println("visit0: " + p.visit(0));

        Cat c = new Cat("Sylvester" , "Looney Tunes" , 15.5);
        System.out.println("inside visit1: " + c.visit(1));
        c.goOutside();
        System.out.println("outside visit1: " + c.visit(1));
        System.out.println("c is " + c);
        avet.add(c);

        System.out.println();
        show(avet);

        Dog d = new Dog("Fido" , "Some Body" , 32.2 , "medium");
        System.out.println("med visit3: " + d.visit(3));
        avet.add(d);

        p = new Dog("Dino" , "Flintstones" , 150 , "large");
        avet.add(p);
        System.out.println("lg visit3: " + p.visit(3));
        System.out.println();
        show(avet);

        avet.add(new Dog("Benji" , "Joe Camp" , 10 , "small"));
        p = new Cat("Tony" , "Kellogg" , 20);
        avet.add(p);
        System.out.println();
        show(avet);

        System.out.println("\na few more tests...");
        System.out.println("find p: " + avet.find(p));
        p = (Pet)avet.find(new Pet("Tweetie Bird" , "Looney Tunes" , 1.5));
        /* 怀疑上一行欲测试的内容有问题，原意是要输出“找到该宠物”，然而它没有考虑体重也需要一样（原来是1.75lbs）
         * 所以这个查找操作应该是失败的！*/
        System.out.println("Tweetie 5 shots: " + p.visit(5));
        System.out.println("found Tweetie: " + p);

        System.out.println("find Fido: "
                + avet.find(new Dog("Fido" , "some body" , 32.2 , "medium")));

        System.out.println("adding string to Vet: " + avet.add("not a pet"));
        System.out.println("deleting string: " + avet.delete("just a string"));

        System.out.println();
        System.out.println("\ndeleting pets:");
        System.out.println(avet.delete(p));
        System.out.println(avet.delete(d));
        System.out.println(avet.delete(c));
        show(avet);

        avet.add(new Pet("Happy" , "Some Body" , 13.5));
        avet.sort();
        System.out.println("\nafter sorting:");
        show(avet);
    }

    /**
     * Output the current state of things to the screen.
     *
     * @param myvet the vet records to display
     */
    public static void show(Vet myvet) {
        System.out.println("--- Vet has " + myvet.size() + " clients");
        myvet.display();
        System.out.println(">> average client weight: " + myvet.averageWeight());
    }
}
