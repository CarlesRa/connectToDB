package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectToMysql {
    //libreria de mysql
    public String driver = "com.mysql.sdbc.Driver";

    //nombre de la base de datos
    public String dataBase = "carreras";

    //host
    public String hostName = "localhost";

    //puerto
    public String port = "3306";

    //Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    public String url = "jdbc:mysql://" + hostName + ":" + port + "/" + dataBase + "?useSSL=false";

    //nombre de usuario
    public String name = "root";

    //clave de usuario
    public String passwd = "";

    public Connection conectarMysql(){
        Connection connection = null;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(url, name, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
