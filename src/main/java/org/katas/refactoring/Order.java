package org.katas.refactoring;

import java.util.List;

public class Order {
     String customerName;
     String customerAddress;
     private List<LineItem> lineItems;

    public Order(String customerName, String customerAddress, List<LineItem>lineItems) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.lineItems =lineItems;
    }

    String getCustomerName() {
        return customerName;
    }

    String getCustomerAddress() {
        return customerAddress;
    }

    List<LineItem> getLineItems() {
        return lineItems;
    }
}
