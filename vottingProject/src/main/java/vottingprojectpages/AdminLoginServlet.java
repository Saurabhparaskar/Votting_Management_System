package vottingprojectpages;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Adminlogin.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vottingSystem", "root", "root");
			String email = request.getParameter("Email").trim();
			String password = request.getParameter("password").trim();

			String admincheck = "Select*from  voters where email=? AND password=?";
			PreparedStatement psmt = con.prepareStatement(admincheck);
			psmt.setString(1, email);
			psmt.setString(2, password);
			ResultSet rs = psmt.executeQuery();
			 if (rs.next()) {

		            String role = rs.getString("Role"); // read from DB

		            if (role.equals("admin")) {
		           
		                response.sendRedirect("Adminpage.jsp");
		            } else {
		                response.sendRedirect("Home.jsp");
		            }

		        } 
		            
    
			
		} catch (Exception e) {
			e.printStackTrace();
			}
	}}

