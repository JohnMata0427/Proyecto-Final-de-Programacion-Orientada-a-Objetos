import java.sql.*;
public class Conexion {
    static ResultSet ejecutarQuery(String sql){
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/medicare", "root", "1726405390"); // Cambiar la contraseña por la que se tenga en MySQL
            Statement statement = conexion.createStatement(); // Se crea un jeto Statement para poder ejecutar las consultas
            return statement.executeQuery(sql); // Se ejecuta la consulta y se retorna el robesultado
        } catch (Exception e) {
            System.out.println("Error al conectar a la base de datos: " + e); // Si hay un error se imprime en consola
        }
        return null;
    }
    static PreparedStatement insertarDatos(String sql){
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/medicare", "root", "1726405390"); // Cambiar la contraseña por la que se tenga en MySQL
            return conexion.prepareStatement(sql);
        } catch (Exception exception){
            System.out.println("Error: " + exception);
        }
        return null;
    }
}