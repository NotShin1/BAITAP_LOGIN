<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8"/>
    <title>Đăng nhập</title>
</head>
<body>
<h2>Đăng nhập</h2>

<c:if test="${alert != null}">
    <div style="color:red; font-weight: bold">${alert}</div>
</c:if>

<form action="${pageContext.request.contextPath}/login" method="post">
    <label>Tài khoản:</label><br/>
    <input type="text" name="username" placeholder="Username"/><br/><br/>

    <label>Mật khẩu:</label><br/>
    <input type="password" name="password" placeholder="Password"/><br/><br/>

    <label><input type="checkbox" name="remember"/> Nhớ đăng nhập</label><br/><br/>

    <button type="submit">Đăng nhập</button>
</form>
</body>
</html>
