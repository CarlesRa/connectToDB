package database;

import java.sql.Connection;

public class GestionDB {
    private ConnectToMysql SQL = new ConnectToMysql();
    private Connection connection = SQL.conectarMysql();
    private String query = "";
}
