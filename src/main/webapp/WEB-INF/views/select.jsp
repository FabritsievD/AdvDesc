<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="com.Advertisements.model.Section" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if  test="${!empty listAdverts}">
    <div class="advList">
        <table class="bordered">
            <tr>
                <th>id</th>
                <th>title</th>
                <th>section</th>
                <th>description</th>
                <th>price</th>
                <th>update</th>
                <th>delete</th>

            </tr>
            <c:forEach items="${listAdverts}" var="advert">
                <tr>
                    <td>${advert.id}</td>
                    <td style="width: 200px;height:40px;overflow: hidden">
                        <a href="/advertData/${advert.id}" target="_blank">${advert.title}</a>
                    </td>
                    <td>${advert.section}</td>
                    <td style="width: 400px;height: 40px;overflow: hidden">${advert.description}</td>
                    <td>${advert.price}</td>
                    <td><a href="<c:url value="/edit/${advert.id}"/>">Edit</a></td>
                    <td><a href="<c:url value="/remove/${advert.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>>
</c:if>
</body>
</html>
