import javax.swing.table.DefaultTableModel;
import java.sql.*;
public class Conexion {
    final static String url = "jdbc:mysql://localhost:3307/medicare";
    final static String usuario = "root";
    final static String contraseña = "1726405390";
    static ResultSet visualizarDatos(String sql) throws SQLException{// Se crea un metodo para visualizar los datos de la base de datos
        // Se crea un objeto ResultSet para almacenar los resultados de la consulta
        Connection conexion = DriverManager.getConnection(url, usuario, contraseña); // Cambiar la contraseña por la que se tenga en MySQL
        // Se crea un objeto Connection para establecer la conexion con la base de datos
        Statement statement = conexion.createStatement(); // Se crea un jeto Statement para poder ejecutar las consultas
        // Se crea un objeto Statement para poder ejecutar las consultas
        return statement.executeQuery(sql); // Se ejecuta la consulta y se retorna el resultado
    }

    static void insertarDatos(String sql) throws SQLException{
        Statement statement = DriverManager.getConnection(url, usuario, contraseña).createStatement();
        statement.executeUpdate(sql);
    }
    static DefaultTableModel obtenerModelo(String tabla) throws SQLException {
        ResultSet resultado = Conexion.visualizarDatos("SELECT * FROM " + tabla);// Se ejecuta la consulta y se almacena el resultado
        ResultSetMetaData metaData = resultado.getMetaData();// Se obtiene la metadata del resultado
        String[] nombreColumnas = new String[metaData.getColumnCount()];// Se crea un arreglo de String para almacenar los nombres de las columnas
        for (int i=0; i<metaData.getColumnCount(); i++){// Se recorre la metadata para obtener los nombres de las columnas
            nombreColumnas[i] = metaData.getColumnLabel(i+1);
        }
        DefaultTableModel model = new DefaultTableModel(nombreColumnas, 0);// Se crea un objeto DefaultTableModel con los nombres de las columnas
        while(resultado.next()){
            Object[] filas = new Object[metaData.getColumnCount()];
            for (int i=0; i<metaData.getColumnCount(); i++){
                filas[i] = resultado.getObject(i+1);
            }
            model.addRow(filas);// Se agregan las filas al modelo
        }
        return model;
    }
}