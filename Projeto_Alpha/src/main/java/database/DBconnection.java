package database;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

    public class DBconnection {

        private static Connection conn = null;
        public static Connection getConnection(){
            try {
                if (conn == null) {
                    Properties props = loadProperties();
                    String url = props.getProperty("dburl");
                    conn = DriverManager.getConnection(url, props);
                }
            }
            catch (SQLException e){
                e.getMessage();
            }
            return conn;
        }

        public static void closeConnection(){
            if (conn != null){
                try {
                    conn.close();
                }
                catch (SQLException e){
                    e.getMessage();
                }
            }
        }
        private static Properties loadProperties() {
            try (FileInputStream fs = new FileInputStream("DB.properties")) {
                Properties props = new Properties();
                props.load(fs);
                return props;

            } catch (IOException e) {
                e.getMessage();
            }

            return null;
        }


    }


