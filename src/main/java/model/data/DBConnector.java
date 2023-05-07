package model.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public final class DBConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final DBConnector INSTANCE = new DBConnector();
    private static Connection connection = null;
    public static DBConnector getInstance() {
        return INSTANCE;
    }
    // Realiza la conexion para MySQL sin una base de datos en especifico
    public static Connection connection(String username, String password) throws ClassNotFoundException {
        try {
            if (connection == null || connection.isClosed()) {
                connection = doConnection("",username, password);
            }
        } catch (SQLException e) {
            System.err.println("Error al comprobar si está cerrada la conexión: "+ e);
            throw new RuntimeException(e);
        }
        return connection;
    }
    // Realiza la conexion para una base de datos SQL especifico
    public static Connection connection(String db,String username, String password) {
        try {
            if (connection == null || connection.isClosed()) {
                connection = doConnection(db,username, password);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al comprobar si está cerrada la conexión: "+ e);
            throw new RuntimeException(e);
        }
        return connection;
    }
    // Cierra el nodo de conexion
    public static void closeConnection() {
        try {
            connection.close();
            System.out.println("Conexión cerrada.");
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: "+ e);
        }
    }
    private static Connection doConnection(String db,String username, String password) throws ClassNotFoundException {
        Connection conn;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL+db, username, password);
        } catch (SQLException e) {
            System.err.println("Error al crear la conexión: "+ e);
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.err.println("Error al crear la conexión: "+ e);
            throw new ClassNotFoundException(e.toString());
        }
        System.out.println("Conexion creada : "+conn);
        return conn;
    }
}
