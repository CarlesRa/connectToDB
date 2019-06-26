package database;

import java.sql.Connection;

public class GestionDB {
    private ConnectToMysql SQL;
    private Connection connection;
    private String query;

    public GestionDB(){
        ConnectToMysql SQL = new ConnectToMysql();
        Connection connection = SQL.conectarMysql();
        String query = "";
    }

    public ConnectToMysql getSQL() {
        return SQL;
    }

    public Connection getConnection() {
        return connection;
    }

}
