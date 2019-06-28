package database;
import java.sql.*;

public class ConnectToMySQL {
    private final String DRIVER = "jdbc:mysql://localhost:3306/carreras";
    private Connection myConnection;
    private Statement myStatement;
    private ResultSet myResultset;

    public ConnectToMySQL(String user, String passWd) throws SQLException {
        myConnection = DriverManager.getConnection(DRIVER,user,passWd);
        myStatement = myConnection.createStatement();
    }

    public Statement getMyStatement() {
        return myStatement;
    }

    public ResultSet getMyResultset() {
        return myResultset;
    }

    public void mostrarCorredoresPorNombre() {

    }
}
