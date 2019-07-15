package org.katas.refactoring;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    public static final double SALES_TAX_RATE = .10;
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {

        printHeaders();
        printCustomerNameAndAddress(order.customerName,order.customerAddress);
        return printsLineItems(order);
    }

        private void printHeaders() {
            System.out.println("======Printing Orders======\n");
        }
        private void printCustomerNameAndAddress(String customerName,String customerAddress) {
            System.out.println(customerName+customerAddress);
        }

    private String printsLineItems(Order order) {
        StringBuilder output = new StringBuilder();
        double totSalesTx = 0d;
        double tot = 0d;
        for (LineItem lineItem : order.getLineItems()) {

            output.append(lineItem.getDescription()).append('\t');
            output.append(lineItem.getPrice()).append('\t');
            output.append(lineItem.getQuantity()).append('\t');
            output.append(lineItem.totalAmount()).append('\n');

            double salesTax = lineItem.totalAmount() * SALES_TAX_RATE;
            totSalesTx += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            tot += lineItem.totalAmount() + salesTax;
        }
        // prints the state tax
            output.append("Sales Tax").append('\t').append(totSalesTx);

            // print total amount
            output.append("Total Amount").append('\t').append(tot);
            return output.toString();
    }


}