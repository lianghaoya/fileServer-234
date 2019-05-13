<%
 /*request.getRequestDispatcher("./WEB-INF/html/jsp/login.jsp").forward(request,response);*/
 response.sendRedirect(request.getContextPath()+"/api/login/getLogin");
%>
<html>
<body>
<h2>Hello World!</h2>
</body>
</html>
