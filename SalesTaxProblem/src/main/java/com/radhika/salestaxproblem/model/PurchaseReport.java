package com.radhika.salestaxproblem.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.radhika.salestaxproblem.utils.SalesTaxCalculator;

public class PurchaseReport implements Serializable {

    private static final long serialVersionUID = -1228549175689373440L;
    private List<PurchaseItem> purchaseItems;
    private double totalCost;
    private double totalTax;
    
    @Autowired
    private SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator();

    public List<PurchaseItem> getPurchaseItems() {
        return purchaseItems;
    }

    public void setPurchaseItems(List<PurchaseItem> purchaseItems) {
        this.purchaseItems = purchaseItems;
    }

    public double computeTotalTax() {
        totalTax = salesTaxCalculator.getTotalTax(purchaseItems);
        return totalTax;
    }

    public double computeTotalCost() {
        totalCost = salesTaxCalculator.getTotalCost(purchaseItems);
        return totalCost + totalTax;
    }
}
