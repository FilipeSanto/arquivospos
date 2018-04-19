/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PJPA.Aula02.Ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Filipe
 */
public class ConnectionFactory {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/universidade";
    private static final String user = "root";
    private static final String password = "";

    private static final Logger logger = Logger.getLogger(ConnectionFactory.class.getName());

    public static Connection getConnection() {
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, password);
            con.setAutoCommit(false);
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro: banco " + url + ". " + ex);
        }
    }

    public static void closeConnection(Connection con, Statement stmt, ResultSet rs) {
        try { // ...
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Erro: banco " + url + ". {0}", ex);
        }
    }

}
