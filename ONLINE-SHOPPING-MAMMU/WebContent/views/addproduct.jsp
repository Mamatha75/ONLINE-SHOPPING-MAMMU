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
ADD PRODUCT !!!!!!
</h1>
</div>


<div align="center" style="padding-top:20px;">
            <h3>
<form action="addproduct">
						Enter product_no  - <input type="text" name="pid"><br>
						Enter product_name - <input type="text" name="pname"><br>
						Enter product_price - <input type="text" name="pprice"><br>
						Enter quantity - <input type="text" name="pquantity"><br>
						Enter discount - <input type="text" name="pdiscount"><br>
						<input type="submit" name="btn" value="add_product">
				</form>
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
width:800px;
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
.box input[type="submit"]{
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
}



</style>
</head>
<body>
<div class="box">
<h2>
ADD PRODUCT FROM ADMIN!!!!!!
</h2>

<form  action="addproduct">

<div class="inputbox">
Enter product_no - <input type="text" name="pid"  placeholder="" required="required">
Enter product_name -<input type="text" name="pname"  placeholder="" required="required">
Enter product_price -<input type="text" name="pprice"  placeholder="" required="required">
Enter quantity -<input type="text" name="pquantity"  placeholder="" required="required">
Enter discount -<input type="text" name="pdiscount"  placeholder="" required="required">
</div>
<input type="submit" name="btn" value="add_product">

</form>
</div>
</body>
</html>