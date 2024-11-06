<%-- 
    Document   : doiMatKhau
    Created on : May 2, 2024, 2:45:43 PM
    Author     : Admin
--%>

<%@page import="model.KhachHang"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đổi mật khẩu</title>
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
            KhachHang khachHang=(KhachHang)session.getAttribute("khachHang");
            if(khachHang==null){
        %>
        <div style="text-align: center"><h1>Bạn chưa đăng nhập vào hệ thống vui lòng đăng nhập lại</h1></div>
        
        <%
            }else{
            String baoLoi=request.getAttribute("baoLoi")+"";
            if(baoLoi.equals("null")){
                baoLoi="";
            }
                    
        %> 
        <div class="text-center">
        <h1>Đổi mật khẩu</h1>
        <span style="color: red"><%=baoLoi%></span>
        </div>
        <div class="container">
            <form action="<%=url%>/khach-hang" method="post">
                <input type="hidden" name="hanhDong" value="doi-mat-khau">

                <div class="row">
                    
                <h3> Tài khoản</h3>
                <div class="mb-3">
                    <label class="form-lable" > Mật khẩu hiện tại:</label></span>
                <input type="password" class="form-control" id="matKhauHienTai" name="matKhauHienTai" required="required" >
                </div>
                <div class="mb-3">
                    <label class="form-lable" > Mật khẩu mới</label>
                    <input type="password" class="form-control" id="matKhauMoi" name="matKhauMoi" required="required" >
                </div>
                <div class="mb-3">
                    <label class="form-lable" > Mật khẩu mới</label>
                    <input type="password" class="form-control" id="matKhauMoiNhapLai" name="matKhauMoiNhapLai" required="required">
                </div>
                <button type="submit" class="btn btn-outline-primary">Lưu mật khẩu</button>
                </div>
            </form>
        </div>
        
        <%}%>
        <%@include file="../footer.jsp" %>
    </body>
</html>
