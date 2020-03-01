package com.ren.javapractice.LibraryBook;

/**
 * 某镇上有两个图书馆，请按照下面要求及提示帮助这两个图书馆实现图书电子借阅。
 * 按照book.java代码中的提示完成该类。该类主要提供借书、还书、查询书的借阅状态、获取书名等功能。当运行该代码的时候，输出为：
 * Title (should be The Da Vinci Code): The Da Vinci Code
 * Rented? (should be false): false
 * Rented? (should be true): true
 * Rented? (should be false): false
 */
public class Book {

    private String title;
    private boolean borrowed;

    // Creates a new Book
    public Book(String bookTitle) {
        // Implement this method
        title = bookTitle;
    }

    // Marks the book as rented
    public void rented() {
        // Implement this method
        borrowed = true;
    }

    // Marks the book as not rented
    public void returned() {
        // Implement this method
        borrowed = false;
    }

    // Returns true if the book is rented, false otherwise
    public boolean isBorrowed() {
        // Implement this method
        return borrowed;
    }

    // Returns the title of the book
    public String getTitle() {
        // Implement this method
        return title;
    }

    public static void main(String[] arguments) {
        // Small test of the Book class
        Book example = new Book("The Da Vinci Code");
        System.out.println("Title (should be The Da Vinci Code): " + example.getTitle());
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
        example.rented();
        System.out.println("Borrowed? (should be true): " + example.isBorrowed());
        example.returned();
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
    }
} 