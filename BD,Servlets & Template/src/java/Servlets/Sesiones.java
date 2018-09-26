/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Sesiones extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//Servlet para definir parametros de sesion
    //Pedimos los atributos
    String Correo = request.getParameter("Correo");
    String Contraseña = request.getParameter("Contrasena");
         //Definir atributos de sesion
        HttpSession sesion = request.getSession();
        sesion.setAttribute("Correo", Correo);
        sesion.setAttribute("Contraseña", Contraseña);
        response.setContentType("text/html");
      //Redireccionar a validacion con Base de datos
      response.sendRedirect("http://localhost:8080/BD,Servlets & Template/ValidaSesion");
  
    }
   

}
