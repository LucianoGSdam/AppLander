/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import garsan_servicios.Partida_servicio;
import garsan_servicios.Usuario_servicio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luciano
 */
public class ServletCookies extends HttpServlet {

    EntityManagerFactory emf;
    EntityManager em;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Actualmente en el doGet de ServletCookies");
        boolean ok = false;

        Cookie[] listaCookies = request.getCookies();
        String name_usuario = "anonymous";
        Date d = new Date();

        emf = Persistence.createEntityManagerFactory("AppLander");
        em = emf.createEntityManager();

        Usuario_servicio us = new Usuario_servicio(em);
        Partida_servicio part = new Partida_servicio(em);

        System.out.println("Tamaño lista de cookies: " + listaCookies.length);
        
        try {
            for (int i = 0; i < listaCookies.length-1; i++) {
                if (us.findnick(listaCookies[i].getValue(), listaCookies[i+1].getValue())) {
                    name_usuario = listaCookies[i].getValue();
                    System.out.println("Usuario encontrado");
                    
                   ok = true;
                    
                } else {
                    System.out.println("Usuario NO encontrado");
                    ok = false;
                    
                }
            }
            
            if(ok){
                 part.addPartida(d, d, 0, name_usuario );
                 RequestDispatcher a = request.getRequestDispatcher("juego_lander.jsp");
                 a.forward(request, response);
            }else{
                RequestDispatcher a = request.getRequestDispatcher("login.jsp");
                a.forward(request, response);
            }
            
            
        } catch (Exception e) { 
           RequestDispatcher a = request.getRequestDispatcher("login.jsp");
           a.forward(request, response);
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
        processRequest(request, response);
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
