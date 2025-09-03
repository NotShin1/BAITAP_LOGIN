<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8"/>
    <title>Trang Quản lý</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="bg-light">

<div class="container mt-4">
    <h2 class="text-primary">Xin chào Quản lý, ${sessionScope.account.fullName}</h2>
    <p>Chào mừng bạn đến với trang quản lý.</p>

    <div class="card shadow p-4 mb-3">
        <h4>Chức năng dành cho Quản lý</h4>
        <ul>
            <li>Phê duyệt nội dung</li>
            <li>Quản lý báo cáo</li>
            <li>Thống kê người dùng</li>
        </ul>
    </div>

    <a href="${pageContext.request.contextPath}/logout" class="btn btn-danger">Đăng xuất</a>
</div>

</body>
</html>
