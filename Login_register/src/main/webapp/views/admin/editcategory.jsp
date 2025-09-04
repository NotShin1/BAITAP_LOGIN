<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa danh mục</title>
    <link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css'/>">
</head>
<body>
<div class="container mt-4">
    <h2>Sửa danh mục</h2>

    <c:url value="/admin/category/edit" var="editUrl"/>
    <form role="form" action="${editUrl}" method="post"
          enctype="multipart/form-data">

        <!-- Hidden ID -->
        <input type="hidden" name="id" value="${category.id}" />

        <!-- Tên danh mục -->
        <div class="form-group mb-3">
            <label for="name">Tên danh mục:</label>
            <input type="text" class="form-control" id="name"
                   name="name" value="${category.name}" required />
        </div>

        <!-- Ảnh hiện tại + upload -->
        <div class="form-group mb-3">
            <c:url value="/image?fname=${category.icon}" var="imgUrl"/>
            <label>Ảnh hiện tại:</label><br>
            <img src="${imgUrl}" alt="Category Image" class="img-thumbnail mb-2" width="120"/><br>

            <label for="icon">Chọn ảnh mới:</label>
            <input type="file" class="form-control" id="icon" name="icon" accept="image/*"/>
        </div>

        <!-- Buttons -->
        <button type="submit" class="btn btn-success">Cập nhật</button>
        <button type="reset" class="btn btn-secondary">Làm lại</button>
    </form>
</div>
</body>
</html>
