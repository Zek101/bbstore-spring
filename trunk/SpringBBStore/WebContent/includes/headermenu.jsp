<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>

<decorator:usePage id="thePage" />

	<center>
		<h1>Book Store</h1>
		<table>
			<tr>
				<td valign="top">
					<center>
						<h2>Managment</h2>

					</center>
					<ul>
						<li><a href="viewlist?edit=true">Edit book</a></li>
						<li><a href="createbook">Add new book</a></li>
						<li><a href="createAuthor">Add new author</a></li>
					</ul>
				</td>
				<td valign="top">
					<center>
						<h2>Shop</h2>

					</center>
					<ul>
						<li><a href="viewlist?edit=false">View Books list</a></li>
					
								<li><a href="viewshoppingcart">View Shopping Basket</a></li>

					</ul>
				</td>
				<td>
					<center>
						<h2>admin</h2>
					</center>
					<ul>
						<li><a href="addUser">add user</a></li>
					</ul>
				</td>
			</tr>
		</table>
	</center>