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
        <title>ADMIN</title>
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

            .depart div{
                border-radius: 0%;
                width: 100px;
            }

            .page div:hover{
                background-color: gray;
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
        <div class="page depart" style="text-align: center">  
            <div style="background-color: black;">
                <a href="/Project_PRJ301/ADServlet"style="color: white">user</a>
            </div>   
            <div>
                <a href="/Project_PRJ301/ADclassServlet">class</a>
            </div>
            <div>
                <a href="/Project_PRJ301/ADdepartServlet">department</a>
            </div>
        </div>


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
                <th>UserName</th>
                <th>email</th>
                <th>active</th>
                <th></th>
                <th></th>

            </tr>
            <c:forEach items="${listSt}" var="st">
                <tr>
                    <td>${st.ID}</td>
                    <td>${st.name}</td>
                    <td>${st.gender?"nam":"nữ"}</td>
                    <td>${st.deptId}</td>
                    <td>${st.phoneNumber}</td>
                    <td>${st.userName}</td>
                    <td>${st.email}</td>
                    <td>${st.active}</td>
                    <td><a href="UpdateStServlet?type=1&AccName=${st.userName}">UPDATE</a></td>
                    <td><a href="ADServlet?type=2&id=${st.ID}">DELETE</a></td>
                </tr>
            </c:forEach>
        </table>


        <div class="page" style="text-align: center">
            <c:forEach begin="1" end="${endp}" var="i" >
                <div>
                    <a href="ADServlet?index=${i}">${i}</a>
                </div>
            </c:forEach>
        </div>
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
