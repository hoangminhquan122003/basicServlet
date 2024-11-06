/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class ChiTietDonHang {
    private String maChiTietDonHang;
    private DonHang donHang;
    private SanPham sanPham;
    private double soLuong;
    private double giaBia;
    private double giamGia;
    private double giaBan;
    private double thueVat;
    private double tongTien;

    public ChiTietDonHang() {
    }

    public ChiTietDonHang(String maChiTietDonHang, DonHang donHang, SanPham sanPham, double soLuong, double giaBia, double giamGia, double giaBan, double thueVat, double tongTien) {
        this.maChiTietDonHang = maChiTietDonHang;
        this.donHang = donHang;
        this.sanPham = sanPham;
        this.soLuong = soLuong;
        this.giaBia = giaBia;
        this.giamGia = giamGia;
        this.giaBan = giaBan;
        this.thueVat = thueVat;
        this.tongTien = tongTien;
    }

    public String getMaChiTietDonHang() {
        return maChiTietDonHang;
    }

    public void setMaChiTietDonHang(String maChiTietDonHang) {
        this.maChiTietDonHang = maChiTietDonHang;
    }

    public DonHang getDonHang() {
        return donHang;
    }

    public void setDonHang(DonHang donHang) {
        this.donHang = donHang;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public double getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(double soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaBia() {
        return giaBia;
    }

    public void setGiaBia(double giaBia) {
        this.giaBia = giaBia;
    }

    public double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(double giamGia) {
        this.giamGia = giamGia;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public double getThueVat() {
        return thueVat;
    }

    public void setThueVat(double thueVat) {
        this.thueVat = thueVat;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
   
}
