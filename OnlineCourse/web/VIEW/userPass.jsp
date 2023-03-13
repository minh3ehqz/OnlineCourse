<%-- 
    Document   : userPass
    Created on : Oct 25, 2022, 8:43:29 AM
    Author     : WIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>mật khẩu</title>
        <link href="https://fonts.googleapis.com/css?family=Playfair+Display&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/mystyle.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/mycode.js"></script>
        <link rel="icon" type="image/x-icon" href="images/istockphoto-1256528848-612x612.jpg" >
        <style>

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

            .bt{
                display: block;
                background-color: #04AA6D;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                width: 90%;
                text-decoration: none;
                text-align: center;
            }
            
            .btsub{
                display: block;
                background-color: #04AA6D;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                width: 85%;
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
            <form action="/Project_PRJ301/UserPassServlet" method="post" class="i">
                <div>
                    <label for="oldpsw"><b>old password</b></label>
                    <input type="password" placeholder="Enter Password" name="oldpsw" required>
                </div>

                <div>
                    <label for="psw"><b>new assword</b></label>
                    <input type="password" placeholder="Enter Password" name="psw" required>
                </div>

                <div>
                    <label for="repsw"><b>re-password</b></label>
                    <input type="password" placeholder="Enter Password" name="repsw" required>
                </div>


                 <button type="submit" class="btsub" formaction="/Project_PRJ301/UserPassServlet">Đổi mật khẩu</button>
            </form>
        </div>

    </body>
</html>
