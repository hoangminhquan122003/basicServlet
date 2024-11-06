/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ArrayList;
import model.KhachHang;

/**
 *
 * @author Admin
 */
public class KhachHangDAO implements DAOInterface<KhachHang> {

    public ArrayList<KhachHang> data = new ArrayList<>();

    @Override
    public ArrayList<KhachHang> selectAll() {
        ArrayList<KhachHang> kq = new ArrayList<>();
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "SELECT * FROM khachhang";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maKhachHang = rs.getString("maKhachHang");
                String tenDangNhap = rs.getString("tendangnhap");
                String matKhau = rs.getString("matkhau");
                String hoVaTen = rs.getString("hoten");
                String gioiTinh = rs.getString("gioitinh");
                String diaChi = rs.getString("diachi");
                String diaChiNhanHang = rs.getString("diachinhanhang");
                String diaChiMuaHang = rs.getString("diachimuahang");
                Date ngaySinh = rs.getDate("ngaysinh");
                String soDienThoai = rs.getString("sodienthoai");
                String email = rs.getString("email");
                boolean dangKyNhanBanTinEmail = rs.getBoolean("dangkinhanbantinemail");
                String maXacThuc=rs.getString("maxacthuc");
                Date thoiGianHieuLucMaXacThuc=rs.getDate("thoigianhieulucmaxacthuc");
                boolean trangThaiXacThuc=rs.getBoolean("trangthaixacthuc");
                String thayDoiAnh=rs.getString("thaydoianh");
                
                KhachHang kh = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, diaChiNhanHang,
                        diaChiMuaHang, ngaySinh, soDienThoai, email, dangKyNhanBanTinEmail,maXacThuc,thoiGianHieuLucMaXacThuc,trangThaiXacThuc,thayDoiAnh);

                kq.add(kh);
            }
            JDBCUtil.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    public KhachHang selectById(KhachHang t) {
        KhachHang kq = null;
        try {
            Connection c = JDBCUtil.getConnection();
            String url = "SELECT * FROM khachhang WHERE makhachhang=?";
            PreparedStatement ps = c.prepareStatement(url);
            ps.setString(1, t.getMaKhachHang());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maKhachHang = rs.getString("makhachhang");
                String tenDangNhap = rs.getString("tendangnhap");
                String matKhau = rs.getString("matkhau");
                String hoVaTen = rs.getString("hoten");
                String gioiTinh = rs.getString("gioitinh");
                String diaChi = rs.getString("diachi");
                String diaChiNhanHang = rs.getString("diachinhanhang");
                String diaChiMuaHang = rs.getString("diachimuahang");
                Date ngaySinh = rs.getDate("ngaysinh");
                String soDienThoai = rs.getString("sodienthoai");
                String email = rs.getString("email");
                boolean dangKyNhanBanTinEmail = rs.getBoolean("dangkynhanbantinemail");
                String maXacThuc=rs.getString("maxacthuc");
                Date thoiGianHieuLucMaXacThuc=rs.getDate("thoigianhieulucmaxacthuc");
                boolean trangThaiXacThuc=rs.getBoolean("trangthaixacthuc");
                String thayDoiAnh =rs.getString("thaydoianh");
                kq = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, diaChiNhanHang,
                        diaChiMuaHang, ngaySinh, soDienThoai, email, dangKyNhanBanTinEmail,maXacThuc,thoiGianHieuLucMaXacThuc,trangThaiXacThuc,thayDoiAnh);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    public int insert(KhachHang t) {
        int kq = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "INSERT INTO khachhang (makhachhang, tendangnhap, matkhau, hoten, gioitinh, diachi, diachinhanhang, diachimuahang, ngaysinh, sodienthoai, email, dangkynhanbantinemail) "
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaKhachHang());
            st.setString(2, t.getTenDangNhap());
            st.setString(3, t.getMatKhau());
            st.setString(4, t.getHoTen());
            st.setString(5, t.getGioiTinh());
            st.setString(6, t.getDiaChi());
            st.setString(7, t.getDiaChiNhanHang());
            st.setString(8, t.getDiaChiMuaHang());
            st.setDate(9, t.getNgaySinh());
            st.setString(10, t.getSoDienThoai());
            st.setString(11, t.getEmail());
            st.setBoolean(12, t.isDangKyNhanBanTinEmail());

            // Bước 3: thực thi câu lệnh SQL
            kq = st.executeUpdate();

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    public int insertAll(ArrayList<KhachHang> arr) {
        int dem = 0;
        for (KhachHang KhachHang : arr) {
            dem += this.insert(KhachHang);
        }
        return dem;
    }

    @Override
    public int delete(KhachHang t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE from khachhang " + " WHERE makhachhang=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaKhachHang());

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ketQua = st.executeUpdate();

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int deleteAll(ArrayList<KhachHang> arr) {
        int dem = 0;
        for (KhachHang KhachHang : arr) {
            dem += this.delete(KhachHang);
        }
        return dem;
    }

    @Override
    public int update(KhachHang t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE khachhang " + " SET " + " tendangnhap=?" + ", matkhau=?" + ", hoten=?" + ", gioitinh=?"
                    + ", diachi=?" + ", diachinhanhang=?" + ", diachimuahang=?" + ", ngaysinh=?" + ", sodienthoai=?"
                    + ", email=?" + ", dangkynhanbantinemail=?" + " WHERE makhachhang=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getTenDangNhap());
            st.setString(2, t.getMatKhau());
            st.setString(3, t.getHoTen());
            st.setString(4, t.getGioiTinh());
            st.setString(5, t.getDiaChi());
            st.setString(6, t.getDiaChiNhanHang());
            st.setString(7, t.getDiaChiMuaHang());
            st.setDate(8, t.getNgaySinh());
            st.setString(9, t.getSoDienThoai());
            st.setString(10, t.getEmail());
            st.setBoolean(11, t.isDangKyNhanBanTinEmail());
            st.setString(12, t.getMaKhachHang());
            // Bước 3: thực thi câu lệnh SQL

            System.out.println(sql);
            ketQua = st.executeUpdate();

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }
    public int updateVerifyInformation(KhachHang t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE khachhang " + " SET " + " maxacthuc=?" + ", thoigianhieulucmaxacthuc=?" + ", trangthaixacthuc=?"
                     + " WHERE makhachhang=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaXacThuc());
            st.setDate(2, t.getThoiGianHieuLucMaXacThuc());
            st.setBoolean(3, t.isTrangThaiXacThuc());
            st.setString(4, t.getMaKhachHang());
            // Bước 3: thực thi câu lệnh SQL

            System.out.println(sql);
            ketQua = st.executeUpdate();

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }
    public int updateImage(KhachHang t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE khachhang " + " SET " +" thaydoianh=?"
                     + " WHERE makhachhang=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getThayDoiAnh());
            st.setString(2, t.getMaKhachHang());
            // Bước 3: thực thi câu lệnh SQL

            System.out.println(sql);
            ketQua = st.executeUpdate();

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }

    public boolean kiemTraTenDangNhap(String tenDangNhap) {
        boolean kq = false;
        try {
            Connection c = JDBCUtil.getConnection();
            String url = "SELECT * FROM khachhang WHERE tenDangNhap=?";
            PreparedStatement ps = c.prepareStatement(url);
            ps.setString(1, tenDangNhap);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                kq = true;
            }
            JDBCUtil.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    public KhachHang selectByUsernameandPassword(KhachHang t) {
        KhachHang kq = null;
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "SELECT * FROM khachhang WHERE tenDangNhap=? AND matKhau=?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, t.getTenDangNhap());
            ps.setString(2, t.getMatKhau());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maKhachHang = rs.getString("maKhachHang");
                String tenDangNhap = rs.getString("tenDangNhap");
                String matKhau = rs.getString("matKhau");
                String hoVaTen = rs.getString("hoTen");
                String gioiTinh = rs.getString("gioiTinh");
                String diaChi = rs.getString("diaChi");
                String diaChiNhanHang = rs.getString("diaChiNhanHang");
                String diaChiMuaHang = rs.getString("diaChiMuaHang");
                Date ngaySinh = rs.getDate("ngaySinh");
                String soDienThoai = rs.getString("soDienThoai");
                String email = rs.getString("email");
                boolean dangKyNhanBanTinEmail = rs.getBoolean("dangKyNhanBanTinEmail");
                String maXacThuc=rs.getString("maxacthuc");
                Date thoiGianHieuLucMaXacThuc=rs.getDate("thoigianhieulucmaxacthuc");
                boolean trangThaiXacThuc=rs.getBoolean("trangthaixacthuc");
           
                kq = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, diaChiNhanHang,
                        diaChiMuaHang, ngaySinh, soDienThoai, email, dangKyNhanBanTinEmail,maXacThuc,thoiGianHieuLucMaXacThuc,trangThaiXacThuc);

            }
            JDBCUtil.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }
     public boolean changePassword(KhachHang t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE khachhang " + " SET  matkhau=?" + " WHERE makhachhang=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMatKhau());
            st.setString(2, t.getMaKhachHang());
            // Bước 3: thực thi câu lệnh SQL

            System.out.println(sql);
            ketQua = st.executeUpdate();

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua>0;
    }

    public int updateInfo(KhachHang t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE khachhang " + " SET hoten=?" + ", gioitinh=?"
                    + ", diachi=?" + ", diachinhanhang=?" + ", diachimuahang=?" + ", ngaysinh=?" + ", sodienthoai=?"
                    + ", email=?" + ", dangkynhanbantinemail=?" + " WHERE makhachhang=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getHoTen());
            st.setString(2, t.getGioiTinh());
            st.setString(3, t.getDiaChi());
            st.setString(4, t.getDiaChiNhanHang());
            st.setString(5, t.getDiaChiMuaHang());
            st.setDate(6, t.getNgaySinh());
            st.setString(7, t.getSoDienThoai());
            st.setString(8, t.getEmail());
            st.setBoolean(9, t.isDangKyNhanBanTinEmail());
            st.setString(10, t.getMaKhachHang());
            // Bước 3: thực thi câu lệnh SQL
            ketQua = st.executeUpdate();
            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua;
    }
}
