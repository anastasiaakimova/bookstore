package org.example;

import org.example.view.CommonView;

import java.sql.SQLException;

public class App 
{
    public static void main( String[] args ) throws SQLException {
        CommonView.getInstance().run();
    }
}
