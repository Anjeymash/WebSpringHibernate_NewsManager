<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


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
				<td width=1300><p><locale:message code="label.manager" /></p></td>
				<td><font size=5><a href="list/?lang= en">en</a>|<a
						href="list/?lang= ru">ru</a></font></td>
			</tr>
		</table>
	</header>
	<main>


	<article>
	
	<p align="left">
			<a href="list"><locale:message code="label.news" /> >></a>
			<locale:message code="label.view" />
			<br /> <br />
		</p>


		<table border="1" cellpadding="7" cellspacing="0">
			<tr align="left">
				<td width=200><locale:message code="label.news_title" /></td>
				<td width=1000>${news.newsTitle}</td>
			</tr>
			 <tr align="left">
				<td><locale:message code="label.news_date" /></td>
				<td>${news.newsDate}</td>
			</tr>
			<tr align="left">
				<td ><locale:message code="label.news_brief" /></td>
				<td>${news.newsBrief}</td>
			</tr>
			<tr align="left">
				<td ><locale:message code="label.news_content" /></td>
				<td>${news.newsMes}</td>
			</tr>
		</table>
		<table >
			<tr>
				<td width=1078></td>
				
				<td>
					<form action="showFormForUpdate" method="get" id = "s">
						<input type="hidden" name="newsId" value="${news.newsId}">
						<button type="submit" form="s"><locale:message	code="label.edit" /></button>
						
					</form>
				</td>
				<td>
					<form action="delete" method="get" id = "d">
						<input type="hidden" name="newsId" value="${news.newsId}">
						<button
								onclick="if (!(confirm('Are you sure you want to save this news?'))) return false"
								type="submit" form="f"><locale:message	code="label.delete" /></button>
						
					</form>

				</td>
			</tr>
		</table>


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









