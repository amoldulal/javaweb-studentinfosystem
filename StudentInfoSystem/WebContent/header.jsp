
<link rel="stylesheet" href="resources/css/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="resources/jquery/jquery-3.2.1.slim.min.js"></script>
<script type="text/javascript" src="resources/jquery/popper.js"></script>
<script type="text/javascript" src="resources/css/bootstrap/js/bootstrap.min.js"></script>


<!-- Grey with black text -->
<nav class="navbar navbar-expand-sm bg-warning navbar-warning">
<a class="navbar-brand" href="#">Student Info System</a>
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="home.jsp">Home</a>
    </li>
    
     <li class="nav-item active">
      <a class="nav-link" href="StudentController?actions=student_list">Student</a>
    </li>
    
    <li class="nav-item">
      <a class="nav-link" href="UserController?actions=user_list">User</a>
    </li>
    <li class="nav-item">
      <a class="nav-link disabled" href="#">Disabled</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">${username}</a>
    </li>
    <li class="nav-item active">
      <a class="nav-link" href="LoginController">Logout</a>
    </li>
  </ul>
</nav>
</body>
</html>