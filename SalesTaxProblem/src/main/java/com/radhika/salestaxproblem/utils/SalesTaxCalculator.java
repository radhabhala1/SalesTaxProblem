package com.radhika.salestaxproblem.utils;

import java.io.Serializable;
import java.util.List;

import com.radhika.salestaxproblem.model.PurchaseItem;

public class SalesTaxCalculator implements Serializable {

    private static final long serialVersionUID = -2678589702645251673L;

    private double salesTaxRate = 0.1;
    
    private double importedTaxRate = 0.05;

    public double computeTax(PurchaseItem item) {
        double totTaxPercent = 0.0;
        if (item.isImported()) {
            totTaxPercent = importedTaxRate;
        }
        if (!item.isExempted()) {
            totTaxPercent += salesTaxRate;
        }
        return Math.round( (totTaxPercent * item.getPrice()) * 100.0 ) / 100.0;
    }

    public double computeCostWithTax(PurchaseItem item) {
        return (roundingOff(computeTax(item)) + item.getPrice())*item.getQuantity();
    }

    public float roundingOff(double tax) {
        return (float) (Math.ceil(tax * 20) / 20);
    }

    public double getTotalTax(List<PurchaseItem> purchaseItems) {
        double totalTax = 0d;
        for (PurchaseItem item : purchaseItems) {
            totalTax = totalTax + computeTax(item);
        }
        return roundingOff(totalTax);
    }

    public double getTotalCost(List<PurchaseItem> purchaseItems) {
        double totalCost = 0d;
        for (PurchaseItem item : purchaseItems) {
            item.setCostWithTax(computeCostWithTax(item));
            totalCost = totalCost + item.getPrice();
        }
        return totalCost;
    }
}
