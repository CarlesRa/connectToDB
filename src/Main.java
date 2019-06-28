import database.ConnectToMySQL;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        String driver = "jdbc:mysql://localhost:3306/elecciones";
        try {
            ConnectToMySQL miConexion = new ConnectToMySQL();
            miConexion.startConnectionToDB(driver,"root","");
            miConexion.viewAllTable("partido");
            System.out.println();
            miConexion.viewRowsByAttribute("partido","nombre_partido","'pepe'");
            System.out.println();
            miConexion.viewRowsByAttribute("partido","nombre_partido","'PP'");
            System.out.println();
            miConexion.toWriteAQuery("delete from partido where nombre_partido='PP'");
            miConexion.viewAllTable("partido");
            miConexion.closeConnectionToDB();
        } catch (SQLException e) {
            System.out.println("Error al conectar");
            e.printStackTrace();
        }
    }
}
