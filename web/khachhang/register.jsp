<%-- 
    Document   : register
    Created on : Apr 24, 2024, 7:44:49 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
        <style>
            .rd{
                color:red;
            }
        </style>
        <% 
            String url=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
        %>
    </head>
    <body>
        <%
          String baoLoi=request.getAttribute("baoLoi")+"";
          baoLoi=(baoLoi.equals("null"))?"": baoLoi;
          
        String tenDangNhap= request.getAttribute("tenDangNhap")+"";
        tenDangNhap=(tenDangNhap.equals("null"))?"": tenDangNhap;
        String hoVaTen= request.getAttribute("hoVaTen")+"";
         hoVaTen=(hoVaTen.equals("null"))?"": hoVaTen;
        String gioiTinh= request.getAttribute("gioiTinh")+"";
         gioiTinh=(gioiTinh.equals("null"))?"": gioiTinh;
        String ngaySinh =request.getAttribute("ngaySinh")+"";
         ngaySinh=(ngaySinh.equals("null"))?"": ngaySinh;
        String diaChiKhachHang =request.getAttribute("diaChiKhachHang")+"";
         diaChiKhachHang=(diaChiKhachHang.equals("null"))?"": diaChiKhachHang;
        String diaChiMuaHang =request.getAttribute("diaChiMuaHang")+"";
         diaChiMuaHang=(diaChiMuaHang.equals("null"))?"": diaChiMuaHang;
        String diaChiNhanHang= request.getAttribute("diaChiNhanHang")+"";
         diaChiNhanHang=(diaChiNhanHang.equals("null"))?"": diaChiNhanHang;
        String dienThoai =request.getAttribute("dienThoai")+"";
         dienThoai=(dienThoai.equals("null"))?"": dienThoai;
        String email= request.getAttribute("email")+"";
         email=(email.equals("null"))?"": email;
        String dongYNhanMail= request.getAttribute("dongYNhanMail")+"";
         dongYNhanMail=(dongYNhanMail.equals("null"))?"": dongYNhanMail;
        %>
        <div class="container">
            <div style="text-align: center"><h1>Đăng ký tài khoản</h1></div>
            <div class="rd" id="baoLoi">
                <%=baoLoi%>
            </div>
            <form action="<%=url%>/khach-hang" method="post">
                <input type="hidden" name="hanhDong" value="dang-ky">

                <div class="row">
                    <div class="col col-md-6">
                <h3> Tài khoản</h3>
                <div class="mb-3">
                    <label class="form-lable" > Tên đăng nhập</label><span class="rd">*</span>
                    <input type="text" class="form-control" id="tenDangNhap" name="tenDangNhap" placeholder="nhập tên đăng ký" required="required" value="<%=tenDangNhap %>">
                </div>
                <div class="mb-3">
                    <label class="form-lable" > Mật khẩu</label><span class="rd">*</span>
                    <input type="password" class="form-control" id="matKhau" name="matKhau" placeholder="nhập password" required="required" >
                </div>
                <div class="mb-3">
                    <label class="form-lable" > Nhập lại mật khẩu</label><span class="rd">*</span>
                    <input type="password" class="form-control" id="nhapLaiMatKhau" onkeyup="kiemTraMatKhau()" name="nhapLaiMatKhau" placeholder="Nhập lại password" required="required">
                    <div class="rd" id="msg"></div>
                </div>
                <h3> Thông tin khách hàng</h3>
                <div class="mb-3">
                    <label class="form-lable" > Họ và tên</label>
                    <input type="text" class="form-control" id="hoVaTen" name="hoVaTen" placeholder="Họ và tên" value="<%=hoVaTen %>">
                </div>
                <div class="mb-3">
                    <label class="form-lable" > Giới tính</label>
                    <select class="form-control" id="gioiTinh" name="gioiTinh" >
                        <option value="Nam" <%=(gioiTinh.equals("Nam")?"selected='selected'":"")%> >Nam</option>
                        <option value="Nữ" <%=(gioiTinh.equals("Nữ")?"selected='selected'":"")%>>Nữ</option>
                        <option value="Khác"<%=(gioiTinh.equals("Khác")?"selected='selected'":"")%>>Khác</option>

                    </select>
                </div>
                <div class="mb-3">
                    <label class="form-lable" > Ngày sinh</label>
                    <input type="date" class="form-control" id="ngaySinh" name="ngaySinh" placeholder="Họ và tên" value="<%=ngaySinh%>">
                </div>
                    </div>
                    <div class="col col-md-6">
                <h3>Địa chỉ</h3>
                <div class="mb-3">
                    <label class="form-lable" > Địa chỉ khách hàng</label>
                    <input type="text" class="form-control" id="diaChiKhachHang" name="diaChiKhachHang" value="<%=diaChiKhachHang %>">
                </div>
                <div class="mb-3">
                    <label class="form-lable" > Địa chỉ mua hàng</label>
                    <input type="text" class="form-control" id="diaChiMuaHang" name="diaChiMuaHang" value="<%=diaChiMuaHang %>">
                </div>
                <div class="mb-3">
                    <label class="form-lable" > Địa chỉ nhận hàng</label>
                    <input type="text" class="form-control" id="diaChiNhanHang" name="diaChiNhanHang" value="<%=diaChiNhanHang %>">
                </div>
                <div class="mb-3">
                    <label class="form-lable" > Điện thoại</label>
                    <input type="tel" class="form-control" id="dienThoai" name="dienThoai" value="<%=dienThoai %>" >
                </div>
                <div class="mb-3">
                    <label class="form-lable" > Email</label>
                    <input type="email" class="form-control" id="email" name="email" value="<%=email %>">
                </div>
                <div class="mb-3">
                    <label class="form-lable" > Đồng ý với điều khoản của công ty</label><span class="rd">*</span>
                    <input type="checkbox" class="form-check-input" id="dongYDieuKhoan" onchange="xuLyDongY()" name="dongYDieuKhoan" required="required">
                </div>
                <div class="mb-3">
                    <label class="form-lable" > Đồng ý với nhận email</label>
                    <input type="checkbox" class="form-check-input" id="dongYNhanMail" name="dongYNhanMail" >
                </div>
                <input type="submit" value="Đăng Ký" class="btn btn-outline-primary form-control" name="submit" id="submit" style="visibility: hidden">
                </div>
                </div>
            </form>
            
        </div>
    </body>
    <script>
        function kiemTraMatKhau(){
              matKhau=document.getElementById("matKhau").value;
              nhapLaiMatKhau=document.getElementById("nhapLaiMatKhau").value;
             if(matKhau!=nhapLaiMatKhau){
                 document.getElementById("msg").innerHTML="Mật khẩu không khớp";
                 return false;
             }else{
                document.getElementById("msg").innerHTML="";
                return true;
             }
        }
        function xuLyDongY(){
            dongYDieuKhoan= document.getElementById("dongYDieuKhoan");
            if(dongYDieuKhoan.checked==true){
                document.getElementById("submit").style.visibility="visible";

            }else
                document.getElementById("submit").style.visibility="hidden";
        }
    </script>
</html>
