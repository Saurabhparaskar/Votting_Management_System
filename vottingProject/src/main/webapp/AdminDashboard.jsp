<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Admin Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<div class="container mt-5">
<h3>Admin Dashboard</h3>
<hr>

<%
String msg = request.getParameter("msg");
if (msg != null) {
%>
<div class="alert alert-success">
    <%= msg %>
</div>
<%
}
%>

<a href="AddCandidate.jsp" class="btn btn-success">Add Candidate</a>
<a href="Result.jsp" class="btn btn-primary">View Results</a>

<br><br>
<a href="Login.jsp" class="btn btn-danger">Logout</a>
</div>
</body>
</html>
