<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Book</title>
</head>
<body>
<center>
<h1>New Book</h1>
<table>
<tr>
<td>
<form method="Post" action="addbook">
	Title:<input type="text" name="title"><br>
	Author:
	 <select name ="idAuthor">
		<c:forEach items="${listAuthor}" var="aut">
			
					<option value="${aut.getId()}">
						${aut.getName().toUpperCase()}&nbsp;${aut.getForname()}
					</option>
 				
		</c:forEach>
	</select>
	<br>
	ISBN:<input type="text" name="isbn"><br>
	Price:<input type="text" name="price"><br>
	<center><input type="submit" value="Send"></center>
</form>

</td>
</tr>
</table>
<a href="index">Back to menu</a>
</center>
</body>
</html>