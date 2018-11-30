
package Dao;

import VO.Estudiante;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DAOEstudiante implements IBaseDatos<Estudiante>{

  
    public List<Estudiante> findAll(int codigo) {
        List<Estudiante> estudiantes = null;
        String query = "Select * from Estudiante";
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(DAOEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement preparedStmt = null;
            preparedStmt = connection.prepareStatement(query);
	    preparedStmt.setInt (1, codigo);
            ResultSet rs = preparedStmt.executeQuery();
            int id = 0;
            String nombre = null, apellido = null, email = null ;

            while (rs.next()) {
                if (estudiantes == null) {
                    estudiantes = new ArrayList<Estudiante>();
                }

                Estudiante estudiante = new Estudiante();
                id = rs.getInt("codigo");
                estudiante.setCodigo(id);

                nombre = rs.getString("nombre");
                estudiante.setNombre(nombre);
                
                apellido = rs.getString("apellido");
                estudiante.setApellido(apellido);
                
                email = rs.getString("email");
                estudiante.setEmail(email);
                
                estudiantes.add(estudiante);
            }
            preparedStmt.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Estudiantes");
            e.printStackTrace();
        }

        return estudiantes;

    }

    @Override
    public boolean insert(Estudiante t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Estudiante t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Estudiante t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Estudiante> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
