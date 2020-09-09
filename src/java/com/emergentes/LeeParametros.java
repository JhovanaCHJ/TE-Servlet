/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Omen
 */
@WebServlet(name = "LeeParametros", urlPatterns = {"/LeeParametros"})
public class LeeParametros extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/htm;charset=UTF-8");
        PrintWriter out =response.getWriter();
        try{
        out.println("<!DOCTYPE html>");    
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet LeeParametros POST (formulario) </title>");
        out.println("</head>");
        out.println("<body>");
       out.println("<h1>Servlet LeeParametros</h1>");
       out.println("<br><br>");
       out.println("<form action ='' method='post'>");
       out.println("Nombre: ");
       out.println("<input type='text' name='nombre' required>");
       out.println("<br>");
       out.println("Apellidos: ");
       out.println("<input type='text' name='apellido' required>");
       out.println("<br>");
       out.println("<input type='submit' value='Enviar'>");
       out.println("</form>");
        out.println("</body>");
        out.println("</html>");
          } finally{
            out.close();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
        response.setContentType("text/htm;charset=UTF-8");
        PrintWriter out =response.getWriter();
        try{
        out.println("<!DOCTYPE html>");    
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet LeeParametros </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Los datos recibidos son</h1>");
        
       if(nombre != null || apellido !=null){
           out.println("Sus datos son: <br>");
           out.println("Nombre: "+nombre+"<br>");
           out.println("Apellido"+apellido+"<br>");
           
       }  else{
           out.println("No hay datos");
       }
       out.println("</body>");
       out.println("</head>");
          } finally{
            out.close();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
