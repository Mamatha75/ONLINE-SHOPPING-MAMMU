<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!-- <html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css" media="screen">
body{
font-family:times;
background-color:#33FFB1;
}

.nav a:hover{
color:red;

}

</style>
</head>
<body >
<div align="center" style="padding-top:50px;">
<h1>
WELCOME TO SHOPPING
</h1>
</div>
<div align="center" style="padding-top:20px;">
            <h3>
                <a href="views/adminlogin.jsp"><h4>adminlogin</h4></a><br><br>
				<a href="views/customerlogin.jsp"><h4>customerlogin</h4></a><br><br>
				</h3>
</div>
</body>
</html> -->

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
.box{
position:absolute;
top:50%;
left:50%;
transform:translate(-50%,-50%);
width:400px;
padding:40px;
background: rgba(0,0,0,.5);
box-sizing: border-box;
show-shadow:0 15px 25px rgba(0,0,0,.5);
border-radius: 5px;
}
.box h2{
margin:0 0 30px;
padding:0;
color: #fff;
text-align: center;
}
.box .inputbox{
position:relative;
}
.box .inputbox input{
width:100%;
padding:10px 0;
font-size: 16px;
color:#fff;
letter-spacing:1px
margin-bottom: 30px;
border:none;
border-bottom: 1px solid #fff;
outline: none;
background: transparent;
border-radius: 5px;

}
/* .box input[type="submit"]{
background: transparent;
border: none;
outline: none;
color: #fff;
height:40px;
width:80px;
background: #03a9f4;
padding: :50px 20px;
cursor: pointer;
border-radius: 5px;
} */



</style>
</head>
<body>
<div class="box">
<h2>
WELCOME TO ONLINE SHOPPING!!!!!!
</h2>

<form  action="addproduct">

<div class="inputbox">
<a href="views/adminlogin.jsp"><h4>adminlogin</h4></a><br><br>
				<a href="views/customerlogin.jsp"><h4>customerlogin</h4></a><br><br>
</div>


</form>
</div>
</body>
</html>