/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class ManufactureDetail {
    private String orderID;
    private Bill bill;
    private Worker worker;
    private int producted;
    private int removed;
    private Date outputDate;


    public ManufactureDetail() {
    }

    public ManufactureDetail(String orderID, Bill bill, Worker worker, int producted, int removed, Date productedDate) {
        this.orderID = orderID;
        this.bill = bill;
        this.worker = worker;
        this.producted = producted;
        this.removed = removed;
        this.outputDate = productedDate;
    }

    
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public int getProducted() {
        return producted;
    }

    public void setProducted(int producted) {
        this.producted = producted;
    }

    public int getRemoved() {
        return removed;
    }

    public void setRemoved(int removed) {
        this.removed = removed;
    }

    public Date getOutputDate() {
        return outputDate;
    }

    public void setOutputDate(Date outputDate) {
        this.outputDate = outputDate;
    }
    
    
    
}
