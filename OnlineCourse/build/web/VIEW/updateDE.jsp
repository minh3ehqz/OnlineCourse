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

            table{
                width: 100%;
            }

            .hold{
                width: 100%;
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

            .i input{
                width: 75%;
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
            <form action="/Project_PRJ301/UpdateDeServlet" method="post" class="i">
                <table>
                    <tr>
                        <td><label><b>DeID</b></label> </td>
                        <td class="hold"><span>${d.ID}</span></td>
                    <input type="hidden" name="deName" value="${d.ID}">
                    </tr>
                    <tr>
                        <td><label for="name"><b>Name</b></label></td>
                        <td class="hold"><input type="text"  name="dname"value="${d.name}" required></td>
                    </tr>
                    <tr>
                        <td><label for="title"><b>Title</b></label></td>
                        <td class="hold"><input type="text"  name="dtitle"value="${d.title}" required></td>

                    </tr>
                    <tr>
                        <td> <label for="images"><b>Images</b></label></td>
                        <td class="hold"><input type="text"  name="dimages"value="${d.images}" required></td>
                    </tr>
                    
                    <tr>
                        <td> <label for="passadmin"><b>password</b></label></td>
                        <td class="hold"><input type="password"  name="passadmin" required></td>
                    </tr>
                   
                </table>
                <button type="submit" class="btsub" formaction="/Project_PRJ301/UpdateDeServlet">update</button>
            </form>
        </div>

    </body>
</html>
