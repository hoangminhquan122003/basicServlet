/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import database.KhachHangDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Calendar;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.KhachHang;
import util.Email;
import util.MaHoa;
import util.SoNgauNhien;

/**
 *
 * @author Admin
 */
@WebServlet(name = "khachhangcontroller", urlPatterns = {"/khach-hang"})
public class khachhangcontroller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String hanhDong = request.getParameter("hanhDong");
        switch (hanhDong) {
            case "dang-nhap":
                dangNhap(request, response);
                break;
            case "dang-xuat":
                dangXuat(request, response);
                break;
            case "dang-ky":
                do_register(request, response);
                break;
            case "doi-mat-khau":
                doiMK(request, response);
                break;
            case "thay-doi-thong-tin":
                thaydoithongtinngdung(request, response);
                break;
            case "xac-thuc":
                xacThuc(request, response);
                break;
            default:
                break;
        }
    }

    private void dangNhap(HttpServletRequest request, HttpServletResponse response) {
        try {
            String tenDangNhap = request.getParameter("tenDangNhap");
            String matKhau = request.getParameter("matKhau");
            matKhau = MaHoa.toSHA1(matKhau);
            KhachHang kh = new KhachHang();
            kh.setTenDangNhap(tenDangNhap);
            kh.setMatKhau(matKhau);
            KhachHangDAO khd = new KhachHangDAO();
            String url = "";
            KhachHang khachHang = khd.selectByUsernameandPassword(kh);
            if (khachHang != null&& khachHang.isTrangThaiXacThuc()) {
                HttpSession session = request.getSession();
                session.setAttribute("khachHang", khachHang);
                url = "/index.jsp";
            } else {
                request.setAttribute("baoLoi", "ten dang nhap hoac mat khau khong dung");
                url = "/khachhang/login.jsp";
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void dangXuat(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            //huy bo session
            session.invalidate();
            response.sendRedirect("index.jsp");
        } catch (Exception e) {
        }
    }

    private void do_register(HttpServletRequest request, HttpServletResponse response) {
        try {
            String tenDangNhap = request.getParameter("tenDangNhap");
            String matKhau = request.getParameter("matKhau");
            String nhapLaiMatKhau = request.getParameter("nhapLaiMatKhau");
            String hoVaTen = request.getParameter("hoVaTen");
            String gioiTinh = request.getParameter("gioiTinh");
            String ngaySinh = request.getParameter("ngaySinh");
            String diaChiKhachHang = request.getParameter("diaChiKhachHang");
            String diaChiMuaHang = request.getParameter("diaChiMuaHang");
            String diaChiNhanHang = request.getParameter("diaChiNhanHang");
            String dienThoai = request.getParameter("dienThoai");
            String email = request.getParameter("email");
            String dongYNhanMail = request.getParameter("dongYNhanMail");

            request.setAttribute("tenDangNhap", tenDangNhap);
            request.setAttribute("hoVaTen", hoVaTen);
            request.setAttribute("gioiTinh", gioiTinh);
            request.setAttribute("ngaySinh", ngaySinh);
            request.setAttribute("diaChiKhachHang", diaChiKhachHang);
            request.setAttribute("diaChiMuaHang", diaChiMuaHang);
            request.setAttribute("diaChiNhanHang", diaChiNhanHang);
            request.setAttribute("dienThoai", dienThoai);
            request.setAttribute("email", email);
            request.setAttribute("dongYNhanMail", dongYNhanMail);

            String baoLoi = "";
            KhachHangDAO khDAO = new KhachHangDAO();
            if (khDAO.kiemTraTenDangNhap(tenDangNhap)) {
                baoLoi += "tên đăng nhập đã tồn tại";
            }
            if (!matKhau.equals(nhapLaiMatKhau)) {
                baoLoi += "mật khẩu không khớp";
            } else {
                matKhau = MaHoa.toSHA1(matKhau);
            }
            request.setAttribute("baoLoi", baoLoi);
            String url = "";
            if (baoLoi.length() > 0) {
                url = "/khachhang/register.jsp";
            } else {

                Random rd = new Random();
                String maKhachHang = rd.nextInt(1000) + "";
                KhachHang kh = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChiKhachHang, diaChiNhanHang, diaChiMuaHang, Date.valueOf(ngaySinh), dienThoai, email, dongYNhanMail != null);
                if (khDAO.insert(kh) > 0) {
                    String soNgauNhien = SoNgauNhien.getSoNgauNhien();
                    Date thoiGianHieuLuc = new Date(new java.util.Date().getTime());
                    Calendar c = Calendar.getInstance();
                    c.setTime(thoiGianHieuLuc);
                    c.add(Calendar.DATE, 1);
                    Date thoiGianHieuLucMaXacThuc = new Date(c.getTimeInMillis());
                    boolean trangThaiXacThuc = false;
                    kh.setMaXacThuc(soNgauNhien);
                    kh.setThoiGianHieuLucMaXacThuc(thoiGianHieuLucMaXacThuc);
                    kh.setTrangThaiXacThuc(trangThaiXacThuc);
                    if (khDAO.updateVerifyInformation(kh) > 0) {
                        Email.sendEmail(kh.getEmail(), "Xac thuc tai khoan", getNoiDung(kh));
                    }
                }
                url = "/khachhang/thanhcong.jsp";
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void doiMK(HttpServletRequest request, HttpServletResponse response) {
        try {
            String matKhauHienTai = request.getParameter("matKhauHienTai");
            String matKhauMoi = request.getParameter("matKhauMoi");
            String matKhauMoiNhapLai = request.getParameter("matKhauMoiNhapLai");
            String url = "/khachhang/doiMatKhau.jsp";
            String matKhauHienTaiSHA1 = MaHoa.toSHA1(matKhauHienTai);
            String baoLoi = "";
            HttpSession session = request.getSession();
            KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");
            if (khachHang == null) {
                baoLoi = "ban chua dang nhap vao he thong";
            } else {
                if (!matKhauHienTaiSHA1.equals(khachHang.getMatKhau())) {
                    baoLoi = "mat khau hien tai khoing chinh xac";
                } else {
                    if (!matKhauMoi.equals(matKhauMoiNhapLai)) {
                        baoLoi = "2 mat khau khong khop";
                    } else {
                        String matKhauMoiSHA1 = MaHoa.toSHA1(matKhauMoi);
                        khachHang.setMatKhau(matKhauMoiSHA1);
                        KhachHangDAO khd = new KhachHangDAO();
                        if (khd.changePassword(khachHang)) {
                            baoLoi = "mat khau da thay doi thanh cong";
                        } else {
                            baoLoi = "mat khau thay doi khong thanh cong";
                        }
                    }
                }
            }
            request.setAttribute("baoLoi", baoLoi);
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void thaydoithongtinngdung(HttpServletRequest request, HttpServletResponse response) {
        try {
            String hoVaTen = request.getParameter("hoVaTen");
            String gioiTinh = request.getParameter("gioiTinh");
            String ngaySinh = request.getParameter("ngaySinh");
            String diaChiKhachHang = request.getParameter("diaChiKhachHang");
            String diaChiMuaHang = request.getParameter("diaChiMuaHang");
            String diaChiNhanHang = request.getParameter("diaChiNhanHang");
            String dienThoai = request.getParameter("dienThoai");
            String email = request.getParameter("email");
            String dongYNhanMail = request.getParameter("dongYNhanMail");

            KhachHangDAO khDAO = new KhachHangDAO();
            String url = "/khachhang/thatbai.jsp";
            HttpSession session = request.getSession();
            KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");
            System.out.println("ãin chào");
            if (khachHang != null) {
                System.out.println("xin chao");
                String maKhachHang = khachHang.getMaKhachHang();
                KhachHang kh = new KhachHang(maKhachHang, "", "", hoVaTen, gioiTinh, diaChiKhachHang, diaChiNhanHang, diaChiMuaHang, Date.valueOf(ngaySinh), dienThoai, email, dongYNhanMail != null);
                khDAO.updateInfo(kh);
                KhachHang kh2 = khDAO.selectById(kh);
                session.setAttribute("khachHang", kh2);
                url = "/khachhang/thanhcong.jsp";
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void xacThuc(HttpServletRequest request, HttpServletResponse response) {
        try {
            String maKhachHang = request.getParameter("maKhachHang");
            String maXacThuc = request.getParameter("maXacThuc");

            KhachHangDAO khDAO = new KhachHangDAO();
            KhachHang kh=new KhachHang();
            kh.setMaKhachHang(maKhachHang);
            String url = "";
            String msg="";
            KhachHang khachHang = khDAO.selectById(kh);
            if (khachHang != null) { 
                if(khachHang.getMaXacThuc().equals(maXacThuc)){
                    khachHang.setTrangThaiXacThuc(true);
                    khDAO.updateVerifyInformation(khachHang);
                     msg="xac thuc thanh cong";
                }else{
                     msg="xac thuc that bai";
                }
                
            }else{
                msg="tai khoan khong ton tai";
            }
            url = "/khachhang/thongbao.jsp";
            request.setAttribute("baoLoi", msg);
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getNoiDung(KhachHang kh) {
        String link = "http://localhost:8080/bt10_JDBC_servlet/khach-hang?hanhDong=xac-thuc&maKhachHang=" + kh.getMaKhachHang() + "&maXacThuc=" + kh.getMaXacThuc();
        String noiDung = "<p>TITV.vn xin ch&agrave;o bạn <strong>" + kh.getHoTen() + "</strong>,</p>\r\n"
                + "<p>Vui l&ograve;ng x&aacute;c thực t&agrave;i khoản của bạn bằng c&aacute;ch nhập m&atilde; <strong>" + kh.getMaXacThuc() + "</strong>, hoặc click trực tiếp v&agrave;o đường link sau đ&acirc;y:</p>\r\n"
                + "<p><a href=\"" + link + "\">" + link + "</a></p>\r\n"
                + "<p>Đ&acirc;y l&agrave; email tự động, vui l&ograve;ng kh&ocirc;ng phản hồi email n&agrave;y.</p>\r\n"
                + "<p>Tr&acirc;n trọng cảm ơn.</p>";
        return noiDung;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
