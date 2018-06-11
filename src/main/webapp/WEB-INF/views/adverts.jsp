
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="../../index.jsp">Back to main menu</a>
<br>
<h1>List of Adverts</h1>
<c:if  test="${!empty listAdverts}">
    <table>
        <tr>
            <th>id</th>
            <th>title</th>
            <th>section</th>
            <th>description</th>
            <th>update</th>
            <th>delete</th>

        </tr>
        <c:forEach items="${listAdverts}" var="advert">
        <tr>
            <td>${advert.id}</td>
            <td>${advert.section}</td>
            <td>${advert.title}</td>
            <td>${advert.description}</td>
            <td>${advert.price}</td>
            <td>${advert.date}</td>
            <td><a href="<c:url value="/edit/${advert.id}"/>">Edit</a></td>
            <td><a href="<c:url value="/remove/${advert.id}"/>">Delete</a></td>
        </tr>
        </c:forEach>
    </table>
</c:if>

<h1>Add advert</h1>

<c:url var="addAction" value="/adverts/add">
    <form:form action="${addAction}" commandName="advert">
    <table>
        <c:if test="${!empty advert.title}">
            <tr>
                <td>
                    <form:label path="id">
                            <spring:message text="id"/>
                        </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="name">
                        <spring:message text="name"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="name" />

                </td>
            </tr>
    </c:if>
    </table>

</c:url>

</body>
</html>
