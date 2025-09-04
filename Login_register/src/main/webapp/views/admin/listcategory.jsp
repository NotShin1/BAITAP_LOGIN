<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8"/>
    <title>Danh sách Category</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body class="container mt-4">

    <h2 class="mb-3">Danh sách Category</h2>

    <a href="${pageContext.request.contextPath}/admin/category/add" class="btn btn-success mb-3">
        + Thêm Category
    </a>

    <table class="table table-bordered table-hover align-middle text-center">
        <thead class="table-dark">
            <tr>
                <th>STT</th>
                <th>Ảnh</th>
                <th>Tên Category</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${cateList}" var="cate" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>

                <td>
                    <c:if test="${not empty cate.icon}">
                        <c:url value="/image?fname=${cate.icon}" var="imgUrl"/>
                        <img src="${imgUrl}" alt="icon" width="120" height="100" class="img-thumbnail"/>
                    </c:if>
                    <c:if test="${empty cate.icon}">
                        <span class="text-muted">Không có ảnh</span>
                    </c:if>
                </td>

                <td>${cate.name}</td>

                <td>
                    <a href="<c:url value='/admin/category/edit?id=${cate.id}'/>" 
                       class="btn btn-primary btn-sm">Sửa</a>

                    <a href="<c:url value='/admin/category/delete?id=${cate.id}'/>"
                       class="btn btn-danger btn-sm"
                       onclick="return confirm('Bạn có chắc chắn muốn xoá category này?');">
                        Xoá
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</body>
</html>
