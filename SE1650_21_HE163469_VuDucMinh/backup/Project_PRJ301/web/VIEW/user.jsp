<%-- 
    Document   : admin
    Created on : Oct 17, 2022, 4:45:52 PM
    Author     : WIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>thông tin</title>
        <link href="https://fonts.googleapis.com/css?family=Playfair+Display&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/mystyle.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
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
                <form class="d-flex" role="search" method="get">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="search" >
                    <button class="btn btn-outline-success" type="submit" style="color: white" formaction="CourseServlet">Search</button>
                </form>
            </div>
        </div>

        <div class="con">
            <form action="/Project_PRJ301/UserServlet" method="post" class="i">
                <div>
                    <label for="name"><b>Name</b></label>
                    <input type="text" placeholder="name" name="name" value="${user.name}" required>
                </div>

                <div>
                    <label for="phone"><b>Phone</b></label>
                    <input type="text" placeholder="Phone" name="phone" value="${user.phoneNumber}" required>
                </div>

                <div>
                    <label for="email"><b>Email</b></label>
                    <input type="text" placeholder="Enter email" name="mail"value="${user.email}" required>
                </div>

                <div>
                    <label for="gender"><b>Gender</b></label>
                    <input type="radio" name="gender" value="m" ${user.gender?"checked":""}>Male
                    <input type="radio" name="gender" value="f" ${user.gender?"":"checked"}>Female</br></br>
                </div>
                <div>
                    <label for="department"><b>Department</b></label>
                    <select name="depart" required>
                        <c:forEach items="${dao.depart}" var="de">
                            <option value="${de.ID}" ${(de.ID)==userDe?"selected":""}>
                                ${de.ID}
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <button type="submit" class="btsub" formaction="/Project_PRJ301/UserServlet">update</button>
                <a href="/Project_PRJ301/UserPassServlet" style="background-color: red">đổi mật khẩu</a>
            </form>
        </div>
                ${err}
        <div id="footer">
            <section class="bootom-footer">
                <div class="container">
                    <p>
                        Cơ quan chủ quản: Công ty Cổ phần Đầu tư và Dịch vụ Giáo dục<br>
                        MST: 0102183602 do Sở kế hoạch và Đầu tư thành phố Hà Nội cấp ngày 13 tháng 03 năm 2007<br>
                        Địa chỉ: <br>
                        - Văn phòng Hà Nội: Tầng 4, Tòa nhà 25T2, Đường Nguyễn Thị Thập, Phường Trung Hoà, Quận Cầu Giấy, Hà Nội.<br>
                        - Văn phòng TP.HCM: 13M đường số 14 khu đô thị Miếu Nổi, Phường 3, Quận Bình Thạnh, TP. Hồ Chí Minh<br>
                        Hotline: 19006933 – Email:  hotro@hoccham.vn <br>
                    </p>
                </div>
            </section>
        </div>
    </body>
</html>
