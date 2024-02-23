
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLDataException;

public class Pacientes_Registrados {
    JPanel Pacientes;
    private JLabel LogoRegistro;
    private JLabel NombreUsuario;
    private JButton cerrarSesiónButton;
    private JTextField textField1;
    private JRadioButton VerPacienteRB;
    private JRadioButton RegistrarCitaRB;
    private JRadioButton HistorialMedicoRB;
    private JRadioButton ResultadosRB;
    private JButton volverButton;
    private JTable PacientesRegistrados;


    public Pacientes_Registrados() {
        ButtonGroup GrupoModulos = new ButtonGroup();
        GrupoModulos.add(VerPacienteRB);
        GrupoModulos.add(RegistrarCitaRB);
        GrupoModulos.add(HistorialMedicoRB);
        GrupoModulos.add(ResultadosRB);
        try {
            ResultSet resultado = Conexion.ejecutarQuery("SELECT * FROM Clientes");
            ResultSetMetaData metaData = resultado.getMetaData();
            DefaultTableModel pacientes = new DefaultTableModel();
            int columnas = metaData.getColumnCount();
            for (int i = 1; i<=columnas; i++){
                pacientes.addColumn(metaData.getColumnLabel(i));
            }
            while(resultado.next()){
                Object[] filas = new Object[columnas];
                for (int i=0; i<columnas; i++){
                    filas[i] = resultado.getObject(i+1);
                }
                pacientes.addRow(filas);
            }
            PacientesRegistrados.setModel(pacientes);
        }catch (Exception ex){
            System.out.println(ex);
        }



        VerPacienteRB.addActionListener(e -> {
                Main.ventanaBase.setContentPane(Main.pacientes);
                Main.ventanaBase.validate();
        });

        RegistrarCitaRB.addActionListener(e -> {
                Main.ventanaBase.setContentPane(new RegistrarCita().RegistrarCitaPanel);
                Main.ventanaBase.revalidate();
        });
        HistorialMedicoRB.addActionListener(e -> {
                Main.ventanaBase.setContentPane(new Historial().HistorialForm);
                Main.ventanaBase.revalidate();
        });

        ResultadosRB.addActionListener(e -> {
                Main.ventanaBase.setContentPane(new Resultados().ResultadosForm);
                Main.ventanaBase.revalidate();
        });
        volverButton.addActionListener(e ->  {
                Main.ventanaBase.setContentPane(Main.moduloAdmin);
                Main.ventanaBase.revalidate();
        });
        cerrarSesiónButton.addActionListener(e -> {
            Main.ventanaBase.setContentPane(Main.login);
            Main.ventanaBase.validate();
        });
    }
}
