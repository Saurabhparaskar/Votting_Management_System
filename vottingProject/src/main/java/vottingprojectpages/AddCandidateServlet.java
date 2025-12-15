package vottingprojectpages;



import java.io.IOException;
import java.sql.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import util.DBConnection;
@WebServlet("/addCandidate")
public class AddCandidateServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String cname = request.getParameter("candidateName");
        String party = request.getParameter("partyName");

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO candidates(candidate_name, party_name) VALUES (?, ?)"
            );
            ps.setString(1, cname);
            ps.setString(2, party);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                response.sendRedirect("AdminDashboard.jsp?msg=Candidate Added Successfully");
            } else {
                response.sendRedirect("AdminDashboard.jsp?msg=Failed to Add Candidate");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("AdminDashboard.jsp?msg=Error Occurred");
        }
    }
}
