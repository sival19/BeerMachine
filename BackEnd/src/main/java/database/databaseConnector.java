package database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import org.apache.ibatis.jdbc.ScriptRunner;

public class databaseConnector {
    //set connection parameters
    private static databaseConnector instance;
    private String url = "localhost";
    private int port = 3306;
    private String databaseName = "beermachine";
    private String username = "root";
    private String password = "secret";
    private Connection connection = null;

    private databaseConnector() {
        initializePostgresqlDatabase();

    }

    public static databaseConnector getInstance() {
        if (instance == null) {
            instance = new databaseConnector();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }


    private void initializePostgresqlDatabase() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Class.forName("com.mysql.jdbc.Driver").newInstance();

            connection = DriverManager.getConnection("jdbc:mysql://" + url + ":" +
                    port + "/" + databaseName, username, password);

//            //excecute migration SQL on app start
//            ScriptRunner sr = new ScriptRunner(connection); //imported class
//            try {
//                Reader reader = new BufferedReader(new FileReader(DatabaseConnector.class.
//                        getResource("migration.SQL").getPath()));
//                sr.runScript(reader);
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }

        } catch (SQLException | IllegalArgumentException ex) {
            ex.printStackTrace(System.err);
        } finally {
            if (connection == null) System.exit(-1);
        }
    }
}