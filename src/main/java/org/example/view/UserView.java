package org.example.view;

import org.example.controller.BookController;
import org.example.controller.UserController;
import org.example.model.User;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserView {
    private Scanner scanner = new Scanner(System.in);
    private Scanner scanner1 = new Scanner(System.in);
    private UserController userController = new UserController();
    private BookController bookController = new BookController();


    public void printUsers() throws SQLException {
        List<User> users = userController.printAll();
        System.out.println("List of all clients : ");
        users.forEach(user1 -> System.out.println(user1.toString()));
    }

    public void deleteUser() throws SQLException {
        System.out.println("Enter id in order to delete row : ");
        Long id = Long.parseLong(scanner.next());
        userController.deleteUser(id);
    }

    public void getByIdUser() throws SQLException {
        System.out.println("Enter id in order to get user :");
        Long id = Long.parseLong(scanner.next());
        try {
            if (userController.getUserById(id) != null)
                System.out.println(userController.getUserById(id).toString());

        } catch (NullPointerException e) {
            System.out.println("There is no such number ");
            System.out.println("Try one more time, please");
            getByIdUser();
        }
    }

    public void saveUser() throws SQLException {
        try {
            User newUser = new User();

            System.out.println("Enter name :");
            String username = scanner.next();
            newUser.setUsername(username);

            System.out.println("Enter login :");
            String login = scanner.next();
            newUser.setLogin(login);

            System.out.println("Enter password :");
            String password = scanner.next();
            newUser.setPassword(password);

            System.out.println("Enter email :");
            String mail = scanner1.next();
            newUser.setMail(mail);
            // Придумать что то с сетом книг для юзера

//            Set<Book> bookSet = new HashSet<>();
//        /*System.out.println("Enter id of user in order to link specialty :");
//        Long idUser = Long.parseLong(scanner.next());*/
//            System.out.println("Enter id of book :");
//            Long idBook = Long.parseLong(scanner.next());
//            bookSet.add(bookController.getBookById(idBook));
//            boolean go = true;
//            while (go) {
//                System.out.println("Do You want to add one more id of books? 1.Yes 2.No");
//                String yesOrNo = scanner.next();
//                switch (yesOrNo) {
//                    case ("1"):
//                   /* System.out.println("Enter id of customer in order to link specialty :");
//                    Long newIdCustomer = Long.parseLong(scanner.next());*/
//                        System.out.println("Enter id of new book :");
//                        Long newIdBook = Long.parseLong(scanner.next());
//                        bookSet.add(bookController.getBookById(newIdBook));
//                        break;
//                    case ("2"):
//                        System.out.println("You choose do not add new book");
//                        go = false;
//                        break;
//                }
//            }
//
            userController.saveUser(newUser);
        } catch (InputMismatchException | SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    public void updateUser() throws SQLException {
        try {
            System.out.println("Enter id in order to find element :");
            Long id = Long.parseLong(scanner.next());

            User newUser = new User();
            newUser = userController.getUserById(id);

            System.out.println("Enter name :");
            String username = scanner1.next();
            newUser.setUsername(username);

            System.out.println("Enter login :");
            String login = scanner1.next();
            newUser.setLogin(login);

            System.out.println("Enter password :");
            String password = scanner1.next();
            newUser.setPassword(password);

            System.out.println("Enter email :");
            String mail = scanner1.next();
            newUser.setMail(mail);

//            Set<Book> bookSet = new HashSet<>();
//        /*System.out.println("Enter id of customer in order to link specialty :");
//        Long idCustomer = Long.parseLong(scanner.next());*/
//            System.out.println("Enter id of book :");
//            Long idBook = Long.parseLong(scanner.next());
//            bookSet.add(bookController.getBookById(id));
//            boolean go = true;
//            while (go) {
//                System.out.println("Do You want to add one more id of specialty? 1.Yes 2.No");
//                String yesOrNo = scanner.next();
//                switch (yesOrNo) {
//                    case ("1"):
//                   /* System.out.println("Enter id of user in order to link specialty :");
//                    Long newIdUser = Long.parseLong(scanner.next());*/
//                        System.out.println("Enter id of new specialty :");
//                        Long newIdBook = Long.parseLong(scanner.next());
//                        bookSet.add(bookController.getBookById(newIdBook));
//                        break;
//                    case ("2"):
//                        System.out.println("You choose do not add new specialty");
//                        go = false;
//                        break;
//                }
//            }
            userController.updateUser(newUser);
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    public void run() throws SQLException {
        boolean go = true;
        while (go) {
            System.out.println("\n Choose option, please :");
            System.out.println(" Enter number : ");
            System.out.println(" 1. Show all rows");
            System.out.println(" 2. Insert new row");
            System.out.println(" 3. Delete row ");
            System.out.println(" 4. Update row  ");
            System.out.println(" 5. Search by id ");
            System.out.println(" 6. End ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    printUsers();
                    break;
                case 2:
                    saveUser();
                    break;
                case 3:
                    deleteUser();
                    break;
                case 4:
                    updateUser();
                    break;
                case 5:
                    getByIdUser();
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