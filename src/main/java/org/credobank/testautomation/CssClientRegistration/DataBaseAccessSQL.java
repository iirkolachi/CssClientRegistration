package org.credobank.testautomation.CssClientRegistration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseAccessSQL {
    public static Connection connectionCss;
    public static Connection getInstanceCss() {
        try {
            if (connectionCss == null || connectionCss.isClosed()) {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connectionCss = DriverManager.getConnection("jdbc:sqlserver://10.195.105.247; encrypt=false; trustedServerCertificate=false", "AppDb", "rKC61m20");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connectionCss;
    }
}
