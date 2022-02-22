/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Worker {
    private int wid;
    private String wname;
    private String phoneNumber;
    private int monthSalary;
    private int productSalary;

    public Worker() {
    }

    public Worker(int wid, String wname, String phoneNumber, int monthSalary, int productSalary) {
        this.wid = wid;
        this.wname = wname;
        this.phoneNumber = phoneNumber;
        this.monthSalary = monthSalary;
        this.productSalary = productSalary;
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getMonthSalary() {
        return monthSalary;
    }

    public void setMonthSalary(int monthSalary) {
        this.monthSalary = monthSalary;
    }

    public int getProductSalary() {
        return productSalary;
    }

    public void setProductSalary(int productSalary) {
        this.productSalary = productSalary;
    }
    
    
}
