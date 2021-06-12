package org.example.view;

import org.example.controller.CommentController;
import org.example.model.Comment;
import org.example.model.User;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CommentView {
    private CommentController commentController = new CommentController();

    public void printComment() throws SQLException {
        System.out.println("List of all comments : ");
        System.out.println(commentController.printAll());
    }

    public void deleteComment() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter id in order to delete row : ");
        Long id = Long.parseLong(scanner.next());
        commentController.deleteComment(id);
    }

    public void getByIdComment() throws SQLException {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter id in order to get comment :");
            Long id = Long.parseLong(scanner.next());
            if (commentController.getValueById(id) != null)
                System.out.println(commentController.getValueById(id).toString());

        } catch (NullPointerException e) {
            System.out.println("There is no such number ");
            System.out.println("Try one more time, please");
            getByIdComment();
        }
    }

    public void saveComment() throws SQLException {
        try {
            Scanner scanner = new Scanner(System.in);
            Comment newComment = new Comment();
            User user = new User();

            System.out.println("Enter id book : ");
            Long id_book = scanner.nextLong();
            newComment.setIdBook(id_book);

            System.out.println("Enter id user : ");
            Long id_user = scanner.nextLong();
            newComment.setIdUser(id_user);
        //    user.setCommentsById(newComment.getId());

            System.out.println("Enter comment text : ");
            String text = scanner.nextLine();
            newComment.setText(text);


            commentController.saveComment(newComment);
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }

    }

    public void updateComment() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id in order to find element :");
        Long id = Long.parseLong(scanner.next());

        Comment newComment = new Comment();
        newComment = commentController.getValueById(id);

        System.out.println("Enter id book : ");
        String id_book = scanner.nextLine();
        newComment.setIdBook(Long.valueOf(id_book));

        System.out.println("Enter id user : ");
        String id_user = scanner.nextLine();
        newComment.setIdUser(Long.valueOf(id_user));

        System.out.println("Enter comment text : ");
        String text = scanner.nextLine();
        newComment.setText(text);
        commentController.updateComment(newComment);

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
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    printComment();
                    break;
                case 2:
                    saveComment();
                    break;
                case 3:
                    deleteComment();
                    break;
                case 4:
                    updateComment();
                    break;
                case 5:
                    getByIdComment();
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
