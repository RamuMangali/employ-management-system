<%@page import="java.util.List"%>
<%@page import="com.dto.EmployDetails"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
List<EmployDetails> det = (List<EmployDetails>) session.getAttribute("details");
%>
  <center>  <form action="search" method="get"><label>search<input type="text" name="value"></label>
  <input type="submit" > </form>
  <form action="getdetails"><input type="submit">GetAllDetails</input></form>
           <table border="2px">
           <tr>
           <td>EmployId</td>
           <td>Emplot Name</td>
           <td>Email</td>
           <td>Mobile</td>
           <td>Gender</td>
           <td>Address</td>
           <td>Password</td>
           </tr>
           <%
               Iterator<EmployDetails> itr= det.iterator();
           while(itr.hasNext())
           {
        	    EmployDetails details=itr.next();
        	    out.print("<tr>");
        	    out.print("<td>"+details.getId()+"</td>");
        	    out.print("<td>"+details.getName()+"</td>");
        	    out.print("<td>"+details.getEmail()+"</td>");
        	    out.print("<td>"+details.getMobile()+"</td>");
        	    out.print("<td>"+details.getGender()+"</td>");
        	    out.print("<td>"+details.getAddress()+"</td>");
        	    out.print("<td>"+details.getPassword()+"</td>");
        	    out.print("<td><button><a href='./delete?Id="+details.getId()+"'>Delete</a></button><button><a href='./update?Id="+details.getId()+"'>update</a></button></td>");
        	    out.print("</tr>");
           }
           out.println("</table>");
           %>
           </table>
  </center>
</body>
</html>