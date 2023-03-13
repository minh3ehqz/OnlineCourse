<%-- 
    Document   : course
    Created on : Oct 20, 2022, 4:23:44 PM
    Author     : WIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Khóa học</title>
        <link href="https://fonts.googleapis.com/css?family=Playfair+Display&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/mystyle.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
        <link rel="icon" type="image/x-icon" href="images/istockphoto-1256528848-612x612.jpg" >
        <style>
            .classroom{
                margin-left: 130px;
                margin-right: 200px;
            }

            .page a{
                text-decoration: none;
                color: black;
                width: 100%;
                height: 100%;
            }

            .page div{
                display: inline-block;
                border: 1px black solid;
                border-radius: 100%;
                width: 25px;
                height: 25px;
                margin-top: 10px;
                margin-bottom: 10px;
            }

            .page div:hover{
                background-color: gray;
            }
            .btcl{
                width: 100%;
                height: 80px;
                color: white;
                background-color: black;
                position: absolute;
                bottom :0px;
            }

            .khoa_hoc a{
                text-decoration: none;
                color: black;
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
        <div class="classroom">
            <c:forEach items="${listClass}" var="cl" >
                <div class="khoa_hoc">
                    <img src="${cl.images}" alt=""/>
                    <a href="DetailServlet?classid=${cl.ID}" ><strong>${cl.title}</strong></a>
                            <c:if test="${user==null}">
                        <a class="clsbtn" href="/Project_PRJ301/Login">Học</a>
                    </c:if>

                    <c:if test="${user!=null}">
                        <c:if test="${user.active==2}">
                            <form type="submit">
                                <button class="btcl" type="submit" formaction="UpdateClassServlet" >EDIT</button>
                                <input name="id" value="${cl.ID.trim()}" type="hidden"/>
                            </form>

                        </c:if>

                        <c:if test="${user.active==1}">
                            <a class="clsbtn" href="CourseServlet?id=${cl.ID}">Học</a>
                        </c:if>

                        <c:if test="${user.active==3}">
                            <a class="clsbtn" href="MentorServlet?id=${cl.ID}">Quản lý</a>
                        </c:if>
                    </c:if>

                </div>
            </c:forEach>
        </div>
        <div class="page" style="text-align: center">
            <c:forEach begin="1" end="${endp}" var="i" >
                <div>
                    <a href="CourseServlet?index=${i}">${i}</a>
                </div>
            </c:forEach>
        </div>


    </body>
</html>
