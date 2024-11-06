<%-- 
    Document   : register
    Created on : Apr 24, 2024, 7:44:49 PM
    Author     : Admin
--%>

<%@page import="model.KhachHang"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thay doi thong tin</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
        
    </head>
    <body>
        <%
            String url=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
        %>
        <jsp:include page="../header.jsp"/>
        <%
            KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");
            if (khachHang == null) {
        %>
        <div style="text-align: center"><h1>Bạn chưa đăng nhập vào hệ thống</h1></div>
        <a href="index.jsp">quai lai</a>
        <%
        } else {
            String hoVaTen = khachHang.getHoTen();
            String gioiTinh = khachHang.getGioiTinh();
            String ngaySinh = khachHang.getNgaySinh().toString();
            String diaChiKhachHang = khachHang.getDiaChi();
            String diaChiMuaHang = khachHang.getDiaChiMuaHang();
            String diaChiNhanHang = khachHang.getDiaChiNhanHang();
            String dienThoai = khachHang.getSoDienThoai();
            String email = khachHang.getEmail();
            boolean dongYNhanMail = khachHang.isDangKyNhanBanTinEmail();
        %>
        <div class="container">
            <div style="text-align: center"><h1>Thay doi thong tin tài khoản</h1></div>
            <form action="<%=url%>/khach-hang" method="post">
                <input type="hidden" name="hanhDong" value="thay-doi-thong-tin"/>
                <div class="row">
                    <div class="col col-md-6">
                        <h3> Thông tin khách hàng</h3>
                        <div class="mb-3">
                            <label class="form-lable" > Họ và tên</label>
                            <input type="text" class="form-control" id="hoVaTen" name="hoVaTen" value="<%=hoVaTen%>">
                        </div>
                        <div class="mb-3">
                            <label class="form-lable" > Giới tính</label>
                            <select class="form-control" id="gioiTinh" name="gioiTinh" >
                                <option value="Nam" <%=(gioiTinh.equals("Nam") ? "selected='selected'" : "")%> >Nam</option>
                                <option value="Nữ" <%=(gioiTinh.equals("Nữ") ? "selected='selected'" : "")%>>Nữ</option>
                                <option value="Khác"<%=(gioiTinh.equals("Khác") ? "selected='selected'" : "")%>>Khác</option>

                            </select>
                        </div>
                        <div class="mb-3">
                            <label class="form-lable" > Ngày sinh</label>
                            <input type="date" class="form-control" id="ngaySinh" name="ngaySinh"  value="<%=ngaySinh%>">
                        </div>
                    </div>
                    <div class="col col-md-6">
                        <h3>Địa chỉ</h3>
                        <div class="mb-3">
                            <label class="form-lable" > Địa chỉ khách hàng</label>
                            <input type="text" class="form-control" id="diaChiKhachHang" name="diaChiKhachHang" value="<%=diaChiKhachHang%>">
                        </div>
                        <div class="mb-3">
                            <label class="form-lable" > Địa chỉ mua hàng</label>
                            <input type="text" class="form-control" id="diaChiMuaHang" name="diaChiMuaHang" value="<%=diaChiMuaHang%>">
                        </div>
                        <div class="mb-3">
                            <label class="form-lable" > Địa chỉ nhận hàng</label>
                            <input type="text" class="form-control" id="diaChiNhanHang" name="diaChiNhanHang" value="<%=diaChiNhanHang%>">
                        </div>
                        <div class="mb-3">
                            <label class="form-lable" > Điện thoại</label>
                            <input type="tel" class="form-control" id="dienThoai" name="dienThoai" value="<%=dienThoai%>" >
                        </div>
                        <div class="mb-3">
                            <label class="form-lable" > Email</label>
                            <input type="email" class="form-control" id="email" name="email" value="<%=email%>">
                        </div>

                        <div class="mb-3">
                            <label class="form-lable" > Đồng ý với nhận email</label>
                            <input type="checkbox" class="form-check-input" id="dongYNhanMail" name="dongYNhanMail" <%=dongYNhanMail?"checked":""%> >
                        </div>
                        <button class="btn btn-primary form-control"  type="submit">Luu thong tin</button>
                    </div>
                </div>
            </form>
                       
        </div>
        <%}%>
        <%@include file="../footer.jsp" %>
    </body>

</html>
