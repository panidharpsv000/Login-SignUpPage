<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%@ page import="loginDAO.loginDAO" %>
  <%
      response.setHeader("Cache-Control","no-cache , no-store , must-revalidate");
  
       if(session.getAttribute("id")==null)
          response.sendRedirect("login.html");
  %>
  <%
     loginDAO l1=new loginDAO();
     String name="";
     if(session.getAttribute("id")!=null)
     {
    	name=l1.getName((int)session.getAttribute("id"));
     }
  %>
  
  <p>Welcome <%= name %></p>

    <iframe width="560" height="315" 
    src="https://www.youtube.com/embed/34Na4j8AVgA?si=GgAzFvGafDa6PLzH" 
    title="YouTube video player" 
    frameborder="0" 
    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" 
    referrerpolicy="strict-origin-when-cross-origin" 
    allowfullscreen></iframe>
    <br>
    <form action="logOut">
      <button type="submit">LogOut</button>
    </form>
</body>
</html>