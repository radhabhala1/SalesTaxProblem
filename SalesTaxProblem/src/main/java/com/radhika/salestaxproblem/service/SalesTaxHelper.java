package com.radhika.salestaxproblem.service;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.radhika.salestaxproblem.model.InputFile;
import com.radhika.salestaxproblem.model.PurchaseItem;
import com.radhika.salestaxproblem.model.PurchaseReport;

@Component
public class SalesTaxHelper {

    @Autowired
    private InputFileReader ifr;

    @Autowired
    private Parser parser;

    public void printInput(List<InputFile> inputFiles) throws FileNotFoundException {
        
        System.out.println("INPUT:");
        
        for (int i = 0; i < inputFiles.size(); i++) {
            System.out.println(String.format("Input %d:", i + 1));
            List<String> fileContent = ifr.readFile(inputFiles.get(i));
            PurchaseReport purchaseReport = new PurchaseReport();
            purchaseReport.setPurchaseItems(parser.parse(fileContent));
            for (PurchaseItem item : purchaseReport.getPurchaseItems()) {
                System.out.println(String.format("%d %s %.2f", item.getQuantity(),
                        item.getDescription(), item.getPrice()));
            }
        }
    }

    public void printOutput(List<InputFile> inputFiles) throws FileNotFoundException {
        
        System.out.println("\nOUTPUT:");
        
        for (int i = 0; i < inputFiles.size(); i++) {
            System.out.println(String.format("Output %d:", i + 1));
            List<String> fileContent = ifr.readFile(inputFiles.get(i));
            PurchaseReport purchaseReport = new PurchaseReport();
            purchaseReport.setPurchaseItems(parser.parse(fileContent));
            double cost = purchaseReport.computeTotalCost();
            for(PurchaseItem item: purchaseReport.getPurchaseItems()){
              System.out.println(String.format("%d %s %.2f",item.getQuantity(),item.getDescription(),item.getCostWithTax()));  
            }
            System.out.println(String.format("Sales Taxes: %.2f", purchaseReport.computeTotalTax()));
            System.out.println(String.format("Total Cost: %.2f", cost));
        }
    }


}
