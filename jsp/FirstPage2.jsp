<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	 <head>
		<meta charset="utf-8">
		<title></title>
		<link href='https://fonts.googleapis.com/css?family=Rubik+One&subset=latin,cyrillic,latin-ext' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Droid+Serif:700' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" href="<c:url value="/resources/css/FirstPageStyle2.css"/>"/>
	</head>
	<body>
		<header class="clearfix" id="header">
			<a class="logo" href=" "></a>
			<nav class="clearfix" id="hdmenu">
				<ul class="menu">
							<li><a href="<c:url value="/"/>">Регистрация</a></li>
						   <li><a href="<c:url value="/"/>">Вход</a></li>
				</ul>	
			</nav>
			<h1>СТАВКИ НА СПОРТ</h1>
			<div class="sidebar clearfix" id="sidebar">
				<p class="quicktext" id="firstqt">Кризис <br>не беспокоит</p>
				<p class="quicktext" id="secondqt">Работать на дядю больше не надо</p>
				<p class="quicktext" id="thirdqt">Появяться деньги, чтобы реализовать свои мечты</p>
			</div>
		</header>
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
			<div class="avtorfoot"><p>@2016 Stavki.by</p><div>
		</footer>
	</body>
</html>