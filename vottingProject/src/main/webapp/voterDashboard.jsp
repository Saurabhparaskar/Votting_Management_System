<%@ page session="true" %>
<%
Boolean hasVoted = (Boolean) session.getAttribute("hasVoted");
%>

<!DOCTYPE html>
<html>
<head>
<title>Voter Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">
<div class="row justify-content-center">
<div class="col-md-6">

<div class="card shadow">
<div class="card-header bg-primary text-white text-center">
<h4>Voter Dashboard</h4>
</div>

<div class="card-body text-center">

<% if (hasVoted != null && hasVoted) { %>
    <div class="alert alert-info">
        You have already voted.
    </div>
<% } else { %>
    <a href="Vote.jsp" class="btn btn-success btn-lg w-75">
        Vote Now
    </a>
<% } %>

</div>

<div class="card-footer text-center">
    <a href="logout" class="btn btn-danger">
        Logout
    </a>
</div>
</div>

</div>
</div>
</div>

</body>
</html>
