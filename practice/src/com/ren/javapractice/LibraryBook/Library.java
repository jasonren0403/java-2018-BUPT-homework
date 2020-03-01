package com.ren.javapractice.LibraryBook;

/**
 * 完成Library.java，该类中的main()方法已经给出。但类成员和类方法需要完善。完成该类的时候请注意以下要求：
 * a.该类中有类成员方法，也有实例成员方法；
 * b.不能改变main()方法的内容。
 * c.main( )方法的输出为：
 * Library hours:
 * Libraries are open daily from 9am to 5pm.
 * <p>
 * Library addresses:
 * 10 Main St.
 * 228 Liberty St.
 * <p>
 * Borrowing The Lord of the Rings:
 * You successfully borrowed The Lord of the Rings
 * Sorry, this book is already borrowed.
 * Sorry, this book is not in our catalog.
 * <p>
 * Books available in the first library:
 * The Da Vinci Code
 * Le Petit Prince
 * A Tale of Two Cities
 * Books available in the second library:
 * No book in catalog
 * <p>
 * Returning The Lord of the Rings:
 * You successfully returned The Lord of the Rings
 * <p>
 * Books available in the first library:
 * The Da Vinci Code
 * Le Petit Prince
 * A Tale of Two Cities
 * The Lord of the Rings
 */

public class Library {
    // Add the missing implementation to this class
    private String libraryaddr;
    private int booknum = 0;

    static class Book {
        private String booktitle;
        private boolean borrowed;

        public Book(String _bookTitle) {
            booktitle = _bookTitle;
            borrowed = false;
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

        public String getBookTitle() {
            return booktitle;
        }

        public boolean isBorrowed() {
            // Implement this method
            return borrowed;
        }
    }

    Book[] books = new Book[15];

    public Library(String addr) {
        libraryaddr = addr;
    }

    public void addBook(Book newBook) {
        books[++booknum] = newBook;
    }

    public void borrowBook(String Bookname) {
        boolean found = false;
        for (int i = 1; i <= booknum; i++) {
            if (books[i].getBookTitle().equals(Bookname)) {
                found = true;
                if (!books[i].isBorrowed()) {
                    books[i].rented();
                    System.out.println("You successfully borrowed " + Bookname);
                    break;
                } else {
                    System.out.println("Sorry,this book is already borrowed.");
                    break;
                }
            }
        }
        if (!found)
            System.out.println("Sorry,this book is not in our catalog.");
    }

    public void returnBook(String Bookname) {
        Book a = new Book(Bookname);
        a.returned();
        books[++booknum] = a;
        System.out.println("You successfully returned " + Bookname);
    }

    public static void printOpeningHours() {
        System.out.println("Libraries are open daily from 9am to 5pm.");
    }

    public void printAddress() {
        System.out.println(libraryaddr);
    }

    public void printAvailableBooks() {
        int i = 0;
        if (booknum == 0)
            System.out.println("No book in catalog");
        else
            while (i < booknum) {
                boolean hadBorrowed = books[++i].isBorrowed();
                if (!hadBorrowed)
                    System.out.println(books[i].getBookTitle());
            }
    }

    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        System.out.print("first library: ");
        firstLibrary.printAddress();
        System.out.print("second library: ");
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        System.out.println("First time borrowing from the first library:");
        firstLibrary.borrowBook("The Lord of the Rings");
        System.out.println("Second time borrowing from the second library:");
        firstLibrary.borrowBook("The Lord of the Rings");
        System.out.println("Try to borrow the book from the second library:");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}

