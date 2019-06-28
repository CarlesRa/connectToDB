/*
 *@autor Carles Ramos
 *Class to connect and manage an MySQL DB
 */
package database;
import java.sql.*;

public class ConnectToMySQL {
    private Connection myConnection;
    private Statement myStatement;
    private ResultSet myResultset;

    public ConnectToMySQL(){
        myConnection = null;
        myStatement = null;
        myResultset = null;
    }

    public void startConnectionToDB(String driver, String user, String passWd){
        try {
            myConnection = DriverManager.getConnection(driver,user,passWd);
            myStatement = myConnection.createStatement();
        } catch (SQLException e) {
            System.out.println("ERROR: Can't connect to DB");
        }
    }

    public void closeConnectionToDB(){
        try {
            myConnection.close();
        } catch (SQLException sqle) {
            System.out.println("ERROR: Can't close connection to DB");
        }
        myStatement = null;
        myResultset = null;
    }
    public void viewAllTable(String tableName) throws SQLException {
        myResultset = myStatement.executeQuery("select * from " + tableName);
        while(myResultset.next()) {
            for (int i = 1; i <= myResultset.getMetaData().getColumnCount(); i++) {
                System.out.print(myResultset.getMetaData().getColumnName(i) + " " + myResultset.getString(i) + "\t");
            }
            System.out.println();
        }
    }

    public void viewRowsByAttribute(String tableName, String attribute, String AttributeValue) throws SQLException {
        myResultset = myStatement.executeQuery("select * from " + tableName + " where " + attribute +"="+AttributeValue);
        while (myResultset.next()){
            for (int i = 1; i <= myResultset.getMetaData().getColumnCount(); i++) {
                System.out.print(myResultset.getMetaData().getColumnName(i) + " " + myResultset.getString(i) + "\t");
            }
            System.out.println();
        }
    }

    public void toWriteAQuery(String query) throws SQLException {
        myStatement.executeUpdate(query);
    }
}
