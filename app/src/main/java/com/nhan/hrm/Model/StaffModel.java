package com.nhan.hrm.Model;

public class StaffModel {
    public String ID;
    public String MSNV;
    public String HoTen;
    public String Gmail;
    public String ChucVu;
    public String GioiTinh;
    public String DiaChi;
    public String SDT;
    public String DuAn;

    @Override
    public String toString() {
        return "StaffModel{" +
                "ID='" + ID + '\'' +
                ", MSNV='" + MSNV + '\'' +
                ", HoTen='" + HoTen + '\'' +
                ", Email='" + Gmail + '\'' +
                ", ChucVu='" + ChucVu + '\'' +
                ", GioiTinh='" + GioiTinh + '\'' +
                ", DiaChi='" + DiaChi + '\'' +
                ", SDT='" + SDT + '\'' +
                ", DuAn='" + DuAn + '\'' +
                '}';
    }

    public StaffModel(String ID, String MSNV, String hoTen, String gmail, String chucVu, String gioiTinh, String diaChi, String SDT, String duAn) {
        this.ID = ID;
        this.MSNV = MSNV;
        this.HoTen = hoTen;
        this.Gmail = gmail;
        this.ChucVu = chucVu;
        this.GioiTinh = gioiTinh;
        this.DiaChi = diaChi;
        this.SDT = SDT;
        this.DuAn = duAn;
    }

    public StaffModel() {
    }


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMSNV() {
        return MSNV;
    }

    public void setMSNV(String MSNV) {
        this.MSNV = MSNV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        this.HoTen = hoTen;
    }

    public String getGmail() {
        return Gmail;
    }

    public void setGmail(String gmail) {
        this.Gmail = gmail;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String chucVu) {
        this.ChucVu = chucVu;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.GioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        this.DiaChi = diaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDuAn() {
        return DuAn;
    }

    public void setDuAn(String duAn) {
        this.DuAn = duAn;
    }
}
