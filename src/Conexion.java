import java.sql.*;
public class Conexion {
    static ResultSet ejecutarQuery(String sql){
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/medicare", "root", "Tsuki1904"); // Cambiar la contraseña por la que se tenga en MySQL
            Statement statement = conexion.createStatement(); // Se crea un objeto Statement para poder ejecutar las consultas
            return statement.executeQuery(sql); // Se ejecuta la consulta y se retorna el resultado
        } catch (Exception e) {
            System.out.println("Error al conectar a la base de datos: " + e); // Si hay un error se imprime en consola
        }
        return null;
    }
}