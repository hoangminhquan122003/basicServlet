
<%@page import="model.KhachHang"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String url=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();

%>
<nav class="navbar navbar-expand-lg bg-body-tertiary fixed-top" >
            <div class="container-fluid">
                <a class="navbar-brand" href="#">
                    <img src="img/download.png" alt="Bootstrap"  height="24">

                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Trang chu</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Giam gia </a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                the loai
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="#">Quan </a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="#">Ao</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="#">mu</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled" aria-disabled="true">Disabled</a>
                        </li>
                    </ul>
                    <form class="d-flex" role="search">

                        <input class="form-control me-2" type="search" placeholder="Tim kiem" aria-label="Search">
                        <button class="btn btn-outline-success mx-2" type="submit" style="white-space: nowrap">Tìm kiếm </button>
                        <%
                            KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");
                            if (khachHang == null) {
                        %>
                        <a class="btn btn-outline-primary mx-2" style="white-space:nowrap" href="khachhang/login.jsp"> Đăng nhập</a>
                        <% } else { %>
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0 ">
                            <li class="nav-item dropdown dropstart">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Tài khoản
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="#">Đơn hàng của tôi </a></li>
                                    <li><hr class="dropdown-divider"></li>
                                    <li><a class="dropdown-item" href="#">Thông báo</a></li>
                                    <li><hr class="dropdown-divider"></li>
                                    <li><a class="dropdown-item" href="<%=url%>/khachhang/thaydoianh.jsp">Thay đổi ảnh</a></li>
                                    <li><hr class="dropdown-divider"></li>
                                    <li><a class="dropdown-item" href="<%=url%>/khachhang/thaydoithongtin.jsp">Thay đổi thông tin</a></li>
                                    <li><hr class="dropdown-divider"></li>
                                    <li><a class="dropdown-item" href="<%=url%>/khachhang/doiMatKhau.jsp">Thay đổi mật khẩu </a></li>
                                    <li><hr class="dropdown-divider"></li>
                                    <li><a class="dropdown-item" href="<%=url%>/khach-hang?hanhDong=dang-xuat">Thoát tài khoản </a></li>
                                </ul>
                            </li>
                        </ul>  
                        <%}%>
                    </form>
                </div>
            </div>
        </nav>