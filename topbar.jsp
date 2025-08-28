<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<div>
    <c:choose>
        <c:when test="${sessionScope.account == null}">
            <a href="${pageContext.request.contextPath }/login">Đăng nhập</a> |
            <a href="${pageContext.request.contextPath }/register">Đăng ký</a>
        </c:when>
        <c:otherwise>
            <a href="${pageContext.request.contextPath }/member/myaccount">
                ${sessionScope.account.fullName}
            </a> |
            <a href="${pageContext.request.contextPath }/logout">Đăng xuất</a>
        </c:otherwise>
    </c:choose>
</div>
