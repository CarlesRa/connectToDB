import database.ConnectToMySQL;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            ConnectToMySQL miConexion = new ConnectToMySQL("root","");
            miConexion.mostrarCorredoresPorNombre("'pepe'");
        } catch (SQLException e) {
            System.out.println("Error al conectar");
            e.printStackTrace();
        }
    }
}
