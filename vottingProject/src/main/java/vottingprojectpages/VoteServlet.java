package vottingprojectpages;


import java.io.IOException;
import java.sql.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import util.DBConnection;

@WebServlet("/vote")
public class VoteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        HttpSession session = request.getSession();
        Boolean hasVoted = (Boolean) session.getAttribute("hasVoted");
        String email = (String) session.getAttribute("email");

        if (hasVoted != null && hasVoted) {
            response.sendRedirect("voterDashboard.jsp");
            return;
        }

        int candidateId = Integer.parseInt(request.getParameter("candidateId"));

        try {
            Connection con = DBConnection.getConnection();

            con.prepareStatement(
                "UPDATE candidates SET vote_count = vote_count + 1 WHERE candidate_id=" + candidateId
            ).executeUpdate();

            con.prepareStatement(
                "UPDATE voters SET has_voted=true WHERE email='" + email + "'"
            ).executeUpdate();

            session.setAttribute("hasVoted", true);
            response.sendRedirect("voterDashboard.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
