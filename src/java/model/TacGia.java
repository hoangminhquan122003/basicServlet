/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class TacGia {
    private String maTacGia;
    private String hoTen;
    private Date ngaySinh;
    private String tieuSu;

    public TacGia() {
    }

    public TacGia(String maTacGia, String hoTen, Date ngaySinh, String tieuSu) {
        this.maTacGia = maTacGia;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.tieuSu = tieuSu;
    }

    public String getMaTacGia() {
        return maTacGia;
    }

    public void setMaTacGia(String maTacGia) {
        this.maTacGia = maTacGia;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getTieuSu() {
        return tieuSu;
    }

    public void setTieuSu(String tieuSu) {
        this.tieuSu = tieuSu;
    }
    
}
