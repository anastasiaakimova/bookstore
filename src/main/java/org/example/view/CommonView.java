package org.example.view;

import java.sql.SQLException;
import java.util.Scanner;

public class CommonView {

    private UserView userView;
    private BookView bookView;
    private CommentView commentView;
    private static CommonView view;

    private CommonView() {
        bookView = new BookView();
        userView = new UserView();
        commentView = new CommentView();
    }

    public static CommonView getInstance() {
        if (view == null) {
            view = new CommonView();
        }
        return view;
    }

    public void run() throws SQLException{
        Scanner scanner = new Scanner(System.in);
        boolean go = true;
        while (go) {
            System.out.println("\nChoose file in order to do operations , please :");
            System.out.println("Enter number : ");
            System.out.println("1. Books");
            System.out.println("2. Comment");
            System.out.println("3. Users");
            System.out.println("4. End ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    runBook();
                    break;
                case 2:
                    runComment();
                    break;
                case 3:
                    runUser();
                    break;
                case 4:
                    go = false;
                    break;
                default:
                    System.out.println("Wrong number");
                    System.out.println("Enter number from 1 to 4, please");
            }
        }
    }
    public void runBook()throws SQLException {
        bookView.run();
    }
    public void runComment()throws SQLException {
        commentView.run();
    }

    public void runUser()throws SQLException {
        userView.run();
    }

}

