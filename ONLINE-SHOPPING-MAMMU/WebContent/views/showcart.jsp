<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<form action="paybill">

<h2>CART DETAILS</h2>
<table border="1" style="padding: 0px;">

 

<tr>

<th>CART ID</th>
<th>CUSTOMER ID</th>
<th>PRODUCT ID</th>
<th>PRODUCT QUANTITY</th>
<th>GRANT TOTAL</th>
<th>TOTAL DISCOUNT</th>
<th>PAYABLE AMOUNT</th>

</tr>

    <c:forEach var="s" items="${list}">
        
  
            <tr> 
             <td><h4> <c:out value="${s.getSno()}"></c:out></h4> </td>
                <td><h4> <c:out value="${s.getCid()}"></c:out></h4> </td>
              
                <td><h4> <c:out value="${s.getPid()}"></c:out> </h4></td>
                    
             
                <td><h4>   <c:out value="${s.getPquantity()}"></c:out></h4></td> 
                    
              <td><h4>   <c:out value="${s.getGrandTotal()}"></c:out></h4></td> 
               <td><h4>   <c:out value="${s.getTotalDiscount()}"></c:out></h4></td> 
                <td><h4>   <c:out value="${s.getPayableAmount()}"></c:out></h4></td> 
                    
                   
               </tr>
        
        
    </c:forEach>
  </table>
  <input type="submit">
  </form>

</body>
</html>