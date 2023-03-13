<%-- 
    Document   : detail
    Created on : Oct 31, 2022, 6:18:13 PM
    Author     : WIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Chi tiết</title>
        <link href="https://fonts.googleapis.com/css?family=Playfair+Display&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/mystyle.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
        <link rel="icon" type="image/x-icon" href="images/istockphoto-1256528848-612x612.jpg" >
        <style>
            .container{
                margin: 10px 300px 20px 300px;
                height: 800px;
                padding-top: 10px;
                padding-left :100px;
                border: 1px double black;
                position: relative;
            }
            .describe{
                width: 400px;
                position: absolute;
                right: 9%;
                top: 1%;
            }

            .btcl{
                width: 100%;
                height: 80px;
                color: white;
                background-color: black;
                position: absolute;
                left :0px;
                bottom: 0%;
            }

        </style>

        <script>
            function myFunction(check) {
                if (!check) {
                    window.alert("bạn cần hoàn thành các môn điều kiện để tiếp tục khóa học này");
                }
            }
        </script>
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

        <div class="container">
            <div style="width: 500px;height: 250px;">
                <image width="100%" height="100%" src="${cls.images}" alt="">
            </div>

            <div class="title">
                <h2><strong>${cls.title}</strong></h2>
            </div>

            <div class="describe">
                <h3>Thông tin chung</h3>
                <p>${cls.describe}</p>
                <div width="100%">
                    <h3>Mentor</h3>
                    <table width="100%">

                        <tr>
                            <th>Tên</th>
                            <td>${mt.name}</td>
                        </tr>

                        <tr>
                            <th>Số điện thoại</th>
                            <td>${mt.phoneNumber}</td>
                        </tr>

                        <tr>
                            <th>Email</th>
                            <td>${mt.email}</td>
                        </tr>
                    </table>
                </div>
            </div>

            <c:if test="${condi!=null}">
                <h3>Môn điều kiện</h3>
                <ul>
                    <c:forEach items="${condi}" var="cocls">
                        <li><a href="DetailServlet?classid=${cocls.ID}">${cocls.title}</a></li>
                        </c:forEach>
                </ul>
            </c:if>
            <h3>Chương trình học</h3>
            <ul>
                <li><a href="#">bài 1</a></li>
                <li><a href="#">bài 2</a></li>
                <li><a href="#">bài 3</a></li>
                <li><a href="#">bài 4</a></li>
            </ul>
            <div>
                <c:if test="${user==null}">
                    <a class="clsbtn" style="position: absolute;left: 0%" href="/Project_PRJ301/Login">Học</a>
                </c:if>

                <c:if test="${user!=null}">
                    <c:if test="${user.active==2}">
                        <form type="submit">
                            <button class="btcl" type="submit" formaction="UpdateClassServlet" >EDIT</button>
                            <input name="id" value="${cls.ID.trim()}" type="hidden"/>
                        </form>

                    </c:if>

                    <c:if test="${user.active==3}">
                        <a class="clsbtn" style="position: absolute;left: 0%" href="MentorServlet?id=${cls.ID}">Quản lý</a>
                    </c:if>

                    <c:if test="${user.active==1}">
                        <a class="clsbtn" style="position: absolute;left: 0%" href="CourseServlet?id=${cls.ID}">Học</a>
                    </c:if>    
                </c:if>
            </div>

        </div>

    </body>
</html>
