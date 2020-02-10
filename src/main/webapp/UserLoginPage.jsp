<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>Авторизация</title>
</head>
<body>
<form class="your-form-selector" method="post" action="/">
    <table width="100%" cellspacing="0" cellpadding="4">
        <tr>
            <td></td>
            <td>Введите: email и пароль</td>
        </tr>
        <tr>
            <td align="right" width="100">Email:</td>
            <td><input type="email" name="email" maxlength="50" size="20" required placeholder></td>
        </tr>
        <tr>
            <td align="right" width="100">Пароль:</td>
            <td><input type="password" name="password" maxlength="50" size="20" required placeholder></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Войти"></td>
        </tr>
        </tr>
    </table>
    <c:out value="${status}" default=""></c:out>
</body>
</html>