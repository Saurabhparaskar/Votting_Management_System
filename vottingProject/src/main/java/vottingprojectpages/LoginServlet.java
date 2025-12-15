package vottingprojectpages;


import java.io.IOException;
import java.sql.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import util.DBConnection;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM voters WHERE email=? AND password=?"
            );
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("email", email);
                session.setAttribute("hasVoted", rs.getBoolean("has_voted"));

                if (rs.getString("role").equals("ADMIN")) {
                    response.sendRedirect("AdminDashboard.jsp");
                } else {
                    response.sendRedirect("voterDashboard.jsp");
                }
            } else {
                response.sendRedirect("Login.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
