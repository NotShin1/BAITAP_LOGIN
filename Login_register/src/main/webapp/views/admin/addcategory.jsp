<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm danh mục</title>
    <link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css'/>">
</head>
<body>
<div class="container mt-4">
    <h2>Thêm danh mục mới</h2>
    <form role="form" action="<c:url value='/admin/category/add'/>" method="post"
          enctype="multipart/form-data">
        
        <!-- Nhập tên danh mục -->
        <div class="form-group mb-3">
            <label for="name">Tên danh mục:</label>
            <input type="text" class="form-control" id="name" 
                   placeholder="Nhập tên danh mục" name="name" required />
        </div>
        
        <!-- Upload ảnh đại diện -->
        <div class="form-group mb-3">
            <label for="icon">Ảnh đại diện:</label>
            <input type="file" class="form-control" id="icon" name="icon" accept="image/*" />
        </div>
        
        <!-- Nút submit -->
        <button type="submit" class="btn btn-success">Thêm</button>
        <button type="reset" class="btn btn-secondary">Hủy</button>
    </form>
</div>
</body>
</html>
