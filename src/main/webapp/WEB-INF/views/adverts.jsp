

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href='../../resources/style.css' rel='stylesheet' type='text/css' >
</head>
<body>

<br>
<h1>List of Adverts</h1>
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
            <td><a href="/advertData/${advert.id}" target="_blank">${advert.title}</a></td>
            <td>${advert.section}</td>
            <td>${advert.description}</td>
            <td>${advert.price}</td>
            <td><a href="<c:url value="/edit/${advert.id}"/>">Edit</a></td>
            <td><a href="<c:url value="/remove/${advert.id}"/>">Delete</a></td>
        </tr>
        </c:forEach>
    </table>
    </div>>
</c:if>

<h1>Add advert</h1>

<c:url var="addAction" value="/adverts/add"/>
    <form:form action="${addAction}" commandName="advert">
    <table class="menu">
        <c:if test="${!empty advert.title}">
            <tr>
                <td style="width: 5%">
                    <form:label path="id">
                            <spring:message text="id"/>
                        </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>

                </td>
            </tr>
        </c:if>
            <tr>
                <td style="width: 15%">
                    <form:label path="title">
                        <spring:message text="title"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="title" />

                </td>
            </tr>
        <tr>
            <td style="width: 10%">
                <form:label path="section">
                    <spring:message text="section"/>
                </form:label>
            </td>
            <td>
                <c:forEach items="${Section}" var="section">
                <form:select path="section">
                    <form:option value="1"></form:option>
                    <form:option value="2">Realty</form:option>
                    <form:option value="3">Vehicles</form:option>
                    <form:option value="4">Electronics</form:option>
                    <form:option value="5">Sport</form:option>
                    <form:option value="6">Clothes</form:option>
                </form:select>
            </c:forEach>
            </td>
        </tr>

        <tr>
        <td>
            <form:label path="description">
                <spring:message text="description"/>
            </form:label>
        </td>
         <td>
            <form:input path="description"/>
        </td>
        </tr>

        <tr>
            <td style="width: 10%">
                <form:label path="price">
                    <spring:message text="price"/>
                </form:label>
            </td>
            <td>
                <form:input path="price"/>
            </td>
        </tr>
        <tr>
            <td style="width: 10%" colspan="2">
                <c:if test="${!empty advert.title}">
                    <input type="submit"
                           value="<spring:message text="Edit Advert"/>"/>
                </c:if>
                <c:if test="${empty advert.title}">
                    <input type="submit"
                           value="<spring:message text="Add Advert"/>"/>
                </c:if>
            </td>
        </tr>

    </table>
    </form:form>


</body>
</html>
