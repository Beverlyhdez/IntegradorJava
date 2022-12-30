/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Socios;
import Modelo.SociosDAO;
import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Beverly
 */
public class SociosController extends HttpServlet 
{
    public SociosController()
    {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        SociosDAO sociosDAO=null;
        try
        {
        sociosDAO=new SociosDAO();
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        String accion;
        accion=request.getParameter("accion");
        
        RequestDispatcher dispatcher=null;
        
        if(accion==null||accion.isEmpty())
        {
            dispatcher=request.getRequestDispatcher("Vistas/socios.jsp");
        }
        else if(accion.equals("modificar"))
        {
            dispatcher=request.getRequestDispatcher("Vistas/modificar.jsp");            
        }
	else if(accion.equals("actualizar"))
	{                        
            int id=Integer.parseInt(request.getParameter("id"));
            String nombre=request.getParameter("nombre");
            String apellido=request.getParameter("apellido");
            String direccion=request.getParameter("direccion");
            String localidad=request.getParameter("localidad");            
            LocalDate fecha=LocalDate.parse(request.getParameter("fnac"));                 
            String email=request.getParameter("email");
            String telefono=request.getParameter("telefono");                                    
            Socios s1=new Socios(id,nombre,apellido,direccion,localidad,fecha,email,telefono,true);
            sociosDAO.actualizarSocios(s1);			
            dispatcher=request.getRequestDispatcher("Vistas/socios.jsp");			
	}
	else if(accion.equals("eliminar"))
	{
            int id=Integer.parseInt(request.getParameter("id"));
            sociosDAO.eliminarSocios(id);			
            dispatcher=request.getRequestDispatcher("Vistas/socios.jsp");
	}
	else if(accion.equals("nuevo"))
        {
            dispatcher=request.getRequestDispatcher("Vistas/nuevo.jsp");
        }
	else if(accion.equals("insertar"))
        {
            String nombre=request.getParameter("nombre");
            String apellido=request.getParameter("apellido");
            String direccion=request.getParameter("direccion");
            String localidad=request.getParameter("localidad");            
            LocalDate fecha=LocalDate.parse(request.getParameter("fnac"));                 
            String email=request.getParameter("mail");
            String telefono=request.getParameter("telefono");                                     
            Socios s1=new Socios(0,nombre,apellido,direccion,localidad,fecha,email,telefono,true);
	    sociosDAO.insertarSocios(s1);		
            dispatcher=request.getRequestDispatcher("Vistas/socios.jsp");
	}          
        
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        doGet(request,response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
