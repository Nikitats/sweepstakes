<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
This is login page
<div class="container">
    <div class="row">
        <form class="m-t" role="form" method="post" action="<c:url value="/login" /> ">
        <div class="form-group">
            <input type="text" class="form-control" name="username"
                   placeholder="password" required="">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" name="password"
                   placeholder="password" required="">
        </div>
        <div class="form-group">
            <input id="remember_me" type="checkbox" class="i-checks" />
            <span class="h6 m-t icheckbox_square_span_2px">remember</span>
        </div>

        <button type="submit" class="btn btn-primary block full-width m-b">Login</button>
        </form>
    </div>
</div>
</body>
</html>
