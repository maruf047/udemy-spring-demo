<%--
  Created by IntelliJ IDEA.
  User: GODFATHER
  Date: 5/2/2020
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student Registration Form</title>
</head>
<body>

<form:form action="processForm" modelAttribute="student">
    First name: <form:input path="firstName"/>
    <br><br>
    Last name: <form:input path="lastName"/>
    <br><br>
    Country:
    <form:select path="country">
<%--        <form:option value="Brazil" label="Brazil"/>--%>
<%--        <form:option value="France" label="France"/>--%>
<%--        <form:option value="Germany" label="Germany"/>--%>
<%--        <form:option value="India" label="India"/>--%>
        <form:options items="${theCountryOptions}"/>
    </form:select>
    <br><br>
    Favourite Language:
<%--    Java <form:radiobutton path="favouriteLanguage" value="Java"/>--%>
<%--    C# <form:radiobutton path="favouriteLanguage" value="C#"/>--%>
<%--    Python <form:radiobutton path="favouriteLanguage" value="Python"/>--%>
<%--    C <form:radiobutton path="favouriteLanguage" value="C"/>--%>
    <form:radiobuttons path="favouriteLanguage" items="${theFavouriteLanguageOptions}"/>
    <br><br>
    Operating Systems:
    Linux <form:checkbox path="operatingSystems" value="Linux"/>
    Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
    Windows <form:checkbox path="operatingSystems" value="Windows"/>
    <br><br>
    <input type="submit" value="Submit">
</form:form>

</body>
</html>
