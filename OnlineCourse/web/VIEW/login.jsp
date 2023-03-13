<%-- 
    Document   : login
    Created on : Oct 13, 2022, 1:54:51 PM
    Author     : WIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Login</title>
        <link rel="icon" type="image/x-icon" href="images/istockphoto-1256528848-612x612.jpg" >
        <style>
            body {
                font-family: Arial, Helvetica, sans-serif;
                background-color: black;
            }

            img{
                width: 100px;
                height: 100px;
                border-radius: 100%;
                position: absolute;
                left: 48.5%;
                top:10%;
            }
            form {
                border: 3px solid #f1f1f1;
                background-color: white;
                height: 340px;
                width: 500px;
                position: absolute;
                left: 38%;
                top: 22%;
            }

            input[type=text], input[type=password] {
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                box-sizing: border-box;
            }

            input[type=submit], input[type=button] {
                background-color: #04AA6D;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 100%;
            }

            input[type=submit] :hover {
                opacity: 0.8;
            }

            .container {
                padding: 16px;
            }
            
            form div:nth-child(2){
                display: flex;
                justify-content: space-between;
            }

            span.psw {
                float: right;

            }


            @media screen and (max-width: 300px) {
                span.psw {
                    display: block;
                    float: none;
                }
                .cancelbtn {
                    width: 100%;
                }
            }
        </style>
    </head>
    <body>
        <img src="images/istockphoto-1256528848-612x612.jpg" alt=""/>
        <form  action="/Project_PRJ301/Login" method="post">
            <div class="container">
                <label for="uname"><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="uname" required>

                <label for="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="psw" required>
                <p style="color: red;height: 18px">${e_mess}</p>
                <input type="submit" value="Đăng nhập" name="login"> 

            </div>
            <div class="container" style="background-color:#f1f1f1">
                <span class="home"><a href="/Project_PRJ301/HomeServlet">Home</a></span>
                <span class="register"><a href="/Project_PRJ301/registerServlet" style="margin-left:40px">Đăng ký</a></span>
                <span class="psw"> <a href="#">Quên mật khẩu?</a></span>
            </div>
        </form>
    </body>
</html>
