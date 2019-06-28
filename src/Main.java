import database.ConnectToMySQL;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            ConnectToMySQL miConexion = new ConnectToMySQL("root","");
            miConexion.mostrarTodosLosCorredores();
            System.out.println();
            miConexion.mostrarCorredoresPorNombre("'pepe'");
            System.out.println();
            miConexion.mostrarCorredoresPorId("5");
            System.out.println();
            miConexion.insertarCorredoresInDB("'Manolo'","120","6","3");
        } catch (SQLException e) {
            System.out.println("Error al conectar");
            e.printStackTrace();
        }
    }
}
