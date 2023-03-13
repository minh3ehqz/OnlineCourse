<%-- 
    Document   : mentor
    Created on : Nov 1, 2022, 8:52:33 PM
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
        <form action="MentorServlet" method="post">
            <table class="table table-striped table-hover" style="margin-top: 10px;height: 65%;">
                <tr>
                    <th colspan="10" style="text-align: center; background-color: black ; color: white" >Danh sách học viên</th>
                </tr>
                <tr>
                    <th>ID</th>
                    <th>Tên</th>
                    <th>giới tính</th>
                    <th>DepartID</th>
                    <th>SĐT</th>
                    <th>email</th>
                    <th></th>
                    <th></th>

                </tr>
                <c:forEach items="${mlist}" var="st">
                    <tr>

                        <td>${st.ID}</td>
                        <td>${st.name}</td>
                        <td>${st.gender?"nam":"nữ"}</td>
                        <td>${st.deptId}</td>
                        <td>${st.phoneNumber}</td>
                        <td>${st.email}</td>
                        <td><input type="radio" name="${st.ID}classST" value="0" ${st.classst==0?"checked":""}>STUDY</td>
                        <td><input type="radio" name="${st.ID}classST" value="1" ${st.classst==1?"checked":""}>COMPLETE</td>
                        <td><input type="text" name="stid" value="${st.ID}" hidden></td>

                    </tr>
                </c:forEach>
            </table>
            <div style="text-align: center">
                <input type="password" name="pass" >
                <button type="submit" >save</button>
            </div>
        </form>
    </body>
</html>
