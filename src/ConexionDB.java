import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
public class ConexionDB {
    String servidor;
    String usuario;
    String password;
    String mensaje;

    public ConexionDB(String servidor, String usuario, String password) {
        this.servidor = servidor;
        this.usuario = usuario;
        this.password = password;
    }
    public ConexionDB(){
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void conexionlocal(String servidor, String usuario, String password){
        try(Connection connection= DriverManager.getConnection(servidor, usuario, password)){
            if(connection!=null){
                mensaje="Conexión correcta";
                System.out.println(mensaje);
            }
        }
        catch (SQLException e){
            mensaje="Conexión fallida";
            System.out.println(mensaje +"\nError: "+ e);
            e.printStackTrace();
        }
    }
}
