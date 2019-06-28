import database.GestionDB;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        GestionDB gestionDB = new GestionDB();
        try {
            System.out.println(gestionDB.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (NullPointerException npe){
            System.out.println("No funciona perqu no es conecta");
        }
    }
}
