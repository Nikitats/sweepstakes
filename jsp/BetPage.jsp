<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
	 <head>
		<meta charset="utf-8">
		<title></title>
			<link href='https://fonts.googleapis.com/css?family=Rubik+One&subset=latin,cyrillic,latin-ext' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Droid+Serif:700' rel='stylesheet' type='text/css'>
		 <link rel="stylesheet" href="<c:url value="/resources/css/BetStyle.css"/>
	</head>
	<body>
		<div id="wrapper">
			<form class="clearfix" method="post" action="<c:url value="/bet/getId"/> ">
				 <header class="clearfix" id="header">
					<div class="logo" href=" "></div>
					<nav class="clearfix" id="hdmenu">
						<ul class= "menu">
						   <li><a href="<c:url value="/"/>">Ставки</a></li>
						   <li><a href="<c:url value="/"/>">Результаты</a></li>
						   <li><a href="<c:url value="/"/>">Регистрация</a></li>
						   <li><a href="<c:url value="/"/>">Вход</a></li>
						</ul>
					 </nav>
				  </header>
				<div class="sidebar">
				</div>
				<div class="content">
					<h2><p>ЕВРО-2016</p></h2>
					<div class="matchs">
						<table >
							<c:forEach var="match" items="${matchList}">
								<form role="form" method="post" action="<c:url value="//registration" /> ">
								<tr id="row_${match.id}">
									<td><input type="radio" id="1" name="betChoise" value="0"><a href=" "><label for="1">${match.homeClub.name}: ${match.homeClubWinCoefficient}</label></a></td>
									<td><input type="radio" id="2" name="betChoise" value="1"><a href=" "><label for="2">X:${match.drawCoeffficient}</label></a></td>
									<td><input type="radio" id="3" name="betChoise" value="2"><a href=" "><label for="3">${match.guestClub.name}: ${match.guestClubWinCoefficient}</label></a><input type="hidden" name="id" value="${match.id}"></a></td>
									<td><input type="text"	id="4" name="betCash" placeholder="Введите сумму"></td>
									<td><input type="submit" value="Сделать ставку" style="width:150px"></td>
							    </tr>
								</form>
							</c:forEach>
						</table>
					</div>
				</div>
			</form>
		</div>
		<footer class="clearfix" id="footer">
			<nav>
				<ul class="menu">
					<li><a href="<c:url value="/"/>">Результаты</a></li>
					<li><a href="<c:url value="/"/>">Мои ставки</a></li>
					<li><a href="<c:url value="/"/>">Инструкция</a></li>
				</ul>	
			</nav>
			<div class="contacts clearfix">
				<div class="telephone">
				   <img src="CSS/image/iconphone.png" height="80px"; width="70px"><br>
					<p>Телефон</p>
					<a><i>+375(29)000-000-000</i></a>
				</div>
				<div class="address">
					<img src="CSS/image/iconadress.png" height="80px"; width="70px"><br>
					<p>Адрес</p>
					<p>Гикало 9 Минск</p>
				</div>
				<div class="email">
					<img src="CSS/image/iconmap.png" height="80px"; width="70px"><br>
					<p>Email</p>
					<a href=" ">stavki@gmail.com</a>
				</div>
			</div>
			<div class="avtorfoot"><p>@2016 Stavki.by</p></div>
		</footer>
	</body>
</html>	