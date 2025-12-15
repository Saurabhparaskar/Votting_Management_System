<!DOCTYPE html>
<html>
<head>
<title>Add Candidate</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<div class="container mt-5">
<h3>Add Candidate</h3>

<form action="addCandidate" method="post">
    <div class="mb-3">
        <label>Candidate Name</label>
        <input type="text" name="candidateName" class="form-control" required>
    </div>

    <div class="mb-3">
        <label>Party Name</label>
        <input type="text" name="partyName" class="form-control" required>
    </div>

    <button class="btn btn-success">Add Candidate</button>
</form>


<br>
<a href="AdminDashboard.jsp">Back</a>
</div>
</body>
</html>
