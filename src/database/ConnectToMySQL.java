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

    /**
     *
     * @param driver: driver to connect to DB
     * @param user: userName
     * @param passWd: password
     */
    public void startConnectionToDB(String driver, String user, String passWd){
        try {
            myConnection = DriverManager.getConnection(driver,user,passWd);
            myStatement = myConnection.createStatement();
        } catch (SQLException e) {
            System.out.println("ERROR: Can't connect to DB");
        }
    }

    /**
     * close the connection to DB
     */
    public void closeConnectionToDB(){
        try {
            myConnection.close();
        } catch (SQLException sqle) {
            System.out.println("ERROR: Can't close connection to DB");
        }
        myStatement = null;
        myResultset = null;
    }

    /**
     *
     * @param tableName
     * @throws SQLException
     */
    public void viewAllTable(String tableName) throws SQLException {
        myResultset = myStatement.executeQuery("select * from " + tableName);
        while(myResultset.next()) {
            for (int i = 1; i <= myResultset.getMetaData().getColumnCount(); i++) {
                System.out.print(myResultset.getMetaData().getColumnName(i) + " " + myResultset.getString(i) + "\t");
            }
            System.out.println();
        }
    }

    /**
     *
     * @param tableName name of the table
     * @param attribute name of attribute
     * @param attributeValue value of atribute to compare
     * @throws SQLException
     */
    public void viewRowsByAttribute(String tableName, String attribute, String attributeValue) throws SQLException {
        myResultset = myStatement.executeQuery("select * from " + tableName + " where " + attribute +"="+attributeValue);
        while (myResultset.next()){
            for (int i = 1; i <= myResultset.getMetaData().getColumnCount(); i++) {
                System.out.print(myResultset.getMetaData().getColumnName(i) + " " + myResultset.getString(i) + "\t");
            }
            System.out.println();
        }
    }

    /**
     *
     * @param query: query to execute
     * @throws SQLException
     */
    public void toWriteAQuery(String query) throws SQLException {
        myStatement.executeUpdate(query);
    }
}
