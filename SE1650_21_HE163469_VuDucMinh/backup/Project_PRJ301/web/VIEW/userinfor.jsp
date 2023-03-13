<%-- 
    Document   : userinfor
    Created on : Oct 25, 2022, 8:38:27 AM
    Author     : WIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>quản lý chung</title>
        <link href="https://fonts.googleapis.com/css?family=Playfair+Display&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/mystyle.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
        <link rel="icon" type="image/x-icon" href="images/istockphoto-1256528848-612x612.jpg" >
        <style>
            .i{
                display: block;
                background-color: #04AA6D;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                width: 100%;
                text-decoration: none;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div class="menu">
            <div class="logo">
                <img src="images/istockphoto-1256528848-612x612.jpg" width="100%" height="100%" alt="s">
            </div>

            <ul>
                <li><div><a href="/Project_PRJ301/HomeServlet">Trang chủ</a></div></li>
                <li><div><a href="/Project_PRJ301/CourseServlet">Khóa học</a></div></li>
                <li><div><a href="#">Hỗ Trợ</a></div></li>
                <li><div><a href="${user==null?"/Project_PRJ301/Login":(user.active==2?"/Project_PRJ301/ADServlet":"/Project_PRJ301/UserInfoServlet")}">
                            ${user==null?"Đăng nhập":user.userName}</a></div></li>
                <li><div><a href="/Project_PRJ301/LogoutServlet">${user==null?"":"Đăng xuất"}</a></div></li>
            </ul>

            <div >
                <form class="d-flex" role="search" method="get">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="search" >
                    <button class="btn btn-outline-success" type="submit" style="color: white" formaction="CourseServlet">Search</button>
                </form>
            </div>
        </div>
        <table class="table table-striped table-hover" style="margin-top: 10px;">
            <tr>
                <th colspan="5" style="text-align: center; background-color: black ; color: white" >Khóa Học</th>
            </tr>
            <tr>
                <th>classID</th>
                <th>DepartID</th>
                <th>title</th>
                <th></th>
                <th></th>

            </tr>
            <c:forEach items="${process.v}" var="st">
                <tr>
                    <td>${st.ID}</td>
                    <td>${st.departID}</td>
                    <td>${st.title}</td>
                    <td><a href="DetailServlet?classid=${st.ID}">HỌC TIẾP</a></td>
                    <c:if test="${st.status==0}">
                        <td><a href="UserInfoServlet?type=2&id=${st.ID}">DELETE</a></td>
                    </c:if>
                    <c:if test="${st.status==1}">
                        <td><a href="#">CHỨNG CHỈ</a></td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
        <a class="i" href="/Project_PRJ301/UserServlet">thông tin chi tiết</a>
        <a class="i" href="/Project_PRJ301/UserPassServlet" style="background-color: red">đổi mật khẩu</a>
    </body>
</html>
