package com.radhika.salestaxproblem.service;

import com.radhika.salestaxproblem.model.PurchaseItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class Parser {

    @Value("${imported.text}")
    private String IMPORTED_TEXT = "imported";

    @Value("${exempted.items}")
    private String[] EXEMPTED_ITEMS = {"chocolate", "book"};

    public List<PurchaseItem> parse(List<String> lines) {
        final List<PurchaseItem> purchaseItems = new ArrayList<>();
        for (final String line : lines) {

            final String array[] = line.split(" ");
            final LinkedList<String> elementList = new LinkedList<>(Arrays.asList(array));

            final int quantity = getQuantity(elementList);
            final boolean isImported = isImported(elementList);
            final double unitCost = getUnitCost(elementList);
            final String productDescription = getDescription(elementList);
            final boolean isExempted = isExempted(elementList);

            purchaseItems.add(new PurchaseItem(productDescription, unitCost, quantity, isImported,
                    isExempted));
        }
        return purchaseItems;
    }

    private double getUnitCost(LinkedList<String> elementList) {
        return Double.parseDouble(elementList.pollLast());
    }

    private String getDescription(LinkedList<String> elementList) {
        return StringUtils.collectionToDelimitedString(elementList, " ");
    }

    private boolean isExempted(LinkedList<String> elementList) {
        for (String exemptedItem : EXEMPTED_ITEMS) {
            if (elementList.contains(exemptedItem)) {
                return true;
            }
        }
        return false;
    }

    private int getQuantity(LinkedList<String> elementList) {
        return Integer.parseInt(elementList.pollFirst());
    }

    private boolean isImported(LinkedList<String> elementList) {
        return elementList.contains(IMPORTED_TEXT);
    }
}
