/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Omen
 */
@WebServlet(name = "UsoSession", urlPatterns = {"/UsoSession"})
public class UsoSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
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
       response.setContentType("text/htm;charset=UTF-8");
        PrintWriter out =response.getWriter();
        try{
        out.println("<!DOCTYPE html>");    
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servelet UsoSession</title>");
        out.println("</head>");
        out.println("<body>");
       //mostrar todas las cookies
      HttpSession session = request.getSession(true);
      //Datos Session
      Date created =new Date(session.getCreationTime());
      Date accessed = new Date(session.getLastAccessedTime());
      out.println("ID: "+ created + "<br>");
      out.println("Creado: "+ created + "<br>");
      out.println("Ultimo acceso: "+ accessed + "<br>");
      //introducir un dato de session
      String nomDato = request.getParameter("nomDato");
       if(nomDato != null && nomDato.length()> 0 ){
       String valor = request.getParameter("valor");
       session.setAttribute(nomDato,valor);
       }
       Enumeration e = session.getAttributeNames();
       while(e.hasMoreElements()){
           String nombre =(String)e.nextElement();
           String valor = session.getAttribute(nombre).toString();
           out.println(nombre +"-" + valor +"<br>");
       }
       out.println("</form>");
        out.println("</body>");
        out.println("</html>");
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