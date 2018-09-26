/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Conexion.ConexionBase;


public class ValidaSesion extends HttpServlet {
   
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
      response.setContentType("text/html");
      HttpSession sesion = request.getSession();
      ConexionBase Conectar = new ConexionBase();
            
      String Usuario = (String)sesion.getAttribute("Correo");
      String Contraseña = (String)sesion.getAttribute("Contraseña");
      

      if(Conectar.Conecta(Usuario, Contraseña)){
          
        out.println("<h1><center> Sesion de " + Conectar.ObtenerRango(Usuario) + "</center></h1>");
        
        if(Conectar.ObtenerRango(Usuario).equals("administrador"))
        {
            out.println("<a href=\"\\BD,Servlets & Template\\todos.html\">Pagina Para Todos<br><br>");
            out.println("<a href=\"\\BD,Servlets & Template\\admin.html\">Pagina de Administrador 1<br>");
        }
        else
            if(Conectar.ObtenerRango(Usuario).equals("normal"))
            {
                out.println("<a href=\"\\BD,Servlets & Template\\todos.html\">Pagina Para Todos <br><br>");
                out.println("<a href=\"\\BD,Servlets & Template\\normal.html\">Pagina de Usuario<br><br>");
            }
        else
                out.println("Escribiste mal el rango :c");
      }
      else
      {
          out.println("<h1> Sesion incorrecta, pruebe de nuevo </h1>");
          out.println("<p> Usuario: " + Usuario + "<br> Contraseña: " + Contraseña + "<p>");
      }
  
    }

}