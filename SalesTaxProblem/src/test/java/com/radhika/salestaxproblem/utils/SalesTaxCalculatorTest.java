package com.radhika.salestaxproblem.utils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.radhika.salestaxproblem.model.PurchaseItem;

/**
 *
 * @author rabhala
 */
@RunWith(MockitoJUnitRunner.class)
public class SalesTaxCalculatorTest {
    
    double price = 10d;
    int quantity = 1;
    
    PurchaseItem item;

    SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator();

    @Test
    public void testComputeTaxRegularTax(){
        item = new PurchaseItem("perfume", price, quantity, false, false);
        double tax = salesTaxCalculator.computeTax(item);
        Assert.assertEquals(1d, tax, 0);
    }
    
    @Test
    public void testComputeTaxExemptedTax(){
        item = new PurchaseItem("book", price, quantity, false, true);
        double tax = salesTaxCalculator.computeTax(item);
        Assert.assertEquals(0d, tax, 0);
    }
    
    @Test
    public void testComputeTaxImportedTax(){
        item = new PurchaseItem("imported book",price, quantity, true, true);
        double tax = salesTaxCalculator.computeTax(item);
        Assert.assertEquals(0.5d, tax, 0);
    }
    
    @Test
    public void testComputeTaxRegularAndImportedTax(){
        item = new PurchaseItem("imported perfume", price, quantity, true, false);
        double tax = salesTaxCalculator.computeTax(item);
        Assert.assertEquals(1.5d, tax, 0);
    }
    
}
