<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><tiles:insertAttribute name="title"/></title>
    <link rel="shortcut icon" href="<c:url value="/resources/images/favicon.ico" />"/>

    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-theme.min.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/ms-style.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/kendo.common.min.css"/> "/>
    <link rel="stylesheet" href="<c:url value="/resources/css/kendo.dataviz.default.min.css"/> "/>
    <link rel="stylesheet" href="<c:url value="/resources/css/kendo.dataviz.min.css"/> "/>
    <link rel="stylesheet" href="<c:url value="/resources/css/kendo.default.min.css"/> "/>
    <link rel="stylesheet" href="<c:url value="/resources/css/monitoring_elements.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/FirstPageStyle2.css"/>"/>

    <script src="<c:url value="/resources/js/jquery.min.js" />"></script>
    <script src="<c:url value="/resources/js/kendo.all.min.js"/> "></script>
    <script src="<c:url value="/resources/js/kendo.messages.ru-RU.min.js"/> "></script>
    <script src="<c:url value="/resources/js/kendo.culture.ru-RU.min.js"/> "></script>

    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

    <script src="<c:url value="/resources/js/sockjs-0.3.min.js" />"></script>
    <script src="<c:url value="/resources/js/stomp.min.js" />"></script>

    <script src="<c:url value="/resources/js/ms-main.js" />"></script>

    <script type="text/javascript">
        var applicationContext = "<c:url value="/"/>";
    </script>

    <tiles:insertAttribute name="scripts" defaultValue=""/>
</head>
<body>
<div class="container">
    <tiles:insertAttribute name="menu"/>
    <tiles:insertAttribute name="body"/>
</div>

</body>
</html>
