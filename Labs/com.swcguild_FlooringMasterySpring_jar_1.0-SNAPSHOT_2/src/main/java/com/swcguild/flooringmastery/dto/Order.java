/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmastery.dto;

/**
 *
 * @author apprentice
 */
public class Order {
    
    protected static int orderNumCount=0;
    protected int orderNum;
    protected String customerName;
    protected String state;
    protected double taxRate;
    protected double costPerSqFt;
    protected double laborCostPerSqFt;
    protected double materialCost;
    protected double laborCost;
    protected double tax;
    protected double total;
    protected double area;
    protected String materials;
    protected String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    
    
    
    public Order(int orderNum){
     this.orderNum=orderNum;
     orderNumCount++;
    }

    public static int getOrderNumCount() {
        return orderNumCount;
    }

    public static void setOrderNumCount(int orderNumCount) {
        Order.orderNumCount = orderNumCount;
    }

    public int getOrderNum() {
        return orderNum;
    }

    
    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public String getMaterials()
    {
        return materials;
    }
    
    public void setMaterials(String materials)
    {
        this.materials = materials;
    }
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getLaborCostPerSqFt() {
        return laborCostPerSqFt;
    }

    public void setLaborCostPerSqFt(double laborCostPerSqFt) {
        this.laborCostPerSqFt = laborCostPerSqFt;
    }

    public double getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(double materialCost) {
        this.materialCost = materialCost;
    }

    public double getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(double laborCost) {
        this.laborCost = laborCost;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getCostPerSqFt() {
        return costPerSqFt;
    }

    public void setCostPerSqFt(double costPerSqFt) {
        this.costPerSqFt = costPerSqFt;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

}