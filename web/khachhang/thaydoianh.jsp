

<%@page import="model.KhachHang"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thay doi anh</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
        
    </head>
    <body>
        <jsp:include page="../header.jsp"/>
        <%
            KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");
            if (khachHang == null) {
        %>
        <div style="text-align: center"><h1>Bạn chưa đăng nhập vào hệ thống</h1></div>
        <a href="index.jsp">quai lai</a>
        <%
        } else {
            String baoLoi=request.getAttribute("baoLoi")+"";
            baoLoi=(baoLoi.equals("null"))?"":baoLoi;
            String thayThoiAnh= khachHang.getThayDoiAnh();
        %>
        <div class="container">
            <div style="text-align: center"><h1>Thay đổi ảnh đại diện</h1></div>
            <div style="color: red" id="baoLoi">
                <%=baoLoi %>
            </div>
            <%
                String url= request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+ request.getContextPath();
            %>
            <form action="<%=url%>/thay-doi-anh" method="post" enctype="multipart/form-data">
                <div class="row">
                    <div class="col">
                        <h3>Ảnh đại diện</h3>
                        <img src="<%=url %>/avatar/<%=thayThoiAnh %>" alt="thay doi anh"/>
                        <div class="mb-3">
                            <label for="thayDoiAnh" class="form-label">Đường dẫn ảnh</label>
                            <input type="file" class="form-control" id="thayDoiAnh" name="thayDoiAnh">
                        </div>
                        
                    </div>
                        <button class="btn btn-primary form-control"  type="submit">Luu thong tin</button>
                    
                </div>
            </form>
                       
        </div>
        <%}%>
        <%@include file="../footer.jsp" %>
    </body>
</html>
