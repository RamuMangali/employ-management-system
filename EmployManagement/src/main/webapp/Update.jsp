<%@page import="com.dto.EmployDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%  EmployDetails details=(EmployDetails) session.getAttribute("Details");
%>
     <center>
      <div>
      <form action="updateUser" method="get">
            <label>User Id<br><input type="text" name="id" value="<%=details.getId()%>"></label><br><br>
       <label>User Name<br><input type="text" name="name" value="<%=details.getName()%>"></label><br><br>
      <label> EmailId <br> <input type="text" name="email" value="<%=details.getEmail()%>"></label><br><br>
      <label>Mobile <br><input type="number" name="mobile" value="<%=details.getMobile()%>"></label><br><br>
      <label>Gender <br></label>
      <label><input type="radio" value="male" name="gender" >Male</label>
      <label><input type="radio" value="female" name="gender">Female</label>
      <label><input type="radio" value="others" name="gender" >Others</label><br><br>
      <label>Address<br> <input type="text" name="address" value="<%=details.getAddress()%>"></label><br><br>
      <label>password <br><input type="password" name="pass" value="<%=details.getPassword()%>"></label><br><br>
      <button type="submit">update</button>
      </form>
      </div>
      </center>

</body>
</html>