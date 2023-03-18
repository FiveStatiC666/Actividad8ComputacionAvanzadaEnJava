/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet (name = "paso",urlPatterns={"/paso"})
public class paso extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()){
            
            if(request.getAttribute("filtro")!=null)
            {
                request.setAttribute("filtro",1);
                request.getRequestDispatcher("/index.jsp").forward(request,response);
                
            }
            
            else
            {
            String base=request.getParameter("base");
            String altura=request.getParameter("altura");
            
            Calculos.triangulo s=new Calculos.triangulo(base,altura);
            s.sacarArea();
            s.sacarPerimetro();
            
            int area=s.getArea();
            int perimetro=s.getPerimetro();
            
            request.setAttribute("calculo", s);
            request.getRequestDispatcher("/muestraResultado.jsp").forward(request, response);
            
            HttpSession sesion = request.getSession(false);
            String nombre = request.getParameter("name");
            
            sesion.setAttribute("nombre", nombre);
            
            Cookie ck=new Cookie("baseCk", s.getBase()+"");
            response.addCookie(ck);
            ck=new Cookie("alturaCk", s.getAltura() +"");
            response.addCookie(ck);
            ck=new Cookie("areaCk", s.getPerimetro()+"");
            response.addCookie(ck);
            ck=new Cookie("perimetroCk", s.getArea()+"");
            response.addCookie(ck);
            
            }
            //response.sendRedirect("/muestraResultado.jsp");
            
            
            
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        processRequest(request, response);
    }
    
    @Override
    public String getServletInfo(){
        return "Short description";
    }
    
    
}