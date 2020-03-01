package com.ren.javapractice.PetVet;

import java.util.Arrays;

/*
 * 实验内容：
 * 请替宠物医院设计并完成一个宠物信息系统，现有完成系统的的类的uml图，及部分类的部分实现代码，和一个测试类P3main.java及main方法的标准输出。总体要求如下：
 * 1．P3main.java中的main()方法实现对整个宠物信息系统的测试，请不要对main()方法的已有语句做任何修改，但如果你觉得这个方法有些功能还没有测试到的话，可以在该方法新增测试语句。
 * 2．系统完成后，对比P3main.java的输出和标准输出，调整你的程序，直至输出和标准输出完全一样。
 * 3．仔细阅读类的uml图，明确类之间继承关系，以及类与接口的关系。
 * 4．本次作业会考察大家对数组的应用，请不要用java类库中的ArrayList或其它的集合类来完成数据的存储及相关操作。
 * 5．完成的类中不能有public的成员变量。
 * 以下是关于你需要实现的类的一些重要说明，请仔细阅读，但说明并不全面，所以你还需要根据功能编写一些额外的方法或域。
 *
 * Vet类：宠物医院类
 * 该类需要保存但不限于医院的名字以及在该医院就诊的宠物信息集合。
 * 该类必须实现已提供的Database.java中的接口，部分代码已经给出，除了完善相关方法之外，也需要根据类的功能增加必要的实例域和相关方法。
 * delete方法在删除相关数据后，不能改变数组中数据顺序。
 */

/**
 * Class to keep track of client (Pet) information for a Veterinary
 * practice. Some methods are sketched for you, but others will need
 * to be added in order to implement the Database interface and
 * support the P3main program and expected output. You'll also need
 * to add the data members.
 */


public class Vet implements Database {

    private String owner;
    private int petcount;
    private Pet[] clients;
    private boolean found;

    /**
     * Create a veterinary practice.
     *
     * @param startSize the capacity for how
     *                  many clients they can handle
     * @param who       the name of the vet practice
     */
    public Vet(int startSize , String who) {
        clients = new Pet[startSize];
        owner = who;
        petcount = 0;
    }

    /**
     * Display the name of the Vet and all the clients, one per line,
     * on the screen. (See sample output for exact format.)
     */
    public void display() {
        System.out.println("Vet " + owner + " client list:");
        for (int a = 0; a < size(); a++) {
            System.out.println(clients[a].toString());
        }
    }


    /**
     * Add an item to the database, if there is room.
     * You are limited by the initial capacity.
     *
     * @param o the object to add (must be a Pet)
     * @return true if added, false otherwise
     */
    public boolean add(Object o) {
        if (petcount == clients.length) return false;
        if (!(o instanceof Pet)) return false;
        else {
            clients[petcount++] = (Pet)o;
            return true;
        }
    }

    /**
     * Delete an item from the database, if it is there,
     * maintaining the current ordering of the list.
     *
     * @param o the object to delete
     * @return the item if one is deleted, null otherwise
     */
    public Object delete(Object o) {
        if (!(o instanceof Pet)) return null;
        else {
            Pet p = (Pet)o;
            int index = 0;
            if (!found) return null;
            else {
                for (int a = 0; a < petcount; a++ , index++) {
                    if (p.equals(clients[a])) {
                        break;
                    }
                }
                for (int a = index; a < petcount; a++) {
                    clients[a] = clients[a + 1];
                }
                petcount--;
                return o;
            }
        }
    }

    /**
     * Compute the average weight over all clients.
     *
     * @return the average
     */
    public double averageWeight() {
        double total = 0.0;
        for (int a = 0; a < petcount; a++)
            total += clients[a].getWeight();
        if (petcount == 0) return 0;
        else return total / petcount;
    }

    /**
     * Sort the clients. (This is complete.)
     */
    public void sort() {
        Arrays.sort(this.clients , 0 , this.size());
    }

    /**
     * Find a particular item in the database.
     *
     * @param o the object to search for, based on equals
     * @return the object if found, null otherwise
     */
    public Object find(Object o) {
        found = false;
        Pet p = (Pet)o;
        for (int a = 0; a < petcount; a++) {
            if (p.equals(clients[a])) {
                found = true;
                return clients[a];
            }
        }
        return null;
    }

    public int size() {
        return petcount;
    }

}
