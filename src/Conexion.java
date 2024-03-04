import javax.swing.table.DefaultTableModel;
import java.sql.*;
public class Conexion {
    final static String url = "jdbc:mysql://localhost:3307/medicare";
    final static String usuario = "root";
    final static String contraseña = "1726405390";
    static ResultSet visualizarDatos(String sql) throws SQLException{
        Connection conexion = DriverManager.getConnection(url, usuario, contraseña); // Cambiar la contraseña por la que se tenga en MySQL
        Statement statement = conexion.createStatement(); // Se crea un jeto Statement para poder ejecutar las consultas
        return statement.executeQuery(sql); // Se ejecuta la consulta y se retorna el robesultado
    }
    static void insertarDatos(String sql) throws SQLException{
        Statement statement = DriverManager.getConnection(url, usuario, contraseña).createStatement();
        statement.executeUpdate(sql);
    }
    static DefaultTableModel obtenerModelo(String tabla) throws SQLException {
        ResultSet resultado = Conexion.visualizarDatos("SELECT * FROM " + tabla);
        ResultSetMetaData metaData = resultado.getMetaData();
        String[] nombreColumnas = new String[metaData.getColumnCount()];
        for (int i=0; i<metaData.getColumnCount(); i++){
            nombreColumnas[i] = metaData.getColumnLabel(i+1);
        }
        DefaultTableModel model = new DefaultTableModel(nombreColumnas, 0);
        while(resultado.next()){
            Object[] filas = new Object[metaData.getColumnCount()];
            for (int i=0; i<metaData.getColumnCount(); i++){
                filas[i] = resultado.getObject(i+1);
            }
            model.addRow(filas);
        }
        return model;
    }
}