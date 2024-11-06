/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class SanPham {
    private String maSach;
    private String tenSach;
    private TacGia tacGia;
    private int namXuatBan;
    private Double giaNhap;
    private Double giaBan;
    private Double giaGoc;
    private int soLuong;
    private TheLoai theLoai;
    private String ngonNgu;
    private String moTa;

    public SanPham() {
    }

    public SanPham(String maSach, String tenSach, TacGia tacGia, int namXuatBan, Double giaNhap, Double giaBan, Double giaGoc, int soLuong, TheLoai theLoai, String ngonNgu, String moTa) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.giaGoc = giaGoc;
        this.soLuong = soLuong;
        this.theLoai = theLoai;
        this.ngonNgu = ngonNgu;
        this.moTa = moTa;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public TacGia getTacGia() {
        return tacGia;
    }

    public void setTacGia(TacGia tacGia) {
        this.tacGia = tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public Double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public Double getGiaGoc() {
        return giaGoc;
    }

    public void setGiaGoc(Double giaGoc) {
        this.giaGoc = giaGoc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public TheLoai getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(TheLoai theLoai) {
        this.theLoai = theLoai;
    }

    public String getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
}
