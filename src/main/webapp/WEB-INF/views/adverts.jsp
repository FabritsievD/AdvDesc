<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import="com.Advertisements.model.Section" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href='../../resources/style.css' rel='stylesheet' type='text/css'>
</head>
<body>

<br>
<h1>List of Adverts</h1>


<c:if test="${!empty listAdverts}">
    <div class="advList">
        <table class="bordered">
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Section</th>
                <th>Description</th>
                <th>Price</th>
                <th>Update</th>
                <th>Delete</th>

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
    </div>
    >
</c:if>

<h1>Add advert</h1>

<c:url var="addAction" value="/adverts/add"/>


<form:form action="${addAction}" commandName="advert">
    <table class="menu">
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

        </c:if>
        <tr>
            <td>
                <form:label path="title">
                    <spring:message text="title"/>
                </form:label>
            </td>
            <td>
                <form:input path="title"/>

            </td>
        </tr>
        <tr>
            <c:if test="${empty advert.title}">
            <td>
                <form:label path="section">
                    <spring:message text="section"/>
                </form:label>
            </td>


            <td>

                <form:label path="section">
                    <form:select path="section">
                        <form:option value="All">${Section.All}</form:option>
                        <form:option value="Clothes">${Section.Clothes}</form:option>
                        <form:option value="Electronics">${Section.Electronics}</form:option>
                        <form:option value="Realty">${Section.Realty}</form:option>
                        <form:option value="Sport">${Section.Sport}</form:option>
                        <form:option value="Vehicles">${Section.Vehicles}</form:option>
                    </form:select>
                </form:label>
            </td>
            </c:if>
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
            <td>
                <form:label path="price">
                    <spring:message text="price"/>
                </form:label>
            </td>
            <td>
                <form:input path="price"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
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


<div style="position: relative; right: -450px;bottom: 220px">
    <h1>Select Advert</h1>


    <table>
        <td>
            <form action="<c:url value="/select"/>">
                <label for="id">ID:</label>
                <input type="text" id="id" name="id" placeholder="0"/>

                <label for="title">Title:</label>
                <input type="text" id="title" name="title" placeholder="title"/>

                <label for="section">Section:</label>
                <select name="section" id="section" style="width: 100px">

                    <option>All</option>
                    <option>Clothes</option>
                    <option>Electronics</option>
                    <option>Realty</option>
                    <option>Sport</option>
                    <option>$Vehicles</option>
                </select>


                <label for="price">Price:
                    <select name="moreOrless" id="moreOrless" style="width: 90px">
                        <option></option>
                        <option>More</option>
                        <option>Less</option>
                    </select>
                </label>
                <input type="text" id="price" name="price" placeholder="0"/>

                <input type="submit" value="Search"/>
            </form>
        </td>


    </table>


</div>

</body>
</html>
