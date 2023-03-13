<%-- 
    Document   : updateST
    Created on : Oct 26, 2022, 3:18:41 PM
    Author     : WIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>admin update</title>
        <link href="https://fonts.googleapis.com/css?family=Playfair+Display&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/mystyle.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/mycode.js"></script>
        <link rel="icon" type="image/x-icon" href="images/istockphoto-1256528848-612x612.jpg" >
        <style>
            body{
                height: 1000px;
            }

            .con{
                height: 720px;
                display: flex;
                justify-content: space-around;
            }

            .i{
                padding-top: 50px;
                width: 700px;
            }

            .i input{
                width: 70%;
            }

            input[type=radio]{
                width: 10%;
            }

            .i div{
                margin-bottom: 5px;
                margin-top: 5px;
            }

            .i a ,.btsub{
                display: block;
                background-color: #04AA6D;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                width: 80%;
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
                <form class="d-flex" role="search">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" >
                    <button class="btn btn-outline-success" type="submit" style="color: white">Search</button>
                </form>
            </div>
        </div>
        <div class="con">
            <form action="/Project_PRJ301/UserServlet" method="post" class="i">
                <label><b>user:</b></label> <span>${u.userName}</span>
                <input type="hidden" name="AccName" value="${u.userName}">
                <div>
                    <label for="pass"><b>Pass</b></label>
                    <input type="password"  name="pass"value="${u.passWord}" required>
                </div>

                <div>
                    <label for="email"><b>Email</b></label>
                    <input type="text"  name="mail"value="${u.email}" required>
                </div>

                <div>
                    <label for="active"><b>Active</b></label>
                    <select name="active">
                        <c:forEach items="${act}" var="i">
                            <option value="${i}">
                                ${i}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <tr>
                    <td> <label for="passadmin"><b>password</b></label></td>
                    <td class="hold"><input type="password"  name="passadmin" required></td>
                </tr>
                <button type="submit" class="btsub" formaction="/Project_PRJ301/UpdateStServlet">update</button>
            </form>
        </div>
    </body>
</html>
