package org.example.view;

import org.example.controller.BookController;
import org.example.model.Book;
import org.hibernate.service.spi.ServiceException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BookView {
    private Scanner scanner = new Scanner(System.in);
    private Scanner scanner1 = new Scanner(System.in);
    private Scanner scanner2 = new Scanner(System.in);
    private Scanner scanner3 = new Scanner(System.in);
    private Scanner scanner4 = new Scanner(System.in);
    private BookController bookController = new BookController();

    public void printBook() throws SQLException {
        List<Book> books = bookController.showAllBooks();
        System.out.println("List of all clients : ");
        books.forEach(book1 -> System.out.println(book1.toString()));
    }

    public void deleteBook() throws SQLException {
        System.out.println("Enter id in order to delete row : ");
        Long id = Long.parseLong(scanner.next());
        try {
            bookController.deleteBookById(id);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Book with id " + id + " has been deleted successfully");
    }


    public void getByIdBook() throws SQLException {
        System.out.println("Enter id in order to get book :");
        Long id = Long.parseLong(scanner.next());
        try {
            if (bookController.getBookById(id) != null){
                System.out.println(bookController.getBookById(id).toString());}
            else {
                System.out.println("This id is doesn't exist");
            }

        } catch (NullPointerException e) {
            System.out.println("There is no such number ");
            System.out.println("Try one more time, please");
            getByIdBook();
        }
    }

    public void saveBook() throws SQLException {
        try {
            Book newBook = new Book();
            System.out.println("Enter book title : ");
            String bookTile = scanner3.nextLine();
            newBook.setBookTitle(bookTile);

            System.out.println("Enter author :");
            String bookAuthor = scanner3.nextLine();
            newBook.setBookAuthor(bookAuthor);

            System.out.println("Enter price :");
            int bookPrice = Integer.parseInt(scanner3.nextLine());
            newBook.setBookPrice(bookPrice);

            bookController.createBook(newBook);
        } catch (InputMismatchException | SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    public void updateBook() throws SQLException {
        try {
            System.out.println("Enter id in order to find element :");
            Long id = Long.parseLong(scanner2.next());

            Book newBook = new Book();
            newBook =bookController.getBookById(id);

            System.out.println("Enter book title : ");
            String bookTile = scanner4.nextLine();
            newBook.setBookTitle(bookTile);

            System.out.println("Enter author :");
            String bookAuthor = scanner4.nextLine();
            newBook.setBookAuthor(bookAuthor);

            System.out.println("Enter price :");
            int bookPrice = scanner4.nextInt();
            newBook.setBookPrice(bookPrice);

            bookController.updateBook(newBook);
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    public void run() throws SQLException {
        boolean go = true;
        while (go) {
            System.out.println("\nChoose option, please :");
            System.out.println("Enter number : ");
            System.out.println("1. Show all rows");
            System.out.println("2. Insert new row");
            System.out.println("3. Delete row ");
            System.out.println("4. Update row  ");
            System.out.println("5. Search by id ");
            System.out.println("6. End ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    printBook();
                    break;
                case 2:
                    saveBook();
                    break;
                case 3:
                    deleteBook();
                    break;
                case 4:
                    updateBook();
                    break;
                case 5:
                    getByIdBook();
                    break;
                case 6:
                    go = false;
                    break;
                default:
                    System.out.println("Wrong number");
                    System.out.println("Enter number from 1 to 6, please");
            }
        }
    }
}
