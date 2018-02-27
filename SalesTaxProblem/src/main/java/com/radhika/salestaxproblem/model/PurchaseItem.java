package com.radhika.salestaxproblem.model;

import java.io.Serializable;

public class PurchaseItem implements Serializable {

    private static final long serialVersionUID = 5277637810333207013L;
    private String description;
    private double price;
    private boolean imported;
    private boolean exempted;
    private int quantity;
    private double costWithTax;
            
    public PurchaseItem() {}

    public PurchaseItem(String description, double price, int quantity, boolean imported, boolean exempted) {
        this.description = description;
        this.price = price;
        this.imported = imported;
        this.exempted = exempted;
        this.quantity = quantity;
    }
    
    public double getCostWithTax() {
        return costWithTax;
    }

    public void setCostWithTax(double costWithTax) {
        this.costWithTax = costWithTax;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }

    public boolean isExempted() {
        return exempted;
    }

    public void setExempted(boolean exempted) {
        this.exempted = exempted;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
