<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Error page</title>
</head>
<body>
    <label>Oops! Something went wrong. Please try again later. :)</label><br/>
    <c:if test="${requestScope.exceptionMessage != null || !requestScope.exceptionMessage.isEmpty}">
        <label><c:out value="${requestScope.exceptionMessage}"/></label>
    </c:if>
</body>
</html>
