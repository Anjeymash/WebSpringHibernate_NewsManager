<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<title>Save News</title>
<style>
e { color: red; }
.error {
	color: red
}
</style>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/style.css"/>" />

</head>

<body>
	<header>
		<table>
			<tr>
				<td width=1300><p>
						<locale:message code="label.manager" />
					</p></td>
				<td><font size=5><a href="list/?lang= en">en</a>|<a
						href="list/?lang= ru">ru</a></font></td>
			</tr>
		</table>
	</header>
	<main>

	<article>
		<p align="left">
			<a href="list"><locale:message code="label.news" /> >></a>
			<locale:message code="label.add_news" />
			<br /> <br />
		</p>

		<form:form action="saveNews" modelAttribute="news" method="POST"
			id="f">

			<!-- need to associate this data with news id -->
			<form:hidden path="newsId" />
			<table>
				<tbody>
					<tr>
						<td align="left" width=150><label><locale:message
									code="label.news_title" />:</label></td>
						<td width=1000><form:textarea path="newsTitle" cols="100"
								rows="1" /><br /> <form:errors path="newsTitle"
								cssClass="error" /></td>
					</tr>

					<tr>
						<td align="left"><label><locale:message
									code="label.news_date" />:</label></td>
						<td><form:input type="date" path="newsDate" /><br /> 
						<form:errors path="newsDate" cssClass="error" /> 
													
						<c:if test="${not empty dateErrorMes}" >
							<e>${dateErrorMes}</e>
						</c:if>


					</tr>

					<tr>

						<td align="left"><label><locale:message
									code="label.news_brief" />:</label></td>
						<td><form:textarea path="newsBrief" cols="100" rows="5" /><br />
							<form:errors path="newsBrief" cssClass="error" /></td>
					</tr>

					<tr>
						<td align="left"><label><locale:message
									code="label.news_content" />:</label></td>
						<td><form:textarea path="newsMes" cols="100" rows="15" /><br />
							<form:errors path="newsMes" cssClass="error" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td>
							<button
								onclick="if (!(confirm('Are you sure you want to save this news?'))) return false"
								type="submit" form="f">
								<locale:message code="label.save" />
							</button>
						</td>
				</tbody>
			</table>

		</form:form>

		<table>
			<tr>
				<td width=150><label></label></td>
				<td width=1000><form action="list" method="get" id="c">
						<button type="submit" form="c">
							<locale:message code="label.cancel" />
						</button>
					</form></td>
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











