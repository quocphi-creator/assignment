/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Manufacture {
    ArrayList<ManufactureDetail> manufactoring;

    public Manufacture() {
    }

    public Manufacture(ArrayList<ManufactureDetail> manufactoring) {
        this.manufactoring = manufactoring;
    }

    public ArrayList<ManufactureDetail> getManufactoring() {
        return manufactoring;
    }

    public void setManufactoring(ArrayList<ManufactureDetail> manufactoring) {
        this.manufactoring = manufactoring;
    }
    
}
