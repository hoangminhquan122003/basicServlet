/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Date;

public class KhachHang {
    private String maKhachHang;
    private String tenDangNhap;
    private String matKhau;
    private String hoTen;
    private String gioiTinh;
    private String diaChi;
    private String diaChiNhanHang;
    private String diaChiMuaHang;
    private Date ngaySinh;
    private String soDienThoai;
    private String email;
    private boolean dangKyNhanBanTinEmail;
    private String maXacThuc;
    private Date thoiGianHieuLucMaXacThuc;
    private boolean trangThaiXacThuc;
    private String thayDoiAnh;
    public KhachHang() {
    }

    public KhachHang(String maKhachHang, String tenDangNhap, String matKhau, String hoTen, String gioiTinh, String diaChi, String diaChiNhanHang, String diaChiMuaHang, Date ngaySinh, String soDienThoai, String email, boolean dangKyNhanBanTinEmail) {
        this.maKhachHang = maKhachHang;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.diaChiNhanHang = diaChiNhanHang;
        this.diaChiMuaHang = diaChiMuaHang;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.dangKyNhanBanTinEmail = dangKyNhanBanTinEmail;
    }

    public KhachHang(String maKhachHang, String tenDangNhap, String matKhau, String hoTen, String gioiTinh, String diaChi, String diaChiNhanHang, String diaChiMuaHang, Date ngaySinh, String soDienThoai, String email, boolean dangKyNhanBanTinEmail, String maXacThuc, Date thoiGianHieuLucMaXacThuc, boolean trangThaiXacThuc) {
        this.maKhachHang = maKhachHang;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.diaChiNhanHang = diaChiNhanHang;
        this.diaChiMuaHang = diaChiMuaHang;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.dangKyNhanBanTinEmail = dangKyNhanBanTinEmail;
        this.maXacThuc = maXacThuc;
        this.thoiGianHieuLucMaXacThuc = thoiGianHieuLucMaXacThuc;
        this.trangThaiXacThuc = trangThaiXacThuc;
    }

    public KhachHang(String maKhachHang, String tenDangNhap, String matKhau, String hoTen, String gioiTinh, String diaChi, String diaChiNhanHang, String diaChiMuaHang, Date ngaySinh, String soDienThoai, String email, boolean dangKyNhanBanTinEmail, String maXacThuc, Date thoiGianHieuLucMaXacThuc, boolean trangThaiXacThuc, String thayDoiAnh) {
        this.maKhachHang = maKhachHang;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.diaChiNhanHang = diaChiNhanHang;
        this.diaChiMuaHang = diaChiMuaHang;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.dangKyNhanBanTinEmail = dangKyNhanBanTinEmail;
        this.maXacThuc = maXacThuc;
        this.thoiGianHieuLucMaXacThuc = thoiGianHieuLucMaXacThuc;
        this.trangThaiXacThuc = trangThaiXacThuc;
        this.thayDoiAnh = thayDoiAnh;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDiaChiNhanHang() {
        return diaChiNhanHang;
    }

    public void setDiaChiNhanHang(String diaChiNhanHang) {
        this.diaChiNhanHang = diaChiNhanHang;
    }

    public String getDiaChiMuaHang() {
        return diaChiMuaHang;
    }

    public void setDiaChiMuaHang(String diaChiMuaHang) {
        this.diaChiMuaHang = diaChiMuaHang;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isDangKyNhanBanTinEmail() {
        return dangKyNhanBanTinEmail;
    }

    public void setDangKyNhanBanTinEmail(boolean dangKyNhanBanTinEmail) {
        this.dangKyNhanBanTinEmail = dangKyNhanBanTinEmail;
    }

    public String getMaXacThuc() {
        return maXacThuc;
    }

    public void setMaXacThuc(String maXacThuc) {
        this.maXacThuc = maXacThuc;
    }

    public Date getThoiGianHieuLucMaXacThuc() {
        return thoiGianHieuLucMaXacThuc;
    }

    public void setThoiGianHieuLucMaXacThuc(Date thoiGianHieuLucMaXacThuc) {
        this.thoiGianHieuLucMaXacThuc = thoiGianHieuLucMaXacThuc;
    }

    public boolean isTrangThaiXacThuc() {
        return trangThaiXacThuc;
    }

    public void setTrangThaiXacThuc(boolean trangThaiXacThuc) {
        this.trangThaiXacThuc = trangThaiXacThuc;
    }

    public String getThayDoiAnh() {
        return thayDoiAnh;
    }

    public void setThayDoiAnh(String thayDoiAnh) {
        this.thayDoiAnh = thayDoiAnh;
    }

}
