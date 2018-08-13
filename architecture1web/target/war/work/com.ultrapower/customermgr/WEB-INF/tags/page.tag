<%@tag pageEncoding="UTF-8" %>
<%@ attribute name="pageInfo" type="com.github.pagehelper.PageInfo" required="true" %>
<%@ attribute name="paginationSize" type="java.lang.Integer" required="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    int current = pageInfo.getPageNum();
    int begin = Math.max(1, current - paginationSize / 2);
    int end = (int) Math.min(begin + (paginationSize - 1), pageInfo.getPages());
      request.setAttribute("current", current);
      request.setAttribute("begin", begin);
      request.setAttribute("end", end);
%>

<div class="pagination">
    <ul>
        <% if (pageInfo.isHasPreviousPage()) {%>
        <li><a href="?pageNum=1&sortName=${sortName}&sortOrder=${sortOrder}&${searchParams}"><<</a></li>
        <li><a href="?pageNum=${current-1}&sortName=${sortName}&sortOrder=${sortOrder}&${searchParams}"><</a></li>
        <%} else {%>
        <li class="disabled"><a href="#"><<</a></li>
        <li class="disabled"><a href="#"><</a></li>
        <%} %>

        <c:forEach var="i" begin="${begin}" end="${end}">
            <c:choose>
                <c:when test="${i == current}">
                    <li class="active"><a
                            href="?pageNum=${i}&sortName=${sortName}&sortOrder=${sortOrder}&${searchParams}">${i}</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="?pageNum=${i}&sortName=${sortName}&sortOrder=${sortOrder}&${searchParams}">${i}</a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <% if (pageInfo.isHasNextPage()) {%>
        <li><a href="?pageNum=${current+1}&sortName=${sortName}&sortOrder=${sortOrder}&${searchParams}">></a></li>
        <li><a href="?pageNum=${pageInfo.pages}&sortName=${sortName}&sortOrder=${sortOrder}&${searchParams}">>></a>
        </li>
        <%} else {%>
        <li class="disabled"><a href="#">></a></li>
        <li class="disabled"><a href="#">>></a></li>
        <%} %>

    </ul>
</div>
