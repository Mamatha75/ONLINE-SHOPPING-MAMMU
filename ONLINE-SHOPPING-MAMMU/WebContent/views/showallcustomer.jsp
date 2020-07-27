<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body{
marigin:0;
padding:0;
font-family:sans-serif;
background-color:#33FFF7;
background-color:cover;
}
</style>
</head>
<body>
<h2>ALL CUSTOMER DETAILS</h2>
<table border="1" style="padding: 0px;">

 

<tr>
<h3>
<th>CUSTOMER ID</th>
<th>CUSTOMER PASSWORD</th>
<th>CUSTOMER BALANCE</th>

</h3>
</tr>

    <c:forEach var="s" items="${list}">
        
  
            <tr> 
                <td><h4> <c:out value="${s.getCid()}"></c:out></h4> </td>
              
                <td><h4> <c:out value="${s.getCpass()}"></c:out> </h4></td>
                    
             
                <td><h4>   <c:out value="${s.getBalance()}"></c:out></h4></td> 
                    
             
                    
                   
               </tr>
        
        
    </c:forEach>
   
</body>

</table>

</html>