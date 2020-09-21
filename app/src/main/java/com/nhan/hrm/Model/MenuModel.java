package com.nhan.hrm.Model;

public class MenuModel {

    private String tenChucNang;
    private String hinhAnh;

    @Override
    public String toString() {
        return "menu{" +
                "tenChucNang='" + tenChucNang + '\'' +
                ", hinhAnh='" + hinhAnh + '\'' +
                '}';
    }

    public MenuModel() {}

    public MenuModel(String tenChucNang, String hinhAnh) {
        this.tenChucNang = tenChucNang;
        this.hinhAnh = hinhAnh;
    }
    public String getTenChucNang() {
        return tenChucNang;
    }

    public void setTenChucNang(String tenChucNang) {
        this.tenChucNang = tenChucNang;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
