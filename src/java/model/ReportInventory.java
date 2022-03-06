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
public class ReportInventory {
    private Bill bill;
    private int producted;
    private int removed;

    public ReportInventory() {
    }


    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
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
    
    
}
