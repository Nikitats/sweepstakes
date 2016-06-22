<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!-- Static navbar -->
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Index</a>
        </div>
        <div id="menu" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li id="menu-monitoring"><a href="<c:url value="/" />">Home</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" href="#" id="menu1" data-toggle="dropdown" role="button"
                       aria-haspopup="true" aria-expanded="false">
                        Item
                        <span class="caret"></span>
                    </a>

                    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">

                        <li role="presentation" class="nav-divider"></li>
                        <li role="presentation">
                            <a role="menuitem" tabindex="-1"
                               href="<c:url value="/"/>">
                                Item</a>
                        </li>
                        <li role="presentation">
                            <a role="menuitem" tabindex="-1"
                               href="<c:url value="/"/>">
                                Item</a>
                        </li>
                        <li role="presentation" class="nav-divider"></li>
                        <li role="presentation">
                            <a role="menuitem" tabindex="-1"
                               href="<c:url value="/"/>">Item</a>
                        </li>
                        <li role="presentation">
                            <a role="menuitem" tabindex="-1"
                               href="<c:url value="/"/>">Item</a>
                        </li>
                        <li role="presentation">
                            <a role="menuitem" tabindex="-1"
                               href="<c:url value="/"/>">Item</a>
                        </li>

                        <li role="presentation" class="nav-divider"></li>
                        <li role="presentation">
                            <a role="menuitem" tabindex="-1"
                               href="<c:url value="/"/>">Item</a>
                        </li>
                        <li role="presentation">
                            <a role="menuitem" tabindex="=-1"
                               href="<c:url value="/" />">Item</a>
                        </li>
                    </ul>
                </li>


                <li id="menu-mixingRecipes"><a href="<c:url value="/"/>">Рецепты Дозирования</a></li>
                <li id="menu-extruderRecipes"><a href="<c:url value="/" />">Рецепты Экструдирования</a></li>
                <li id="menu-archive"><a href="<c:url value="/"/>">Архив</a></li>
                <li id="menu-logout"><a href="<c:url value="/logout"/>">
                    Выйти <span style="color:blue">
                    (<sec:authentication property="principal.username"/>)
                        </span></a>
                </li>

            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
    <!--/.container-fluid -->
</nav>
