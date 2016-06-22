<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title: ${message}</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="row">
        Test forn git
    </div>
    <div class="row">
        <a class="button" href="<c:url value="/messages/" />">go to messages</a>
    </div>
</div>
</body>
</html>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="defaultLayout">
    <tiles:putAttribute name="title">
        Home
    </tiles:putAttribute>

    <tiles:putAttribute name="scripts">
        <script>
            var wsUrl = "<c:url value="/ws"/>"
            var applicationContext = "<c:url value="/"/>"


        </script>
    </tiles:putAttribute>

    <tiles:putAttribute name="body">
        <div class="row">
            <input type="text" id="messageText" />
            <input type="button" id="addMessage" value="addMessage">
        </div>
        <div class="row">
            <table id="messageTable" class="table table-hover">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Text</th>
                    <th>Del</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="club" items="${clubList}">
                    <tr id="row_${club.id}">
                        <th scope="row">${club.nation.name}</th>
                        <td>${club.sport.name} популярность ${club.name} = ${club.popularity}</td>
                        <td><input type='button' class='delete-message' value='delete' data-messageid='${message.id}'/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>