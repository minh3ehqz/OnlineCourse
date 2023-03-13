

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Học Chăm</title>
        <link href="https://fonts.googleapis.com/css?family=Playfair+Display&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/mystyle.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/mycode.js"></script>
        <link rel="icon" type="image/x-icon" href="images/istockphoto-1256528848-612x612.jpg" >
        <style>
            .classroom{
                position: absolute;
                left: -2%;
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

        <div class="banner">
            <div style="margin-top: 250px ; text-align: center">
                <div class="content">
                    <h1>HỌC LẬP TRÌNH CHO NGƯỜI MỚI BẮT ĐẦU VÀ NHỮNG NGÀNH LIÊN QUAN</h1>
                    <h4>Trở thành lập trình viên full-stack trong 6 tháng</h4>
                </div>
                <c:if test="${user==null}">
                    <button type="submit" formaction="/Project_PRJ301/registerServlet"><a style="color: white ;text-decoration: none" href="/Project_PRJ301/registerServlet">ĐĂNG KÝ NGAY</a></button>
                </c:if>
            </div>
            <img src="images/banner_5.png" alt="banner" />
        </div>
        <div class="container">
            <div class="intro">
                <img src="images/intro.png" alt=""/>
                <div>
                    <h4>CÓ PHẢI BẠN ĐÃ TỪNG NGHĨ RẰNG:</h4>
                    <ul>
                        <li>Lập trình viên là một nghề rất xa vời?</li>
                        <li>Rất khó để có thể học được nghề lập trình?</li>
                        <li>Công việc lập trình chỉ dành cho những người rất giỏi toán?</li>
                        <li>Phải rất am hiểu về công nghệ thì mới theo được lập trình?</li>
                    </ul>
                    <h4>HAY BẠN THÍCH HỌC LẬP TRÌNH NHƯNG KHÁ LO LẮNG:</h4>
                    <ul>
                        <li>Mình đã không học hành gì trong nhiều năm nên khó để đi học lại?</li>
                        <li>Học 4 năm đại học còn không xong thì làm sao học được trong vài tháng?</li>
                        <li>Mình lớn tuổi thế này thì bắt đầu có muộn quá không?</li>
                        <li>Mình không biết tiếng Anh thì không biết có học lập trình được không?</li>
                    </ul>
                </div>
            </div>

            <h1 style="text-align: center">TOP CÁC NGÀNH HOT TRONG THỜI ĐẠI SỐ</h1>



            <div class="top_Course">
                <div class  ="MH">
                    <c:forEach items="${dao.depart}" var="de">
                        <div class="item">
                            <img src="${de.images}" alt="t" />
                            <h3>${de.name}</h3>
                            <p>${de.title}</p>
                        </div>     
                    </c:forEach>  
                </div>
            </div>

            <div class="course">
                <div class="intro_class">
                    <h1>${user==null?"MỘT SỐ KHÓA HỌC NỔI BẬT":"MỘT SỐ KHÓA HỌC KHUYẾN NGHỊ"}</h1>
                    <a href="/Project_PRJ301/CourseServlet">xem thêm</a>
                </div>

                <div class="classroom">
                    <c:forEach items="${topcl.topclass}" var="clt" >
                        <div class="khoa_hoc">
                            <img src="${clt.images}" alt=""/>
                            <p><strong>${clt.title}</strong></p>
                        </div>
                    </c:forEach>
                </div>
            </div> 
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
