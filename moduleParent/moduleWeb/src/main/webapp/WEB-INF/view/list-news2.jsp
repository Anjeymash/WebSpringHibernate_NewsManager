<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>

<html>

<head>
<title>List News</title>

<!-- reference our style sheet -->

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/style.css"/>" />
</head>

<body>
	<header>
		<p>News management</p>
	</header>
	<main>


	<article>
<form action="deleteSelected" method="POST">
<input type="hidden" name="selectedNewsId">
		<c:forEach var="tempNews" items="${newslist}">
			<!-- construct a "view" link with news id -->
			<c:url var="viewLink" value="/news/showForm">
				<c:param name="newsId" value="${tempNews.newsId}" />
			</c:url>

			<!-- construct an "edit" link with news id -->
			<c:url var="editLink" value="/news/editForm">
				<c:param name="newsId" value="${tempNews.newsId}" />
			</c:url>
			<table border="1" cellpadding="7" cellspacing="0">
				<tr>
					<td width=900>${tempNews.newsBrief}</td>
					<td width=300><aside>${tempNews.newsDate}</aside></td>
				</tr>
				<tr>
					<td>${tempNews.newsMes}</td>
					<td>
						<!-- display the update link --> <a href="${viewLink}">view</a> |
						<a href="${editLink}"
						onclick="if (!(confirm('Are you sure you want to edit this news?'))) return false">edit</a>
					</td>

				</tr>

				<tr>
					<td><form:checkboxes path="selectedNewsId" items="${newslist}"  /></td>
				</tr>
				
			</table>
		</c:forEach>
		
		<input type="submit"  name="submit" value="Delete" />
		</form>
		
	</article>



	<nav>
		<p>News</p>
		<li><a href="redirect:/authorization/showAuthorizationForm">
				registration</a></li>
		<li><a href="/showAllUsers/showUsersForm">show all users</a></li>
	</nav>



	</main>
	<footer>
		<p>Copyright HTP 2017. All rights reserved</p>
	</footer>
</body>

</html>









