<%-- 
    Document   : Login
    Created on : Oct 10, 2017, 10:03:23 AM
    Author     : DucCuong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:choose>
            <c:when test="${empty cookie['user']}">
                <h1>LoGIN From</h1>
                <form action="MyServlet" method="POST">
                    USER:<input type="text" name="txtUser"/><br/>
                    Pass:<input type="password" name="txtPass"/><br/>
                    <input type="submit" value="Login"/>
                    <input type="reset" value="Reset"/><br/>
                    <input type="checkbox" name="ckRemember" value="Remember Acc"/>
                </form>

            </c:when>
            <c:otherwise>
                <h1>Welcome ${sessionScope['username']}</h1>
                <form action="MyServlet" method="POST">
                    User:<input type="text" name="txtUser" value="${cookie['user'].value}"/><br/>
                    Pass:<input type="password" name="txtPass" value="${cookie['pass'].value}"/><br/>
                    <input type="submit" value="Login"/>
                    <input type="reset" value="Reset"/><br/>
                    <input type="checkbox" name="ckRemember" value="Remember Acc"/>
                </form>
            </c:otherwise>
        </c:choose>
    </body>
</html>
