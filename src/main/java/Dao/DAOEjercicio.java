/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;



import VO.Ejercicio;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DAOEjercicio implements IBaseDatos<Ejercicio>  {

    @Override
    public List<Ejercicio> findAll() {
        List<Ejercicio> Ejercicios = null;
        String query = "SELECT * FROM Ejercicio";
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(DAOEjercicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            int Eno = 0;
            String Cat = null;
            int MaxPt = 0;
            String Tema = null;

            while (rs.next()) {
                if (Ejercicios == null) {
                    Ejercicios = new ArrayList<Ejercicio>();
                }

                Ejercicio registro = new Ejercicio();
                Eno = rs.getInt("Eno");
                registro.setEno(Eno);

                Cat = rs.getString("Cat");
                registro.setCat(Cat);
                
                Tema = rs.getString("Tema");
                registro.setTema(Tema);
                
                
                MaxPt = rs.getInt("MaxPt");
                registro.setMaxPt(MaxPt);
                
                Ejercicios.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Departamentos");
            e.printStackTrace();
        }

        return Ejercicios;

    }

  

    @Override
    public boolean insert(Ejercicio t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Ejercicio t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Ejercicio t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
