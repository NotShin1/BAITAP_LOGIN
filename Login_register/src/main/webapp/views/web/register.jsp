<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8"/>
    <title>Đăng ký tài khoản</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="bg-light">
<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow-lg p-4" style="width: 550px; border-radius: 15px;">
        <h3 class="text-center mb-4">Đăng ký tài khoản</h3>

        <!-- Thông báo lỗi -->
        <c:if test="${alert != null}">
            <div class="alert alert-danger">${alert}</div>
        </c:if>

        <form action="${pageContext.request.contextPath}/register" method="post">
            <div class="mb-3">
                <label class="form-label">Email</label>
                <input type="email" name="email" class="form-control" placeholder="Email" required/>
            </div>

            <div class="mb-3">
                <label class="form-label">Tài khoản (Username)</label>
                <input type="text" name="username" class="form-control" placeholder="Username" required/>
            </div>

            <div class="mb-3">
                <label class="form-label">Họ tên đầy đủ</label>
                <input type="text" name="fullname" class="form-control" placeholder="Họ và tên"/>
            </div>

            <div class="mb-3">
                <label class="form-label">Mật khẩu</label>
                <input type="password" name="password" class="form-control" placeholder="Password" required/>
            </div>

            <div class="mb-3">
                <label class="form-label">Avatar (URL)</label>
                <input type="text" name="avatar" class="form-control" placeholder="Link ảnh đại diện"/>
            </div>

            <div class="mb-3">
                <label class="form-label">Vai trò</label>
                <select name="roleid" class="form-select" required>
                    <option value="1">Người dùng thường</option>
                    <option value="2">Moderator</option>
                    <option value="0">Admin</option>
                </select>
            </div>

            <div class="mb-3">
                <label class="form-label">Số điện thoại</label>
                <input type="text" name="phone" class="form-control" placeholder="Số điện thoại"/>
            </div>

            <div class="mb-3">
                <label class="form-label">Ngày tạo</label>
                <input type="date" name="createdDate" class="form-control"/>
            </div>

            <button type="submit" class="btn btn-success w-100">Đăng ký</button>
        </form>

        <div class="mt-3 text-center">
            <a href="${pageContext.request.contextPath}/login" class="text-decoration-none">Quay lại đăng nhập</a>
            &nbsp;|&nbsp;
            <a href="${pageContext.request.contextPath}/forget-password" class="text-decoration-none">Quên mật khẩu?</a>
        </div>
    </div>
</div>
</body>
</html>
