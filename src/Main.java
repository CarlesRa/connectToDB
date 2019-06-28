import database.ConnectToMySQL;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        String driver = "jdbc:mysql://localhost:3306/carreras";
        try {
            ConnectToMySQL miConexion = new ConnectToMySQL();
            miConexion.startConnectionToDB(driver,"root","");
            miConexion.viewAllTable("corredores");
            System.out.println();
            miConexion.viewRowsByAttribute("corredores","nom","'pepe'");
            System.out.println();
            miConexion.viewRowsByAttribute("corredores","corredor_id","5");
            System.out.println();
            miConexion.toWriteAQuery("delete from corredores where nom='martina'");
            miConexion.viewAllTable("corredores");
            miConexion.closeConnectionToDB();
        } catch (SQLException e) {
            System.out.println("Error al conectar");
            e.printStackTrace();
        }
    }
}
