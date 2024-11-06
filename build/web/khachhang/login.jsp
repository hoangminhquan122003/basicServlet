<%-- 
    Document   : login
    Created on : Apr 26, 2024, 7:31:48 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
        <% 
            String url=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
        %>
        <link href="<%=url %>/css/sign-in.css" rel="stylesheet">
    </head>
    <body class=" align-items-center py-4 bg-body-tertiary ">
        <jsp:include page="../header.jsp"/>
        <main class="form-signin w-100 m-auto" ">
            <form class="text-center " style="margin-top: 30px"  action="<%=url%>/khach-hang" method="post">
            <input type="hidden" name="hanhDong" value="dang-nhap"/>

            <h1 class="h3 mb-3 fw-normal">Đăng nhập</h1>
            <%
              String baoLoi=request.getAttribute("baoLoi")+"";
              baoLoi=(baoLoi.equals("null"))?"":baoLoi;
            %>
            <span class="rd"><%=baoLoi %></span>
             <div class="form-floating">
                <input type="text" class="form-control" id="tenDangNhap" name="tenDangNhap" placeholder="tên đăng nhập">
                <label for="tenDangNhap">tên đăng nhập</label>
            </div>
            <div class="form-floating">
                <input type="password" class="form-control" id="matKhau" name="matKhau" placeholder="mật khẩu">
                <label for="matKhau">Mật khẩu</label>
            </div>

            <div class="form-check text-start my-3">
                <input class="form-check-input" type="checkbox" value="remember-me" id="flexCheckDefault">
                <label class="form-check-label" for="flexCheckDefault">
                    Ghi nhớ tài khoản
                </label>
            </div>
            <button class="btn btn-primary w-100 py-2" type="submit">Đăng nhập</button>
            <a href="register.jsp">Đăng ký tài khoản</a>
            <p class="mt-5 mb-3 text-body-secondary">&copy; 2017–2024</p>
        </form>
        </main>
        <%@include file="../footer.jsp" %>
    </body>
</html>
