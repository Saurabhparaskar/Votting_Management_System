<%@ page import="java.sql.*,util.DBConnection" %>
<%
Boolean hasVoted = (Boolean) session.getAttribute("hasVoted");
if(hasVoted != null && hasVoted){
    response.sendRedirect("voterDashboard.jsp");
}
%>

<!DOCTYPE html>
<html>
<head>
<title>Vote Candidate</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<div class="container mt-5">
<h3>Vote for Candidate</h3>

<form action="vote" method="post">

<table class="table table-bordered">
<tr>
<th>Select</th>
<th>Candidate</th>
<th>Party</th>
</tr>

<%
Connection con = DBConnection.getConnection();
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("SELECT * FROM candidates");
while(rs.next()){
%>
<tr>
<td><input type="radio" name="candidateId" value="<%=rs.getInt("candidate_id")%>" required></td>
<td><%=rs.getString("candidate_name")%></td>
<td><%=rs.getString("party_name")%></td>
</tr>
<% } %>
</table>

<button class="btn btn-success">Submit Vote</button>
</form>
</div>
</body>
</html>
