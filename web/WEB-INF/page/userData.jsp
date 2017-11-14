<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Title</title>
</head>
<body>
    <c:if test="${requestScope.user != null}">
        <c:set var="user" scope="request" value="${requestScope.user}"/>
        <table border="1">
            <tr>
                <td>Name</td>
                <td>Surname</td>
                <td>Phone number</td>
                <td>e-mail</td>
            </tr>
            <tr>
                <td><c:out value="${requestScope.user.name}" /></td>
                <td><c:out value="${requestScope.user.surname}" /></td>
                <td><c:out value="${requestScope.user.phoneNumber}" /></td>
                <td><c:out value="${requestScope.user.email}" /></td>
            </tr>
        </table>
    </c:if>
</body>
</html>
