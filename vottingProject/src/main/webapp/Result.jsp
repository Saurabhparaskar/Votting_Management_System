<%@ page import="java.sql.*,util.DBConnection" %>
<!DOCTYPE html>
<html>
<head>
<title>Voting Result</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<div class="container mt-5">
<h3>Voting Result</h3>

<table class="table table-bordered">
<tr>
<th>Candidate</th>
<th>Party</th>
<th>Votes</th>
</tr>

<%
Connection con = DBConnection.getConnection();
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("SELECT * FROM candidates");
while(rs.next()){
%>
<tr>
<td><%=rs.getString("candidate_name")%></td>
<td><%=rs.getString("party_name")%></td>
<td><%=rs.getInt("vote_count")%></td>
</tr>
<% } %>
</table>

<a href="AdminDashboard.jsp">Back</a>
</div>
</body>
</html>
