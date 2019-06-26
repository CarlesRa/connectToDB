package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectToMysql {
    //libreria de mysql
    private String driver;
    //nombre de la base de datos
    private String dataBase;
    //host
    private String hostName;
    //puerto
    private String port;
    //Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    private String url;
    //nombre de usuario
    private String user;
    //clave de usuario
    private String passwd;

    Connection connection = null;

    public ConnectToMysql(){
        driver = "" ;
        dataBase = "carreras";
        hostName  = "localhost";
        port = "3306";
        url = "jdbc:mysql://" + hostName + ":" + port + "/" + dataBase + "?useSSL=false";
        user  = "root";
        passwd  = "admin";
    }

    public ConnectToMysql(String dataBase, String hostName, String port, String user, String passwd) {
        this.dataBase = dataBase;
        this.hostName = hostName;
        this.port = port;
        this.user = user;
        this.passwd = passwd;
        url = "jdbc:mysql://" + hostName + "/" + port + "/" + dataBase + "?useSSL=false";
    }

    public Connection conectarMysql(){
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("No encuentra la clase");
        }
        try {
            //generamos la coneion
            connection = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No es pot conectar");
        }
        return connection;
    }
    public void desconectarMySQL(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
