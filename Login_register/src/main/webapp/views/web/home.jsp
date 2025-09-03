<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8"/>
    <title>Trang Người dùng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="bg-light">

<div class="container mt-4">
    <h2 class="text-success">Xin chào ${sessionScope.account.fullName}</h2>
    <p>Chào mừng bạn đến với hệ thống.</p>

    <div class="card shadow p-4 mb-3">
        <h4>Chức năng của bạn</h4>
        <ul>
            <li>Cập nhật thông tin cá nhân</li>
            <li>Xem và tương tác bài viết</li>
            <li>Tham gia cộng đồng</li>
        </ul>
    </div>

    <a href="${pageContext.request.contextPath}/logout" class="btn btn-danger">Đăng xuất</a>
</div>

</body>
</html>
