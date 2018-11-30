<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="VO"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
body {
    background-image:
        url('http://cdn.crunchify.com/wp-content/uploads/2013/03/Crunchify.bg_.300.png');
}
</style>
 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Estudiantes</title>
    </head>
    <body>
        <div align="center" style="margin-top: 50px;">
            <%
              if(request.getAttribute("escuelas")!=null){
            %>   
            <form action="Estudiante" method="post">
                <select name = "Estudiante">
           <%
              List<Estudiante> Estudiantes  = (List<Estudiante>)request.getAttribute("Estudiantes");  
               for (Estudiante estudiante : estudiante) {
             %>
               <option value="<%=estudiante.getNombreo()%>"><%=estudiante.getCodigo()%></option>
             
             <%
               }
           %>
                </select>
                <input type="submit" value="submit">
            </form>
            <%
              }
            
            %>
            
          
        </div>


        <div align="center" style="margin-top: 50px;">
            
            <%
              if(request.getAttribute("estudiantes")!=null){
            %>      
              <table style="width:100%">
               <tr>
                    <th>Codigo</th>
                    <th>Nombre</th> 
                    <th>Apellido</th>
                    <th>Email</th>
              </tr>
                
              <%
              List<Estudiante> estudiantes  = (List<Estudiante>)request.getAttribute("estudiantes");  
               for (Estudiante estudiante : estudiantes) {
             %>
             
               <tr>
                  <td><%=estudiante.getCodigo()%></td>
                  <td><%=estudiante.getNombre()%></td> 
                  <td><%=estudiante.getApellido()%></td>
                  <td><%=estudiante.getEmail()%></td>
              </tr>
             
             <%
             }
             %>
               
                </table>
               
            <%
              }
            %>   
            
        </div>
    
    
</body>
</html>
