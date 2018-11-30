/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import VO.Estudiante;
import Dao.DAOEjercicio;
import Dao.DAOEstudiante;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletEstudiante extends  HttpServlet{
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         DAOEstudiante daoEstudiante = new DAOEstudiante();
         List<Estudiante> Estudiantes= daoEstudiante.findAll();
         request.setAttribute("Estudiantes", Estudiantes);
         //Redireccionando la informacion
         RequestDispatcher redireccion = request.getRequestDispatcher("index.jsp");
         redireccion.forward(request, response);      
      
     }
     
     
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         DAOEstudiante daoEstudiante = new DAOEstudiante();
         String nombre = request.getParameter("nombre");
         List<Estudiante> estudiantes= daoEstudiante.findAll(Integer.parseInt(nombre));
         request.setAttribute("estudiantes", estudiantes);
         //Redireccionando la informacion
         RequestDispatcher redireccion = request.getRequestDispatcher("index.jsp");
         redireccion.forward(request, response);      
         
      
     }
}
