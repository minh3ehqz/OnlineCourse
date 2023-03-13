
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Register</title>
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
                top:1%;
            }
            form {
                border: 3px solid #f1f1f1;
                background-color: white;
                height: 710px;
                width: 500px;
                position: absolute;
                left: 38%;
                top: 12%;
            }

            input[type=text], input[type=password] {
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                box-sizing: border-box;
            }

            input[type=submit] {
                background-color: #04AA6D;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 100%;
                margin-top: 100px;
            }

            input[type=submit] :hover {
                opacity: 0.8;
            }

            .container {
                padding: 16px;
            }

            p.psw {
                padding-top: 10px;
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
            
            .err{
                height: 8px;
                color: red;
                margin: 0px 0px 8px 0px;
                float: right;
            }
        </style>
    </head>
    <body>
        <img src="images/istockphoto-1256528848-612x612.jpg" alt=""/>
        <form action="/Project_PRJ301/registerServlet" method="post">
            <div class="container">
                <label for="uname"><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="uname" required>
                <h6 class="err">${emess[0]}</h6>
                <label for="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="psw" required>
                <h6 class="err">${emess[1]}</h6>
                <label for="re-psw"><b>Re-Password</b></label>
                <input type="password" placeholder="Enter Password" name="re_psw" required>
                <h6 class="err">${emess[2]}</h6>
                <label for="phone"><b>Phone number</b></label>
                <input type="text" placeholder="Phone" name="phone" required>
                <h6 class="err">${emess[3]}</h6>
                <label for="email"><b>Email</b></label>
                <input type="text" placeholder="Enter emali" name="mail" required>
                <h6 class="err">${emess[4]}</h6>
                <label for="gender"><b>Gender</b></label>
                <input type="radio" name="gender" value="m" checked>Male
                <input type="radio" name="gender" value="f" >Female</br></br>

                <label for="department"><b>Department</b></label>
                <select name="depart" required>
                    <c:forEach items="${dao.depart}" var="de">
                        <option value="${de.ID}">
                            ${de.ID}
                        </option>
                    </c:forEach>
                </select>
                <!--<h6>${dao.status}</h6>--> 
                <input type="submit" value="Đăng ký" name="register" style="background-color: red">
            </div>
            <div class="container" style="background-color:#f1f1f1">
                <p class="psw">Đã có tài khoản  <a href="/Project_PRJ301/Login">đăng nhập ngay</a></p>
            </div>
        </form>
    </body>
</html>
