package com.ecodeup.controller;

import java.awt.List;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecodeup.dao.DAO;
import com.ecodeup.model.Tabla;

/**
 * Servlet implementation class TablaController
 */
@WebServlet(description = "tabla", urlPatterns = { "/Tabla" })
public class TablaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TablaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String opcion = request.getParameter("opcion");
		if(opcion.equals("crear")) {
			System.out.println("usted a presionado la opcion crear");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/crear.jsp");
			requestDispatcher.forward(request, response);
		} else if(opcion.equals("listar")) {
			
			DAO dao = new DAO();
			java.util.List<Tabla> lista = new ArrayList<>();
			try {	
				lista = dao.obtenerTablas();
				for (Tabla tabla : lista) {
					System.out.println(tabla);	
				}
				
				request.setAttribute("lista", lista);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/listar.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}			
			System.out.println("usted a presionado la opcion listar");
			
		}else if(opcion.equals("meditar")) {
			int Id=Integer.parseInt(request.getParameter("Id"));
			System.out.println("Editar Id : "+Id);
			DAO dao = new DAO();	
			Tabla t = new Tabla();
			try {
				t=dao.obtenerTabla(Id);
				System.out.println(t);
				request.setAttribute("tabla", t);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(opcion.equals("eliminar")) {
			DAO dao = new DAO();
			int Id=Integer.parseInt(request.getParameter("Id"));
			try {
				dao.eliminar(Id);
				System.out.println("Registro eliminado");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcion= request.getParameter("opcion");
		
		if(opcion.equals("guardar")) {
			DAO dao = new DAO();
			Tabla tabla = new Tabla();
			tabla.setNombre(request.getParameter("nombre"));
			tabla.setCUI(request.getParameter("CUI"));
			tabla.setCarrera(request.getParameter("carrera"));
			
			try {
				dao.guardar(tabla);
				System.out.println("Registro guardado");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request,response);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if (opcion.equals("editar")) {
			Tabla tabla = new Tabla();
			DAO dao = new DAO();
			
			tabla.setId(Integer.parseInt(request.getParameter("Id")));
			tabla.setNombre(request.getParameter("nombre"));
			tabla.setCUI(request.getParameter("CUI"));
			tabla.setCarrera(request.getParameter("carrera"));
			try {
				dao.editar(tabla);
				System.out.println("Registro guardado");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request,response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		//doGet(request, response);
	}

}
