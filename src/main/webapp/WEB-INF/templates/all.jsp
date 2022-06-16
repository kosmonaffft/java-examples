<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hello</title>
</head>

<body>
<header>
    <h1>All users</h1>
</header>
<nav>

</nav>
<main>
    <table border="1" class="red-colored bold-text" id="myTable">
        <thead>
        <tr>
            <th>Id</th>
            <th>First Name</th>
            <th onclick="onLastNameClick()">Last Name</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td onmouseenter="onHover()">
                    <h1><c:out value="${user.id}"></c:out></h1>
                </td>
                <td>
                    <h1><c:out value="${user.firstName}"></c:out></h1>
                </td>
                <td>
                    <h1><c:out value="${user.lastName}"></c:out></h1>
                </td>
                <td>
                    <a href="/delete/${user.id}" onclick="onUserDelete()">Удалить!!!</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/add">Добавить пользователя</a>
</main>

<link rel="stylesheet" href="main.css">
<script type="text/javascript" src="main.js">
</script>

</body>
</html>
