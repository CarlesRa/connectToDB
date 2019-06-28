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

    public void mostrarTodosLosCorredores() throws SQLException {
        myResultset = myStatement.executeQuery("select * from corredores");
        while (myResultset.next()){
            System.out.println(myResultset.getString(1) + " " + myResultset.getString(2)+ " " + myResultset.getString(3)+ " " + myResultset.getString(6));
        }
    }
    public void mostrarCorredoresPorNombre(String nombre) throws SQLException {
        myResultset = myStatement.executeQuery("select * from corredores where nom="+nombre);
        while (myResultset.next()){
            System.out.println(myResultset.getString(1) + " " + myResultset.getString(2));
            return;
        }
        System.out.println("No existe corredores con ese nombre");
    }

    public void mostrarCorredoresPorId(String corredor_id) throws SQLException{
        myResultset = myStatement.executeQuery("select * from corredores where corredor_id="+corredor_id);
        while (myResultset.next()){
            System.out.println(myResultset.getString(1) + " " + myResultset.getString(2));
        }
    }

    public void insertarCorredoresInDB(String nom, String tiempo, String falta1, String falta2) throws SQLException {
        int resultado;
        resultado = myStatement.executeUpdate("insert into corredores values(null,"+nom+","+tiempo+","+falta1+","+falta2+",null)");
    }
}
