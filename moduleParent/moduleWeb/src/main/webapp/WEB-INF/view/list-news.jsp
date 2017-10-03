<%@ taglib uri="http://www.springframework.org/tags" prefix="locale"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language = "java" contentType = "text/html; charset= UTF-8" pageEncoding = "UTF-8" %>
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
		<table>
			<tr>
				<td width=1300>
					<p>
						<locale:message code="label.manager" />
					</p>
				</td>
				<td >					
						<font size=5><a href="?lang= en">en</a>|<a href="?lang= ru">ru</a></font>
					
				</td>
			</tr>
		</table>
	</header>
	<main>
	<article>
		<p align="left">
			<a href="list"><locale:message code="label.news" /> >></a>
			<locale:message code="label.news_list" />
			<br /> <br />
		</p>

		<c:forEach var="tempNews" items="${newslist}">
			<!-- construct a "view" link with news id -->
			<c:url var="viewLink" value="/news/showForm">
				<c:param name="newsId" value="${tempNews.newsId}" />
			</c:url>

			<!-- construct an "edit" link with news id -->
			<c:url var="editLink" value="/news/showFormForUpdate">
				<c:param name="newsId" value="${tempNews.newsId}" />
			</c:url>

			<!-- construct an "edit" link with news id -->
			<c:url var="delLink" value="/news/delete">
				<c:param name="newsId" value="${tempNews.newsId}" />
			</c:url>

			<table border="1" cellpadding="7" cellspacing="0">
				<tr>
					<td align="left" width=1000 style="font-weight: bold;" height="60">${tempNews.newsTitle}</td>
					<td><aside>${tempNews.newsDate}</aside></td>
				</tr>
				<br />
				<tr>
					<td align="left" width=1000>${tempNews.newsBrief}</td>
					<td>
						<!-- display the update link --> <a href="${viewLink}"><locale:message
								code="label.view" /></a> | <a href="${editLink}"><locale:message
								code="label.edit" /></a> | <a href="${delLink}"
						onclick="if (!(confirm('Are you sure you want to delete this news?'))) return false"><locale:message
								code="label.delete" /></a>
					</td>


				</tr>
			</table>
		</c:forEach>


	</article>



	<nav>
		<p>
			<locale:message code="label.news" />
		</p>
		<li><a href="list"> <locale:message code="label.news_list" /></a></li>
		<li><a href="showFormForAdd"><locale:message
					code="label.add_news" /></a></li>
	</nav>



	</main>
	<footer>
		<p>Copyright HTP 2017. All rights reserved</p>
	</footer>
</body>

</html>









